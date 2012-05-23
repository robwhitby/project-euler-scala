/*
If the numbers 1 to 5 are written out in words: one, two, three, four, five,
then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.

If all the numbers from 1 to 1000 (one thousand) inclusive were written 
out in words, how many letters would be used?
*/

val len = Map(
  0 -> 0,
  1 -> 3,
  2 -> 3,
  3 -> 5,
  4 -> 4,
  5 -> 4,
  6 -> 3,
  7 -> 5,
  8 -> 5,
  9 -> 4,
  10 -> 3,
  11 -> 6,
  12 -> 6,
  13 -> 8,
  14 -> 8,
  15 -> 7,
  16 -> 7,
  17 -> 9,
  18 -> 8,
  19 -> 8,
  20 -> 6,
  30 -> 6,
  40 -> 5,
  50 -> 5,
  60 -> 5,
  70 -> 7,
  80 -> 6,
  90 -> 6
)

val and = 3
val hundred = 7

def numLen(i: Int): Int = i match {
  case n if ((n < 100 && n % 10 == 0) || n < 20) => len(n)
  case n if (n < 100) => len(n - (n % 10)) + len(n % 10)
  case n if (n < 1000) => len((n/100).toInt) + hundred + (if (n % 100 > 0) and else 0) + numLen(n % 100)
  case 1000 => "onethousand".length
  case _ => -1
}

val total = (1 to 1000).foldLeft(0)(_ + numLen(_))

println(total)
