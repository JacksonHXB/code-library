# -*- coding: utf-8 -*-
import scrapy
from ..items import QuoteItem


class QuotesSpider(scrapy.Spider):
    name = 'quotes'
    allowed_domains = ['quotes.toscrape.com']
    start_urls = ['http://quotes.toscrape.com/']

    # 解析索引页
    def parse(self, response):
        # 输出网页源代码
        # print(response.text)
        
        # 获取quote的区块集合
        quotes = response.css('.quote')
        
        # 遍历每个区块，并获取其中所要爬取的数据
        for quote in quotes:
            # 获取对象并赋值
            item = QuoteItem()
            
            text = quote.css('.text::text').extract_first()
            author = quote.css('.author::text').extract_first()
            tags = quote.css('.tags .tag::text').extract()
            
            item['text'] = text
            item['author'] = author
            item['tags'] = tags
            
            # 生成item，scrapy会自动识别
            yield item
            
        # 获取下一页的连接
        nextHref = response.css('.pager .next a::attr(href)').extract_first()
        # 生成一个绝对的URL
        url = response.urljoin(nextHref)
        # 重新指定url地址，然后再回调本函数，实现递归效果
        yield scrapy.Request(url=url, callback=self.parse)

















































