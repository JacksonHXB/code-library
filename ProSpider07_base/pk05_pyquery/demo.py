#===============================================================================
# PyQuery库
#===============================================================================

#--- 初始化 --------------------------------------------------------------------------- 
html = """
    <div id="container">
        <ul>
            <li class="item-0">first item</li>
            <li class="item-1"><a href="link2.html">second item</a></li>
            <li class="item-2"><a href="link3.html"><span>third item</span></a></li>
            <li class="item-3"><a href="link4.html">fourth item</a></li>
            <li class="item-4"><a href="link5.html">fifth item</a></li>
        </ul>
    </div>
"""
#--- 字符串初始化 --------------------------------------------------------------------------- 
from pyquery import PyQuery as pq
def initialize1():
    doc = pq(html)
    print(doc("li"))

#---- url初始化 ------------------------------------------------------------------------- 
def initialize2():
    doc = pq(url='http://www.baidu.com')
    print(doc('head'))
    
#---- 文件初始化 ------------------------------------------------------------------------- 
def initialize3():
    doc = pq(filename='demo.html')
    print(doc("li"))

# 基本的css选择器
#------------------------------------------------------------------------------ 
def selector1():
    doc = pq(html)
    print(doc('#container'))
    
    
selector1()
    


































