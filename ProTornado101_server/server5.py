#===============================================================================
# Tornado服务器--options
#===============================================================================

import tornado.web
import tornado.ioloop
import tornado.httpserver
import tornado.options

tornado.options.define("port",default=8000,type=int)
tornado.options.define("list",default=[],type=str,multiple=True)

class IndexHandler(tornado.web.RequestHandler):
    def get(self,*args,**kwargs):
        self.write("Jackson2 is a good man!")

if __name__ == "__main__":
    # 将配置文件中的参数进行转换，并保存到tornado.options.options
    tornado.options.parse_config_file("config")
    print("list=", tornado.options.options.list)
    
    app = tornado.web.Application([
        (r"/", IndexHandler)                               
    ])
    httpServer = tornado.httpserver.HTTPServer(app)
    
    httpServer.bind(tornado.options.options.port)
    httpServer.start(5)
    
    tornado.ioloop.IOLoop.current().start()






































































