import os
BASE_DIRS = os.path.dirname(__file__)

options ={
    "port": 8000
}

settings = {
    "static_path": os.path.join(BASE_DIRS, "static"),
    "template_path": os.path.join(BASE_DIRS, "templates"),
    "autoreload": True,
    # 关闭自动转义
#     "autoescape": None
}



















