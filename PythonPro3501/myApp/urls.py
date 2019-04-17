from django.conf.urls import url
from . import views

urlpatterns = [
    # 测试
    url(r'^$',views.index),
    # 跳转上传文件页面
    url(r"^upFile/$", views.upFile),
    # 保存文件
    url(r"^saveFile/$", views.saveFile),
    # 学生分页
    url(r"^studentPage/(\d+)/$", views.studentPage),
    # Ajax请求
    url(r"^ajaxStudents/$", views.ajaxStudents),
    url(r"^studentsinfo/$", views.studentsinfo),
    # 在自定义视图中
    url(r"^edit/$",views.edit),
]
































