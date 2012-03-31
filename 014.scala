#!/bin/sh
exec scala "$0" "$@"
!#

/*
The following iterative sequence is defined for the set of positive integers:

n -> n/2 (n is even)
n -> 3n + 1 (n is odd)

Using the rule above and starting with 13, we generate the following sequence:

13  40  20  10  5  16  8  4  2  1
It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it 
has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.

Which starting number, under one million, produces the longest chain?

NOTE: Once the chain starts the terms are allowed to go above one million.
*/

def chain(n: Long, count: Int = 0): Int = {
  if (n == 1) count + 1
  else chain(if (n % 2 == 0) n/2 else 3*n + 1, count + 1)
}

val longest = (2 until 1000000).foldLeft((1,1))((a, b) => {
  val c = chain(b)
  if (c > a._2) (b, c) else a
})._1

println(longest)
