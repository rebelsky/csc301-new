---
title: "EBoard 22: Coded Bias"
number: 23
section: eboards
held: 2021-10-25
link: true
---
# {{ page.title }}

_Approximate overview_

* Admin
* Watch

Administrative stuff
--------------------

* Happy Sunny Monday!  (It was 
* Happy rainy Friday, if such a thing is possible.
    * Lots of rainy class days this week.
* Colds are going around campus; if you're using a MathLAN workstation,
  make sure to use one of the keyboard/mouse wipes.
* If you're going to miss class, please DM me or drop me an email.

### Pre-Break PSA

* Moderation in everything, except sleep.
* Take time for yourselves, if you can.
* I look forward to seeing you after break.

### Upcoming token-generating activities

### Upcoming other activities

* Scarlet and Black Swim Meet Saturday at noon

### Upcoming work

* [HW7](../assignments/assignment07) due Thursday after break.  To
  be discussed soon. 
* Sam will open up all the assignments during break for those of you who have
  not turned them in.

### Q&A

Do we have to do HW7 over fall break?

> No, you can do it the week you return.  Most of you seem to do work the week
  it is due, not the weekend before.

Is it okay if I turn in HW6 late?

> Yes.

What is your estimated time for HW7?

> Three-to-four hours.  No implementation!

Why is it so hard to predict how long your assignment will take?
(Both for Sam and for Students.)

> The wonder of computing.  If you get it right, or mostly right,
  it's quick.  If you have a bug, it may take a nearly infinite
  amount of time to find that bug.

> Get help!  (SHAW has a 24 hour help line.)  (SAM has an
  occasional help line.)

> It's hard to tell how many bugs you have.

About HW7
---------

Sam blathers for awhile.

It's about proofs.  Of correctness of algorithms.  And developing those algorithms.

It *should* be straightforward.

Ask Sam for help when you can't get the last part of the last problem.

Efficient exponentiation, iterative
-----------------------------------

Your goal: Rewrite `expmod` iteratively.  In case you've forgetten, we
want to compute `x^n mod m`, with appropriate restrictions.

* You may want to add at least one other variable to handle odd exponents.
* Use invariants to help keep your code correct.
* Hint: If n is even, x^n = (x^2)^(n/2) = (x^(n/2))^2

An example that may or may not help.  Let's compute 5^23.

* 5^23
* 5 x 5^22
* 5 x 25^11
* 5 x 25 x 25^10
* 5 x 25 x 625^5
* 5 x 25 x 625 x 625^4
* 5 x 25 x 625 x 625^4
* 5 x 25 x 625 x (625x625)^2
* 5 x 25 x 625 x 390625^2
* 5 x 25 x 625 x 152587890625

Let's make it simpler by adding some mod

Let's compute 5^23 mod 7

* 5^23 mod 7
* 5 x 5^22 mod 7
* 5 x 25^11 mod 7
* 5 x 4^11 mod 7
* 5 x 4 x 4^10 mod 7
* 5 x 4 x 16^5 mod 7
* 5 x 4 x 2^5 mod 7
* 5 x 4 x 2 x 2^4 mod 7
* 5 x 4 x 2 x 4^2 mod 7
* 5 x 4 x 2 x 16^1 mod 7
* 5 x 4 x 2 x 16 mod 7
* 5 x 4 x 2 x 2 mod 7
* 80 mod 7
* 3

Working with someone(s) near you, write this algorithm iteratively (and
prove it correct)!

```
long
expmod (long x, long n, long m)
{
  // x > 0, n >= 0, m > 1
  long y = x % m;
  // x > 0, n >= 0, y = x mod m
  long p = n
  // x > 0, n >= 0, y = x mod m, p = n
  long t = 1;
  // x > 0, n >= 0, y = x mod m, p = n, t = 1
  // Our numbers have been cleverly chosen to ensure that the
  // invariant holds when we start.
  // Invariant: x^n mod m = t * y^p mod m.
  while (p > 0) {
    // Invariant: x^n mod m = t * y^p mod m
    // p > 0
    if (p % 2 == 0) {
      y = (y * y) % m;
      p = p / 2;
      // ynew = (yold * yold) % m
      // pnew = (pold) / 2
      // x^n mod m = t * yold^pold mod m
      // x^n mod m = t * (yold*yold)^(pold/2) mod m by the law of even exponents
      // x^n mod m = t * (yold*yold mod m)^(pold/2) mod m by modulo rule 13a
      // x^n mod m = t * ynew^pnew mod m by substitution
      // Invariant: x^n mod m = t * y^p mod m
    }
    else {
      t = (t * y) % m;
      p = p - 1;
      // x^n mod m = t * yold^pold mod m
      // x^n mod m = t * (yold * yold^(pold-1)) mod m // By the def'n of exponents
      // x^n mod m = (t * yold) * yold^(pold-1) mod m // By the transitive property
      // x^n mod m = (t * yold mod m) * yold^(pold-1) mod m // modulo rule 13a
      // x^n mod m = tnew * yold^pnew mod m  // See above
      // Invariant: x^n mod m = t * y^p mod m
    }
    // Invariant: x^n mod m = t * y^p mod m (because it holds for both ifs)
  } // while
  // Invariant: x^n mod m = t * y^p mod m
  // p == 0
  // x^n mod m = (t * 1) mod m and t < m
  return t;
} // expmod
```

Why does this terminate?

* Identify a "problem size"   p
* Show that the problem size decreases at every iteration.
    * In one case, it divides by two.  That decreeases as long as p > 0.
    * In the other, it subtracts one.  That always decreases.
* Yay!  It terminates.

Why is this O(logn)

* If we have an even exponent, it cuts the exponent in half.  Repeated
  cutting in half is generally an O(logn) algorithm.
* We can never have an odd exponent in two successive iterations.  When
  you subtract one from an odd power, the new power is even.

Testing
-------

Suppose we didn't trust our proof (e.g., because proofs can be wrong as
often as code is, or because, well, things sometimes behave differently
in the world of C), what kind of tests might we write?

* How do we know what the result should be beforehand?
    * You could choose things you know the result for.
    * You could write a less efficient expt procedure that you know is correct.
      `long result = 1; for (i = 1; i <= n; i++) { result = (result * x) % m; }`
    * You could generate expected results as you go.
      `{ result = (result* x) % m; test(expmod(x, i, m), result; }`
* One solution: Exhaustive: For each x from 1 to `LONG_MAX`, for each
  exponent from 0 to sqrt(`LONG_MAX`), compare to the inefficient result.
    * Slow!
    * So randomization might help (exponent, mod, base)

More Invariants
---------------

More broadly, an invariant is a characteristic of something, a characteristic
that you intend to maintain.  

Can you think of other characteristics we've tried to maintain?  (TPS)

Invariants get used in, say, the design of heaps, bsts, balanced bsts, ....

Even if we only do it informally, identifying characteristics to maintain
is likely to be useful.
