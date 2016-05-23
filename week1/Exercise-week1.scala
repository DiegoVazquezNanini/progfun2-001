progfun2

map
flatMap
filter

for {
  x <- 2 to N
  y <- 2 to x if (x % y == 0)
} yield (x, y)

(2 to N) flatMap (x => 2 to x) withFilter(y => (x % y) == 0) map (y => (x, y))

for {
  b <- books
  a <- b.authors if a startsWith "Bird"
} yield b.title

 books flatMap (b =>
   b.authors withFilter(a =>
     a startsWith "Bird")
   ) map (y => y.title) )


ScalaQuery
Slick

ScalaCheck - Random input values
Read Scalacheck tutorial

this - current scope
self - `object level scope

Monad

flatMap
unit > Some(), List(), Set(), single()

Associativity
Monoid. Example: Int

Left unit

Right unit

Mondas with zero

