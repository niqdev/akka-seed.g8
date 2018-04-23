import Settings._

lazy val app = project.in(file("app"))
  .settings(appSettings)
  .enablePlugins(JavaServerAppPackaging)

lazy val cli = project.in(file("cli"))
  .settings(cliSettings)
  .dependsOn(app)

lazy val `$name;format="normalize"$` = project.in(file("."))
  // TODO issue AutomateHeaderPlugin https://github.com/sbt/sbt-header/issues/153
  .enablePlugins(SiteScaladocPlugin, ScalaUnidocPlugin)
  .settings(rootSettings)
  .aggregate(app, cli)
