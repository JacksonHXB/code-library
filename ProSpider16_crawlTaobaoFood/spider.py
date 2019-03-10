#===============================================================================
# 使用Selenium模拟浏览器抓取淘宝商品美食信息
#===============================================================================
import re
from selenium import webdriver
from selenium.common.exceptions import TimeoutException
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.ui import WebDriverWait
from pyquery import PyQuery as pq
from config import *
import pymongo


# 初始化MongoDB相关对象
client = pymongo.MongoClient(MONGO_URL)
db = client(MONGO_DB)

# 初始化浏览器
# browser = webdriver.Chrome360()
browser = webdriver.PhantomJS(service_args=SERVICE_ARGS)
browser.set_window_size(1400, 900)# 设置浏览器窗口大小

# 初始化等待对象了
wait = WebDriverWait(browser, 10)


# 搜索操作
#------------------------------------------------------------------------------ 
def search():
    print('正在搜索！')
    try:
        browser.get('https://www.taobao.com')
        # 当ID为q的元素加载出的时候就获取该元素
        inputField = wait.until(
            EC.presence_of_element_located((By.CSS_SELECTOR, "#q"))
        )
        # 当元素可以点击的时候就获取该元素
        searchBtn = wait.until(EC.element_to_be_clickable((By.CSS_SELECTOR, '#J_TSearchForm > div.search-button > button')))
        # 在输入框中输入内容
        inputField.send_keys('美食')
        # 点击搜索按钮
        searchBtn.click()
        # 返回总的页数
        total = wait.until(EC.presence_of_element_located((By.CSS_SELECTOR, '#mainsrp-pager > div > div > div > div.total')))
        # 解析页面
        parseGoods()
        return total.text
    except TimeoutException:
        # 使用递归方式重新请求
        return search()


# 获取下一页
#------------------------------------------------------------------------------ 
def nextPage(pageNumber):
    print('正在翻页：', pageNumber)
    try:
        # 获取第几页的输入框
        inputField = wait.until(
            EC.presence_of_element_located((By.CSS_SELECTOR, "#mainsrp-pager > div > div > div > div.form > input"))
        )
        # 获取跳转到第几页的确定按钮
        submitBtn = wait.until(EC.element_to_be_clickable((By.CSS_SELECTOR, '#mainsrp-pager > div > div > div > div.form > span.btn.J_Submit')))
        # 清除输入框中的内容
        inputField.clear()
        # 向输入框中传入跳转的页码数
        input.send_keys(pageNumber)
        # 点击跳转按钮
        submitBtn.click()
        # 等待并判断是否已经跳转到指定的页面
        wait.until(EC.text_to_be_present_in_element((By.CSS_SELECTOR, '#mainsrp-pager > div > div > div > ul > li:nth-child('+ str(int(pageNumber)+1) +') > a'), str(pageNumber)))
        # 解析页面
        parseGoods()
    except TimeoutException:
        nextPage(pageNumber)


# 解析获取的每一页内容
#------------------------------------------------------------------------------ 
def parseGoods():
    # 等待相关元素加载成功
    wait.until(EC.presence_of_element_located((By.CSS_SELECTOR, '#mainsrp-itemlist > div > div > div:nth-child(1) > div:nth-child(41)')))
    # 获取网页源代码
    html = browser.page_source
    # 使用PyQuery解析网页源代码
    doc = pq(html)
    # 获取所有商品信息
    items = doc('#mainsrp-itemlist > div > div > div:nth-child(1) > div:nth-child(41)').items()
    # 遍历所有商品信息，并将单个商品存入到数据库中
    for item in items:
        good = {
            'image': item.find('.pic .img').attr('src'),
            'price': item.find('.price').text(),
            'deal': item.find('.deal-cnt').text()[:-3],
            'title': item.find('.title').text(),
            'shop': item.find('.shop').text(),
            'location': item.find('.location').text()
        }
        print(good)
        # 将解析的单个商品存入到MongoDB数据库中
        saveToMongodb(good)


# 保存至mongodb
#------------------------------------------------------------------------------ 
def saveToMongodb(result):
    try:
        if db[MONGO_TABLE].insert(result):
            print('保存到MongoDB成功！', result)
    except Exception:
        print('存储到MongoDB错误！', result)
        
        
# 主函数
#------------------------------------------------------------------------------ 
def main():
    try:
        total = search()# 共 100 页，
        # 提取页码 100
        total = int(re.compile('(\d+)').search(total).group(1))
        # 根据页码遍历所遇商品
        for i in range(2, total+1):
            nextPage(i)
    except Exception:
        print('出错了！')
    finally:
        browser.close()
    
    
if __name__ == '__main__':
    main()















































































