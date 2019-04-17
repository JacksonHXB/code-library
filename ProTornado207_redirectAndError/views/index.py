#===============================================================================
# 视图
#===============================================================================
from tornado.web import RequestHandler

class IndexHandler(RequestHandler):
    def get(self,*args,**kwargs):
        url = self.reverse_url("Jackson")
        self.write("<a href='%s'>去另一个界面</a>"%(url))


# 重定向
class RedirectHandler(RequestHandler):
    def get(self, *args, **kwargs):
        # 重定向到主页
        self.redirect("/")


# 显示错误页面
class ErrorHandler(RequestHandler):
    def write_error(self, status_code, **kwargs):
        if status_code ==  500:
            code = 500
            self.write("服务器内部错误！")
        elif status_code == 404:
            code = 404
            self.write("资源不存在！")
        # 设置返回的状态码值
        self.set_status(code)
    def get(self, *args, **kwargs):
        # 获取参数的值
        flag = self.get_query_argument("flag")
        # 如果flag=0则抛出错误
        if flag == '0':
            self.send_error(500)
        self.write("you are right!")






























































































