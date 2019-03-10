import json

from scrapy import Spider, Request
from ProSpider29_zhihuuser.items import UserItem


# https://www.zhihu.com/people/excited-vczh/following?page=2
class ZhihuSpider(Spider):
    name = 'zhihu'
    allowed_domains = ['www.zhihu.com']
    start_urls = ['http://www.zhihu.com/']
    
    # 起始点
    start_user = 'excited-vzch'
    
    # 用户连接
    user_url = 'http://www.zhihu.com/api/v4/members/{user}?include={include}'
    user_query = 'locations,employments,gender,educations'# 查询参数
    
    # 关注列表
    follows_url = 'http://www.zhihu.com/api/v4/members/{user}/followees?include={include}&offset={offset}&limit={limit}'
    follows_query = 'data[*].answer_count,articles_count,gender'
    
    # 粉丝列表
    follows_url = 'http://www.zhihu.com/api/v4/members/{user}/followers?include={include}&offset={offset}&limit={limit}'
    follows_query = 'data[*].answer_count,articles_count,gender'
    
    # 初始化请求，构造请求体
    def start_requests(self):
        yield Request(self.user_url.format(user=self.start_user, include=self.user_query), self.parse_user)
        yield Request(self.follows_url.format(user=self.start_user, include=self.follows_query, offset=0, limit=20), self.parse_follows)
        yield Request(self.followers_url.format(user=self.start_user, include=self.follows_query, offset=0, limit=20), self.parse_follows)
     
        
    # 解析当前用户信息，并进一步解析关注列表
    def parse_user(self, response):
        # 将获得的字符串转为json
        result = json.loads(response.text)
        
        # 声明对象并赋值
        item = UserItem()
        # 遍历模型的所有字段
        for field in item.fields:
            # 如果该字段在返回的结果里存在，则赋值
            if field in result.keys():
                item[field] = result.get(field)
        # 返回的结果给scrapy
        yield item
        
        # 进一步解析关注列表
        yield Request(self.follows_url.format(user=result.get('url_token'), include=self.follows_query, limit=20, offset=0), self.parse_follows)
        # 进一步解析粉丝列表
        yield Request(self.follows_url.format(user=result.get('url_token'), include=self.follows_query, limit=20, offset=0), self.parse_follows)
        
    
    # 解析并获取用户的关注列表  
    def parse_follows(self, response):
        results = json.loads(response.text)
        # 判断是否存在data的键名
        if 'data' in results.keys():
            for result in results.get('data'):
                yield Request(self.user_url.format(user=result.get('url_token'), include=self.user_query), self.parse_user)
        # 分页处理
        if 'paging' in results.keys() and results.get('paging').get('is_end') == False:
            # 下一页连接
            next_page = results.get('paging').get('next')
            # 递归执行该函数
            yield Request(next_page, self.parse_follows)
            
            
    # 解析并获取用户的粉丝列表
    def parse_followers(self, response):
        results = json.loads(response.text)
        if 'data' in results.keys():
            for result in results.get('data'):
                yield Request(self.user_url.format(user=result.get('url_token'), include=self.user_query), self.parse_user)
        if 'paging' in results.keys() and results.get('paging').get('is_end') == False:
            next_page = results.get('paging').get('next')
            yield Request(next_page, self.parse_follwers)


































