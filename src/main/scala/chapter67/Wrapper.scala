package chapter67

class Wrapper[A](value: A) {

  /**
   * But in Scala’s “functional objects” approach, you can access value implicitly.
   * Technically this violates my rule that for pure functions, “Output depends only on input,”
   * but when you use the functional objects coding style, this is the one case where you are allowed to implicitly
   * access other fields in a function in your class.
   *
   * If you’ve heard the term “closure” before, yes, this is essentially a closure.
   *
   */
  def map[B](f: A => B): Wrapper[B] = {
    val newInt = f(value)
    new Wrapper(newInt)
  }

  def flatMap[B](f: A => Wrapper[B]): Wrapper[B] = f(value)

  override def toString: String = value.toString
}
