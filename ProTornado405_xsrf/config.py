import os
BASE_DIRS = os.path.dirname(__file__)

options ={
    "port": 8000
}

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
    "cookie_secret":"uZxf7STZT7KKGPv1d70Y8qfueV12rEnrtc6sMpS+nXo=",
    # 开启XSRF保护
    "xsrf_cookies": True
}






















































































