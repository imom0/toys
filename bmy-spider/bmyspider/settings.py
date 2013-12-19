# Scrapy settings for bmyspider project
#
# For simplicity, this file contains only the most important settings by
# default. All the other settings are documented here:
#
#     http://doc.scrapy.org/en/latest/topics/settings.html
#

BOT_NAME = 'bmyspider'

SPIDER_MODULES = ['bmyspider.spiders']
NEWSPIDER_MODULE = 'bmyspider.spiders'

MONGODB_URI = 'mongodb://localhost:27017'
MONGODB_DATABASE = 'momo_test'
MONGODB_COLLECTION = 'articles'

# Crawl responsibly by identifying yourself (and your website) on the user-agent
#USER_AGENT = 'bmyspider (+http://www.yourdomain.com)'

ITEM_PIPELINES = {
    'bmyspider.pipelines.BmySpiderPipeline': 100,
    'scrapy_mongodb.MongoDBPipeline': 200,
}
