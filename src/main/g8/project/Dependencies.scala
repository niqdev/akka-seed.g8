import sbt._

object Dependencies {

  lazy val N = new {
    val typesafe = "com.typesafe.akka"
    val circe = "io.circe"
    val prometheus = "io.prometheus"
  }

  lazy val V = new {
    val scala = "2.12.5"

    val logback = "1.2.3"
    val scalaLogging = "3.9.0"
    val config = "1.3.3"
    val scopt = "3.7.0"

    val akka = "2.5.12"
    val akkaHttp = "10.1.1"

    val circe = "0.9.3"

    val prometheus = "0.3.0"

    val scalatest = "3.0.5"
    val scalamock = "3.6.0"
  }

  lazy val commonDependencies = Seq(
    "ch.qos.logback" % "logback-classic" % V.logback,
    "com.typesafe.scala-logging" %% "scala-logging" % V.scalaLogging,
    "com.typesafe" % "config" % V.config,

    "org.scalatest" %% "scalatest" % V.scalatest % Test,
    "org.scalamock" %% "scalamock-scalatest-support" % V.scalamock % Test
  )

  lazy val appDependencies = commonDependencies ++ Seq(
    N.typesafe %% "akka-actor" % V.akka,
    N.typesafe %% "akka-stream" % V.akka,
    N.typesafe %% "akka-http" % V.akkaHttp,
    N.typesafe %% "akka-slf4j" % V.akka,

    N.circe %% "circe-core" % V.circe,
    N.circe %% "circe-generic" % V.circe,
    N.circe %% "circe-parser" % V.circe,
    N.circe %% "circe-java8" % V.circe,

    N.prometheus % "simpleclient" % V.prometheus,
    N.prometheus % "simpleclient_common" % V.prometheus,
    N.prometheus % "simpleclient_hotspot" % V.prometheus,

    N.typesafe %% "akka-testkit" % V.akka % Test,
    N.typesafe %% "akka-http-testkit" % V.akkaHttp % Test
  )

  lazy val cliDependencies = commonDependencies ++ Seq(
    "com.github.scopt" %% "scopt" % V.scopt
  )

  lazy val perfDependencies = commonDependencies ++ Seq(
    "io.gatling.highcharts" % "gatling-charts-highcharts" % "2.3.1" % "test,it",
    "io.gatling" % "gatling-test-framework" % "2.3.1" % "test,it"
  )

}
