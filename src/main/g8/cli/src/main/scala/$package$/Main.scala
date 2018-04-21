package $package$

import com.typesafe.scalalogging.Logger

object Main extends App {
  private[this] val log = Logger(getClass.getName)

  log.debug("hello")
}
