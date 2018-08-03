name := "pubsubexp"

version := "0.1"

scalaVersion := "2.12.6"

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies +=
  "com.typesafe.akka" %% "akka-actor" % "2.5.0"

libraryDependencies +=
  "com.typesafe.akka" %% "akka-cluster" % "2.5.0"

libraryDependencies +=
"com.typesafe.akka" %% "akka-cluster-tools" % "2.5.0"