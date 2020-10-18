package chapter13

object Capitalize extends App {

  val names = List("dinuka","roshan")

  val capNames = for(e<-names) yield e.capitalize

  println(capNames)
}
