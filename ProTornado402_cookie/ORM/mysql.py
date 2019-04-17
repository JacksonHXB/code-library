"""
    封装数据库
"""
import pymysql

import config

# 装饰器
def singleton(cls,*args,**kwargs):
    instances = {}
    def _singleton():
        if cls not in instances:
            instances[cls] = cls(*args, **kwargs)
        return instances[cls]
    return _singleton


@singleton
class MySQL():
    host = config.mysql["host"]
    user = config.mysql["user"]
    passwd = config.mysql["password"]
    dbName = config.mysql["dbName"]
    
    
    def connect(self):
        self.db = pymysql.connect(self.host, self.user, self.passwd, self.dbName)
        self.cursor = self.db.cursor()
        
    def close(self):
        self.cursor.close()
        self.db.close()
        
    def get_one(self,sql):
        res = None
        try:
            self.connect()
            self.cursor.execute(sql)
            self.cursor.fetchone()
            self.close()
        except:
            print("查询失败！")
        return res
    
    # 不建议使用，这里返回的是元组
    def get_all(self, sql):
        res = ()
        try:
            self.connect()
            self.cursor.execute(sql) 
            res = self.cursor.fetchall()
            self.close()
        except: 
            print("查询失败！")
        return res

    def get_all_obj(self,sql,tableName,*args):
        resList = []
        fieldsList = []
        if (len(args) > 0):
            for item in args:
                fieldsList.append(item)
        else:
            fieldsSql = "select COLUMN_NAME from information_schema.COLUMNS where table_name = '%s' and table_schema ='%s'"%(tableName,self.dbName)
            fields = self.get_all(fieldsSql)
            for item in fields:
                fieldsList.append(item[0])
        # 执行查询语句SQL
        res = self.get_all(sql)
        for item in res:
            obj = {}
            count = 0
            for x in item:
                obj[fieldsList[count]] = x
                count += 1
            resList.append(obj)
        return resList
    
    def insert(self,sql):
        return self.__edit(sql)
    
    def update(self,sql):
        return self.__edit(sql)
    
    def delete(self,sql):
        return self.__edit(sql)
    
    def __edit(self,sql):
        count = 0
        try:
            self.connect()
            count = self.cursor.execute(sql)
            self.db.commit()
            self.close()
        except:
            print("事务提交失败！")
            self.db.rollback()
        return count
            













































