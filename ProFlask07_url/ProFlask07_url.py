#===============================================================================
# Flask
#===============================================================================

from flask import Flask, render_template


app = Flask(__name__)

# 路由只支持GET，如果需要增加，需要自行指定
@app.route('/', methods=['GET', 'POST'])
def index():
    return render_template('index.html')


# 使用同一个视图函数，来显示不同用户的订单信息
# <>定义路由的参数，<>内需要起一个名字
@app.route('/orders/<int:order_id>')
def get_order_id(order_id):
    # 参数类型，默认是字符串，unicode
    print(type(order_id))
    
    # 有的时候，需要对路由做访问优化，订单ID应该是int类型
    
    # 需要在视图函数的()内填入参数名，那么后面的代码才能去使用
    return '参数order_id的值为:%d' % order_id

    




   

if __name__ == '__main__':
    app.run()

















































