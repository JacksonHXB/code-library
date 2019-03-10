#===============================================================================
# Requests库
#===============================================================================

#---- 实例引入 -------------------------------------------------------------------------- 
import requests

def demo1():
    response = requests.get("https://www.baidu.com/")
    print(type(response))
    print(response.status_code)
    print(type(response.text))
    print(response.text)
    print(response.cookies)

#-- 各种请求方式 ---------------------------------------------------------------------------- 
import requests
def demo2():
    requests.post("http://httpbin.org/post")
    requests.put("http://httpbin.org/put")
    requests.delete("http://httpbin.org/delete")
    requests.head("http://httpbin.org/get")
    requests.options("http://httpbin.org/get")
    
#---- 基本GET请求 -------------------------------------------------------------------------- 
import requests 
def request1():
    response = requests.get("http://httpbin.org/get")
    print(response.text)

#----- 携带参数的GET请求 ------------------------------------------------------------------------ 
import requests
def request2():
    response = requests.get("http://httpbin.org/get?name=germey&age=23")
    print(response.text)
def request3():
    data = {"name":"germey","age":22}
    response = requests.get("http://httpbin.org/get", params=data)
    print(response.text)

#---- 解析JSON -------------------------------------------------------------------------- 
import requests
def json():
    response = requests.get("http://httpbin.org/get")
    print(type(response.text))
    print(response.json())
    print(type(response.json()))

#---- 获取二进制数据 -------------------------------------------------------------------------- 
import requests
def getBinary1():
    response = requests.get("http://github.com/favicon.ico")
    print(type(response.text),type(response.content))
    print(response.text)
    print(response.content)
# 保存二进制文件
import requests
def saveBinary():
    response = requests.get("http://github.com/favicon.ico")
    with open("favicon.ico", "wb") as f:
        f.write(response.content)
        f.close()
    
#---- 添加headers -------------------------------------------------------------------------- 
import requests
def addHeaders():
   headers = {"User-Agent":"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36"} 
   response = requests.get("https://www.zhibu.com/explore",headers=headers)
   print(response.text)


#----- 基本POST请求 ------------------------------------------------------------------------- 
import requests
def post():
    data = {"name":"germey","age":"22"}
    headers = {"User-Agent":"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36"} 
    response = requests.post("http://httpbin.org/post", data=data, headers=headers)
    print(response.json())
















getBinary1()
















































