package $package$
package http

import akka.http.scaladsl.model.StatusCodes.ServiceUnavailable
import akka.http.scaladsl.server.Directives.pathPrefix
import akka.http.scaladsl.server.Route
import akka.util.Timeout
import $package$.http.route.{MetricsRoute, StatusRoute}

import scala.concurrent.ExecutionContext

// scalastyle:off underscore.import
import akka.http.scaladsl.server.Directives._
// scalastyle:on underscore.import

trait Routes extends StatusRoute with MetricsRoute {

  protected[this] implicit def executionContext: ExecutionContext
  protected[this] implicit def timeout: Timeout

  /**
    * All routes.
    *
    * @return Route
    */
  def routes: Route = statusRoute ~ metricsRoute ~ v1

  private[this] def v1 =
    pathPrefix("v1") {
      get {
        complete(ServiceUnavailable)
      }
    }

}
