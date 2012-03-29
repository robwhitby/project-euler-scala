#!/bin/sh
exec scala "$0" "$@"
!#

/*
By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, 
we can see that the 6th prime is 13.

What is the 10 001st prime number?
*/

lazy val primes: Stream[Int] = 2 #:: primes.map(p => {
  Stream.from(p + 1).find(i => primes.takeWhile(math.pow(_,2) <= i).forall(i % _ != 0)).get
})

println(primes.take(10001).last)
