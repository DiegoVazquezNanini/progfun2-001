package quickcheck

import common._
import org.scalacheck._
import Arbitrary._
import Gen._
import Prop._

import scala.annotation.tailrec

abstract class QuickCheckHeap extends Properties("Heap") with IntHeap {

  lazy val genHeap: Gen[H] = for {
    elem <- arbitrary[A]
    m <- oneOf(const(empty), genHeap)
  } yield insert(elem, m)

  implicit lazy val arbHeap: Arbitrary[H] = Arbitrary(genHeap)

  @tailrec
  private def isSorted(h: H): Boolean = {
    if (isEmpty(h)) true
    else if (isEmpty(deleteMin(h))) true
    else { if (findMin(h) > findMin(deleteMin(h))) false else isSorted(deleteMin(deleteMin(h))) }
  }

  property("min1") = forAll { a: Int =>
    val h = insert(a, empty)
    findMin(h) == a
  }

  property("gen1") = forAll { (h: H) =>
    val m = if (isEmpty(h)) 0 else findMin(h)
    findMin(insert(m, h)) == m
  }

  property("hint1") = forAll { (x: Int, y: Int) =>
    val m = insert(y, insert(x, empty))
    findMin(m) == ord.min(x, y)
  }

  property("hint2") = forAll { a: Int =>
    val m = insert(a, empty)
    deleteMin(m) == empty
  }

  property("hint3") = forAll { (h: H) =>
    isSorted(h)
  }

  property("hint4") = forAll { (h: H, j: H) =>
    val minMerge = findMin(meld(h, j))
    findMin(h) == minMerge || findMin(j) == minMerge
  }

}
