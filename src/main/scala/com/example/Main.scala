package com.example

  import akka.actor.ActorSystem
  import akka.actor.Props
  import akka.cluster.Cluster
  import com.example.Publisher
  import com.example.Subscriber

object Main {
  def main(args: Array[String]): Unit = {
    val systemName = "PubSub"
    val system1 = ActorSystem(systemName)
    val joinAddress = Cluster(system1).selfAddress
    Cluster(system1).join(joinAddress)
    val publisher = system1.actorOf(Props[Publisher], "publisher")

    Thread.sleep(5000)
    val system2 = ActorSystem(systemName)
    Cluster(system2).join(joinAddress)
    system2.actorOf(Props[Subscriber], "subscriber")

    Thread.sleep(5000)
    publisher ! "something"
  }
}