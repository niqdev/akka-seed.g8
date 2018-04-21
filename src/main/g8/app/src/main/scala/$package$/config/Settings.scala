package $package$
package config

import akka.actor.{ActorSystem, ExtendedActorSystem, Extension, ExtensionId, ExtensionIdProvider}

final class SettingsImpl(system: ExtendedActorSystem) extends Extension {
  private[this] val config = system.settings.config
  private[this] val applicationConfig = config getConfig "application"
}

object Settings extends ExtensionId[SettingsImpl] with ExtensionIdProvider {

  override def lookup: ExtensionId[SettingsImpl] = Settings

  override def createExtension(system: ExtendedActorSystem): SettingsImpl = new SettingsImpl(system)

  /**
    * Java API: retrieve the Settings extension for the given system.
    */
  override def get(system: ActorSystem): SettingsImpl = super.get(system)
}
