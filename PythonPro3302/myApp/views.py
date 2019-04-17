from django.http import HttpResponse
from django.shortcuts import render


def index(request):
    return HttpResponse("主页！")

def attributes(request):
    print(request.path)
    print(request.method)
    print(request.encoding)
    print(request.GET)
    print(request.POST)
    print(request.FILES)
    print(request.COOKIES)
    print(request.session)
    return HttpResponse("attributes")

# 获取GET传递的数据
def get1(request):
    a = request.GET.get("a")
    b = request.GET["b"]
    c = request.GET.get("c")
    return HttpResponse(a + "  " + b + "  " + c)

def get2(request):
    a = request.GET.getlist("a")
    return HttpResponse(a[0] + "   " + a[1])

# POST
def showRegister(request):
    return render(request, "myApp/register.html")
def register(request):
    name = request.POST.get("name")
    gender = request.POST.get("gender")
    age = request.POST.get("age")
    hobby = request.POST.getlist("love")
    return HttpResponse("Register Success! name:" + str(name) + " gender:" + str(gender) + " age:" + str(age) + " hobby：" + str(hobby))


# 输出HttpResponse对象的属性
def showResponse(request):
    res = HttpResponse()
    print(res.content)
    print(res.charset)
    print(res.status_code)
    print(res.content-type)
    return res


# 测试Cookie
def showCookie(request):
    res = HttpResponse()
    # 设置cookie
    setCookie = res.set_cookie("Jackson", "good")
    # 获取客户端中的cookie
    getCookie = request.COOKIES
    res.write("<h1>" + getCookie["Jackson"] + "</h1>")
    return res

# 重定向与JsonResponse
from django.http import HttpResponseRedirect, JsonResponse
from django.shortcuts import redirect
def redirect1(request):
#     return HttpResponseRedirect("/test/redirect2")
    # 简写重定向
    return redirect("/test/redirect2")
def redirect2(request):
#     if request.is_ajax():
#         a = JsonResponse({"json1":"fff","json2":12})
#         return a
    return HttpResponse("我是重定向后的视图")
    

### 登陆测试 ###
def main(request):
    # 取出session的值，第二个参数是默认值
    userName = request.session.get("name", "游客")
    print("userName:", userName)
    return render(request, "myApp/main.html", {"username":userName})

def login(request):
    return render(request, "myApp/login.html")

def showmain(request):
    username = request.POST.get("username")
    # 存储到username
    request.session["name"] = username
    # 设置session过期时间，这里设置的是10s
    request.session.set_expiry(10)
    return redirect("/test/main")

from django.contrib.auth import logout
def quitLogin(request):
    # 清除session方式一,推荐使用
    logout(request)
    # 清除session方式二
#     request.session.clear()
    # 清除session方式三
#     request.session.flush()
    return redirect("/test/main")











