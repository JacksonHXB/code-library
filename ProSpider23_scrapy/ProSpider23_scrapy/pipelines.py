# -*- coding: utf-8 -*-
import pymongo
from scrapy.exceptions import DropItem


# Define your item pipelines here
#
# Don't forget to add your pipeline to the ITEM_PIPELINES setting
# See: https://doc.scrapy.org/en/latest/topics/item-pipeline.html
# 在保存成文本之前进行处理的类
class TextPipeline(object):
    def __init__(self):
        self.limit = 50
        
    def process_item(self, item, spider):
        # 如果名言太长，则截取并加上省略号
        if item['text']:
            if len(item['text']) > self.limit:
                item['text'] = item['text'][0:self.limit].rstrip() + '...'
            return item
        else:
            return DropItem('缺失文本！')


# 在保存到Monogdb之前处理的类
class MongoPipeline(object):
    def __init__(self, mongo_uri, mongo_db):
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
    
    # 在开启爬虫时，就创建MongoDB客户端对象
    def open_spider(self, spider):  
        self.client=pymongo.MongoClient(self.mongo_uri)
        self.db=self.client[self.mongo_db]
    
    def process_item(self, item, spider):
        name = item.__class__.__name__
        self.db[name].insert(dict(item))
        return item

    def close_spider(self, spider):
        self.client.close()
        




























