#===============================================================================
# 视图
#===============================================================================
from tornado.web import RequestHandler

class IndexHandler(RequestHandler):
    def get(self,*args,**kwargs):
        self.write("This is a test!")


#---  POST传递参数：RegisterHandler------------------------------------------------------------------------ 
class RegisterHandler(RequestHandler):
    # 显示注册页面
    def get(self, *args, **kwargs):
        # 返回模板
        self.render('register.html')
    
    # 注册处理    
    def post(self, *args, **kwargs):
        # 获取参数值
        username = self.get_body_argument("username")
        passwd = self.get_body_argument("passwd")
        hobbyList = self.get_body_arguments("hobby")
        self.write(username + "-" + passwd + "-" + str(hobbyList))






















































































