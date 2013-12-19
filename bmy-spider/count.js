var heheReduce = function (key, values) {
  var total = 0;
  for (var i = 0; i < values.length; i++) {
    total += values[i];
  }
  return total;
};
var heheMap = function() {
  var pattern = /\u5475\u5475/g,
      matched = this.content.match(pattern),
      count = matched == null?0:matched.length;
  emit(this.author, count)
};
db.articles.mapReduce(
    heheMap,
    heheReduce,
    {
      out: 'article_hehe_count'
    }
)
printjson(
  db.article_hehe_count.find().sort({
    'value': -1
  }).limit(50).toArray()
)
