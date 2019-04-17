import tkinter

win = tkinter.Tk()

# text文本控件，用于显示多行文本的
text = tkinter.Text(win, width=30, height= 2)
text.pack()
# 向文本控件中插入字符
str = "Jackson is a good man!"
text.insert(tkinter.INSERT, str)

############带滚动条的Text
# 创建滚动条
scroll = tkinter.Scrollbar()
text2 = tkinter.Text(win, width=30, height=2)
str = "tyui[ghjjohkhhsjdfjhsekfjs;lejgsljrgls;rjgjds;lgj;lrjglsrj;gojrs;lgj;lrsdjg;ldjg;lsjgljlggr"
text2.insert(tkinter.INSERT, str)
# 将滚动条放置在窗体右侧，并将Y轴填充满
scroll.pack(side=tkinter.RIGHT, fill=tkinter.Y)
text2.pack(side=tkinter.LEFT, fill=tkinter.Y)
# 在竖直方向进行关联
# 滚动条动，文本动
scroll.config(command=text2.yview)
# 文本动，滚动条动
text2.config(yscrollcommand=scroll.set)





win.mainloop()






































