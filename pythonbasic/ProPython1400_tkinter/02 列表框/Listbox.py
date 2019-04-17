"""
    Listbox列表框控件
        可以包含一个或者多个文本框
        作用：可以在listbox控件的小窗口显示一个字符串
"""
import tkinter

win = tkinter.Tk()
win.geometry("400x400+200+100")

# 创建Listbox控件
# selectmode表示显示模式;
listBox = tkinter.Listbox(win, selectmode=tkinter.BROWSE)

# 向列表中添加索引
for item in ["good", "nice", "handsome", "good2", "OK"]:
    # 将元素按照顺序添加到listBox; END表示末尾, ACTIVE表示聊表开始
    listBox.insert(tkinter.END, item)
listBox.insert(tkinter.ACTIVE, "cool")

# 删除列表框中的元素; 参数1为开始的索引，参数2为结束的索引，如果不指定参数2，只删除第一个索引所在的元素
listBox.delete(1, 3)

# 设置默认选中的元素, 第二个参数可以有
listBox.select_set(1, 2)

# 设置取消选中的元素
listBox.select_clear(2)

# 获取列表框中的元素个数
print("列表中元素的个数：" + str(listBox.size()))

# 获取列表框中元素
print(listBox.get(0))
print(listBox.get(1, 2))

# 返回当前的选中元素的索引
print(listBox.curselection())

# 判断某个索引是否被选中
print(listBox.selection_includes(1))


listBox.pack()


















win.mainloop()












































