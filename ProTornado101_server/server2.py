#===============================================================================
# Tornado服务器--自定义服务器
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
    
    # 自定义http服务器
    httpserver = tornado.httpserver.HTTPServer(app)
    # 绑定端口
    httpserver.listen(8000)
    
    tornado.ioloop.IOLoop.current().start()














































































