emailValidator = (value, callback) ->
  setTimeout ->
    if /.+@.+/.test value
      callback true
    else
      callback false
  , 300

$container = $ '#container'
handsonTable = $container.data 'handsonTable'

$ 'body'
  .on 'click', 'button[name=load]', ->
    $.ajax
      url: '/j'
      dataType: 'json'
      type: 'GET'
      success: (data) ->
        handsonTable.loadData(data)

$ 'body'
  .on 'click', 'button[name=save]', ->
    $.ajax
      url: '/j'
      dataType: 'json'
      data: JSON.stringify {}
      type: 'POST'
      contentType: 'application/json; charset=utf-8'
      success: (data) ->
        if data.ok is true
          console.log 'success!'
          window.location.href = '/'
        else
          console.log 'fail!'
      error: ->
        console.log 'fail!'
