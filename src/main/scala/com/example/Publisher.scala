package com.example
import akka.actor.{Actor, ActorSystem, Props}
import akka.cluster.pubsub.{DistributedPubSub, DistributedPubSubMediator}
import com.typesafe.config.ConfigFactory

class Publisher extends Actor {
  import DistributedPubSubMediator.Publish
  // activate the extension
  val mediator = DistributedPubSub(context.system).mediator

  def receive = {
    case in: String => {
      val out = in.toUpperCase
      println(s"Received '$in', transformed to '$out'.")
      mediator ! Publish("content", out)
    }
  }
}
/*
object PublisherMain extends App {
  val config = ConfigFactory.load()
  val system = ActorSystem("ClusterSystem", config.getConfig("PublishApp"))
  val actor = system.actorOf(Props[Publisher], name="Publisher")
  actor ! "something small"
}*/
