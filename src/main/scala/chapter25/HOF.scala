package chapter25

object HOF extends App {

  def sayHello(callback: () => Unit): Unit = {
    callback()
  }

  def hello(): Unit = {
    println("hello")
  }

  sayHello(hello)

  def runAFunction(f: Int => Unit): Unit = {
    f(42)
  }

  def printAnInt(i: Int): Unit = {
    println(i + 1)
  }

  runAFunction(printAnInt)

  def executeAndPrint(f: (Int, Int) => Int, x: Int, y: Int): Unit = {
    val result = f(x, y)
    println(result)
  }

  def sum(x: Int, y: Int) = x + y

  executeAndPrint(sum, 2, 2)

  def executeTwoFunctions(f1: (Int, Int) => Int, f2: (Int, Int) => Int, a: Int, b: Int): Tuple2[Int, Int] = {
    val resultOne = f1(a, b)
    val resultTwo = f2(a, b)
    (resultOne, resultTwo)
  }

  def multiply(a:Int, b:Int) = a * b

  println(executeTwoFunctions(multiply,sum, 2,2))

  val sumExtended: (Int, Int)=>Int = (a,b)=> a+ b

  executeAndPrint(sumExtended,1,2)


}

