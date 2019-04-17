#===============================================================================
# 视图
#===============================================================================
from tornado.web import RequestHandler


class IndexHandler(RequestHandler):
    def get(self,*args,**kwargs):
        self.write("This is a test!")


import os
import config
#---  上传文件 ----------------------------------------------------------------------- 
class UpFileHandler(RequestHandler):
    # 显示上传文件页面
    def get(self, *args, **kwargs):
        self.render('upfile.html')
        
    # 接收上传的文件
    def post(self, *args, **kwargs):
        filesDict = self.request.files
#         {
#             'file':[
#                 {'filename': 'a.txt', 'body': b'This is a.', 'content_type': 'text/plain'}, 
#                 {'filename': 'b.txt', 'body': b'This is b.', 'content_type': 'text/plain'}], 
#             'img': [
#                 {'filename': 'c.png', 'body': b'', 'content_type': 'image/png'}]
#         }
        # 将文件保存到本服务器中
        for inputname in filesDict:
            fileArr = filesDict[inputname]
            for fileObj in fileArr:
                # 存储路径
                filePath = os.path.join(config.BASE_DIRS, 'upfile/' + fileObj.filename)
                # 写入内容
                with open(filePath,"wb") as f:
                    f.write(fileObj.body)
        print(filesDict)
        self.write("OK")
        
#------ write  ------------------------------------------------------------------------ 
class WriteHandler(RequestHandler):
    def get(self, *args, **kwargs):
        # 向缓冲区中写入数据，因此数据是连续的
        self.write("Jackson is a good man!")
        self.write("Jacskon is a nice man!")
        self.write("Jacskon is a handsome man!")
        # 刷新缓冲区,并关闭当次请求通道
        self.finish()
        self.write("Jacskon is a smart man!")













































































