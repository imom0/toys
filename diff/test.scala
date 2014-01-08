/**
 * Created by imom0 on 14-01-08.
 */
import simplediff.SimpleDiff

object Test extends App {
  val a = "Hello, World"
  val b = "Hello, world!"
  assert(new SimpleDiff(a, b).diff == List(("=", "Hello, "), ("-", "W"), ("+", "w"), ("=", "orld"), ("+", "!")))
}
