#===============================================================================
# 视图
#===============================================================================

from tornado.web import RequestHandler
from models import Students


#----- 普通cookie -------------------------------------------------------------- 
class PCookieHandler(RequestHandler):    
    def get(self, *args, **kwargs):
        # 设置Cookie
        self.set_cookie("Jackson","good")
        # cookie的原理
        self.set_header("Set-Cookie","Jackson=nice;Paht=/")
        self.write("OK")
        
        
#--- 获取cookie ---------------------------------------------------------------
class GetPCookieHandler(RequestHandler):
    def get(self, *args, **kwargs):
        # 获取cookie
        cookie = self.get_cookie("demo", "未登录")
        print("cookie=",cookie)
        self.write("OK")
        

#--- 清除Cookie ---------------------------------------------------------------
class ClearPCookieHandler(RequestHandler):
    def get(self, *args, **kwargs):
        # 方式一:清除一个cookie
        self.clear_cookie("Jackson")
        
        # 方式二：清除所有cookie
        self.clear_all_cookies()
        
        self.write("OK")
        
        
#--- 生成密钥 ------------------------------------------------------------------
# import base64
# import uuid
# class generateKey():
#     print("generateKey:" + (base64.b64encode(uuid.uuid4().bytes + uuid.uuid4().bytes))


#----- 设置安全cookie -------------------------------------------------------------- 
class SCookieHandler(RequestHandler):    
    def get(self, *args, **kwargs):
        # 设置安全cookie
        self.set_secure_cookie("hxb", "nice")
        
        self.write("OK")


#------ 获取安全cookie ------------------------------------
class GetSCookieHandler(RequestHandler):
    def get(self, *args, **kwargs):
        # 获取安全cookie
        scookie = self.get_secure_cookie("hxb")
        print("scookie=" + str(scookie))









































