logLevel := Level.Debug

// common
addSbtPlugin("com.geirsson" % "sbt-scalafmt" % "1.4.0")
addSbtPlugin("de.heikoseeberger" % "sbt-header" % "5.0.0")
addSbtPlugin("org.scalastyle" %% "scalastyle-sbt-plugin" % "1.0.0")

// app
addSbtPlugin("com.typesafe.sbt" % "sbt-native-packager" % "1.3.4")
