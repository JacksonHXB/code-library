#===============================================================================
# Flask:实现一个简单的登录的逻辑处理
#===============================================================================

from flask import Flask, render_template, request,flash


app = Flask(__name__)

app.secret_key = 'itheima'

# 给模板传递消息
# flash需要对内容加密，因此需要设置secret_key,做加密消息的混淆
@app.route('/', methods=['GET', 'POST'])
def index():
    # 判断请求方式，request是一个请求对象，获取请求方式，及数据
    if request.method == 'POST':
        # 获取请求参数
        username = request.form.get('username')
        password = request.form.get('password')
        password2 = request.form.get('password2')
        # 验证密码是否相同
        if not all([username, password, password2]):
            # flash闪现
            flash('参数不完整')
        elif password != password2:
            print('密码不一致！')
        else:
            print('验证通过！')
            return 'success'
    
    return render_template('index1.html')

if __name__ == '__main__':
    app.run()

















































