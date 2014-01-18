package com.imom0.akka

import scala.collection.immutable._

import akka.actor.ActorSystem
import akka.actor.Props
import akka.actor.actorRef2Scala
import com.imom0.akka.actors.MasterActor

class Word(val word:String,val count:Int)
case class Result
class MapData(val dataList: List[Word])
class ReduceData(val reduceDataMap: Map[String, Int])


object MapReduceApplication {

	def main(args: Array[String]) {
		val _system = ActorSystem("MapReduceApp")
		val master = _system.actorOf(Props[MasterActor], name = "master")

		master ! "The quick brown fox tried to jump over the lazy dog and fell on the dog"
		master ! "Dog is man's best friend"
		master ! "Dog and Fox belong to the same family"

		Thread.sleep(500)
		master ! new Result

		Thread.sleep(500)
		_system.shutdown
	}
}
