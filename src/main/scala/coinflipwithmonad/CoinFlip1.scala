package coinflipwithmonad

import cats.effect.IO
import coinflipwithmonad.CoinFlipUtils._

import scala.util.Random

case class GameState(numFlips: Int, numCorrect: Int)

object CoinFlip1 extends App {
  val r = Random
  val s = GameState(0, 0)
  //mainLoop(s, r)

  def mainLoop(gameState: GameState, random: Random): IO[Unit] = for {
    _ <- IO {
      showPrompt()
    }
    userInput <- IO {
      getUserInput()
    }
    _ <- if (userInput == "H" || userInput == "T") for {
      // this first line is a hack; a for-expr must begin with a generator
      _ <- IO {
        println("you said H or T")
      }
      coinTossResult = tossCoin(random)
      newNumFlips = gameState.numFlips + 1
      newGameState = createNewGameState(userInput, coinTossResult, gameState, newNumFlips)
      _ <- IO {
        printGameState(printableFlipResult(coinTossResult), newGameState)
      }
      _ <- mainLoop(newGameState, random)
    } yield ()
    else for {
      _ <- IO {
        println("did not enter H or T")
      }
      _ <- IO {
        printGameOver()
      }
      _ <- IO {
        printGameState(gameState)
      }
    } yield ()
  } yield ()

  mainLoop(s, r).unsafeRunSync()

  private def createNewGameState(userInput: String,
                                 coinTossResult: String,
                                 gameState: GameState,
                                 newNumFlips: Int
                                ): GameState = {
    if (userInput == coinTossResult) {
      val newNumCorrect = gameState.numCorrect + 1
      val newGameState = gameState.copy(numFlips = newNumFlips, numCorrect = newNumCorrect)
      newGameState
    } else {
      val newGameState = gameState.copy(numFlips = newNumFlips)
      newGameState
    }
  }

}
