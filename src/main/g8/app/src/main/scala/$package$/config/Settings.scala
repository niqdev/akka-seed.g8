package $package$
package config

import java.util.concurrent.TimeUnit.SECONDS

import akka.actor.{ActorSystem, ExtendedActorSystem, Extension, ExtensionId, ExtensionIdProvider}
import com.typesafe.config.ConfigFactory

import scala.concurrent.duration.FiniteDuration

final class SettingsImpl(system: ExtendedActorSystem) extends Extension {
  private[this] lazy val config = system.settings.config
  private[this] val applicationConfig = config getConfig "application"

  object Http {
    private[this] val httpConfig = applicationConfig getConfig "http"

    val host: String = httpConfig getString "host"
    val port: Int = httpConfig getInt "port"
    val timeout = FiniteDuration((httpConfig getDuration "timeout").getSeconds, SECONDS)
  }
}

object Settings extends ExtensionId[SettingsImpl] with ExtensionIdProvider {

  override def lookup: ExtensionId[SettingsImpl] = Settings

  override def createExtension(system: ExtendedActorSystem): SettingsImpl = new SettingsImpl(system)

  /**
    * Java API: retrieve the Settings extension for the given system.
    */
  override def get(system: ActorSystem): SettingsImpl = super.get(system)
}

// alternative without actor system
object BaseSettings {
  private[this] lazy val config = ConfigFactory.load()
  private[this] val applicationConfig = config getConfig "application"

  val name: String = applicationConfig getString "name"
}
