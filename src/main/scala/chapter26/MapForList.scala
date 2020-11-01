package chapter26

object MapForList extends App {

  def map[A,B](f: (A) => B, list: Seq[A]): Seq[B] = {
    for {
      x <- list
    } yield f(x)
  }

  val test = List(1, 2, 3)

  val doubleProduct: (Int) => Int = (a) => a * 2


  print(map(doubleProduct, test))
}
