package chapter53

import org.scalactic.{Bad, ErrorMessage, Good, Or}

import scala.util.{Failure, Success, Try}

object PureFunctions extends App {

  /**
   * In FP, we never throw errors. Always return an option. Otherwise you violate the functional composition.
   *
   * While those are idiomatic examples of how to use Option , it’s important to note that Option has a weakness:
   * it doesn’t tell you anything about why something failed.
   *
   */
  def makeInt(s: String): Option[Int] = {
    try {
      Some(s.trim.toInt)
    } catch {
      case e: Exception => None
    }
  }

  val myInt = makeInt("2") match {
    case Some(value) => println(value)
    case None => println("Exception occurred")
  }


  val myInvalidInt = makeInt("dummy") match {
    case Some(value) => println(value)
    case None => println("Exception occurred")
  }

  val myIntWithGetOrElse = makeInt("2").getOrElse(0)
  println(myIntWithGetOrElse)

  val resultWithForExpression = for {
    a <- makeInt("2")
    b <- makeInt("2")
  } yield a + b

  println(resultWithForExpression)

  val resultWithForExpressionWhenError = for {
    a <- makeInt("2")
    b <- makeInt("dummy")
  } yield a + b
  println(resultWithForExpressionWhenError)


  def makeIntWithTry(s: String): Try[Int] = {
    Try(s.toInt)
  }

  val myValidInputWithTry = makeIntWithTry("2") match {
    case Success(value) => println(value)
    case Failure(exception) => println(s"Exception occurred : ${exception}")
  }

  val myInValidInputWithTry = makeIntWithTry("dummy") match {
    case Success(value) => println(value)
    case Failure(exception) => println(s"Exception occurred : ${exception}")
  }

  val resultWithTry = for {
    a<- makeIntWithTry("2")
    b<- makeIntWithTry("dummy")
  } yield a+b

  println(resultWithTry)

  val myInValidInputOrElseWithTry = makeIntWithTry("dummy").getOrElse("2")
  println(myInValidInputOrElseWithTry)

  def makeIntWithScalatic(s:String): Int Or ErrorMessage = {
    try{
      Good(s.toInt)
    }catch {
      case e: Exception => Bad(e.toString)
    }
  }

  val myValidInputWithScalatic = makeIntWithScalatic("2") match {
    case Good(value) => println(value)
    case Bad(exception) => println(s"Exception occurred : ${exception}")
  }

  val myInValidInputWithScalactic = makeIntWithScalatic("dummy") match {
    case Good(value) => println(value)
    case Bad(exception) => println(s"Exception occurred : ${exception}")
  }

  val resultWithScalactic = for {
    a<- makeIntWithScalatic("2")
    b<- makeIntWithScalatic("dummy")
  } yield a+b

  println(resultWithScalactic)
}
