/**
 * Created by imom0 on 14-01-08.
 */

import collections.mutable.{Map, ListBuffer}

class SimpleDiff(before: String, after: String) {
  def diff = {
    var before_map = Map[Char, ListBuffer[Int]]()
    for ((x, i) <- before.view.zipWithIndex) {
      var e = m.getOrElse(x, ListBuffer[Int]())
      e += i
      m(x) = e
    }
    List(("=", "Hello, "), ("-", "W"), ("+", "w"), ("=", "orld"), ("+", "!"))
  }
}
