package chapter79
import cats.effect.IO



object CatsIOMonadHelloWorld extends App {

  val hello: IO[Unit] = IO { println("Hello, world") }
  hello.unsafeRunSync()

}
