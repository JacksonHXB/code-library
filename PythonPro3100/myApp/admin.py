from django.contrib import admin

# 注册模型
from .models import Grades,Students

### 在创建班级的时候直接添加两个学生 ###
class StudentsInfo(admin.TabularInline):#StackedInline
    model = Students
    extra = 2
    
# 自定义管理页面
class GradesAdmin(admin.ModelAdmin):
    # 添加学生
    inlines = [StudentsInfo]
    #### 列表页属性 ####
    # 显示字段名
    list_display = ['pk', 'gname', 'gdate', 'ggirlnum', 'gboynum', 'isDelete']
    # 添加过滤器,过滤字段
    list_filter = ['gname']
    # 按字段名搜索
    search_fields = ['gname']
    # 分页
    list_per_page = 2
    
    ### 添加，修改页属性 ###
    # 修改添加/修改页字段排列顺序
#     fields = ['ggirlnum', 'gboynum', 'gname', 'gdate', 'isDelete']
    # 给属性分组
    fieldsets = [("num",{"fields":['ggirlnum', 'gboynum']}),("base",{"fields":['gname','gdate','isDelete']})]
    
admin.site.register(Grades, GradesAdmin)

# 使用装饰器注册
# @admin.register(Students)
class StudentsAdmin(admin.ModelAdmin):
    # 解决布尔值显示问题
    def gender(self):
        if self.sgender:
            return "boy"
        else:
            return "girl"
    # 设置字段名的别名
    gender.short_description = "mySex"
    
    list_display = ['pk', 'sname', 'sage', gender,'scontend', 'sgrade', 'isDelete']
    list_per_page = 2
    
    # 执行动作的位置
    actions_on_top= True
    actions_on_bottom = True
admin.site.register(Students, StudentsAdmin)






































