/*
A Pythagorean triplet is a set of three natural numbers, a  b  c, for which,

a^2 + b^2 = c^2
For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.

There exists exactly one Pythagorean triplet for which a + b + c = 1000.
Find the product abc.
 */

val triplet = for (a <- 1 to 500; b <- 1 to a; c = math.sqrt((a*a) + (b*b)) if (a + b + c == 1000)) yield a*b*c

println(triplet.head.toInt)