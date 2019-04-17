"""
日历模块
"""
import calendar

# 返回指定某年某月的日历
print(calendar.month(2017, 7))

# 返回指定年的日历
print(calendar.calendar(2017))

# 判断是否是闰年
print(calendar.isleap(2000))

# 返回某个月的weekday的第一天和这个月所有的天数
print(calendar.monthrange(2017, 7))

# 返回某个月以每一周为元素的列表
print(calendar.monthcalendar(2017, 7))













































































