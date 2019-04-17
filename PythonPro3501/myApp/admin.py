from django.contrib import admin

# ע��ģ��
from .models import Grades,Students
from cgitb import text

### �ڴ����༶��ʱ��ֱ���������ѧ�� ###
class StudentsInfo(admin.TabularInline):#StackedInline
    model = Students
    extra = 2
    
# �Զ������ҳ��
class GradesAdmin(admin.ModelAdmin):
    # ���ѧ��
    inlines = [StudentsInfo]
    #### �б�ҳ���� ####
    # ��ʾ�ֶ���
    list_display = ['pk', 'gname', 'gdate', 'ggirlnum', 'gboynum', 'isDelete']
    # ��ӹ�����,�����ֶ�
    list_filter = ['gname']
    # ���ֶ�������
    search_fields = ['gname']
    # ��ҳ
    list_per_page = 2
    
    ### ��ӣ��޸�ҳ���� ###
    # �޸����/�޸�ҳ�ֶ�����˳��
#     fields = ['ggirlnum', 'gboynum', 'gname', 'gdate', 'isDelete']
    # �����Է���
    fieldsets = [("num",{"fields":['ggirlnum', 'gboynum']}),("base",{"fields":['gname','gdate','isDelete']})]
    
admin.site.register(Grades, GradesAdmin)

# ʹ��װ����ע��
# @admin.register(Students)
class StudentsAdmin(admin.ModelAdmin):
    # �������ֵ��ʾ����
    def gender(self):
        if self.sgender:
            return "boy"
        else:
            return "girl"
    # �����ֶ���ı���
    gender.short_description = "mySex"
    
    list_display = ['pk', 'sname', 'sage', gender,'scontend', 'sgrade', 'isDelete']
    list_per_page = 2
    
    # ִ�ж�����λ��
    actions_on_top= True
    actions_on_bottom = True
admin.site.register(Students, StudentsAdmin)


# 注册Text
from .models import Text
admin.site.register(Text)




































