package exercises

import scala.collection.immutable.Seq

// Implement, using foldRight, the following Seq[Int] operations:

object FoldRightFunctions {
  def sum(n: Seq[Int]): Int = n.foldRight(0)(_+_)
  def elem(i: Int, n: Seq[Int]): Option[Int] = n.foldRight(None:Option[Int])((b,a) => if(n.indexOf(b) == i) Some(b) else a)
  def filter(n: Seq[Int], i: Seq[Int]): Seq[Int] = n.foldRight(Seq[Int]()) ((b, a) => if(i.contains(b)) a else b +: a)
  def map[A](n: Seq[Int])(fn: Int => A): Seq[A] = n.foldRight(Seq[A]())((b, a) => fn(b) +: a)
}
