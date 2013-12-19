# Define your item pipelines here
#
# Don't forget to add your pipeline to the ITEM_PIPELINES setting
# See: http://doc.scrapy.org/en/latest/topics/item-pipeline.html
from scrapy.exceptions import DropItem


class BmySpiderPipeline(object):

    def __init__(self):
        self.seen = set()

    def process_item(self, item, spider):
        ident = (item['author'], item['date'])
        if ident in self.seen:
            raise DropItem("Duplicate item found: %s" % item)
        else:
            self.seen.add(ident)
            return item
