#===============================================================================
# 视图
#===============================================================================

from tornado.web import RequestHandler

#---- 展示所有学生 ------------------------------------------------------------ 
class StudentsHandler(RequestHandler):
    def get(self, *args, **kwargs):
        # 从数据库汇总提取数据
        sql = "select * from tb_student"
        tablename = "tb_student"
        stus = self.application.db.get_all_obj(sql,tablename)
        
        # 获取某个字段的值
        # stus = self.application.db.get_all_obj("select name,age from tb_student", "tb_student", "name", "age")

        # 插入数据
        self.application.db.insert("insert into tb_student(name, age) values ('tom', 23)")
        
        print(stus)
        self.render("students.html", stus=stus)
































































