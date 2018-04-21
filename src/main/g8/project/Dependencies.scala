import sbt._

object Dependencies {

  lazy val N = new {
    val typesafe = "com.typesafe.akka"
  }

  lazy val V = new {
    val scala = "2.12.5"

    val logback = "1.2.3"
    val scalaLogging = "3.9.0"
    val config = "1.3.3"

    val akka = "2.5.12"

    val scalatest = "3.0.5"
  }

  lazy val commonDependencies = Seq(
    "ch.qos.logback" % "logback-classic" % V.logback,
    "com.typesafe.scala-logging" %% "scala-logging" % V.scalaLogging,
    "com.typesafe" % "config" % V.config,

    N.typesafe %% "akka-stream" % V.akka
  )

  lazy val testDependencies = Seq(
    "org.scalatest" %% "scalatest" % V.scalatest % Test,
    N.typesafe %% "akka-testkit" % V.akka % Test
  )

  lazy val libDependencies = commonDependencies ++ testDependencies

  lazy val cliDependencies = commonDependencies

}
