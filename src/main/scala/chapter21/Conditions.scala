package chapter21

object Conditions extends App {

  val greater = if (2 > 1) 2 else 1
  println(greater)

  val i = 1
  val evenOrOdd = i match {
    case 1 | 3 | 5 => println("odd")
    case 2 | 4 | 8 => println("even")
  }



  def toInt(s: String): Int = {
    try {
      s.toInt
    } catch {
      case _: Throwable => 0
    }
  }

  println(toInt("1"))
  println(toInt("ss"))
}
