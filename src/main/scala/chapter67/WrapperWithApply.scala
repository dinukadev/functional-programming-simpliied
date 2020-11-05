package chapter67

class WrapperWithApply[A] private(value: A) {

  /**
   * But in Scala’s “functional objects” approach, you can access value implicitly.
   * Technically this violates my rule that for pure functions, “Output depends only on input,”
   * but when you use the functional objects coding style, this is the one case where you are allowed to implicitly
   * access other fields in a function in your class.
   *
   * If you’ve heard the term “closure” before, yes, this is essentially a closure.
   *
   */
  def map[B](f: A => B): WrapperWithApply[B] = {
    val newInt = f(value)
    new WrapperWithApply(newInt)
  }

  def flatMap[B](f: A => WrapperWithApply[B]): WrapperWithApply[B] = f(value)

  override def toString: String = value.toString
}

/**
 * This is called a companion object for the WrapperWithApply class
 */
object WrapperWithApply {

  /**
   * The constructor is private to all other code, but because apply is created in
   * WrapperWithApply ’s companion object, apply can still see that constructor.
   */
  def apply[A](value: A): WrapperWithApply[A] = new WrapperWithApply[A](value)

}
