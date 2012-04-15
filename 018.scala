#!/bin/sh
exec scala "$0" "$@"
!#

/*

By starting at the top of the triangle below and moving to adjacent numbers on
the row below, the maximum total from top to bottom is 23.

3
7 4
2 4 6
8 5 9 3

That is, 3 + 7 + 4 + 9 = 23.

Find the maximum total from top to bottom of the triangle below:

*/


val triangle: Seq[Seq[Int]] = Seq(
  Seq(75),
  Seq(95, 64),
  Seq(17, 47, 82),
  Seq(18, 35, 87, 10),
  Seq(20, 04, 82, 47, 65),
  Seq(19, 01, 23, 75, 03, 34),
  Seq(88, 02, 77, 73, 07, 63, 67),
  Seq(99, 65, 04, 28, 06, 16, 70, 92),
  Seq(41, 41, 26, 56, 83, 40, 80, 70, 33),
  Seq(41, 48, 72, 33, 47, 32, 37, 16, 94, 29),
  Seq(53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14),
  Seq(70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57),
  Seq(91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48),
  Seq(63, 66, 04, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31),
  Seq(04, 62, 98, 27, 23,  9, 70, 98, 73, 93, 38, 53, 60, 04, 23)
).reverse


def process(sums: Seq[Int], rows: Seq[Seq[Int]]): Int = {
  val row = rows.head
  if (row.length == 1) row(0) + sums.max
  else process((0 until row.length).map(i => row(i) + sums.slice(i, i+2).max), rows.tail)
}

val max = process(triangle.head, triangle.tail)

println(max)
