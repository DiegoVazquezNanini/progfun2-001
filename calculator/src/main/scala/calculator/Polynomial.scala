package calculator

object Polynomial {
  def computeDelta(a: Signal[Double], b: Signal[Double],
      c: Signal[Double]): Signal[Double] = {
    val delta = Math.pow(b(), 2) - 4 * a() * c()
    Signal(delta)
  }

  def computeSolutions(a: Signal[Double], b: Signal[Double],
      c: Signal[Double], delta: Signal[Double]): Signal[Set[Double]] = {
    if (delta() < 0.0) Signal(Set.empty)
    else if (delta() == 0.0) {
      val root0 = - b() / (2 * a())
      Signal(Set(root0))
    }
    else {
      val root1 = (- b() + Math.pow(delta(), 0.5)) / (2 * a())
      val root2 = (- b() - Math.pow(delta(), 0.5)) / (2 * a())
      Signal(Set(root1, root2))
    }
  }
}
