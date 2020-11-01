package chapter26

object FilterForList extends App {

  def filter[A](f: A => Boolean, list: Seq[A]): Seq[A] = {
    for {
      x <- list
      if f(x)
    } yield x
  }

  val test = List(1, 2, 3)

  val isEven: Int => Boolean = (a) => a % 2 == 0

  print(filter(isEven,test))


}
