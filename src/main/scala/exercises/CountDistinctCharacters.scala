package exercises

import scala.annotation.tailrec

object CountDistinctCharacters extends App {
  // given a string, the method return the amount of distinct characters

  def noDistinctCharacters(value: String): Int = {
    @tailrec
    def numberOfDistinctCharacters(characters: Seq[Char], result: Int = 0): Int = {
      characters match {
        case Nil => result
        case Seq(f, tail@_*) if tail.contains(f) =>
          numberOfDistinctCharacters(tail.filter(_ != f), result)

        case Seq(_, tail@_*) =>
          numberOfDistinctCharacters(tail, result + 1)

        case _ => numberOfDistinctCharacters(Nil, result)
      }
    }

    numberOfDistinctCharacters(value.toSeq)
  }
}
