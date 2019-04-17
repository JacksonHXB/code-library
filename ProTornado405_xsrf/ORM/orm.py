
import tornado.web
from .mysql import MySQL

class ORM(tornado.web.RequestHandler):
    
    @classmethod
    def save(self):
        # 根据类名获取表的名称
        tableName = (self.__class__.__name__).lower()
        fieldsStr = valuesStr = "("
        for field in self.__dict__:
            fieldsStr += (field + ",")
            if isinstance(self.__dict__[field], str):
                valuesStr += ("'" + self.__dict__[field] + "',")
            else:
                valuesStr += (str(self.__dict__[field]) + ",")
        fieldsStr = fieldsStr[:len(fieldsStr)-1] + ")"
        valuesStr = valuesStr[:len(valuesStr)-1] + ")"
        sql = "insert into " + tableName + " " + fieldsStr + " values " + valuesStr
        db = MySQL()
        db.insert(sql)
    
    def delete(self):
        pass
    
    def update(self):
        pass
    
    @classmethod
    def all(cls):
        tableName = (cls.__name__).lower()
        sql = "select * from " + tableName
        db = MySQL()
        return db.get_all_obj(sql, tableName)
    
    def filter(self):
        pass












































