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
* Computing fibonacci numbers
* Minimizing stamps
* Dynamic programming: Generalizing these techniques

Administrative stuff
--------------------

* Since the response to my complaint about our new email policy was
  "If you don't want to install Outlook on your iPhone, than you
  don't need to read email when you're not on your computer", I will
  be much less likely to answer email outside of the workday.
* We'll get another opportunity to prove an algorithm incorrect
  today.  (I suppose if it's incorrect, it's not an algorithm.,
  but you know what I mean.)
* I've made some revisions to the schedule. At least I think I have.

### Upcoming token-generating activities

* SEPC Event Tuesday at 4pm.
* CS Extra Thursday at 4pm.
* November 18-21, _Do You Feel Anger?_ 

Other good things

### Upcoming work

* No new readings.
* [HW10](../assignments/assignment10) due Thursday.

### Q&A

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

### What's the running time?

Improving the Fibonacci Computation
-----------------------------------

_Survey time!_

Have you seen how to improve this before?  (We're going to go over
it in any case; I just want a sense.)

### Improvement 1:

### Improvement 2:

### Improvement 3:

Minimizing Stamps
-----------------

The problem: Given a set of positive integral stamp prices (one of
which is 1) and a total cost, find the fewest number of stamps that
meet the cost.

The problem, restated: Given a set of _n_ positive integral stamp
prices (_s1_, _s2_, ... _sn_), one of which is 1, and a
total cost (_c_), find integers _m1_, _m2_, ... _mn_ s.t.

* _s1_\*_m1_ + _s2_\*_m2_ + ... _sn_\*_mn_ = _c_.
* For every other sequence of _n_ integers, _a1_, _a2_ ... _an_ s.t. 
* _a1_\*_m1_ + _a2_\*_m2_ + ... _an_\*_mn_ = _c_,
  _s1_ + _s2_ + ... + _sn_ <= _a1_ + _a2_ + ... _an_.

Without loss of generality, we can assume that the stamp values are
stored in decreasing order.  _s1_ is the most expensive stamp.  _sn_
is 1.

We sometimes simplify the algorithm to just give the number of
stamps, and not their value.  That's the version we'll work on
today.

### The greedy algorithm

* Take as many stamps of value _s1_ as possible.
* Then take as many stamps of value _s2_ as possible.
* ...
* Finally, take as many 1 cent stamps as necessary.

This algorithm works with stamps priced like US Coins.

_Find a set of stamp prices and a cost for which the greedy algorithm
does not work._ (TPS)

### Another algorithm

_Write a (multiply-recursive) solution_ (TPS)

Full details not necessary.

Improving the exhaustive algorithm
----------------------------------

Can we use the techniques we used for Fibonacci (at least the first
two techniques)?

### Improvement one: Caching

### Improvement two: Iterative computation

Generalizing the technique
--------------------------

The combination of what I call "caching" and the iterative
construction of the cache is often called "dynamic programming".

Why "dynamic programming"?  Marketing!
