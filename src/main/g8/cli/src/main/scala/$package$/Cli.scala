package $package$

import com.typesafe.scalalogging.Logger

object Cli extends App {
  private[this] val log = Logger(getClass.getName)

  log.debug("hello")
}
