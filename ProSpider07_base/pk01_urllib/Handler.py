
#----- 使用代理 ------------------------------------------------------------------------- 
import urllib.request

def handler():
    proxy_handler = urllib.request.ProxyHandler({
        "http":"http://127.0.0.1:8000",
        "https":"https://127.0.0.1:8000"
    })
    opener = urllib.request.build_opener(proxy_handler)
    response = opener.open("http://www.baidu.com")
    print(response.read())

#--- cookie --------------------------------------------------------------------------- 
import http.cookiejar,urllib.request
def cookie1():
    cookie = http.cookiejar.CookieJar
    handler = urllib.request.HTTPCookieProcessor(cookie)
    opener = urllib.request.build_opener(handler)
    response = opener.open("http://www.baidu.com")
    # 输出所有cookie
    for item in cookie:
        print(item.name + "=" + item.value)

#--- 将cookie在本地保存成文件 -----------------------------------------------------------------
import http.cookiejar,urllib.request
def cookie2():
    filename = "cookie.txt"
    cookie = http.cookiejar.MozillaCookieJar(filename)
    handler = urllib.request.HTTPCookieProcessor(cookie)
    opener = urllib.request.build_opener(handler)
    response = opener.open("http://www.baidu.com")
    cookie.save(ignore_discard=True, ignore_expires=True)


#--- 将cookie在本地保存成文件2 ---------------------------------------------------------------- 
import http.cookiejar,urllib.request
def cookie3():
    filename = "cookie.txt"
    cookie = http.cookiejar.LWPCookieJar(filename)
    handler = urllib.request.HTTPCookieProcessor(cookie)
    opener = urllib.request.build_opener(handler)
    response = opener.open("http://www.baidu.com")
    cookie.save(ignore_discard=True, ignore_expires=True)
    
    
#--- 读取cookie信息 --------------------------------------------------------------------------- 
import http.cookiejar,urllib.request
def cookie4():
    cookie = http.cookiejar.LWPCookieJar
    cookie.load("cookie.txt", ignore_discard=True, ignore_expires=True)
    handler = urllib.request.HTTPCookieProcessor(cookie)
    opener = urllib.request.build_opener(handler)
    response = opener.open("http://www.baidu.com")
    print(response.read().decode("UTF-8"))
    



handler()















































































