#===============================================================================
# 分析Ajax来抓取今日头条街拍美图
#===============================================================================
import json
import re
from urllib.parse import urlencode
from hashlib import md5
from bs4 import BeautifulSoup
import pymongo
import os
import requests
from requests.exceptions import RequestException
from config import *
from multiprocessing.pool import Pool
from json.decoder import JSONDecodeError

# 生成数据库对象
#------------------------------------------------------------------------------
#　请求MongoDB客户端 ，connect=False在多进程时可以防止报错
client = pymongo.MongoClient(MONGO_URL,connect=False)
# 连接数据库
db = client[MONGO_DB]


# 请求索引页：获得所有与关键字有关的图片集
#------------------------------------------------------------------------------ 
# offset:表示页面偏移量；keyword：表示关键字；返回值为字符串类型的json数据
def getPageIndex(offset, keyword):
    # 设置要发送的JSON数据
    data = {
        'offset': offset,
        'format': 'json',
        'keyword': keyword,
        'autoload': 'true',
        'count': '20',
        'cur_tab': 3,
        'from':'search_tab'
    }
    # urlencode(data)将字典类型变量转为请求参数
    # https://www.toutiao.com/search_content/?offset=0&format=json&keyword=%E8%A1%97%E6%8B%8D&autoload=true&count=20&cur_tab=1&from=search_tab
    url = 'https://www.toutiao.com/search_content/?' + urlencode(data)
    try:
        response = requests.get(url)
        if response.status_code == 200:
            return response.text
        return None
    except RequestException:
        print("请求索引页出错")
        return None


# 解析索引页：获取索引页中每个图片集的连接地址
#------------------------------------------------------------------------------ 
def parsePageIndex(html):
    try:
        # 将html字符串转为json数据
        data = json.loads(html)
        # 如果data存在，并且存在是data的key键时
        if data and 'data' in data.keys():
            for item in data.get('data'):
                # 获取每一个图片集的连接
                yield item.get('article_url')
    except JSONDecodeError:
        pass
    

# 请求详情页：将请求过来的每一个图片集的连接返回一个页面
#------------------------------------------------------------------------------ 
def getPageDetail(url):   
    try:
        response = requests.get(url)
        if response.status_code == 200:
            return response.text
        return None
    except RequestException:
        print('请求详情页出错')
        return None


# 解析详情页的内容：解析每一个图片集中图片内容
#------------------------------------------------------------------------------ 
def parsePageDetail(html, url):
    # 使用BeautifulSoup获取标题内容
    soup = BeautifulSoup(html,'lxml')
    title = soup.select('title')[0].get_text()
    print(title)
    
    # 使用正则抓取页面的地址
    images_pattern = re.compile('var gallery = (.*?);', re.S)
    result = re.search(images_pattern, html)
    
    if result:
        data = json.loads(result.group(1))
        if data and 'sub_images' in data.keys():
            sub_images = data.get('sub_images')
            images = [item.get('url') for item in sub_images]
            for image in images:
                downloadImage(image)
            # 返回一个字典
            return {
                'title': title,
                'url': url,
                'images': images
            }



# 存储至数据库   
#------------------------------------------------------------------------------ 
def saveToMongo(result):
    if db[MONGO_TABLE.insert(result)]:
        print('存储至MongoDB成功！', result)
        return True
    return False


# 下载图片
#------------------------------------------------------------------------------ 
def downloadImage(url):
    print('正在下载：', url)
    try:
        response = requests.get(url)
        if response.status_code == 200:
            # 一般响应的是文字，则使用text，如果是图片使用content
            saveImage(response.content)
    except RequestException:
        print('请求图片出错', url)
        return None


# 存储图片
#------------------------------------------------------------------------------ 
def saveImage(content): 
    # 0表示路径；1表示文件名；这里使用md5防止文件名重复；2表示后缀名
    filePath = '{0}/{1}.{2}'.format(os.getcwd(),md5(content).hexdigest(),'jpg')
    if not os.path.exists(filePath):
        with open(filePath, 'wb') as f:
            f.write(content)
            f.close()
    
# 主函数
#------------------------------------------------------------------------------ 
def main(offset):
    html = getPageIndex(offset, KEYWORD)
    for url in parsePageIndex(html):
        html = getPageDetail(url)
        if html:
            result = parsePageDetail(html)
            # 存储至数据库
            if result:
                saveToMongo(result)
    
    
if __name__ == '__main__':
    main()
    groups = [x*20 for x in range(GROUP_START,GROUP_END + 1)]
    pool = Pool()
    pool.map(main, groups)















































































