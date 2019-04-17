from django.http import HttpResponse
from django.shortcuts import render
from .models import Grades

def index(request):
    return render(request, "myApp/index.html")


# 上传文件页面
def upFile(request):
    return render(request,"myApp/upfile.html")


# 保存文件
import os
from django.conf import settings
def saveFile(request):
    # 判断是否是POST请求，上传文件必须是POST请求
    if request.method == "POST":
        # 读取文件
        file = request.FILES["file"]
        # 文件在服务器中的路径
        filePath = os.path.join(settings.MDEIA_ROOT, file.name)
        # 将读取的文件复制到服务器中
        with open(filePath, 'wb') as fp:
            for info in file.chunks():# 以文件流的形式接收数据
                fp.write(info)
        return HttpResponse("上传成功！")
    else:
        return HttpResponse("上传失败！")


# 学生分页
from .models import Students
from django.core.paginator import Paginator
def studentPage(request, pageId):
    # 获取所有学生的列表
    allList = Students.objects.all()
    # 获取分页列表对象
    paginator = Paginator(allList, 2)
    # 获取单个分页对象
    page = paginator.page(pageId)
    return render(request, "myApp/studentPage.html", {"students":page})


# Ajax请求
def ajaxStudents(request):
    return render(request,"myApp/ajaxStudents.html")


from django.http import JsonResponse
def studentsinfo(request):
    stus = Students.objects.all()
    list = []
    for stu in stus:
        list.append([stu.sname, stu.sage])
    return JsonResponse({"data":list})


# 富文本
def edit(request):
    return render(request, "myApp/edit.html")













































































