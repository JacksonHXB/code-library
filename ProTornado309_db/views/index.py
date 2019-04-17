#===============================================================================
# 视图
#===============================================================================

from tornado.web import RequestHandler
from models import Students


#---- 添加学生 ------------------------------------------------------------ 
class AddStuHandler(RequestHandler):
    def get(self, *args, **kwargs):
        
        
        s = Students("小力", 60)
        s.save()
        
        self.write("OK")
        

































































