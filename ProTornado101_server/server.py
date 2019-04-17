#===============================================================================
# Tornado服务器--测试
#===============================================================================

# tornado的基础web框架模块
import tornado.web
# tornado的核心IO循环模块，封装了Linux的epoll和BSD的kqueue，是tornado高效的基础
import tornado.ioloop

# 类视图，一个业务处理类
class IndexHandler(tornado.web.RequestHandler):
    # 处理GET请求的，不能处理POST请求
    def get(self,*args,**kwargs):
        # 对应http请求的方法，给浏览器响应信息
        self.write("Jackson is a good man!")

if __name__ == "__main__":
    # 实例化APP应用
    # Application:是tornado web框架的核心应用类，是与服务器对应的接口
    # 里面保存了路由映射表
    app = tornado.web.Application([
        (r"/", IndexHandler)                               
    ])
    # .listen创建服务器，并绑定端口
    app.listen(8000)
    # IOLoop.current()：返回当前线程的IOLoop实例
    # IOLoop.start()：启动了IOLoop的I/O循环，同时开启了监听
    tornado.ioloop.IOLoop.current().start()















































































