#---- test -------------------------------------------------------------------------- 
from urllib import request,error
def exception1():
    try:
        # 请求不存在的网页
        response = request.urlopen("http://cuiqingcai.com/index.html")
    except error.URLError as e:
        # 输出异常的原因
        print(e.reason)
        

#--- test2 --------------------------------------------------------------------------- 
from urllib import request,error
def exception2():
    try:
        response = request.urlopen("http://cuiqingcai.com/index.html")
    except error.HTTPError as e:
        print(e.reason,e.code,e.headers,sep="\n")
    except error.URLError as e:
        print(e.reason)
    else:
        print("Request Successfully")

#--- test3 --------------------------------------------------------------------------- 
import socket
import urllib.request
import urllib.error

def exception3():
    try:
        response = urllib.request.urlopen("https://www.baidu.com",timeout=0.01)
    except urllib.error.URLError as e:
        print(type(e.reason))
        if isinstance(e.reason, socket.timeout):
            print("TIME OUT")



























