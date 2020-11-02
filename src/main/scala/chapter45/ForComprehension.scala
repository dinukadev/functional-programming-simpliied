package chapter45

object ForComprehension extends App {

  case class Person(firstName: String, lastName: String)

  val personList = List(Person("Bruce", "Wayne"),
    Person("Clark", "Kent"))

  val firstNameStartsWithB = for {
    p <- personList
    firstName = p.firstName
    if firstName startsWith "B"
  }yield firstName.toUpperCase

  println(firstNameStartsWithB)

}
