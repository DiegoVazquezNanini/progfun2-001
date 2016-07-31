package calculator

import org.junit.runner.RunWith
import org.scalatest._
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class PolynomialSuite extends FunSuite with ShouldMatchers {

  test("quadratic example 1") {
    val a: Signal[Double] = Signal(1.0)
    val b: Signal[Double] = Signal(1.0)
    val c: Signal[Double] = Signal(-6.0)
    val delta = Polynomial.computeDelta(a, b, c)
    val results = Polynomial.computeSolutions(a, b, c, delta)
    assert(results() == Set(2, -3))
  }

  test("quadratic example 2") {
    val a: Signal[Double] = Signal(1.0)
    val b: Signal[Double] = Signal(4.0)
    val c: Signal[Double] = Signal(4.0)
    val delta = Polynomial.computeDelta(a, b, c)
    val results = Polynomial.computeSolutions(a, b, c, delta)
    assert(delta() == 0.0)
    assert(results() == Set(-2))
  }

  test("quadratic example 3") {
    val a: Signal[Double] = Signal(1.0)
    val b: Signal[Double] = Signal(1.0)
    val c: Signal[Double] = Signal(4.0)
    val delta = Polynomial.computeDelta(a, b, c)
    val results = Polynomial.computeSolutions(a, b, c, delta)
    assert(delta() == -15)
    assert(results() == Set.empty)
  }

  test("quadratic example 4") {
    val a: Signal[Double] = Signal(1.0)
    val b: Signal[Double] = Signal(3.2)
    val c: Signal[Double] = Signal(2.0)
    val delta = Polynomial.computeDelta(a, b, c)
    val results = Polynomial.computeSolutions(a, b, c, delta)
    assert(delta() == 2.240000000000002)
    assert(results() == Set(-0.8516685226452115, -2.3483314773547885))
  }

}
