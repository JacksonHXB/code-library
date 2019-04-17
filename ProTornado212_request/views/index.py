#===============================================================================
# 视图
#===============================================================================
from tornado.web import RequestHandler

class IndexHandler(RequestHandler):
    def get(self,*args,**kwargs):
        self.write("This is a test!")

#---  获取Request对象的属性----------------------------------------------------------------------- 
class ReqPropertiesHandler(RequestHandler):
    def get(self, *args, **kwargs):
        print('method：', self.request.method)
        print('host：', self.request.host)
        print('uri：', self.request.uri)
        print('path：', self.request.path)
        print('query：', self.request.query)
        print('version：', self.request.version)
        print('headers：', self.request.headers)
        print('body：', self.request.body)
        print('remote_ip：', self.request.remote_ip)
        print('files：', self.request.files)




















































































