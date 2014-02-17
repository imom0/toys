casper = require('casper').create
  viewportSize:
    width: 1600,
    height: 900

casper.start 'http://love.163.com/', ->
  @echo @getTitle()
  @click 'a.pLogin-login-sina'

casper.waitForUrl /api\.weibo/, ->
  @echo @getTitle()
  @fill 'form[name="authZForm"]',
      userId: ''
      passwd: ''
    ,
    false
  @click '.oauth_login_submit a.WB_btn_login'

casper.waitForUrl /love\.163\.com\//,
  -> @capture 'login.png',
  ->
    @capture 'timeout.png'
    @echo 'timeout'
  ,
  15000

casper.run()
