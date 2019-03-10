#===============================================================================
# Requests高级操作
#===============================================================================

#--- 文件上传 --------------------------------------------------------------------------- 
import requests
def upfiles():
    files = {"file":open("favicon.ico", "rb")}
    response = requests.post("http://httpbin.org/post",files=files)
    print(response.text)

#--- 获取cookie --------------------------------------------------------------------------- 
import requests
def getCookie():
    response = requests.get("https://www.baidu.com")
    print(response.cookies)
    for key,value in response.cookies.items():
        print(key + "=" + value)
        
#--- 会话维持 --------------------------------------------------------------------------- 
import requests
def cookie1():
    requests.get("http://httpbin.org/cookies/set/number/123456789")
    response = requests.get("http://httpbin.org/cookies")
    print(response.text)
    
def cookie2():
    s = requests.Session()
    s.get("http://httpbin.org/cookies/set/number/123456789")
    response = s.get("http://httpbin.org/cookies")
    print(response.text)
    
#--- 证书验证 --------------------------------------------------------------------------- 
import requests
def validate1():
    response = requests.get("https://www.12306.cn")
    print(response.status_code)

def validate2():
    response = requests.get("http://www.12306.cn",verify=False)
    print(response.status_code)

def validate3():
    response = requests.get("https://www.12306.cn",cert=('/path/server.crt','/path/key'))
    print(response.status_code)

#---- 代理设置 -------------------------------------------------------------------------- 
import requests
def proxy1():
    proxies = {
       "http":"http://127.0.0.1:8080", 
       "https":"https://127.0.0.1:8080"
    }
    response = requests.get("https://www.taobao.com",proxies=proxies)
    print(response.status_code)

def proxy2():
    proxies = {
       "http":"socks5://127.0.0.1:8080", 
       "https":"socks5://127.0.0.1:8080"
    }
    response = requests.get("https://www.taobao.com",proxies=proxies)
    print(response.status_code)
    
 
#--- 超时设置 --------------------------------------------------------------------------- 
import requests
def timeout():
    response = requests.get("https://www.taobao.com",timeout=1)
    print(response.status_code)


#---- 认证设置 -------------------------------------------------------------------------- 
import requests
from requests.auth import HTTPBasicAuth
def auth():
    r = requests.get("http://127.0.0.1:9000",auth=HTTPBasicAuth("user","123"))
    print(r.stauts_code)

#---- 异常处理 -------------------------------------------------------------------------- 
import requests
from requests.exceptions import ReadTimeout,HTTPError,RequestException
def excep():
    try:
        res = requests.get("http://httpbin.org/get",timeout=0.5)
        print(res.status_code)
    except ReadTimeout:
        print("Timeout")
    except HTTPError:
        print("Http error")
    except RequestException:
        print("Error")

























