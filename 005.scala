#!/bin/sh
exec scala "$0" "$@"
!#

/*
2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.

What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
*/

def gcd(i: Long, j: Long): Long = j match {
  case 0 => i
  case _ => gcd(j, i % j)
}

def lcm(i: Long,  j: Long) = i * j / gcd(i, j)

println(
  (1L to 20L).foldLeft(1L)(lcm)
)
