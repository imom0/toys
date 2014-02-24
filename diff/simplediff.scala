/**
 * Created by imom0 on 14-01-08.
 */

import collections.mutable.{Map, ListBuffer}

class SimpleDiff(before: String, after: String) {
  def diff = {
    var before_map = Map[String, ListBuffer[Int]]()
    List(("=", "Hello, "), ("-", "W"), ("+", "w"), ("=", "orld"), ("+", "!"))
  }
}
