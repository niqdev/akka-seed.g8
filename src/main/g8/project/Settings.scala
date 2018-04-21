import Dependencies._
import sbt.Keys._

object Settings {

  lazy val commonSettings = Seq(
    scalaVersion := V.scala,

    organization := "$organization$"
  )

  lazy val appSettings = commonSettings ++ Seq(
    name := "app",
    libraryDependencies ++= appDependencies,
    mainClass in run := Some("$package$.Main")
  )

  lazy val cliSettings = commonSettings ++ Seq(
    name := "cli",
    libraryDependencies ++= cliDependencies,
    mainClass in run := Some("$package$.cli.Cli")
  )

}
