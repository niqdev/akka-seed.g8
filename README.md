# akka-seed.g8

[![Build Status][travis-image]][travis-url]

[travis-image]: https://travis-ci.org/niqdev/akka-seed.g8.svg?branch=master
[travis-url]: https://travis-ci.org/niqdev/akka-seed.g8

```bash
# create project
sbt new niqdev/akka-seed.g8
```

Features

* [Akka](https://akka.io/docs)
* [circe](https://circe.github.io/circe)
* [Multi-Project](https://www.scala-sbt.org/1.x/docs/Multi-Project.html)
* [scopt](https://github.com/scopt/scopt)
* [ScalaTest](http://www.scalatest.org)
* [Gatling](https://gatling.io)
* [Docker](https://www.scala-sbt.org/sbt-native-packager/formats/docker.html)
* [Prometheus](https://prometheus.io)
* [CircleCI](https://circleci.com)
<!-- [ECR](https://aws.amazon.com/ecr) -->
* [Kubernetes](https://kubernetes.io)

Plugins

* [sbt-revolver](https://github.com/spray/sbt-revolver)
* [sbt-scoverage](https://github.com/scoverage/sbt-scoverage)
* [sbt-scalafmt](http://scalameta.org/scalafmt/)
* [sbt-header](https://github.com/sbt/sbt-header)
* [scalastyle-sbt-plugin](http://www.scalastyle.org/sbt.html)
* [sbt-dependency-graph](https://github.com/jrudolph/sbt-dependency-graph)
* [sbt-updates](https://github.com/rtimush/sbt-updates)
* [sbt-site](https://www.scala-sbt.org/sbt-site/)
* [sbt-unidoc](https://github.com/sbt/sbt-unidoc)
* [sbt-native-packager](https://www.scala-sbt.org/sbt-native-packager)
* [sbt-assembly](https://github.com/sbt/sbt-assembly)
* [gatling-sbt](https://gatling.io/docs/current/extensions/sbt_plugin)

### Development

```bash
# create template
g8 foundweekends/giter8.g8

# test template
g8 file://akka-seed.g8 \
  --name=my-akka-project \
  --force
```
