import os
BASE_DIRS = os.path.dirname(__file__)

options ={
    "port": 8000
}

# 数据库配置
mysql = {
    "host": "127.0.0.1",
    "user": "root",
    "password": "123456",
    "dbName": "db_test"
}

settings = {
    "static_path": os.path.join(BASE_DIRS, "static"),
    "template_path": os.path.join(BASE_DIRS, "templates"),
    "autoreload": True,
    # 关闭自动转义
#     "autoescape": None
}






















































































