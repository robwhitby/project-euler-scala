#!/bin/sh
exec scala "$0" "$@"
!#

/*
Starting in the top left corner of a 2x2 grid, there are 6 routes (without backtracking) to the bottom right corner.

How many routes are there through a 20x20 grid?

1
1 2
1 3 6
1 4 10 20
1 5 15 35 70
*/

val size = 20

def factorial(n: Int): Double = if (n == 1) 1 else n * factorial(n - 1)

val routes = factorial(size * 2) / math.pow(factorial(size),2)

println(routes)
