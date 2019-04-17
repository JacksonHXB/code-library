#===============================================================================
# Tornado服务器--设置服务器多进程
#===============================================================================

import tornado.web
import tornado.ioloop
# 引入服务器模块
import tornado.httpserver

class IndexHandler(tornado.web.RequestHandler):
    def get(self,*args,**kwargs):
        self.write("Jackson2 is a good man!")

if __name__ == "__main__":
    app = tornado.web.Application([
        (r"/", IndexHandler)                               
    ])
    httpServer = tornado.httpserver.HTTPServer(app)
    # 绑定端口
    httpServer.bind(8000)
    # 设置进程数
    httpServer.start(5)
    
    tornado.ioloop.IOLoop.current().start()














































































