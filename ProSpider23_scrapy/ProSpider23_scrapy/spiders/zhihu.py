# -*- coding: utf-8 -*-
import scrapy


class ZhihuSpider(scrapy.Spider):
    name = 'zhihu'
    allowed_domains = ['www.zhihu.com']
    start_urls = ['http://www.zhihu.com/']
    
    # 自定义配置文件的配置:用来覆盖全局的配置文件
    custom_settings = {
        'DEFAULT_REQUEST_HEADERS':{
            'User-Agent':None,
            'Accept-Languate':'en'
        }
    }
    
    
    def __init__(self,mongo_uri,mongo_db,*args,**kwargs):
        super(ZhihuSpider, self).__init__(*args, **kwargs)
        self.mongo_uri = mongo_uri
        self.mongo_db = mongo_db
    
    # 此方法可以从settings中取得配置文件中的信息
    @classmethod
    def from_crawler(self, crawler):
        cls = ()
        return cls(
            mongo_uri = crawler.settings.get('MONGO_URI'),
            mongo_db = crawler.settings.get('MONGO_DB')
        )

    def parse(self, response):
        pass
    
    































































