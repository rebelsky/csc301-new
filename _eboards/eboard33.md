---
title: "EBoard 33: Return of Greed" 
number: 33
section: eboards
held: 2021-11-17
link: true
---
# {{ page.title }}

_Approximate overview_

* Admin
* A return to greedy algorithms
* Proving greedy algorithms correct

Administrative stuff
--------------------

* We'll get more opportunities to prove algorithms incorrect
  today.  (I suppose if it's incorrect, it's not an algorithm,
  but you know what I mean.)
* I've made some revisions to the schedule. At least I think I have.

### Upcoming token-generating activities

* CS Extra Thursday at 4pm.
* CS Workshop on finding internships Thursday at 7-8pm.
* November 18-21, _Do You Feel Anger?_

Other good things

### Upcoming work

* No new readings.
* [HW10](../assignments/assignment10) due Thursday.

### Q&A

Sam, did you screw up on the design of problem 3?

> Yes.  I think so.  I can't fix it quickly.  So problem 3 is cancelled.
  Sorry student who spent 3 hours on the problem.  It's good to try
  impossible things.

Coin minimization
-----------------

* Like the stamp minimization problem from class.
* But with US coins.
* Given c cents, and coin prices s[1], s[2], ... s[n], find
  the smallest number of coins that exactly make c cents.

How do we approach the problem?

* Greed!
* Take the largest available coin, as long as it doesn't exceed
  the remaining amount

It doesn't always work

* Suppose coin values are 1, 5, 7
* How many coins to make 17 cents?
* two 7's and three 1's.  (The greedy solution)
* Or, better yet, one 7 and two 5's.

Can we prove that it's correct for US coins?

* Maybe.  We'll try a varient.

Let's assume coins are 1, b, b^2, b^3, ... b^k

How many coins do we need?  We'll use g[i] for the number of
the b^i coin we need.

* g[k] = floor(A/(b^k))
* g[k-1] = floor((A - g[k]b^k)/b^(k-1))
* ...

Greedy algorithm: A = g[k]b^k + g[k-1]b^(k-1) + ...

Optimum algorithm: A = o[k]b^k + o[k-1]b^(k-1) + ....

What is the most number of any value that you would want?  E.g.,
if we have pennies, nickles, and quarters, how many nickles would
we want?

* No more than four!

If we generalize ...

* No more than b-1 of any coin.

Question: If I use b-1 of each of the first i coins, how much
money do I have?

```
(b-1)b^0 + (b-1)b^1 + (b-1)b^2 + ... + (b-1)b^(i-1)
```

Factor out `(b-1)`

```
(b-1)(b^0 + b^1 + b^2 + ... + b^(i-1))
```

What's the second sum?  We look up geometric sums

```
(b^(i-1+1) - 1)/(b-1)
```

So our overall sum is

```
((b-1)(b^(i-1+1) - 1))/(b-1)
= (b^i - 1)
```

Suppose o[k] < g[k] for some k.  Choose the largest such k.

We have to make up b^k with smaller coins.

But the most we can reasonably make with smaller coins is (b^k - 1).
Whoops!

Activity Selection Problem
--------------------------

Each activity has a start time and a stop time.

```
|-----| |------| |------|
  |------|  |------|    |-----|
 |----|    |---------| |--------|
```

We can't take an activity at the same as another activity.

How do we find the maximum number of activities we can take?

What would you optimize?

* A: The (non-overlapping) activity that starts first.
* B: The shortest activity that does not overlap with anything else.
* C: The (non-overlapping) activity that ends first.
* D: Smallest gap
* E: Fewest overlaps

There's a good intuition behind each of these.  However, four
of them are wrong.  Can we do counter-examples?  Sure

_See whiteboard.  Summary below._

* A: A really long class that starts early and ends late.
* B: Short task that overlaps two other tasks (that we could
  do)
* C: Hmmmm ....
* D: Two long tasks with a small gap between them, each of which
  overlaps with two smaller tasks that have larger gaps.
* E: Make huge stacks of overlaps.

Moral: Greedy algorithms don't always work.  Hand-waving arguments
are often not enough.

How do we prove that approach C is correct?  (It _is_ correct.)

We're going to compare the greedy solution to the optimal solution.

We know that there's a point at which the two solutions diverge.
That is, the optimal solution and the greedy solution choose
different next activity

Knapsack Problem
----------------

You are a burglar.  Not the hamburglar.

You have a backpack that can hold up to k cubic centimetres of stuff.

You are in a warehouse.

In the warehouse are a variety of boxes.  Each box has a value v[i],
and size s[i].  Your backpack is magic!  It can stretch to hold exactly
k cubic centimeters (i.e., you don't have to worry about layout).

Your goal: Get the most value for the size.

Greedy approaches

* A: smallest
* B: highest value
* C: largest value/size ratio
* D: biggest remaining

Find counter-examples for A, B, and C.  (No, D is not correct.)

Counter example for A (smallest):

* Your bag holds size 2.  size 1 item is worth 1, size 2 item is worth 2.
  Picking the size 1 item is a bad idea.

Counter example for B:

* Your bag is size 10.  You have one item of size 10 and worth 100 and
  ten size-one items that are each worth 50.

Counter example for C:

* Your bag is size 6.  You have an item whose value is 100 and size is 4. (25:1)
  You have two items whose value is 60 and size is 3 (20:1).

Damn!  Maybe we should use exhaustive search (dynamic programming).
