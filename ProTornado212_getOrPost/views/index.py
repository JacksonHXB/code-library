#===============================================================================
# 视图
#===============================================================================
from tornado.web import RequestHandler

class IndexHandler(RequestHandler):
    def get(self,*args,**kwargs):
        self.write("This is a test!")

#---  获取任意方式传递的参数----------------------------------------------------------------------- 
class RegisterHandler(RequestHandler):
    def get(self, *args, **kwargs):
        test = self.get_argument("test")
        print("test",test)
        self.render('register.html')
    
    def post(self, *args, **kwargs):
        username = self.get_argument("username")
        passwd = self.get_argument("passwd")
        hobbyList = self.get_arguments("hobby")
        self.write(username + "-" + passwd + "-" + str(hobbyList))






















































































