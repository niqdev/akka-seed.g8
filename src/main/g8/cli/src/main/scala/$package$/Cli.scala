package $package$

import com.typesafe.scalalogging.Logger

object Cli {
  private[this] val log = Logger(getClass.getName)

  def main(args: Array[String]): Unit = {
    CommandLineParser.parse(args) match {
      case Right(params) =>
        log.debug(s"\$params")
      case Left(error) =>
        log.error(s"\$error")
    }
  }

}
