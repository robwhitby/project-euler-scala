/*
The Fibonacci sequence is defined by the recurrence relation:

Fn = Fn-1 + Fn-2, where F1 = 1 and F2 = 1.
Hence the first 12 terms will be:

F1 = 1
F2 = 1
F3 = 2
F4 = 3
F5 = 5
F6 = 8
F7 = 13
F8 = 21
F9 = 34
F10 = 55
F11 = 89
F12 = 144
The 12th term, F12, is the first term to contain three digits.

What is the first term in the Fibonacci sequence to contain 1000 digits?
*/

def fib = new Iterator[(Int, BigInt)] {
  private var i = BigInt(0)
  private var j = BigInt(1)
  private var idx = 1
  def next: (Int, BigInt) = {
    val k = i + j
    i = j
    j = k
    idx += 1
    return (idx, k)
  }
  def hasNext = true
}

val n = fib.find(n => n._2.toString.length == 1000).get._1

println(n)
