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
      success: ->
        handsonTable.loadData(data)
