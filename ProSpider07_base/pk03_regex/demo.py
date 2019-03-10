#---- 最常规的匹配 -------------------------------------------------------------------------- 
import re


def regex1():
    content = "Hello 123 4567 World_This is a Regex Demo"
    result = re.match("^Hello\s\d{3}\s\d{4}\s\w{10}.*Demo$",content)
    print(result)
    print("匹配结果是:", result.group())
    print("结果范围是：", result.span())


#---- 泛匹配 ------------------------------------------------------------------------- 
def regex2():
    content = "Hello 123 4567 World_This is a Regex Demo"
    result = re.match("^Hello.*Demo$",content)
    print(result.group())
    
#----- 匹配目标 ------------------------------------------------------------------------- 
def regex3():
    content = "Hello 123 4567 World_This is a Regex Demo"
    result = re.match("^Hello\s(\d+)\sWorld.*Demo$", content)
    print("输出第一个括号内的内容：", result.group(1))
    
#---- 贪婪匹配 -------------------------------------------------------------------------- 
def regex4():
    content = "Hello 1234567 World_This is a Regex Demo"
    result = re.match("^He.*(\d+).*Demo$", content)
    print(result.group(1))

#----- 非贪婪匹配 ------------------------------------------------------------------------- 
def regex5():
    content = "Hello 1234567 World_This is a Regex Demo"
    result = re.match("^He.*?(\d+).*Demo$", content)
    print(result.group())

#------ 匹配模式 ------------------------------------------------------------------------ 
def regex6():
    content = """Hello 1234567 World_This 
    is a Regex Dmeo"""
    # 尽量使用泛匹配，使用括号得到匹配目标，尽量使用非贪婪模式，有换行符就用re.S
    result = re.match("^Hello.*?(\d+).*?Demo$", content, flags=re.S)
    print(result.group())
regex6()


#------- 转义 ----------------------------------------------------------------------- 
def regex7():
    content = "price is $5.00"
    result = re.match("price is $5.00". content)
    print(result.group())

#---- re.search -------------------------------------------------------------------------- 
def regex8():
    # re.search扫描整个字符串并返回第一个成功的匹配
    content = "Extra strings Hello 1234567 World_This is a Regex Demo Extra strings"
    result = re.search("Helo.*?(\d+).*?Demo", content)
    print(result)


#---- 匹配练习 -------------------------------------------------------------------------- 
def regex9():
    html= """
        <div id="song-list">
            <h2 class="title">经典老歌</h2>
            <p class="introduction">
                                        经典老歌列表
            </p>
            <ul id="list" class="list-group">
                <li data-view="2">一路上有你</li>
                <li data-view="7">
                    <a href="/2.mp3" singer="任贤齐">沧海一声笑</a>
                </li>
                <li data-view="4" class="active">
                    <a href="/3.mp3" singer="齐秦">往事随风</a>
                </li>
            </ul>
        </div>
    """
    result = re.search('<li.*?active.*?singer="(.*?)>(.*?)</a>',html,flags=re.S)
    print(result)

#--- re.findall ------------------------------------------------------------------------ 
# 搜索字符串，以列表形式返回全部能匹配的字符串

#---- re.sub ------------------------------------------------------------------------- 
# 替换字符串中每一个匹配的子串后返回替换后的字符串

#---- re.compile -------------------------------------------------------------------------- 
# 将一个正则字符串转换成正则对象，以方便复用












































