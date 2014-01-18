package com.imom0.akka.actors

import scala.collection.immutable._

import akka.actor.actorRef2Scala
import akka.actor.Actor
import akka.actor.ActorRef
import com.imom0.akka.MapData
import com.imom0.akka.ReduceData
import com.imom0.akka.Word

class ReduceActor(aggregateActor: ActorRef) extends Actor {

  val defaultCount: Int = 1
  def receive: Receive = {
    case message: MapData =>
      aggregateActor ! reduce(message.dataList)
  }

  def reduce(dataList: List[Word]): ReduceData = {
    var reducedMap = new HashMap[String, Int]
    for (wc: Word <- dataList) {
      var word: String = wc.word
      if (reducedMap.contains(word)) {  
    	var count:Int = reducedMap.get(word).get + defaultCount  
        reducedMap += word -> count
      } else {
        reducedMap += word -> defaultCount
      }
    }
    return new ReduceData(reducedMap)
  }
}
