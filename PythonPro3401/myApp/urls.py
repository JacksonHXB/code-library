from django.conf.urls import url
from . import views

urlpatterns = [
    url(r"^test/$", views.test),
    url(r"^index/$", views.index),
    
    # 显示学生列表
    url(r"^queryStudents/$", views.queryStudents),
    # -----------------------------------------------反向解析实例,反向解析这里出现问题
#     url(r"^good/(\d+)/$", views.good)

    # 主页，测试模板继承
    url(r"^main/$", views.main),
    # 详情页
    url(r"^detail/$", views.detail),
    
    
    # 测试HTML转义
    url(r"^htmlTransfer/$", views.htmlTransfer),
    
    
    # 测试CSRF
    url(r"^postFile/$", views.postFile),
    url(r"^showInfo/$", views.showInfo),
    
    
    # 验证码登录验证-生成验证码
    url(r"^showVerifyCode/$", views.verifyCode),
    # 验证码登录验证-显示验证码
    url(r"^verifyCodeFile/$", views.verifyCodeFile),
    # 验证码登录验证-验证验证码
    url(r"^verifyCodeCheck/$", views.verifyCodeCheck),
]









































































