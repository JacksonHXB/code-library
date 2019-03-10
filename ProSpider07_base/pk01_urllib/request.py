#===============================================================================
# 
#===============================================================================


#-- 使用GET请求，请求百度网址 ---------------------------------------------------------- 
import urllib.request
def request1():                              
    response = urllib.request.urlopen("http://www.baidu.com")
    print(response.read().decode("UTF-8"))
   
                      
#--- 使用POST请求 ------------------------------------------------------------------ 
import urllib.parse
import urllib.request
def request2():
    # 向连接中输入字典
    data = bytes(urllib.parse.urlencode({"word":"hello"}),encoding="UTF-8")
    response = urllib.request.urlopen("http://httpbin.org/post", data=data)
    print(response.read())
 
 
#--- 超时设置 --------------------------------------------------------------------- 
import urllib.request
def request3():
    response = urllib.request.urlopen("http://httpbin.org/get",timeout=1)
    print(response.read())
    
    
#--- 超时设置2 -------------------------------------------------------------------- 
import socket
import urllib.request
import urllib.error
def request4():
    try:
        response = urllib.request.urlopen("http://httpbin.org/get",timeout=0.1)
    except urllib.error.URLError as e:
        if isinstance(e.reason,socket.timeout):
            print("TIME OUT")   
    
    
#--- response ------------------------------------------------------------------ 
import urllib.request
def response1():
    response = urllib.request.urlopen("http://www.python.org")
    print("响应类型：", type(response))
    print("状态码：", response.status)
    print("响应头：", response.getheaders())
    print("响应头2：", response.getheader("Server"))


#---- 添加headers并发送请求 ---------------------------------------------------------- 
from urllib import request,parse

def request5():
    url = "http://httpbin.org/post"
    headers = {
        "User=Agent":"Mozilla/4.0 (compatible;MSIE 5.5; Windows NT)",
        "Host":"httpbin.org"
    }
    dictStr = {"name":"Germey"}
    data = bytes(parse.urlencode(dictStr), encoding='utf8')
    req = request.Request(url=url, data=data, headers=headers,method="POST")
    response = request.urlopen(req)
    print(response.read().decode("UTF-8"))
    
    
#---- add_header并发送请求 ---------------------------------------------------------- 
from urllib import request,parse
def request6():
    url = "http://httpbin.org/post"
    dictStr = {"name":"Germey"}
    data = bytes(parse.urlencode(dictStr),encoding="utf8")
    req = request.Request(url=url,data=data,method="POST")
    req.add_header("User=Agent","Mozilla/4.0 (compatible;MSIE 5.5; Windows NT)")
    response = request.urlopen(req)
    print(response.read().decode("UTF-8"))


# 调用函数
request5()
































