package chapter31

import scala.annotation.tailrec

object AllAboutRecursionPartOne extends App {

  //creating empty lists
  val emptyListOne = List()
  val emptyListTwo = Nil
  println(emptyListOne)
  println(emptyListTwo)

  //creating lists with elements
  val listWithEleOne = List(1, 2, 3)
  val listWithEleTwo = 1 :: 2 :: 3 :: Nil
  //The second approach is known as using “cons cells.” As you can see, it’s a very literal approach to creating a List ,
  // where you specify each element in the List , including the Nil element, which must be in the last position.
  // If you forget the Nil element at the end, the Scala compiler will bark at you:
  println(listWithEleOne)
  println(listWithEleTwo)
  println(listWithEleOne == listWithEleTwo)


  //Sum a list using recursion

  def sum(list: List[Int]): Int = list match {
    case Nil => 0
    //you do not say return 0 in scala as values are evaluated and not returned in FP. It is still valid to say
    //return 0 as well
    //Since Nil == List() you can write the above case as case List() => 0 as well

    case head :: tail => head + sum(tail)
    //When working with a list, a single element is often referred to as x ,
    // and multiple elements are referred to as xs . It’s a way of indicating that x is singular and xs is plural,
    // like referring to a single “pizza” or multiple “pizzas.”

  }

  println(sum(List(1, 2, 3)))


  //the above sum function fails if you use it with a larger list due to a stackoverflow
  //println((sum(List.range(1,10000))))

  //tail-recursive sum function

  def tailRecSum(list: List[Int]): Int = {
    @tailrec
    def sumWithAccumulator(accumulator: Int, list: List[Int]): Int = list match {
      case Nil => accumulator
      case x :: xs => sumWithAccumulator(accumulator + x, xs)
    }

    sumWithAccumulator(0, list)
  }

  println(tailRecSum(List.range(1, 1000000)))


}
