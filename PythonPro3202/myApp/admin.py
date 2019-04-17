from django.contrib import admin

# Register your models here.
from .models import Grades,Students
admin.site.register(Grades)
admin.site.register(Students)