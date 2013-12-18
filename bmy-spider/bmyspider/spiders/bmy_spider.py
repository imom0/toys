#!/usr/bin/env python
# -*- coding: UTF-8 -*-

from urllib import urlencode

from scrapy.spider import BaseSpider, Request
from scrapy.selector import Selector

from ..items import ArticleItem


BASE_URL = 'http://202.117.1.8/BMY/'
TOPIC_LIST_URL = BASE_URL + 'bbstdoc'

counter = 0


class NewsTopicSpider(BaseSpider):
    name = 'xjtunews'
    allowed_domains = ['202.117.1.8']
    start_payload = {'B': 'XJTUnews', 'S': 2500}
    start_urls = [TOPIC_LIST_URL + '?' + urlencode(start_payload)]

    def parse(self, response):
        if response.url.startswith(TOPIC_LIST_URL):
            for request in self.parse_topic_links(response):
                yield request
        else:
            for request in self.parse_topic_detail(response):
                yield request

    def parse_topic_links(self, response):
        global counter
        sel = Selector(response)
        nexts = [item.css('::attr(href)').extract()[0]
                 for item in sel.css('.level2 a')
                 if item.css('::text').extract()[0] == u'下一页']
        topics = [item.css('::attr(href)').extract()[0]
                  for item in sel.css('.tdborder a')
                  if item.css('::text').re(ur'^○ (?!【合集】)')]
        for url in topics:
            url = BASE_URL + url
            yield Request(url, callback=self.parse)

        if counter < 10:
            for url in nexts:
                url = BASE_URL + url
                yield Request(url, callback=self.parse)
            counter += 1

    def parse_topic_detail(self, response):
        sel = Selector(response)
        nexts = [item.css('::attr(href)').extract()[0]
                 for item in sel.css('.level2 a')
                 if item.css('::text').extract() == [u'下页']]
        print response.body[:50]
        for url in nexts:
            url = BASE_URL + url
            yield Request(url, callback=self.parse)
