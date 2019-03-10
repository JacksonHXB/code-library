#===============================================================================
# Selenium
#===============================================================================

#---- 基本使用 -------------------------------------------------------------------------- 
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.wait import WebDriverWait

def base():
    browser = webdriver.Chrome360()
    try:
        # 打开百度
        browser.get('http://www.baidu.com')
        myinput = browser.find_element_by_id('kw')
        # 向元素里面发送值
        myinput.send_keys('Python')
        # 按下回车
        myinput.send_keys(Keys.ENTER)
        # 等待元素被加载
        wait = WebDriverWait(browser,10)
        wait.until(EC.presence_of_element_located((By.ID,'content_left')))
        print(browser.current_url)
        print()
        print(browser.get_cookies())
        print()
        print(browser.page_source)
    finally:
        browser.close()
        
        
# 声明浏览器对象
#------------------------------------------------------------------------------ 
def defineBrowser():
    browser = webdriver.Chrome()
    browser = webdriver.Firefox()
    browser = webdriver.Edge()
    browser = webdriver.PhantomJS()


# 访问页面
#------------------------------------------------------------------------------ 
def visitWeb():
    browser = webdriver.Chrome360()
    browser.get('https://www.taobao.com')
    print(browser.page_source)
    browser.close()
    
    
# 查找元素1
#------------------------------------------------------------------------------ 
def selectItem():   
    browser = webdriver.Chrome360()
    browser.get('http://www.taobao.com')
    input_first = browser.find_element_by_id('q')
    input_second = browser.find_element_by_css_selector('#q')
    input_third =browser.find_element_by_xpath('//*[@id="q"]')
    print(input_first,input_second,input_third)
    browser.close()


# 查找元素2-通用查找方式
#------------------------------------------------------------------------------ 
def selectItem2():
    browser = webdriver.Chrome360()
    browser.get('https://www.taobao.com')
    input_first = browser.find_element(By.ID,'q')
    print(input_first)
    browser.close()
    

# 查找多个元素1
#------------------------------------------------------------------------------ 
def selectItems():
    browser = webdriver.Chrome360()
    browser.get('https://www.taobao.com')
    lis = browser.find_elements_by_css_selector('.service-bd li')
    print(lis)
    browser.close()


# 查找多个元素2-通用查找方式
#------------------------------------------------------------------------------ 
def selectItems2():
    browser = webdriver.Chrome360()
    browser.get('https://www.taobao.com')
    lis = browser.find_elements(By.CSS_SELECTOR, '.service-bd li')
    print(lis)
    browser.close()


# 元素的交互操作
#------------------------------------------------------------------------------ 
import time
def useForm():
    browser = webdriver.Chrome360()
    browser.get('https://www.taobao.com')
    # 查找ID为q的文本输入框
    input = browser.find_element_by_id('q')
    # 向输入框中输入iPhone
    input.send_keys('iPhone')
    # 等待1s
    time.sleep(1)
    # 清空文本框
    input.clear()
    # 重新输入iPad
    input.send_keys('iPad')
    # 查找搜索按钮
    button = browser.find_element_by_class_name('btn-search')
    # 点击搜索按钮
    button.click()
    
    
# 交互动作  
#------------------------------------------------------------------------------ 
# 模拟鼠标拖拽
from selenium.webdriver import ActionChains
def communicate():
    browser = webdriver.Chrome360()
    url = 'http://www.runoob.com/try/try.php?filename=jqueryui-api-droppable'
    browser.get(url)
    browser.switch_to.frame('iframeResult')
    source = browser.find_element_by_css_selector('#draggable')
    target = browser.find_element_by_css_selector('#droppable')
    actions = ActionChains(browser)
    actions.drag_and_drop(source, target)
    actions.perform()
    
    
# 执行javascript
#------------------------------------------------------------------------------ 
# 模拟下拉滚动条
def useJavascript():
    browser = webdriver.Chrome360()
    browser.get('https://www.zhihu.com/explore')
    browser.execute_script('window.scrollTo(0,document.body.scrollHeight)')
    browser.execute_script('alert(To Button)')
    
    
# 获取元素信息
#------------------------------------------------------------------------------ 
# 获取属性值
def getElementInfo():
    browser = webdriver.Chrome360()
    browser.get('https://www.zhihu.com/explore')
    logo = browser.find_element_by_id('zh-top-link-logo')
    print(logo)
    print(logo.get_attribute('class'))

# 获取文本值
def getElementInfo2():
    browser = webdriver.Chrome360()
    browser.get('https://www.zhihu.com/explore')
    input = browser.find_element_by_cass_name('zu-top-add-question')
    print(input.text)

# 获取ID,位置，标签名，大小
def getElementInfo3():
    browser = webdriver.Chrome360()
    browser.get('https://www.zhihu.com/explore')
    input = browser.find_element_by_class_name('zu-top-add-question')
    print(input.id)
    print(input.location)
    print(input.tag_name)
    print(input.size)


# Frame  
#------------------------------------------------------------------------------ 
import time
from selenium import webdriver
from selenium.common.exceptions import NoSuchElementException
def frame():
    browser = webdriver.Chrome360()
    url = 'http://www.runoob.com/try/try.php?filename=jqueryui-api-droppable'
    browser.get(url)
    browser.switch_to.frame('iframeResult')
    source = browser.find_element_by_css_selector('#draggable')
    print(source)
    try:
        logo = browser.find_element_by_class_name('logo')
    except NoSuchElementException:
        print('NO LOGO')
    browser.switch_to.parent_frame()
    logo = browser.find_element_by_class_name('logo')
    print(logo)
    print(logo.text)


# 等待
#------------------------------------------------------------------------------ 
# 隐式等待
def browserWait1():
    browser = webdriver.Chrome360()
    browser.implicitly_wait(10)
    browser.get('https://www.zhibu.com/explore')
    myinput = browser.find_element_by_class_name('zu-top-add-question')
    print(myinput)

# 显式等待
def browserWait2():
    browser = webdriver.Chrome360()
    browser.get('https://www.taobao.com/')
    wait = WebDriverWait(browser,10)
    myinput = wait.until(EC.presence_of_element_located(By.ID, 'q'))
    button = wait.until(EC.element_to_be_clickable(By.CSS_SELECTOR,'btn-search'))
    print(myinput,button)

    
# 前进后退
#------------------------------------------------------------------------------ 
import time
from selenium import webdriver
def test():
    browser = webdriver.Chrome360()
    browser.get('https://www.baidu.com')
    browser.get('https://www.taobao.com')
    browser.get('https://www.python.org')
    browser.back()
    time.sleep(1)
    browser.forward()
    browser.close()
    

# cookies
#------------------------------------------------------------------------------ 
def testCookie():
    browser = webdriver.Chrome360()
    browser.get('https://www.zhihu.com/explore')
    print(browser.get_cookies)
    browser.add_cookie({'name':'name','domain':'www.zhihu.com','value':'germey'})
    print(browser.get_cookies)
    browser.delete_all_cookies()
    print(browser.get_cookies)


# 选项卡管理
#------------------------------------------------------------------------------ 
def myoptions():
    browser = webdriver.Chrome360()
    browser.get('https://www.baidu.com')
    browser.execute_script('window.open()')
    print(browser.window_handles)
    browser.switch_to_window(browser.window_handles[1])
    browser.get('https://www.taobao.com')
    time.sleep()
    browser.switch_to_window(browser.window_handles[0])
    browser.get('https://python.org')


# 异常处理  
#------------------------------------------------------------------------------ 
from selenium.common.exceptions import TimeoutException,NoSuchElementException
def testexception():
    browser = webdriver.Chrome360()
    try:
        browser.get('https://www.baidu.com')
    except TimeoutException:
        print("Time Out")
    try:
        browser.find_element_by_id('hello')
    except NoSuchElementException:
        print('No Element')
    finally:
        browser.close()
    
    



















