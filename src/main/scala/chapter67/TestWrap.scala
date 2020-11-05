package chapter67

object TestWrap extends App {

  val testWrap = new Wrapper[Int](2)

  println(testWrap.map(_  * 2))

  val intResult: Wrapper[Int] = for {
    a <-new Wrapper(1)
    b <-new Wrapper(2)
    c <-new Wrapper(3)
  } yield a + b + c
  println(intResult)


  val stringResult: Wrapper[String] = for {
    a <-new Wrapper("a")
    b <-new Wrapper("b")
    c <-new Wrapper("c")
  } yield a + b + c

  println(stringResult)

}
