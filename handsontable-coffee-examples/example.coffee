emailValidator = (value, callback) ->
  setTimeout ->
    if /.+@.+/.test value
      callback true
    else
      callback false
  , 300
