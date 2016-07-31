import java.util.Observable

import com.sun.corba.se.impl.orbutil.concurrent.Sync

Observer pattern

Event handeling

publish/suscribe
MVC Model/View/Controller

VIEWS
 CONTROLLER
MODEL

Good. views decouple from the state
Bad. Side effects

Improve on the interative view of event handeling > Functional Reactive progamming.

Deprecating the Observer Pattern - paper. Scala.react. frp.Signal
Signal()
Var()

Implement Signals and Var
`package` frp

define apis

Synconization
Thread-Local

Discrete signal and continius signals (sample no evaluation)
       One        Many
Sync   T/Try[T]   Iterable[T]
Async  Future[T]  Observable[T]

Effects: Latency (time)

Future[T] monad to handles exception and latency
recover recoverWith filter map flatMap fallbackTo

flatMap of future
val a = List(a,b,c)
foldRight folds from the right. a.foldRight(e)(f) = f(a, f(b, f(c, e)))
foldLeft folds from the left.



