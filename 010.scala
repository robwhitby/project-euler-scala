/*
The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.

Find the sum of all the primes below two million.
 */

lazy val primes: Stream[Int] = 2 #:: primes.map(p => {
  Stream.from(p + 1).find(i => primes.takeWhile(math.pow(_,2) <= i).forall(i % _ != 0)).get
})

println(primes.takeWhile(_ < 2000000).foldLeft(0L)(_ + _))
