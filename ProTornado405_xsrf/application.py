#===============================================================================
# 应用程序与路由
#===============================================================================

import tornado.web
import config
import os
from views import index

class Application(tornado.web.Application):
    def __init__(self):
        handlers = [
            # 设置普通cookie
            (r'/pcookie', index.PCookieHandler),
            
            # cookie计数,记录浏览器访问次数
            (r'/cookienum1', index.PCookieHandler),
            
            # 获取cookie计数
            (r'/getCookie', index.GetCookieHandler),
            
            # 设置cookie计数
            (r'/setCookie', index.SetCookieHandler),
            
            # 设置_xsrf的cookie
            (r'/setxsrfcookie',index.SetXSRFCookie),
            
            # 默认主页
            (r'/(.*)$', index.StaticFileHandler,{"path":os.path.join(config.BASE_DIRS, "static/html"),"default_filename":"index.html"})
        ]
        super(Application,self).__init__(handlers,**config.settings)





































































































