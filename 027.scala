/*
Euler published the remarkable quadratic formula:

n² + n + 41

It turns out that the formula will produce 40 primes for the consecutive 
values n = 0 to 39. However, when n = 40, 40² + 40 + 41 = 40(40 + 1) + 41 
is divisible by 41, and certainly when n = 41, 41² + 41 + 41 is clearly 
divisible by 41.

Using computers, the incredible formula  n² - 79n + 1601 was discovered, 
which produces 80 primes for the consecutive values n = 0 to 79. The product 
of the coefficients, -79 and 1601, is -126479.

Considering quadratics of the form:

n² + an + b, where |a| < 1000 and |b| < 1000

where |n| is the modulus/absolute value of n 
e.g. |11| = 11 and |-4| = 4

Find the product of the coefficients, a and b, for the quadratic expression 
that produces the maximum number of primes for consecutive values of n, 
starting with n = 0.
*/

lazy val primes: Stream[Int] = 2 #:: primes.map(p => {
  Stream.from(p + 1).find(i => primes.takeWhile(math.pow(_,2) <= i).forall(i % _ != 0)).get
})

val primesUnder1000 = primes.takeWhile(_ < 1000).toList

def quadIsPrime(n: Int, a: Int, b: Int) = 
  primesUnder1000.contains(n*n + a*n + b)

def primeSeq(a: Int, b:Int) = 
  Stream.from(1).takeWhile(n => quadIsPrime(n, a, b)).lastOption.getOrElse(0)

val max = 
  (for (a <- primesUnder1000 ++ primesUnder1000.map(_ * -1); b <- (-999 to 999)) 
    yield (a, b, primeSeq(a,b))
  ).maxBy(_._3)

println(max._1 * max._2)  
