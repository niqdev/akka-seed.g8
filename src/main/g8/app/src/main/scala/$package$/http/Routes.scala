package $package$
package http

import akka.actor.ActorSystem
import akka.http.scaladsl.model.StatusCodes.ServiceUnavailable
import akka.http.scaladsl.server.Directives.pathPrefix
import akka.http.scaladsl.server.Route
import akka.stream.ActorMaterializer
import akka.util.Timeout
import $package$.http.route.{EnvRoute, MetricsRoute, StatusRoute}

import scala.concurrent.ExecutionContext

// scalastyle:off underscore.import
import akka.http.scaladsl.server.Directives._
// scalastyle:on underscore.import

trait Routes extends StatusRoute with MetricsRoute with EnvRoute {

  protected[this] implicit def actorSystem: ActorSystem
  protected[this] implicit def materializer: ActorMaterializer
  protected[this] implicit def executionContext: ExecutionContext
  protected[this] implicit def timeout: Timeout

  /**
    * All routes.
    *
    * @return Route
    */
  def routes: Route = statusRoute ~ metricsRoute ~ envRoute ~ v1

  private[this] def v1 =
    pathPrefix("v1") {
      get {
        complete(ServiceUnavailable)
      }
    }

}
