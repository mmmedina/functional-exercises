package exercises

import java.security.MessageDigest
import scala.annotation.tailrec
import scala.collection.immutable.Seq

/*
Statement

 “In cryptography and computer science, a hash tree or Merkle tree is a
 tree in which every non-leaf node is labelled with the hash of the labels or
 values (in case of leaves) of its child nodes. Hash trees allow efficient and
 secure verification of the contents of large data structures.”

 Given the following code, implement a MerkleRootHash calculation function:

object FirstExercise {
  case class Node(someData: Seq[Byte])
  def hash(data: Seq[Byte]): Seq[Byte] =
    MessageDigest
      .getInstance("MD5")
      .digest(data.toArray[Byte]).toSeq
  def merkleRootHash(node: Node*): Seq[Byte] = ???
  def main(args: Array[String]): Unit = {
    println(merkleRootHash(
      Node(Seq(1, 1)),
      Node(Seq(0, 8)),
      Node(Seq(7, 10)),
      Node(Seq(2, 3)),
      Node(Seq(1)))
    )
    // Add more cases if needed
  }
}
*/

// Solution

object MerkleTree {
  case class Node(someData: Seq[Byte])

  private def hash(data: Seq[Byte]): Seq[Byte] =
    MessageDigest
      .getInstance("MD5")
      .digest(data.toArray[Byte]).toSeq

  def merkleRootHash(node: Node*): Seq[Byte] = {
    @tailrec
    def tailRecRootHash(originalNodes: Seq[Node], auxiliaryNodes: Seq[Byte]): Seq[Byte] = originalNodes match {
      case Nil => auxiliaryNodes
      case Seq(a, tail@_*) => tailRecRootHash(tail, auxiliaryNodes ++ hash(a.someData))
    }

    tailRecRootHash(node, Nil)
  }
}
