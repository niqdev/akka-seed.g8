package $package$

import akka.actor.ActorSystem
import akka.event.Logging
import akka.stream.ActorMaterializer
import akka.util.Timeout
import $package$.config.Settings
import $package$.http.Web

import scala.concurrent.ExecutionContext

object Server extends Web with App {

  protected[this] implicit val actorSystem: ActorSystem = ActorSystem("$name$")
  protected[this] implicit val materializer: ActorMaterializer = ActorMaterializer()
  protected[this] implicit val executionContext: ExecutionContext = actorSystem.dispatcher

  private[this] lazy val httpConfig = Settings(actorSystem).Http
  protected[this] implicit val timeout: Timeout = httpConfig.timeout

  private[this] val log = Logging(actorSystem, getClass.getName)

  bindAndHandleHttp {
    log.debug("run server")
  }

}
