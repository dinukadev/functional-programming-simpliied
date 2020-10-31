package chapter23

object FunctionsAsVal extends App {

  val double = (x: Int) => x * 2


  println(double(2))

  //The scala compiler converts the above function to the below function
  val doubleAsExplicitFunction = new Function[Int, Int] {
    override def apply(v1: Int): Int = 2 * v1
  }

  println(doubleAsExplicitFunction(2))

  def doubleMethod(x: Int): Int = {
    2 * x
  }

  println(doubleMethod(2))

  //Making the def function a val function
  val defToValFunction  = doubleMethod _

  println(defToValFunction(2))

}
