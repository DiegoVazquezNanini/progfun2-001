import sun.invoke.empty.Empty

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


Water Pouring problem

4 liter
9 liter

N liter glasses
target capacity

Operation
Empty(glass)
Fill(glass)
Pour(from, to)

Randown walk solution
genPaths of lenght 1, 2, 3

class Pouring(capacity: Vector[Int]) {

   type State = Vector[Int]
   val initialState = capacity map (x => 0)

   trait Move {
      def change(state: State): State
   }

   case class Empty(glass: Int) extends Move {
      def change(state: State) = state updated(glass, 0)
   }

   case class Fill(glass: Int) extends Move {
      def change(state: State) = state updated(glass, capacity(glass))
   }

   case class Pour(from: Int, to: Int) extends Move {
      def change(state: State) = {
         val amount = state(from) min (capacity(to) - state(to))
         state updated(from, state(from) - amount) updated(to, state(to) + amount)
      }
   }

}

   val glasses = 0 until capacity.lenght
   val moves =
      (for (g <- glasses) yield Empty(g)) ++
      (for (g <- glasses) yield Fill(g)) ++
      (for (from <- glasses; to <- glasses if from != to) yield Pour(from, to))

class Path(history: List[Move], val endState: State) {
   def extends(move: Move) = new Path(move :: history, move change endState)
   override def toString = (history.reverse mkString " ") + " --> " + endState

}

val inialPath = new Path(Nil, inialState)

def from(paths: Set[Path], explored: Set(State)): Stream[Set[Path]] =
  if (paths.isEmpty) Stream.empty
  else {
     val more = for {
        path <- paths
        next <- moves map path.extend
        if !(explored contains next.endState)
     } yield next
     paths #:: from(more, explored ++ (more map (_.endState)))
  }

val pathSets = from(Set(initialPath), Set(inialState))

def solution(target: Int): Stream[Path] =
 for {
   pathSet <- pathSets
   path <- pathSet
   if path.endState contains target
 } yield path


TIPS:
  - Name everything you can
  - Put operations into natural scopes
  - Keep degrees of freedom for future refinements
