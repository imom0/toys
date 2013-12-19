#!/usr/bin/env python
# -*- coding: UTF-8 -*-

from scrapy.item import Item, Field


class ArticleItem(Item):
    title = Field()
    author = Field()
    content = Field()
    date = Field()
