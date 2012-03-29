#!/bin/sh
exec scala "$0" "$@"
!#

/*
A palindromic number reads the same both ways. The largest palindrome made from the
product of two 2-digit numbers is 9009 = 91 99.

Find the largest palindrome made from the product of two 3-digit numbers.
*/

println(
  (100 to 999).flatMap(i => (i to 999).map(_ * i).filter(j => j.toString == j.toString.reverse)).max
)
