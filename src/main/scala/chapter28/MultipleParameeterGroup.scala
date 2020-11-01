package chapter28

object MultipleParameeterGroup extends App {

  def sum(a: Int)(b: Int)(c: Int): Int = {
    a + b + c
  }

  println(sum(1)(2)(3))

  def whilst(testCondition: => Boolean)(codeBlock: => Unit): Unit = {
    while (testCondition) {
      codeBlock
    }
  }

  var i = 1
  whilst(i < 5) {
    println(i)
    i += 1
  }
}
