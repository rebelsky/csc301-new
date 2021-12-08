---
title: "EBoard 16: Fast O(n) Sorting Algorithms"
number: 16
section: eboards
held: 2021-10-01
link: true
---
# {{ page.title }}

_Approximate overview_

* Admin
* A sorting problem
* Some notes
* Bucket sort
* Radix sort

Administrative stuff
--------------------

* Please notify me when you are unable to attend class (preferably
  prospectively; alternately retrospectively)
* A reminder: Both 12:00 a.m. and 12:00 p.m. are ambiguous times.
  If you mean noon, use "noon", 11:59 a.m., 12:01 p.m., or 12:00 m.

### Friday PSA

* Please take care of yourselves.  You are awesome, stay that way.
* Moderation in what you do.
* Get sleep.
* Consent is ESSENTIAL!

### Upcoming token-generating activities

* Prof. Eliott's Coffee Chat in ELBICA lab (across from CS Learning Center)
  some Fridays 5-6 p.m. (but not today)
* Pioneer Weekend introductory talk, 7:00 p.m. Friday, October 1.
* Pioneer Weekend, October 1--3.
* Uncle Bill's Petting Farm 12:30-2:30 Sunday
* Neverland players this weekend.
* CS Extras: ???
* Arcadia, October 8--10. (7 p.m. Friday and Saturday, 2 p.m. Sunday.)
  (I think.)
    * Theatre.  Show by Tom Stoppard.  Mathy.
    * Ticketing Wednesday

### Upcoming other activities

* Concert Friday night
* Concert Satuday night "Cornstalk" 7:30-???? at Farm House

### Upcoming work

* [HW5](../assignments/assignment05) due next Thursday night.  Implement
  AVL trees in Racket or Java.
* [HW6](../assignments/assignment06) will come out Monday.  Implement 
  the best stable sorting algorithm you can.  Implement radix sort
  for strings.  Implement a hybrid bucket sort for strings, bucketing
  on the first two characters.  More details forthcoming.
    * Sorry about multiple weeks of implementation in a row.  My
      goal is generally to alternate implementation and theory.
    * C!

### Q&A

A strange math problem
----------------------

_Taken and modified from some strange Math book Sam is reading._

* Assume the earth is a sphere.
* You wrap a cord tightly around the equator.
* You add six feet to the cord and it somehow floats evenly away from the
  earth.  (That is, the distance from the earth to the cord is consistent.)
* Is there ...
    * (a) Enough room to walk under the rope? 
    * (b) Not enough room to walk under the rope, but enough room to 
      crawl under the rope?  
    * (c) Not enough room to crawl under the rope, but probably enough to 
      slip a soda can underneath?  
    * (d) Not enough room for a soda can, but enough to slip a piece of 
      paper underneath?  
    * (e) Not even room for a piece of paper?

Note: Our intuition is not always correct; sometimes it's worthwhile
to "do the math".

A sorting exercise
------------------

You have a bunch of letters of the alphabet.  

* Not all letters may appear.
* Some letters may appear multiple times.
* Different copies of the same letter should remain distinguished.
* Say we have 1000 letters.
* You want to put them in alphabetical order.  How might you do it?
* E.g.,: A, E, B, a, F, Ä -> A, a, Ä, B, E, F

Some solutions

Use one of the ones we've learned.

```
Create an array with a "slot" for each letter. O(n)
Iterate through the letters, adding each to the appropriate slot O(n)
Iterate through the array, pulling the letters the back out. O(m+n), where
  m is the number letters.
```

```
Use a hash map instead of an array.
```

Sam suggests that using a hash map instead of an array for this
problem buys you nothing and potentially increases your cost, since
"A"->0 is much cheaper than computing the hash code of A, modding
by the array size, considering whether we need to increase the size
of the array ...

Questions about sorting routines

* Running time (big O): O(m+n), where m is the number of distinct
  categories.
* Memory (big O): O(m+n), m for number of categories, we have to store
  each element.
* Can we make it stable?  Yes, by putting things at the end of each bucket
  (which we represent as lists and design so that add-to-end is O(1))
* Special cases this is good for: Small ranges of data.
* Range of the data: A to Z

* E.g.,: A, E, B, a, F, Ä -> A, a, Ä, B, E, F

```
  A
+---+---+---+---
| * |   |   | 
+-|-+---+---+---
  v
+---+---+    +---+---+    +---+---+
| A | *----> | a | *----> | Ä | / |
+---+---+    +---+---+    +---+---+
```

Some notes
----------

See above.

Bucket sort
-----------

You've designed it.  You'll implement it on the next assignment.  I'll
give you linked lists.

Variants
--------

What if we had a bigger set of inputs, too big for a table (e.g.,
arbitrary strings).

Does the bucketing approach help us in any way?

* We could bucket by the first letter and then sort the remaining lists
  using another strategy.
* Kind of like quicksort, but with more categories.
* This is not great for memory.

Radix sort
----------

### Demo

### The algorithm, roughly

* Split by rightmost digit, retain order.
* Shove 0 pile in front of ones
* THen by next-to-rightmost
* THen by next to next-to-righmost
* Etc.
* At the end, everything is magically sorted.

### The algorithm, clarified

```
for int k = 0; k < numbits; k++
  for v in vals
    if bit k of v is 0
      add v to zeros
    else
      add v to ones
  v = zeroes + ones
```

### Why does it work?

* After each round, the items are arranged with the last k digits in
  increasing order.
* After all the rounds, all the digis are arranged in increasing order.

### General analysis

* Running time: O(n\*numberofdigits); numberofdigits is fixed.
  Hence, this is an O(n) sorting algorithm!
    * That's okay, we're not comparing.
* Space: O(n) for the two temporary holding cells for ones and zeroes
* Stable?: Yes.  The process ensures that equal values always end up
  in the same pile; and things end up in order in the same pile.
* Special cases: Things representable in a short number of binary digits.

Implementing Radix Sort for Integers
------------------------------------

See [the example code](../examples/radix.c)
