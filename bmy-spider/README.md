爬取 xjtuenews 版非合集的数据，确保 mongodb 已启动，

    pip install -r requirements.txt
    
    scrapy crawl xjtunews
    
这个过程需要约10分钟，结束时会显示 `Spider closed (finished)` 。


统计`呵呵`出现的次数，显示降序排序前50名，

    mongo localhost:27017/momo_test count.js