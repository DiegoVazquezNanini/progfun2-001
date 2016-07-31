package calculator

import org.junit.runner.RunWith
import org.scalatest._
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class PolynomialSuite extends FunSuite with ShouldMatchers {

  test("test1") {
    val delta = Polynomial.computeDelta(Signal(1), Signal(1), Signal(-6))
    val results = Polynomial.computeSolutions(Signal(1), Signal(1), Signal(-6), delta)
    assert(results() == Set(2, -3))
  }

  test("test2") {
    val delta = Polynomial.computeDelta(Signal(1), Signal(4), Signal(4))
    val results = Polynomial.computeSolutions(Signal(1), Signal(4), Signal(4), delta)
    assert(delta() == 0)
    assert(results() == Set(-2))
  }

  test("test3") {
    val delta = Polynomial.computeDelta(Signal(1), Signal(1), Signal(4))
    val results = Polynomial.computeSolutions(Signal(1), Signal(1), Signal(4), delta)
    assert(delta() == -15)
    assert(results() == Set.empty)
  }

}
