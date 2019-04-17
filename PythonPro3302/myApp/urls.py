from django.conf.urls import url
from . import views

urlpatterns = [
    # 主页,name在使用url反向解析时使用
    url(r'^$', views.index, name="index"),
    
    url(r"^attributes$", views.attributes),
    
    url(r"^get1$", views.get1),
    url(r"^get2$", views.get2),
    
    url(r"^showRegister/$", views.showRegister),
    url(r"showRegister/registe/$", views.register),
    
    url(r"^showResponse/$", views.showResponse),
    
    url(r"^showCookie$", views.showCookie),
    
    # 重定向
    url(r"^redirect1$", views.redirect1),
    url(r"^redirect2$", views.redirect2),
    
    # 登陆测试
    url(r"^main/$", views.main),
    url(r"^login/$", views.login),
    url(r"^showmain/$", views.showmain),
    url(r"^quitLogin/$", views.quitLogin),
]






















































