---
title: "EBoard 21: Program verification and loop invariants (2)"
number: 21
section: eboards
held: 2021-10-13
link: true
---
# {{ page.title }}

_Approximate overview_

* Admin
* Extended example: Binary search
* Extended example: A variant of binary search
* The canonical loop invariant example: DNF
* Efficient exponentiation, recursive
* Efficient exponentiation, iterative

Administrative stuff
--------------------

* Happy rainy Wednesday, if such a thing is possible.
* Colds are going around campus; if you're using a MathLAN workstation,
  make sure to use one of the keyboard/mouse wipes.
* If you're going to miss class, please DM me or drop me an email.

### Upcoming token-generating activities

* Thursday Extras: Visitor from WashU

### Upcoming other activities

* Men's Soccer, Today, 4:30 pm (???)
* Volleyball, Today, 7:00 pm
* Scarlet and Black Meet this coming weekend.

### Upcoming work

* [HW6](../assignments/assignment06) due Thursday.
* HW7 to be released Friday.  Something to do with invariants.

### Q&A

Does Gradescope accept Zipfiles?

> Yes

I feel like my C programming needs work.  What should I do?

> Write more code!

> Read code!

> Take CSC-282 in the spring.

Can I blow off class on Friday because I have a needy friend who wants me to drive them to the airport?

> I guess so.  Check the eboard for details on what happened in class.

I can't get the code to compile on my laptop.

> Use MathLAN.

Do we have to do HW7 over fall break?

> No, you can do it the week you return.  Most of you seem to do work the week
  it is due, not the weekend before.

Can we assume a similar testing suite, or at least not millions of elements?

> Yes.

Is it okay to write a different sort for part A, rather than just improve mergesort?

> Sure.

Extended Example: Binary Search
-------------------------------

### Overview

I0: If val is in the array, then it's in the subarray [lb..ub).

```
{ I0 }
while (lb < ub)
  { I0 and (lb < ub) }
  CODE
  { I0 }
end while
{ I0 and (lb >= ub) }
{ Whoops!  It's not in the array. }
```

Problems: 

* (a) Maintaining the invariant (I0) and 
* (b) ensuring that the loop terminates.

### Details

I0: If val is in the array, then it's in the subarray [lb..ub).
S0: Vals is sorted

```
binary_search (int val, int vals[], int n) 
  int lb = 0;
  int ub = n;
  { I0, S0 }
  while (lb < ub)
    { I0, S0, and (lb < ub) }
    int mid = (lb + ub)/2;       // What overflow?; this is quotient
    { I0, S0, (lb < ub), lb <= mid < ub }
    if (val == vals[mid])
      return mid;
    else if (val < vals[mid])
      { (lb < ub), I0, val < vals[mid], lb <= mid < ub }
      ub = mid;
      { Argument for I0: it can't be at mid b/c val < vals[mid], it can't be beyond
        mid, because the values are sorted. }
      { S0, I0 }
    else // (val > vals[mid])
      { (lb < ub), I0, val > vals[mid], lb <= mid < ub }
      lb = mid;
      { val > vals[mid], so val > vals[lb] and it shouldn't fall to the left of
        lb because the array is sorted; if it was in the old subarray, it's in
        this subarray. }
      { (lb < ub), I0, S0 }
    end if
    { S0, I0 }
  end while
  { I0 and (lb >= ub) }
{ The value is not in the array }
return -1
```

First detour: What do we need to ensure I0?

```
val = 2
vals = [1,3,2]
n = 3
lb = 0
ub = 3
mid = 1
2 < vals[1]
```

Second detour: Run on the inputs (3, [1,5], 2)

```
val = 3
vals = [1,5]
n = 2
lb = 0
ub = 2
mid = 1
// val (3) < vals[mid] (5)
ub = mid = 1
mid = 0
// val (3) > vals[mid] (1)
lb = mid = 0
// lb < ub, so we keep going
mid = 0
// val (3) > vals[mid] (1)
lb = mid = 0
// Whoops!  Our code doesn't terminate.
```

```
binary_search (int val, int vals[], int n) 
  int lb = 0;
  int ub = n;
  { I0, S0 } { size = ub-lb; want to argue that it gets smaller every time }
  while (lb < ub)
    { I0, S0, and (lb < ub) }
    int mid = (lb + ub)/2;       // What overflow?; this is quotient
    { I0, S0, (lb < ub), lb <= mid < ub }
    if (val == vals[mid])
      return mid;
    else if (val < vals[mid])
      { (lb < ub), I0, val < vals[mid], lb <= mid < ub }
      ub = mid;
      { Argument for I0: it can't be at mid b/c val < vals[mid], it can't be beyond
        mid, because the values are sorted. }
      { S0, I0 }
      { Decreasing ub decreases ub-lb; this shrinks the thing I called "size" }
    else // (val > vals[mid])
      { (lb < ub), I0, val > vals[mid], lb <= mid < ub }
      lb = mid + 1;
      { val > vals[mid], so val > vals[lb] and it shouldn't fall to the left of
        lb because the array is sorted; if it was in the old subarray, it's in
        this subarray. }
      { I0, S0 }
      { Was: Whoops.  If lb = mid We cannot guarantee that this increases lb / shrinks 
        the size of the subarray. }
      { Now: Shrinks the size of the subarray }
    end if
    { S0, I0 }
  end while
  { I0 and (lb >= ub) }
{ The value is not in the array }
return -1
```

We now have a termination proof!

Important steps: Termination proof, Design invariant, think of how to maintain it.

Extended example, revisited
---------------------------

What if, instead of *any* index of val, we want the *first* index?
u
* We also want the search to remain O(logn) divide and conquer.
* And we don't want the code to be too ugly.  (Or maybe we start with ugly code
  and prettify it.)

Approaches

* I0, S0
     * If `val == vals[mid]`, check the value at `vals[mid-1]`
     * If `vals[mid-1]` is val, use mid as ub.  O/w return mid
     * Problem: What if mid is 0?  Crash.  Or just return mid.
* A more complicated invariant: 

The canonical loop invariant problem: Dutch National Flag
---------------------------------------------------------

Efficient exponentiation, recursive
-----------------------------------

Problem: Compute `(x^n) mod m` for non-negative x,n.  Assume m < `sqrt(LONG_MAX)`.

O(n) solution: For loop.

O(1) solution: Use log and expt.  Approximates.  ` (log 243 3)` is not 5, even though
it should be.

O(logn) solution:

```
long
expmod (long x, long n, long m) 
{
  long result;
  if (0 == n) {
    result = 1;
    // { result = x^0, n = 0 }
    // { result = x^n % m }
  }
  else if (0 == n % 2) {
    long tmp = expmod (x, n/2, m);
    { tmp = x^(n/2) % m }
    result = (tmp * tmp) % m;
    { result = (x^(n/2) % m) * (x^(n/2) % m) % m } { BY INDUCTION }
    { result = (x^(n/2) * x^(n/2)) % m }
    { result = (x^n % m }
  }
  else {
    { n is odd }
    long tmp = expmod (x, n-1, m);
    { tmp = x^(n-1) % m }
    result = (x * tmp) % m;
    { result = x^n % m } 
  }
  // { HOPE: result = (x^n) mod m }
  return result;
} // expmod
```

We've written an algorithm and proven it correct.  Yay!

Efficient exponentiation, iterative
-----------------------------------

Your goal: Rewrite `expmod` iteratively.

* You may want to add at least one other variable to handle odd exponents.
* Use invariants to help keep your code correct.
* Hint: If n is even, x^n = (x^2)^(n/2) = (x^(n/2))^2
* To be continued next class ....
