#===============================================================================
# Flask:实现一个简单的登录的逻辑处理
#===============================================================================

from flask import Flask
from flask_sqlalchemy import SQLAlchemy



app = Flask(__name__)

# 配置数据库地址
app.config['SQLALCHEMY_DATABASE_URI'] = 'mysql://root:123456@127.0.0.1/db_flask'
# 动态跟踪数据库的修改，不建议开启，未来的版本中会移除
app.config['SQLALCHEMY_TRACK_MODIFICATIONS'] = False

db = SQLAlchemy(app)

# 两张表
# 角色（管理员 / 普通用户）
# 用户（角色ID）
# 数据库的模型，需要继承db.Model
class Role(db.Model):
    # 定义表名
    __tablename_ = 'tb_roles'
    # 定义字段
    # db.Column表示一个字段
    id = db.Column(db.Integer,primary_key=True)
    name = db.Column(db.String(16), unique=True)
    

class User(db.Model):
    __tablename__ = 'tb_users'
    id = db.Column(db.Integer, primary_key=True)
    name = db.Column(db.String(16), unique=True)
    # db.ForeignKey表示是外键，
    role_id = db.Column(db.Integer, db.ForeignKey('tb_roles.id'))
    


@app.route('/')
def index():
    return '成功！'

if __name__ == '__main__':
    # 删除表
    db.drop_all()
    # 创建表
    db.create_all()
    app.run()

















































