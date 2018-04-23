package $package$
package http

import akka.http.scaladsl.testkit.ScalatestRouteTest
import org.scalatest.{Matchers, WordSpec}
import $package$.Server.routes
import $package$.http.route.Status

// scalastyle:off underscore.import
import io.circe.generic.auto._
import io.circe.syntax._
// scalastyle:on underscore.import

class RoutesSpec extends WordSpec with Matchers with ScalatestRouteTest {

  "routes /status" should {
    "return OK for GET requests to the root path" in {
      Get("/status") ~> routes ~> check {
        responseAs[String] shouldEqual Status("OK").asJson.noSpaces
      }
    }
  }

}
