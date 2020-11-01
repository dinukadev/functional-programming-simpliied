package chaptere27

object ByName extends App {

  def timer[A](blockOfCode: => A) = {
    val startTime = System.nanoTime
    val result = blockOfCode
    val stopTime = System.nanoTime
    val delta = stopTime - startTime
    (result, delta)
  }


  val sumFunc: (Int, Int) => Int = (a, b) => a + b


  print(timer(sumFunc(1, 2)))
}
