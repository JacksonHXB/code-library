#===============================================================================
# Response
#===============================================================================

#--- response属性 --------------------------------------------------------------------------- 
import requests
def getRespProperties():
    response = requests.get("http://www.jianshu.com")
    print(type(response.status_code),response.status_code)
    print(type(response.headers),response.headers)
    print(type(response.cookies), response.cookies)
    print(type(response.url), response.url)
    print(type(response.history), response.history)

#--- 状态码判断 -------------------------------------------------------------------------- 
import requests
def isStusts():
    response = requests.get("http://www.jianshu.com")
    exit() if not response.status_code == requests.codes.ok else print("Request Successfully")
    exit() if not response.status_code == 200 else print("Request Successfully")











getRespProperties()




















































