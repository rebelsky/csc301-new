---
title: "EBoard 32: Dynamic Programming" 
number: 32
section: eboards
held: 2021-11-15
link: true
---
# {{ page.title }}

_Approximate overview_

* Admin
* Computing Fibonacci numbers
* Minimizing stamps
* Dynamic programming: Generalizing these techniques

Administrative stuff
--------------------

* Since the response to my complaint about our new email policy was
  "If you don't want to install Outlook on your iPhone, than you
  don't need to read email when you're not on your computer", I will
  be much less likely to answer email outside of the workday.
* We'll get another opportunity to prove an algorithm incorrect
  today.  (I suppose if it's incorrect, it's not an algorithm,
  but you know what I mean.)
* I've made some revisions to the schedule. At least I think I have.

### Upcoming token-generating activities

* SEPC Event Tuesday at 4pm.
* CS Extra Thursday at 4pm.
* CS Workshop on finding internships Thursday at 7-8pm.
* November 18-21, _Do You Feel Anger?_

Other good things

* Harp concert JRC some point tomorrow

### Upcoming work

* No new readings.
* [HW10](../assignments/assignment10) due Thursday.

### Q&A

For HW10, do we actually have to write code?

> No, pseudocode algorithms are fine.  Just indicating how you should
  draw the graph is probably fine.  (Or you can make LaTeX draw the
  graph.)

Computing Fibonacci Numbers
---------------------------

The definition (adapted from Lionardo, filius Bonacci)

```
fib(0) = 0.
fib(1) = 1.
fib(n) = fib(n-1) + fib(n-2) for all n > 1.
```

### The obvious implementation

In Scheme/Racket

```
(define fib
  (lambda (n)
    (if (<= n 1)
        n
        (+ (fib (- n 1))
           (fib (- n 2))))))
```

In Java

```
  public static BigInteger fib(int n) {
    if (n <= 1) {
      return BigInteger.valueOf(n);
    } else {
      return fib(n-1).add(fib(n-2));
    } 
  } // fib(n)
```

### Is this a good approach?

No.  See the next question.

### What's the running time?

Observation: T(n) and T(n-1) are similar, but we know that T(n) > T(n-1)
for sufficiently large n.

#### Upper bound

T(n) <= T(n-1) + T(n-1) = 2T(n-1) 

T(n) <= 2T(n-1) <= 2(2T(n-2)) = 4T(n-2) <= 4(2T(n-3)) = 8T(n-3)

T(n) <= 2^k\*T(n-k)

Let n = k.

T(n) <= T(0)\*2^n

T(n) is in O(2^n)

#### Lower bound

T(n) >= T(n-2) + T(n-2) = 2T(n-2)

T(n) >= 2T(n-2) >= 4T(n-4) >= 8T(n-6) >= 16T(n-8)

T(n) >= (2^k)T(n-2k)

Let k = n/2

T(n) >= 2^(n/2)T(0) = 2^(n/2)

T(n) is in Omega(2^(n/2)) = Omega(sqrt(2^n))

Improving the Fibonacci Computation
-----------------------------------

_Survey time!_

Have you seen how to improve this before?  (We're going to go over
it in any case; I just want a sense.)

### Improvement 1: Caching

We will a build a table, Fib, s.t. Fib[i] gives the ith Fibonacci number.

We'll fill in the table as we compute the values.

```
  ArrayList<BigInteger> Fib = new ArrayList<BigInteger>(10);
  public static BigInteger fib(int n) {
    if (n <= 1) {
      return BigInteger.valueOf(n);
    } else {
      // Make sure that Fib is now big enough to hold element n.
      Fib.ensureCapacity(n+1);
      // If the value is not already cached
      if (Fib.get(n) == null) {
        // Compute and cache it
        Fib.set(n, fib(n-1).add(fib(n-2)));
      }
      return Fib.get(n);
    } 
  } // fib(n)
```

### Improvement 2: Build the cache iteratively

Recursive

```
fib(5)  
  [0:null,1:null,2:null,3:null,4:null,5:null]
fib(5) = fib(4) + fib(3)
  [0:null,1:null,2:null,3:null,4:null,5:null]
fib(5) = (fib(4) = fib(3) + fib(2)) + fib(3)
  [0:null,1:null,2:null,3:null,4:null,5:null]
fib(2) + fib(1) + fib(2) + fib(3)
  [0:null,1:null,2:null,3:null,4:null,5:null]
fib(1) + fib(0) + fib(1) + fib(2) + fib(3)
  [0:null,1:null,2:null,3:null,4:null,5:null]
1 + fib(1) + fib(2) + fib(3)
  [0:null,1:null,2:1,3:null,4:null,5:null]
1 + 1 + fib(2) + fib(3)

UGH!  (Ugh to drawing; ugh to method.)
```

Suggestion: Populate cache(0) with 0 and cache(1) with 1.

So why not populate from left to right?

```
  public BigInteger fib(int n) {
    cache.set(0, BigInteger.ZERO);
    cache.set(1, BigInteger.ONE);
    for (int i = 2; i <= n; i++) {
      cache.set(i, cache.get(i-1).add(cache.get(i-2)));
    }
    return cache.get(n);
  }
```

O(n)

A cache let us go from an exponential algorithm to a linear algorithm!

### Improvement 3: You only need the previous two Fibonacci values

(Saves memory.)

Minimizing Stamps
-----------------

The problem: Given a set of positive integral stamp prices (one of
which is 1) and a total cost, find the fewest number of stamps that
meet the cost.

The problem, restated: Given a set of _n_ positive integral stamp
prices (_s1_, _s2_, ... _sn_), one of which is 1, and a
total cost (_c_), find integers _m1_, _m2_, ... _mn_ s.t.

* The right cost: _s1_\*_m1_ + _s2_\*_m2_ + ... _sn_\*_mn_ = _c_.
* Minimum: For every other sequence of _n_ integers, _a1_, _a2_ ... _an_ s.t. 
* _a1_\*_m1_ + _a2_\*_m2_ + ... _an_\*_mn_ = _c_,
  _s1_ + _s2_ + ... + _sn_ <= _a1_ + _a2_ + ... _an_.

Without loss of generality, we can assume that the stamp values are
stored in decreasing order.  _s1_ is the most expensive stamp.  _sn_
is 1.

We sometimes simplify the algorithm to just give the number of
stamps, and not their value.  That's the version we'll work on
today.

For example, if our stamp prices are 25, 10, 5, and 1.

To send a letter that costs 53 cents we need ....

* five: 2x25, 0x10, 0x5, 3x1

### The greedy algorithm

* Take as many stamps of value _s1_ as possible.
* Then take as many stamps of value _s2_ as possible.
* ...
* Finally, take as many 1 cent stamps as necessary.

This algorithm works with stamps priced like US Coins.

_Find a set of stamp prices and a cost for which the greedy algorithm
does not work._ (TPS)

c = 50

s = [40, 25, 1]

### Another algorithm

_Write a (multiply-recursive) solution_ (TPS)

```
minstamps(c, s)
  minstamps(c - s[1])
  minstamps(c - s[2])
  minstamps(c - s[3])
  minstamps(c - s[4])
  ...
  minstamps(c - s[n-1])
  c // all one cent stamps
```

or

```
minstamps(c, s)
  guess = c // all 1 cent stamps
  for (int i = 1; i < n-1; i++) {
    compute minstamps(c - s[i])
    and then?
  }
  return ???
```

Full details not necessary.

Do an exhaustive algorithm, rather than a greedy one.

```
minstamps(c, s)
  guess = c // all 1 cent stamps
  for (int i = 1; i < n-1; i++) {
    tmp = minstamps(c - s[i])
    if (tmp + 1) < guess
      guess = tmp + 1
  }
  return ???
```

Really expensive.

But gets the job done.

Improving the exhaustive algorithm
----------------------------------

Can we use the techniques we used for Fibonacci (at least the first
two techniques)?

### Improvement one: Caching

### Improvement two: Iterative computation

```
cache.set(s[1], 1)
cache.set(s[2], 1)
...
cache.set(s[n], 1)
```

Suppose our stamp prices are 18, 7, 5, 1

table

```
  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19 20 21
  1  2  3  4  1  2  1  2  3  2                       1

8 cents: 1 cent plus 7 cents : 2
8 cents: 5 cent plus 3 cents : 4
8 cents: 7 cent plus 1 cents : 2

9 cents: 1 cent plus 8 : 3 stamps
9 cents: 5 cent plus 4 : 5 stamps
9 cents: 7 cent plus 2 : 3 stamps

10 cents: 1 cents plus 9 : 4
10 cents: 5 cents plus 5 : 2
10 cents: 7 cents plus 3 : 4

This takes us O(nc) steps
```

Generalizing the technique
--------------------------

The combination of what I call "caching" and the iterative
construction of the cache is often called "dynamic programming".

It turns exponential exhaustive minimization/maximization algorithms
to (usually linear, always polynimal) algorithms at the cost of
some space for the cache.

Why "dynamic programming"?  Marketing!
