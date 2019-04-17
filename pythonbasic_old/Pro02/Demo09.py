'''IF嵌套'''

ticket=1            #1表示有车票，0表示没有车票

knifeLength=20      #cm

#先判断是否有车票：
if ticket==1:
    print("通过车票的检测，进入车站")
    
    #判断刀的长度是否合法
    if knifeLength<=10:
        print("通过安检，进入到候车厅！")
    else:
        print("安检没有通过，等待公安处理！")
else:
    print("兄弟，你还没有买票！")

















































