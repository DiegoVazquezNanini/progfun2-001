package quickcheck

import common._

import org.scalacheck._
import Arbitrary._
import Gen._
import Prop._

abstract class QuickCheckHeap extends Properties("Heap") with IntHeap {

  lazy val genHeap: Gen[H] = for {
    elem <- arbitrary[A]
    m <- oneOf(const(empty), genHeap)
  } yield insert(elem, m)

  implicit lazy val arbHeap: Arbitrary[H] = Arbitrary(genHeap)

  property("min1") = forAll { a: Int =>
    val h = insert(a, empty)
    findMin(h) == a
  }

  property("gen1") = forAll { (h: H) =>
    val m = if (isEmpty(h)) 0 else findMin(h)
    findMin(insert(m, h)) == m
  }

  property("suggestion1") = forAll { (x: Int, y: Int) =>
    val m = insert(y, insert(x, empty))
    findMin(m) == (if (x < y) y else x)
  }

  property("suggestion2") = forAll { a: Int =>
    val m = insert(a, empty)
    deleteMin(m) == empty
  }

  property("suggestion3") = forAll { (h: H) =>
    def sorted(h: H, min: A): H = {
      h
    }

    //findMin(h) < findMin(deleteMin(h)) < findMin(deleteMin(deleteMin(h)))
  }

  property("suggestion4") = forAll { (h: H, j: H) =>
    val minMerge = findMin(meld(h, j))
    findMin(h) == minMerge || findMin(j) == minMerge
  }


}
