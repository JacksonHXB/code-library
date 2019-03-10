#===============================================================================
# 使用代理处理反爬爬取微信文章
#===============================================================================

from urllib.parse import urlencode
import requests
from pyquery import PyQuery as pq
import pymongo

baseUrl = 'http://weixin.sogou.com/weixin?'
headers = {
    'Cookie': 'IPLOC=CN3100; SUID=7E89F63A2C18960A000000005B7130DC; SUV=1534144649494186; ABTEST=7|1534144734|v1; SNUID=31C6A66A504A2304A8A47AD750623A3C; weixinIndexVisited=1; ppinf=5|1534144770|1535354370|dHJ1c3Q6MToxfGNsaWVudGlkOjQ6MjAxN3x1bmlxbmFtZToyNzolRTklQkIlODQlRTUlQjAlOEYlRTUlODUlQjV8Y3J0OjEwOjE1MzQxNDQ3NzB8cmVmbmljazoyNzolRTklQkIlODQlRTUlQjAlOEYlRTUlODUlQjV8dXNlcmlkOjQ0Om85dDJsdU01bW4yOUZUclk1RTE3UDI1ckRERHNAd2VpeGluLnNvaHUuY29tfA; pprdig=p9ehnn-554WUX7EgwHo7qT6EE1aC0gSUgW3q5t_HmVv8eTXKNFaTtWXrQFgIrdeZbuiK0Wu32K9W6bnS7rLvY9m3OZaZ35cCjAyJorYf2UHvqI4NJZKFel2oSPlnXvM6xjMGOSy8BN0Ji5S3uPSZjSwmtXFTwfkTpMbD3Kgy55Y; sgid=24-36554159-AVtxMQJvDXOOB8zgA3ua3MA; ppmdig=1534144770000000a5001bc1db1a19d1fd7a54dac430808a',
    'Host': 'weixin.sogou.com',
    'Upgrade-Insecure-Requests': '1',
    'User-Agent': 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36',
}
keyword = '风景'      # 搜索的关键字
proxyPoolUrl = 'http://127.0.0.1:5555/random'  # 获取代理的接口
proxy = None
maxCount = 5    # 最大请求次数

# MongoDB客户端
#------------------------------------------------------------------------------ 
client = pymongo.MongoClient('localhost')
db = client['db_weixin']


# 获取代理
#------------------------------------------------------------------------------ 
def getProxy():
    try:
        response = requests.get(proxyPoolUrl)
        if response.status_code == 200:
            return response.text
        return None
    except ConnectionError:
        return None


# 发起请求
#------------------------------------------------------------------------------ 
def getHtml(url, count=1):# count控制请求次数
    print(' 请求的URL： ' + url + '  请求次数：' + str(count))
    global proxy
    
    if count >= maxCount:
        print('请求次数太多')
        return None
    
    try:
        if proxy:
            # 创建代理
            proxies = {'http': 'http://' + proxy}
            # 使用代理进行请求
            response = requests.get(url, allow_redirects=False, headers=headers, proxies=proxies)
        else:
            response = requests.get(url, allow_redirects=False, headers=headers)# requests会默认吹302，因此这里要设置
            
        if response.status_code == 200:
            return response.text
        if response.status_code == 302:
            # 设置代理
            print('302')
            proxy = getProxy()
            if proxy:
                print('使用代理：：', proxy)
                return getHtml(url)
            else:
                print("代理出错！")
                return None
    except ConnectionError as e:
        print('出错了！', e.args)
        proxy = getProxy()
        count += 1
        return getHtml(url, count)


# 请求索引页
#------------------------------------------------------------------------------ 
def getIndex(keyword, page):
    data = {
        'query': keyword,
        'type': 2,
        'page': page
    }
    queries = urlencode(data)
    url = baseUrl + queries
    html = getHtml(url)
    return html


# 解析索引页
#------------------------------------------------------------------------------ 
def parseIndex(html):
    doc = pq(html)
    items = doc('.news-box .news-box').items()
    for item in items:
        yield item.attr('href')


# 获取详情页的源代码
#------------------------------------------------------------------------------ 
def getDetail(url):
    try:
        response = requests.get(url)
        if response.status_code == 200:
            return response.text
        return None
    except ConnectionError:
        return None


# 解析文章的详情页
#------------------------------------------------------------------------------ 
def parseDetail(html):
    try:
        doc = pq(html)
        title = doc('.rich_media_title').text()
        content = doc('.rich_media_content').text()
        date = doc('#post-date').text()
        nickname = doc('.rich_media_content .rich_media_meta_nickname').text()
        wechat = doc('#js_profile_qrcode > div > p:nth-child(3) > span').text()
        return {
            'title': title,
            'content': content,
            'date': date,
            'nickname': nickname,
            'wechat': wechat
        }
    except Exception:
        return None
  

def saveToMongo(data):
    # 如果查询到就更新，如果没有查询到就执行插入
    if db['articles'].update({'title':data['title']}, {'$set': data}, True):
        print('SaveToMongo', data['title'])
    else:
        print('SaveToMongo Failed', data['title'])
    
    
# 主函数
#------------------------------------------------------------------------------ 
def main():
    for page in range(1, 101):
        html = getIndex(keyword, page)
        if html:
            articleUrls = parseIndex(html)
            for articleUrl in articleUrls:
                articleHtml = getDetail(articleUrl)
                if articleHtml:
                    articleData = parseDetail(articleHtml)
                    if articleData:
                        saveToMongo(articleData)
                

if __name__ == '__main__':
    main()














































































