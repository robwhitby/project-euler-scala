#!/bin/sh
exec scala "$0" "$@"
!#

/*
The prime factors of 13195 are 5, 7, 13 and 29.

What is the largest prime factor of the number 600851475143 ?
*/

def maxPrimeFactor(x: Long): Long = {
  (2L to math.sqrt(x).toLong).find(x % _ == 0) match {
    case Some(factor) => maxPrimeFactor(x/factor)
    case _ => x
  }
}

println(maxPrimeFactor(600851475143L))
