#===============================================================================
# Tornado服务器--options
#===============================================================================

import tornado.web
import tornado.ioloop
import tornado.httpserver
# 引入options模块
import tornado.options

# 创建全局变量
tornado.options.define("port",default=8000,type=int)
tornado.options.define("list",default=[],type=str,multiple=True)

class IndexHandler(tornado.web.RequestHandler):
    def get(self,*args,**kwargs):
        self.write("Jackson2 is a good man!")

if __name__ == "__main__":
    # 将命令行里面的参数进行转换，并保存到tornado.options.options
    tornado.options.parse_command_line()
    print("list=", tornado.options.options.list)
    
    app = tornado.web.Application([
        (r"/", IndexHandler)                               
    ])
    httpServer = tornado.httpserver.HTTPServer(app)
    
    # 获取全局变量的值
    httpServer.bind(tornado.options.options.port)
    httpServer.start(5)
    
    tornado.ioloop.IOLoop.current().start()






































































