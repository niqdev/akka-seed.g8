import Settings._

lazy val app = project.in(file("app"))
  .settings(appSettings)

lazy val cli = project.in(file("cli"))
  .settings(cliSettings)
  .dependsOn(app)

lazy val `$name;format="normalize"$` = project.in(file("."))
  .aggregate(app, cli)
