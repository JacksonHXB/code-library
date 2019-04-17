''' 
字典的排序
'''
# nums=[22,4543,345,132,6545,75435,865,677]
# #从小到大排序
# nums.sort()
# print(nums)
# print()
# #从大到小排序
# nums.sort(reverse=True)
# print(nums)

info=[{"name":"banZhang","age":10},{"name":"xiaoLi","age":34},{"name":"wangMaZi","age":16}]
info.sort(key=(lambda x:x["name"]))
print(info)





































