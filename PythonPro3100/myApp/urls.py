from django.conf.urls import url
from . import views

urlpatterns = [
    # http://localhost:8000
    url(r'^$',views.index),
    # 小括号是接收参数
    # http://localhost:8000/2334
    url(r'^(\d+)/$', views.detail),
    
    # 遍历班级url
    url(r'^grades/$', views.grades),
    
    # 遍历学生
    url(r'^students/$', views.students),
    
    # 遍历班级并遍历学生
    url(r'^grades/(\d+)$', views.gradesStudents)
]
































