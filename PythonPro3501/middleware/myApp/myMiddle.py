'''
创建自定义中间件
'''
from django.utils.deprecation import MiddlewareMixin

class MyMiddle(MiddlewareMixin):
    # 重写process_request()
    def process_request(self, request):
        print("get的参数为：", request.GET.get("a"))

















































