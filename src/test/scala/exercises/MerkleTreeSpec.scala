package exercises

import exercises.MerkleTreeSolution._
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

import scala.collection.immutable.Seq

class MerkleTreeSpec extends AnyFlatSpec with Matchers {
  "Merkle tree" should "be equal when both trees have the same nodes" in {
    val merkleTree1 = merkleRootHash(
      Node(Seq(1, 1)),
      Node(Seq(0, 8)),
      Node(Seq(7, 10)),
      Node(Seq(2, 3)),
      Node(Seq(1))
    )
    val merkleTree2 = merkleRootHash(
      Node(Seq(1, 1)),
      Node(Seq(0, 8)),
      Node(Seq(7, 10)),
      Node(Seq(2, 3)),
      Node(Seq(1))
    )
    merkleTree1 shouldEqual merkleTree2
  }


  it should "be different when some node of any tree its different from the other tree" in {
    val merkleTree1 = merkleRootHash(
      Node(Seq(1, 1)),
      Node(Seq(0, 8)),
      Node(Seq(7, 10)),
      Node(Seq(2, 3)),
      Node(Seq(1))
    )
    val merkleTree2 = merkleRootHash(
      Node(Seq(1, 1)),
      Node(Seq(0, 7)),
      Node(Seq(7, 10)),
      Node(Seq(2, 3)),
      Node(Seq(1))
    )
    merkleTree1 should not be merkleTree2
  }
}
