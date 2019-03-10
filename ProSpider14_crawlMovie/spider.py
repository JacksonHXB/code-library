import json
import re
from multiprocessing import pool
import requests
from requests.exceptions import RequestException


# 请求单页
#------------------------------------------------------------------------------ 
def getOnePage(url):
    try:
        # 发出请求
        response = requests.get(url)
        # 判断请求的响应状态码
        if response.status_code == 200:
            # 返回响应的内容
            return response.text
        return None
    except RequestException:
        return None


# 解析单页
#------------------------------------------------------------------------------ 
def parseOnePage(html):
    # 创建正则对象
    pattern = re.compile('<dd>.*?board-index.*?>(\d+)</i>'
                        +'.*?data-src="(.*?)"'
                        +'.*?name"><a.*?>(.*?)</a>'
                        +'.*?star">(.*?)</p>'
                        +'.*?releasetime">(.*?)</p>'
                        +'.*?integer">(.*?)</i>'
                        +'.*?fraction">(.*?)</i>'
                        +'.*?</dd>', re.S)
    items = re.findall(pattern, html)
    for item in items:
        # 生成器
        yield{
            'index':item[0],
            'image':item[1],
            'title':item[2],
            'actor':item[3].strip()[3:],
            'time':item[4].strip()[5:],
            'score':item[6]+item[6]
        }


# 存储至文件
#------------------------------------------------------------------------------
def writeToFile(content): 
    # 读取文件文件并写入，a表示追加，encoding一定要写
    with open('result.txt', 'a', encoding='UTF-8') as f:
        f.write(json.dumps(content, ensure_ascii=False) + '\n')
        f.close()


# 主函数
#------------------------------------------------------------------------------ 
def main(offset):
    url = 'http://maoyan.com/board/4?offset=' + str(offset)
    html = getOnePage(url)
    for item in parseOnePage(html):
        print(item)
        writeToFile(item)
    
    

if __name__ == '__main__':
    # 进程池,加快抓取速度
    pool = pool.Pool()
    pool.map(main, [i*10 for i in range(10)])








































