package exercises

import exercises.CountDistinctCharacters._
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class CountDistinctCharactersSpec extends AnyFlatSpec with Matchers {
  "edsfgasfwe" should "return 4" in {
    val result: Int = noDistinctCharacters("edsfgasfwe")
    result shouldEqual 4
  }

  "edsFgasfwe" should "return 6" in {
    val result = noDistinctCharacters("edsFgasfwe")
    result shouldEqual 6
  }

  "edsfgasfwedgwa" should "return 0" in {
    val result: Int = noDistinctCharacters("edsfgasfwedgwa")
    result shouldEqual 0
  }

  "empty string" should "return 0" in {
    val result: Int = noDistinctCharacters("")
    result shouldEqual 0
  }
}
