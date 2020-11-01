package chapter29

object PartiallyAppliedFunctions extends App {

  //partially applied functions example
  def plus(a: Int)(b: Int) = a + b

  def plus2 = plus(2)(_)

  //  def plus2 = plus(2)_ is also the same as above

  println(plus2(2))


  def wrap(prefix: String)(html: String)(suffix: String) = prefix + html + suffix

  def wrapWithDiv = wrap("<div>")(_: String)("</div>")

  println(wrapWithDiv("text"))


  //curried example

  def add(a: Int, b: Int) = a + b

  def addFunction = add _

  println((add _).isInstanceOf[Function2[_, _, _]])

  val addCurried = addFunction.curried

  println(addCurried(1)(1))

  //creating a PAF from a curried function
  def addCurriedTwo = addCurried(1)

  print(addCurriedTwo(1))


}
