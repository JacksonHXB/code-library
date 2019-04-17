#===============================================================================
# Flask
#===============================================================================

from flask import Flask, render_template


app = Flask(__name__)


# 1，如何放回一个网页（模板）
# 2，如何给模板填充数据
@app.route('/', methods=['GET', 'POST'])
def index():
    
    # 比如：传递一个网址
    url_str = 'www.baidu.com'
    
    myList = [1, 3, 5, 7, 9]
    
    myDict = {
        'name':'黑马程序员',
        'age':12
    }
    
    # 通常，模板中使用的变量名和要传递的数据变量名保持一致
    return render_template('index.html', url_str=url_str,myList=myList,myDict=myDict)


if __name__ == '__main__':
    app.run()

















































