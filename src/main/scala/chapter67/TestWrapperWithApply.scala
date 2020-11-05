package chapter67

object TestWrapperWithApply extends App {

  val intResult = for {
    a <-WrapperWithApply(1)
    b <-WrapperWithApply(2)
    c <-WrapperWithApply(3)
  } yield a + b + c
  println(intResult)


}
