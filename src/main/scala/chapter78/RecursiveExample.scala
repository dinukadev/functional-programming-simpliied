package chapter78

object RecursiveExample extends App {

  def loop: IO[Unit] = for {
    _     <- putStrLn("Type something: ")
    input <- getLine
    _     <- putStrLn(s"You said '$input'.")
    _     <- if (input == "quit") IO() else loop  //RECURSE
  } yield ()

  loop.run
}
