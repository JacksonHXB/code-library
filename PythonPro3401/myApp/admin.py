from django.contrib import admin

# 注册模型
from .models import Grades,Students
admin.site.register(Grades)
admin.site.register(Students)
