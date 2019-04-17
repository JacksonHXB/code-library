from django.shortcuts import render, redirect
from django.http import HttpResponse
from .models import Grades,Students


# Create your views here.

def test(request):
    return HttpResponse("This is a test!")


def index(request):
    student = Students.objects.get(pk=1)
    return render(request, "myApp/index.html", {"num":10, "student":student, "list":["Jackson","小兵"]})

def queryStudents(request):
    studentList = Students.objects.all()
    return render(request, "myApp/students.html", {"studentList":studentList})

# def good(request, id):
#     return render(request, "myApp/good.html", {"num": id})


def main(request):
    return render(request, "myApp/main.html")

def detail(request):
    return render(request, "myApp/detail.html")

# ----------------------------------------------------------------------------------
# 测试HTML转义

def htmlTransfer(request):
    student = Students.objects.get(pk = 1)
    return render(request, "myApp/htmlTransfer.html", {"stu":student, "code":"<h1>Jackson is a good man!</h1>"})

#----------------------------------------------------------------------------------
### 测试CSRF ###

def postFile(request):
    return render(request,"myApp/postFile.html")
def showInfo(request):
    print("This is a test!")
    username = request.POST.get("username")
    password = request.POST.get("password")
    return render(request,"myApp/showInfo.html", {"username":username, "password":password})


#-------------------------------------------------------------------------------------------------
### 验证码 ###

def verifyCode(request):
    # 引入绘图模块
    from PIL import Image,ImageDraw,ImageFont
    # 引入随机函数模块
    import random
    # 定义变来那个，用于画面的背景色，宽，高
    bgcolor = (random.randrange(20,100), random.randrange(20,100), random.randrange(20,100))
    width = 100
    height = 50
    # 创建画面对象
    im = Image.new("RGB", (width, height), bgcolor)
    # 创建画笔对象
    draw = ImageDraw(im)
    # 创建画笔point()函数绘制噪点
    for i in range(0, 100):
        xy = (random.randrange(0, width), random.randrange(0, height))
        fill = (random.randrange(0,255), 255, random.randrange(0,255))
        draw.point(xy, fill=fill)
    # 定义验证码的备选值
    str = "1234567890qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM"
    # 随机选取4个值作为验证码
    rand_str = ""
    for i in range(0, 4):
        rand_str += str[random.randrange(0, len(str))]
    # 构造字体对象
    font = ImageFont.truetype(r"C:\Windows\Fonts\Consolas 常规.ttf", 40)
    # 构造字体颜色
    fontcolor = (255, random.randrange(0, 255), random.randrange(0, 255))
    # 绘制4个字
    draw.text((5,2), rand_str[0], font=font, fill=fontcolor)
    draw.text((25,2), rand_str[1], font=font, fill=fontcolor)
    draw.text((50,2), rand_str[2], font=font, fill=fontcolor)
    draw.text((75,2), rand_str[3], font=font, fill=fontcolor)
    # 释放画笔
    del draw
    # 存入session,用于做进一步的验证
    request.session["verifyCode"] = rand_str
    # 内存文件爱你操作
    import io
    buf = io.BytesIO()
    # 将图片保存在内存中，文件类型为png
    im.save(buf, "png")
    # 将内存中的图片数据返回给客户端，MIME类型为图片png
    return HttpResponse(buf.getvalue(), "image/png")

def verifyCodeFile(request):
    flag = request.session.get("flag", True)
    str = ""
    if flag == False:
        str = "请重新输入！"
    request.session.clear()
    return render(request, "myApp/verifyCodeFile.html", {"flag":flag})

def verifyCodeCheck(request):
    # 获取用户输入的验证码
    userVerifyCode = request.POST.get("verifyCode").upper()
    # 获取
    sysVerifyCode = request.session["verifyCode"].upper()
    if userVerifyCode == sysVerifyCode:
        return render(request, "myApp/verifyCodeSuccess.html")
    else:
        # 设置用户输入的验证码是否正确为False
        request.session["flag"] = False
        return redirect("/verifyCodeFile/")




























































