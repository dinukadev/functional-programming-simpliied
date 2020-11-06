package chapter79
import cats.effect.IO
object CatsForExpressionProgram extends App {

  val program: IO[Unit] = for {
    _ <-IO { println("Welcome to Scala! What's your name?") }
    name <-IO { scala.io.StdIn.readLine }
    nameUC = name.toUpperCase
    _ <-IO { println(s"Well hello, $nameUC!") }
  } yield ()

  program.unsafeRunSync()


}
