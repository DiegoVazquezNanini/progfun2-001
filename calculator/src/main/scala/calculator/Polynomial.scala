package calculator

object Polynomial {
  def computeDelta(a: Signal[Double], b: Signal[Double],
      c: Signal[Double]): Signal[Double] = {
    val an = a()
    val bn = b()
    val cn = c()
    val delta = Math.pow(bn, 2) - 4 * an * cn
    Signal(delta)
  }

  def computeSolutions(a: Signal[Double], b: Signal[Double],
      c: Signal[Double], delta: Signal[Double]): Signal[Set[Double]] = {
    val an = a()
    val bn = b()
    val cn = c()
    val deltan = delta()

    val root1 = - bn + Math.pow(deltan, 0.5) / 2 * an
    val root2 = - bn - Math.pow(deltan, 0.5) / 2 * an
    Signal(Set(root1, root2))
  }
}
