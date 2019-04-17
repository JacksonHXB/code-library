#===============================================================================
# 视图
#===============================================================================
from tornado.web import RequestHandler

class IndexHandler(RequestHandler):
    def get(self,*args,**kwargs):
        self.write("Jackson is a good man!")


class JacskonHandler(RequestHandler):
    # 接收参数,该方法会在HTTP方法之前调用
    def initialize(self, word1, word2):
        self.word1 = word1
        self.word2 = word2
    def get(self,*args,**kwargs):
        print("接收的参数为：" + self.word1 + "\t" +self.word2)
        self.write("Jackson is a nice man!");


# json1
import json
class Json1Handler(RequestHandler):
    def get(self,*args,**kwargs):
        # 创建字典
        per = {
            "name":"Jackson",
            "age":18,
            "height":175,
            "weight":70
        }
        # 将字典转为JSON字符串
        jsonStr = json.dumps(per)
        # 设置请求之后，将会和Json2Handler一样的效果
        self.set_header("Content-Type", "application/json;charset=UTF-8")
        # 自定义请求头
        self.set_header("Jackson", "good")
        self.write(jsonStr)


# json2(建议方式)
import json
class Json2Handler(RequestHandler):
    def get(self, *args, **kwargs):
        # 创建字典
        per = {
            "name":"Jackson",
            "age":18,
            "height":175,
            "weight":70
        }
        # write方法能将直接将对象或字典转化为JSON字符串
        self.write(per)


# header
class HeaderHandler(RequestHandler):
    # 重写设置默认头部信息
    def set_default_headers(self):
        self.set_header("Content-Type", "text/html;charset=UTF-8")
        self.set_header("Jackson","nice")
    def get(self, *args, **kwargs):
        self.set_header("Jackson", "handsome")
        self.write("good nice")
        pass
    def post(self, *args, **kwargs):
        RequestHandler.post(self, *args, **kwargs)


# 状态码
class StatusHandler(RequestHandler):
    def get(self, *args, **kwargs):
        # 自定义状态码
        # 方式一：self.set_status(404)
        self.set_status("199", "Who are you?")
        self.write("Jackson is a good man!")






























































