package chapter53

object PureFunctions extends App {

  /**
   * In FP, we never throw errors. Always return an option. Otherwise you violate the functional composition.
   */
  def makeInt(s: String): Option[Int] = {
    try {
      Some(s.trim.toInt)
    } catch {
      case e: Exception => None
    }
  }

  val myInt = makeInt("2") match {
    case Some(value) => println(value)
    case None => println("Exception occurred")
  }


  val myInvalidInt = makeInt("dummy") match {
    case Some(value) => println(value)
    case None => println("Exception occurred")
  }

}
