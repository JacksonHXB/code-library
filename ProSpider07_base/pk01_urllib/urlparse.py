
#--- urlparse --------------------------------------------------------------------------- 
from urllib.parse import urlparse
def parse1():
    result = urlparse("http://www.baidu.com/index.html;user?id=5#comment")
    print(type(result),result)
    
    result1 = urlparse("www.baidu.com/index.html;user?id=5#comment",schema="https")
    print(result1)
    
    result2 = urlparse("http://www.baidu.com/index.html;user?id=5#comment",schema="https")
    print(result2)
    
    result3 = urlparse("http://www.baidu.com/index.html;user?id=5#comment",allow_fragments=False)
    print(result3)
    
    
#--- urlunparse:拼接URL --------------------------------------------------------------------------- 
from urllib.parse import urlunparse
def urlunparse1(): 
    data = ["http","www.baidu.com","index.html","user","a=6","comment"]  
    print(urlunparse(data))

#--- urljoin -------------------------------------------------------------------------- 
from urllib.parse import urljoin
def urljoin1():
    print(urljoin("http://www.baidu.com","FAQ.html"))
 
#----- urlencode ------------------------------------------------------------------------- 
from urllib.parse import urlencode    

params = {
    "name":"germey",
    "age":22
}
base_url = "http://www.baidu.com?"
url = base_url + urlencode(params)
print(url)
    
    
    







































