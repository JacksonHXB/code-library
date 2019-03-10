#===============================================================================
# 简单测试
#===============================================================================
import requests

response = requests.get('http://www.baidu.com')

# 输出响应状态码
print(response.status_code)

# 输出响应头
print(response.headers)

# 输出响应体
print(response.text)













































