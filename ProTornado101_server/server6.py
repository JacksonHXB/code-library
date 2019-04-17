#===============================================================================
# Tornado服务器--options-config.py
#===============================================================================

import tornado.web
import tornado.ioloop
import tornado.httpserver
# 导入配置文件
import config

class IndexHandler(tornado.web.RequestHandler):
    def get(self,*args,**kwargs):
        self.write("Jackson2 is a good man!")

if __name__ == "__main__":
    print("list=", config.options["list"])
    
    app = tornado.web.Application([
        (r"/", IndexHandler)                               
    ])
    httpServer = tornado.httpserver.HTTPServer(app)
    
    httpServer.bind(config.options["port"])
    httpServer.start(5)
    
    tornado.ioloop.IOLoop.current().start()






































































