name := "hehe"

organization := "com.imom0"

version := "1.0"

scalaVersion := "2.10.3"

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.2.3",
  "org.scalatest" % "scalatest_2.10" % "2.0" % "test"
)
