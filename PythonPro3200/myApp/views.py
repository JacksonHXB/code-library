# 创建主页
from django.http import HttpResponse
def index(request):
    return HttpResponse("Jackson is a good man!")