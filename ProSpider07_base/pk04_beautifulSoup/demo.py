#===============================================================================
# BeautifulSoup
#===============================================================================

#--- 基本应用 --------------------------------------------------------------------------- 
from bs4 import BeautifulSoup
html = """
    <!DOCTYPE html>
    <html>
    <head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    </head>
    <body>
        <p name="test" id="myP" class="myp">This is a test!</p>
        <div>
            <span name="myspan">
                This is a p1
                <p>This is a p2</p>
                <font>brother</font>
            </span>
        </div>
"""
def bs1():
    # 申明BeautifulSoup对象，并传入解析器
    soup = BeautifulSoup(html,'lxml')
    # 格式化代码,可以自动调整为标准格式
    print(soup.prettify())
    # 获取title标签中的内容
    print(soup.title.string)

bs1()

#--- 选择元素 --------------------------------------------------------------------------- 
def bs2():
    soup = BeautifulSoup(html,'lxml')
    print("网页标题标签：")
    print(soup.title)
    print(type(soup.title))
    
    print("\n网页标题内容：")
    print(soup.title.name)
    
    print("\n获取head标签：")
    print(soup.head)
    
    print("\n获取p标签：")
    print(soup.p)
    
    print("\n获取属性：")
    print(soup.p.attrs['name'])
    
    print("\n获取内容：")
    print(soup.p.string)
    
    print("\n嵌套选择：")
    print(soup.head.title.string)
    
    print("\n子节点与子孙节点：")
    print(soup.div.contents)
    for i,child in enumerate(soup.div.children):
        print(i,child)
    print()
    for i,child in enumerate(soup.div.descendants):
        print(i,child)
        
    print("\n父节点与祖先节点：")
    print(soup.span.parent)
    
    print("\n兄弟及节点：")
    print(list(enumerate(soup.div.span.p.next_siblings)))
    print(list(enumerate(soup.div.span.font.previous_siblings)))

#--- 标准选择器 --------------------------------------------------------------------------- 
# find_all(name,attrs,recursive,text,**kwargs)
# 可根据标签名，属性，内容查找文档
def standard():
    soup = BeautifulSoup(html,'lxml')
    print("find_all:")
    print(soup.find_all('div'))
    print(type(soup.find_all("div")))
    
    print("\nattrs:")
    print(soup.find_all(attrs={'id':'myP'}))
    print(soup.find_all(attrs={'name':'myspan'}))
    print(soup.find_all(class_='myp'))
    
    print("\n根据文本内容进行选择：")
    print(soup.find_all(text='brother'))
    
#--- find()--------------------------------------------------------------------------- 
# find返回单个元素，find_all返回所有元素

#---- find_parenets()和find_parent()------------------------------------------------------------------------- 
# find_parents返回所有祖先节点，find_parent()返回直接父节点

#----- find_next_siblings()和find_next_sibling()------------------------------------------------------------------------- 
# find_next_siblings()返回后面所有的兄弟节点，find_next_sibling()返回后面第一个兄弟节点

#----- find_all_next()与find_next() ------------------------------------------------------------------------- 
# find_all_next()返回节点后所有符合条件的节点，find_next()返回第一个符合条件的节点

#----- find_all_previous()和find_previous() ------------------------------------------------------------------------- 
# find_all_previous返回节点所有符合条件的节点，find_previous()返回第一个符合条件的节点


#---- css选择器-------------------------------------------------------------------------
# 通过select()直接传入css选择器即可完成选择

 














































