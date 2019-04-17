import os
# 获取当前目录所在的路径
BASE_DIRS = os.path.dirname(__file__)

# 参数
options ={
    "port": 8000
}

# 配置
settings = {
    # 配置静态目录
    "static_path": os.path.join(BASE_DIRS, "static"),
    # 配置模板目录
    "template_path": os.path.join(BASE_DIRS, "templates"),
#     "debug": True
    "autoreload": True
    
}
# static_path:配置静态文件路径
# template_path:配置模板路径



















