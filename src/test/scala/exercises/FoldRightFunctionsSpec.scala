package exercises

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

import exercises.FoldRightFunctions._

class FoldRightFunctionsSpec extends AnyFlatSpec with Matchers {
  "sum" should "return 15" in {
    val result = sum(Seq(6,5,3,4,8,4))
    result shouldEqual 30
  }

  "elem" should "return 45, value in the third position" in {
    val result = elem(3, Seq(13,22,31,45,75,96))
    result shouldEqual Some(45)
  }

  it should "return None when the position exceeds the length of the list" in {
    val result = elem(33, Seq(13,22,31,45,75,96))
    result shouldEqual None
  }

  "filter" should "remove elements 3, 4 and 6" in {
    val value = filter(Seq(1,2,3,4,5,6), Seq(3,4,60, 6))
    value shouldEqual Seq(1,2,5)
  }

  "map" should "return each element incremented by one" in {
    val value = map(Seq(1,2,3,4,5,6))(_ + 1)
    value shouldEqual Seq(2,3,4,5,6,7)
  }
}
