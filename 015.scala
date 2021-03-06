/*
Starting in the top left corner of a 2x2 grid, there are 6 routes 
(without backtracking) to the bottom right corner.

How many routes are there through a 20x20 grid?
*/

val size = 20

def factorial(n: Int): Double = if (n == 1) 1 else n * factorial(n - 1)

val routes = factorial(size * 2) / math.pow(factorial(size),2)

println(routes)
