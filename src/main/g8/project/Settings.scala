import Dependencies._
import com.typesafe.config.ConfigFactory
import com.typesafe.sbt.SbtNativePackager.autoImport.packageName
import com.typesafe.sbt.packager.docker.DockerPlugin.autoImport.dockerExposedPorts
import sbt.Keys._
import sbt._

object Settings {

  lazy val commonSettings = Seq(
    scalaVersion := V.scala,

    organization := "$organization$"
  )

  lazy val appSettings = commonSettings ++ Seq(
    name := "app",
    libraryDependencies ++= appDependencies,
    mainClass in run := Some("$package$.Main"),

    // docker
    packageName := "$name;format="normalize"$",
    dockerExposedPorts := {
      val resourceFile = (resourceDirectory in Compile).value / "application"
      val config = ConfigFactory.parseFileAnySyntax(resourceFile).resolve()
      Seq(config.getInt("application.docker.port"))
    }
  )

  lazy val cliSettings = commonSettings ++ Seq(
    name := "cli",
    libraryDependencies ++= cliDependencies,
    mainClass in run := Some("$package$.cli.Cli")
  )

}
