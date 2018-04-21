import Settings._

lazy val app = project.in(file("app"))
  .settings(appSettings)

lazy val cli = project.in(file("cli"))
  .settings(cliSettings)
  .dependsOn(app)

lazy val `akka-stream-cassandra` = project.in(file("."))
  .aggregate(app, cli)
