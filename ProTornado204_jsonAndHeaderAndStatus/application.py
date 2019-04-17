
import tornado.web
import config
from views.index import IndexHandler,JacskonHandler,Json1Handler,Json2Handler,HeaderHandler,StatusHandler

class Application(tornado.web.Application):
    def __init__(self):
        handlers = [
            (r'/', IndexHandler),
            # 传递参数
            (r'/jackson', JacskonHandler,{"word1":"good","word2":"nice"}),
            # json
            (r'/json1', Json1Handler),
            (r'/json2', Json2Handler),
            
            # header
            (r'/header', HeaderHandler),
            
            # 状态码
            (r'/status', StatusHandler),
        ]
        super(Application,self).__init__(handlers,**config.settings)






































































































