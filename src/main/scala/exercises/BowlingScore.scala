package exercises

import scala.annotation.tailrec
import scala.collection.immutable.Seq

/*
Bowling is game where players roll a heavy ball to knock down pins arranged in
a triangle. Write code to keep track of the score of a game of bowling.

The game consists of 10 frames.
A frame is composed of one or two ball throws
with 10 pins standing at frame initialization. There are three cases for the
tabulation of a frame.

An open frame is where a score of less than 10 is recorded for the frame. In this
case the score for the frame is the number of pins knocked down.

A spare is where all ten pins are knocked down after the second throw. The total
value of a spare is 10 plus the number of pins knocked down in their next throw.

A strike is where all ten pins are knocked down after the first throw. The total
value of a strike is 10 plus the number of pins knocked down in their next two
throws. If a strike is immediately followed by a second strike, then we can not
total the value of first strike until they throw the ball one more time.

Write code to keep track of the score of a game of bowling. It
should support two operations:

Is called each time the player rolls a ball. The argument is the number of pins knocked down.
def roll(pins : Int) = ???

Is called only at the very end of the game. It returns the total score for that game.
def score() : Int = ???
*/

object BowlingScore {
  type PinsKnocked = Int
  private var pinsKnockedPerRoll: List[PinsKnocked] = List()

  def roll(pins: Int): Unit = pinsKnockedPerRoll = pinsKnockedPerRoll :+ pins

  def score: Int = {
    @tailrec
    def tailrecScore(pinsKnocked: Seq[PinsKnocked], result: Int): Int = pinsKnocked match {
      case Nil => result

      case Seq(a) => result + a

      // tenth frame
      case Seq(a, b, c) => result + a + b + c

      // strike
      case Seq(10, a, b, tail@_*) => tailrecScore(a +: b +: tail, result + 10 + a + b)

      // spare
      case Seq(a, b, c, tail@_*) if a + b == 10 => tailrecScore(c +: tail, result + a + b + c)

      // open frame
      case Seq(a, b, tail@_*) => tailrecScore(tail, result + a + b)
    }

    val result = tailrecScore(pinsKnockedPerRoll, 0)
    pinsKnockedPerRoll = List()
    result
  }
}
