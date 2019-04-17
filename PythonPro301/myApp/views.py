from django.http import HttpResponse
from django.shortcuts import render

from .models import Grades


# 自定义视图
# 定义主页
def index(request):
    return HttpResponse("Jackson is a good man!")

# 定义页面2
def detail(request, num):
    return HttpResponse("detail-%s"%num)


# 定义班级视图
def grades(request):
    # 去模板里取数据
    gradesList = Grades.objects.all()
    # 将数据传递给模板, 模板再渲染页面，再将渲染好的页面返回给浏览器
    return render(request, 'myApp/grades.html', {"grades":gradesList})


from .models import Students
def students(request):
    studentList = Students.objects.all()
    return render(request, 'myApp/students.html', {"students":studentList})


# 根据班级id遍历学生
def gradesStudents(request, num):
    # 将班级下的所有学生取出来
    grade = Grades.objects.get(pk=num)
    studentsList = grade.students_set.all()
    return render(request, 'myApp/students.html', {"students":studentsList})






























































































