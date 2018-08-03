package com.example
import akka.actor.{Actor, ActorLogging, ActorSystem, Props}
import akka.cluster.pubsub.{DistributedPubSub, DistributedPubSubMediator}

class Subscriber extends Actor with ActorLogging {
  import DistributedPubSubMediator.{ Subscribe, SubscribeAck }
  val mediator = DistributedPubSub(context.system).mediator
  // subscribe to the topic named "content"
  mediator ! Subscribe("content", self)

  def receive = {
    case s: String =>
      log.info("Got {}", s)
    case SubscribeAck(Subscribe("content", None, `self`)) =>
      log.info("subscribing");
  }
}
/*

object SubscriberMain extends App {
  val system = ActorSystem("ClusterSystem")
  val actor = system.actorOf(Props[Subscriber], name="Subscriber")
}*/
