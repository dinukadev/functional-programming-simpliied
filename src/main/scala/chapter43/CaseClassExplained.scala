package chapter43

object CaseClassExplained extends App {

  case class Person(name: String, age: Int)

  val jonny = Person("Jonny", 20)

  println(jonny)

  jonny match {
    case Person(name, age) => println(name, age)
  }

  val jonnyCopy = jonny.copy(age = 22)

  println(jonnyCopy)



}
