Functions and State
side effects
confluence

operational equivalence: no possible test can distinguish them

REPEAT {
  command
} UNTIL (condition)

def REPEAT(command, condition): Unit = {
  command
  if (condition) ()
  else REPEAT(command, condition)
}

def UNTIL(condition): Boolean = condition

do { comamnd } while condition

For-Loops
for (1 <- 1 until 3) { expression }

=> .foreach(d: T => Unit): Unit

Discrete events Simulations. Digital curcuit simulator.

Digital Circuits
Inverter Neg INV
AND Gate - Conjuntion AND
OR Gate - Disjuntion OR



