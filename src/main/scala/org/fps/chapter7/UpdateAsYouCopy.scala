package org.fps.chapter7

object UpdateAsYouCopy extends App {

  case class Person(firstName: String, lastName: String)

  val emily1 = Person("Emily","Turner")

  val emily2 = emily1.copy(lastName = "Groover")

  println(s"Emily 1: $emily1")

  println(s"Emily2: $emily2")

}
