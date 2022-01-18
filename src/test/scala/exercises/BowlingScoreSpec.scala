package exercises

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

import exercises.BowlingScoreSolution._

class BowlingScoreSpec extends AnyFlatSpec with Matchers {

  "score" should "return 0" in {
    Seq(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0).foreach(roll)
    score shouldEqual 0
  }

  it should "return 300" in {
    Seq(10,10,10,10,10,10,10,10,10,10,10,10).foreach(roll)
    score shouldEqual 300
  }

  it should "return 48 with fill ball" in {
    Seq(1,2,3,0,1,5,0,1,3,1,0,9,0,1,5,4,9,0,0,3).foreach(roll)
    score shouldEqual 48
  }

  it should "return 81 without fill ball" in {
    Seq(1,2,9,0,5,3,1,7,8,1,8,1,1,8,4,5,5,4,0,8).foreach(roll)
    score shouldEqual 81
  }

  it should "return 91 with strikes" in {
    Seq(1,2,3,0,1,5,10,3,1,0,9,10,5,4,9,0,10,4,1).foreach(roll)
    score shouldEqual 91
  }

  it should "return 93 with spares" in {
    Seq(1,2,9,1,5,3,1,7,8,1,8,1,1,8,5,5,5,4,0,8).foreach(roll)
    score shouldEqual 93
  }
}
