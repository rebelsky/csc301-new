---
title: "EBoard 15: Bounds on Sorting"
number: 15
section: eboards
held: 2021-09-27
link: true
---
# {{ page.title }}

_Approximate overview_

* Admin
* Monday recap
* Common questions about algorithms
* A lower bound on sorting algorithms, take one
* A lower bound on sorting algorithms, take two

Administrative stuff
--------------------

* Happy Wednesday!
* Since things seem safer on campus, I am willing to meet with students
  in my office.  Let me know what you prefer.
* Please notify me when you are unable to attend class (preferably
  prospectively; alternately retrospectively)

### Upcoming token-generating activities

* CS Extras: Study Abroad in CS.  Thursday, 4pm, Science 3821.
* Prof. Eliott's Coffee Chat in ELBICA lab (across from CS Learning Center)
  Fridays 5-6 p.m.
* Pioneer Weekend introductory talk, 7:00 p.m. Friday, October 1.
* Pioneer Weekend, October 1--3.
* Arcadia, October 8--10. (7 p.m. Friday and Saturday, 2 p.m. Sunday.)
  (I think.)

### Upcoming other activities

* Lunar New Year (unofficial) Celebration this weekend.

### Upcoming work

* [HW5](../assignments/assignment05) due Thursday night.  Implement
  AVL trees in Racket or Java.
* Read Section 5.6 for Friday.
* [HW6](../assignments/assignment06) due a week from Thursday.  Implement
  the best stable sorting algorithm you can.  Implement radix sort for
  strings.  More details forthcoming.
    * Sorry about two weeks of implementation in a row.  My goal is
      to alternate implementation and theory.

### Q&A

If we do the Scheme/Racket version of HW5, what should we do?

> You need to rewrite `node-insert!` so that it rebalances after
  inserting.  You need to add a `kth` procedure, that finds the
  `kth` value you would see in left-to-right preorder.  You need
  to check the heights for various input sizes.

Any hints on rewriting `node-insert!`?

> There's a "cleanup" procedure (`node-update-attributes!`) that gets 
  called after nodes are inserted in the left or right subtree.
  You could have that check for imbalance at that node and rebalance.

How do I rebalance?

> See Knuth and/or your notes from Friday.

What about the `kth` element?

> See Knuth.

What happens if I use more tokens than I have?

> You incur a token debt.

What happens if I have a token debt at the end of the semester?

> Your grade decreases.

How much?

> You don't want to find out.

Monday recap
------------

* We know six or so sorting algorithms: Insertion sort, selection sort,
  merge sort (two flavors), quick sort, and heap sort.
* Most sorting algorithms are *not* stable, at least not by default.
* Insertion sort is a favorite O(n^2) stable sorting algorithm that
  does particularly well with mostly-sorted input, particularly because
  it can sort in place.
* Merge sort is an O(nlogn) stable sorting algorithm that requires
  O(n) extra space.  Because it's stable, we often use it (or a
  variant thereof), in spite of the space requirements.
* When you get to really large inputs, you start considering other issues,
  such as locality.

Questions about algorithms
--------------------------

None of the sorting algorithms we traditionally use is better than
O(nlogn).

As an algorithm designer, you should have at least three followup questions:

* Which one is better in practice?  (Experiments!)
* Can I do better?  (Perhaps by restricting the input.)
* Can I prove that I can't do better?  (Perhaps by characterizing the
  basic algorithm approach.)

We'll do the latter two, as strange as that is.  Better algorithms will be
next class.  We'll start with the theorem today.

A lower bound on sorting algorithms
-----------------------------------

Theorem: All comparison-based algorithms have inputs that require
Omega(nlogn) running time.

Proof?  You get to consider how to approach it.

* What proof techniques do we know?
* How can we represent a comparison-based sorting algorithm?

A lower bound on comparison-based sorting algorithms, revisited
---------------------------------------------------------------

### Modeling comparison-based sorting algorithms

### An important lemma

### Our theorem
