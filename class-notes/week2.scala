IntSet
define laws they need to follow

Streams. Like list but the tail evaliated the next elemet on demand
** Stream are very useful things **

Stream.empty
Stream.cons()

  .toStream
Stream(1,2,3)

((1000 to 10000).toStream filter isPrime)(1)

#:: cons operator to stream. equivalent to :: on list

x #:: xs == Stream.cons(x, xs)

the fundamental difference come from a call by name parameter on the cons method od the stream
   tail: => Stream[T]

'lazy evaluation
scala use strict evaluation by default

xzyz

