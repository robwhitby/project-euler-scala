#!/bin/sh
exec scala "$0" "$@"
!#

/*
Find the sum of the digits in the number 100!
*/

implicit def factorial(n: Int) = new { def ! = (1 to n).foldLeft(BigInt(1))(_ * _) }

val sum = (100!).toString.map(_.asDigit).sum

println(sum)
