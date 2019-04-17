#===============================================================================
# Flask:实现一个简单的登录的逻辑处理
#===============================================================================

# import sys
from flask import Flask, render_template, request,flash
from flask_wtf import FlaskForm
from wtforms import StringField, PasswordField, SubmitField
from wtforms.validators import DataRequired, EqualTo


app = Flask(__name__)
app.secret_key = 'itheima'


# 解决编码问题
# reload(sys)
# sys.setdefaultencoding('UTF-8')


# 试用WTF实现表单，自定义表单类
class LoginForm(FlaskForm):
    username = StringField(u'用户名:', validators=[DataRequired()])# u表示转码的问题
    password = PasswordField(u'密码:', validators=[DataRequired()])
    password2 = PasswordField(u'确认密码:', validators=[DataRequired(), EqualTo('password','两次密码不一致！')])
    submit = SubmitField(u'提交')


@app.route('/form', methods=['GET', 'POST'])
def login():
    login_form = LoginForm()
    
    if request.method == 'POST':
        username = request.form.get('username')
        password = request.form.get('password')
        password2 = request.form.get('password2')
        
        # 验证参数，WTF可以一句话就实现所有的校验
        # 我们没有CSRF_token
        if login_form.validate_on_submit():
            print('成功!'+ username + password + password2)
            return 'success'
        else:
            flash('参数有误！')
    
    
    return render_template('index1.html',login_form=login_form)


if __name__ == '__main__':
    app.run()

















































