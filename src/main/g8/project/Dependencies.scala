import sbt._

object Dependencies {

  lazy val N = new {
    val typesafe = "com.typesafe.akka"
    val circe = "io.circe"
  }

  lazy val V = new {
    val scala = "2.12.5"

    val logback = "1.2.3"
    val scalaLogging = "3.9.0"
    val config = "1.3.3"

    val akka = "2.5.12"
    val akkaHttp = "10.1.1"

    val circe = "0.9.3"

    val scalatest = "3.0.5"
  }

  lazy val commonDependencies = Seq(
    "ch.qos.logback" % "logback-classic" % V.logback,
    "com.typesafe.scala-logging" %% "scala-logging" % V.scalaLogging,
    "com.typesafe" % "config" % V.config,

    N.typesafe %% "akka-actor" % V.akka,
    N.typesafe %% "akka-stream" % V.akka,
    N.typesafe %% "akka-http" % V.akkaHttp,
    N.typesafe %% "akka-slf4j" % V.akka,

    N.circe %% "circe-core" % V.circe,
    N.circe %% "circe-generic" % V.circe,
    N.circe %% "circe-parser" % V.circe,
    N.circe %% "circe-java8" % V.circe
  )

  lazy val testDependencies = Seq(
    "org.scalatest" %% "scalatest" % V.scalatest % Test,
    N.typesafe %% "akka-testkit" % V.akka % Test,
    N.typesafe %% "akka-http-testkit" % V.akkaHttp % Test
  )

  lazy val libDependencies = commonDependencies ++ testDependencies

  lazy val cliDependencies = commonDependencies

}
