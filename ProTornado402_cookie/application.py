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
              
            # 获取普通cookie
            (r'/getPCookie', index.GetPCookieHandler),
            
            # 清除Cookie
            (r'/clearPCookie', index.ClearPCookieHandler),
            
            # 设置安全cookie
            (r'/scookie', index.SCookieHandler),
            
            # 获取安全cookie
            (r'/getSCookie', index.GetSCookieHandler),
                    
            # 默认主页
            (r'/(.*)$', tornado.web.StaticFileHandler, {"path":os.path.join(config.BASE_DIRS, "static/html"),"default_filename":"index.html"})
        ]
        super(Application,self).__init__(handlers,**config.settings)





































































































