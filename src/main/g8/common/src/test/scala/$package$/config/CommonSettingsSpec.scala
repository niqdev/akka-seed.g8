package $package$
package config

import org.scalatest.{Matchers, WordSpecLike}

final class CommonSettingsSpec extends WordSpecLike with Matchers {

  "name" should {
    "be equal to $name;format="normalize"$" in {
      CommonSettings.name shouldEqual "$name;format="normalize"$"
    }
  }

  "log file name" should {
    "be equal to name" in {
      CommonSettings.logName shouldEqual CommonSettings.name
    }
  }

}
