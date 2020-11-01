package chapter26

object MapForList extends App {

  def map[A](f: Int => A, list: List[Int]): List[A] = {
    for {
      x <- list
    } yield f(x)
  }

  val test = List(1, 2, 3)

  val doubleProduct: (Int) => Int = (a) => a * 2


  print(map(doubleProduct, test))
}
