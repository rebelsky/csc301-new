---
title: "EBoard 15: Bounds on Sorting"
number: 15
section: eboards
held: 2021-09-29
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
    * Theatre.  Show by Tom Stoppard.  Mathy.
    * Ticketing Wednesday
* Uncle Bill's Petting Farm 12:30-2:30 Sunday
* Neverland players this weekend.

### Note: Email me a one-paragraph reflection

### Upcoming other activities

* Concert Friday night
* Concert Satuday night "Cornstalk" 7:30-???? at Farm House
* Lunar New Year (unofficial) Celebration this weekend.

### Upcoming work

* [HW5](../assignments/assignment05) due next Thursday night.  Implement
  AVL trees in Racket or Java.
* Read Section 5.6 for Friday.
* [HW6](../assignments/assignment06) is on hiatus.  Implement the best 
  stable sorting algorithm you can.  Implement radix sort for strings.  
  More details forthcoming.
    * Sorry about two weeks of implementation in a row.  My goal is
      to alternate implementation and theory.

### Q&A

If we do the Scheme/Racket version of HW5, what should we do?

> You need to rewrite `node-insert!` so that it rebalances after
  inserting.  You need to add a `kth` procedure, that finds the
  `kth` value you would see in left-to-right inorder.  You need
  to check the heights for various input sizes.

Tell me more about kth.

> As you know, we can number the nodes in the tree according to a
  depth-first, left-to-right, in-order traveral.  kth gives the
  node that would be numbered k in such a traversal.

> Your kth shoul be O(height), which for balanced trees is O(logn)

Any hints on rewriting `node-insert!`?

> There's a "cleanup" procedure (`node-update-attributes!`) that gets 
  called after nodes are inserted in the left or right subtree.
  You could have that check for imbalance at that node and rebalance.

Should we just write a separate "balanced-node-insert!" procedure?

> Great idea!  Thanks for the suggestion.  Anything that lets you
  compare is fine.

If our tree is a BST, does kth give the kth-smallest element?

> Yes.

Why did you give us a preorder traversal if inorder is the important
thing?

> Um.  I'm not sure.  Lack of sleep?

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

Theorem: All comparison-based sorting algorithms have inputs that 
require Omega(nlogn) running time.

Proof?  You get to consider how to approach it.

* What proof techniques do we know?
    * Proof by induction (assume all inputs of size k < n require
      Omega(klogk), show that an input of size n requires nlogn)
    * Proof by contradiction (assume we can sort in less than nlogn.
      find out that ...)
    * Direct proof / proof by construction
    * Brute force: Here are all the inputs of size n.  Let's count how
      many different ways we sort each one.  Counting.
    * By definition.  "The definition of sorting suggests that ..."
    * Wave those hands.  "Look, it seems plausible that ..."
* How can we represent a comparison-based sorting algorithm?

A lower bound on comparison-based sorting algorithms, revisited
---------------------------------------------------------------

### Modeling comparison-based sorting algorithms

Claim: Every comparison-based sorting algoirthm for a particular size
can be represented by a decision tree.

### An important lemma

The tree for an input of size n must have a different leaf for each
permutation of [1,2,...,n].  There are n! permutations. By logic!

There are n choices for the first slot.  n-1 choices for the next slot,
n-2 choices for the next slot.  Etc.  So n\*n-1\*n-2\*...\*2\*1 = n!.

Proof of lemma.  By contradiction.

Suppose there were fewer leaves than permutations.  

There exists a leaf that is used for two separate inputs.  (Pigeonhole
principle.)

Two separate inputs will differ in at least two positions.

But the leaf must permute both of them the same.

So if we put smaller in the first position and larger in the second position
in the first input, and larger in the first position and smaller in the
second position in the second input, one must be unsorted at the end.

Hence, the tree does not always sort.  That contradicts our assumption
that we could build a tree that sorts with fewer than n! leaves.

Therefore, a tree that sorts any array of size n must have n! leaves.

### Lemma

Proof by direct construction.

n! >= (n/2)^(n/2)

* Hand wave: "Some famous mathematician said this."

```
n! = n \* n-1 \* n-2 \* ... \* n/2 \* (n/2-1) \* .... \* 1
   
   >= n \* n-1 \* n-2 \* ... \* n/2 

   >= n/2 \* n/2 \* n/2 \* ... \* n/2

   >= (n/2)^(n/2)
```

### Our theorem

Theorem: All comparison-based sorting algorithms have inputs that 
require Omega(nlogn) running time.

Proof:

Our sorting tree for input of size n has n! leaves.  (By Lemma above)

Assume that tree has height k.  

The shortest possible tree (a complete binary tree) has 2^(k-1) leaves.

2^(k-1) >= n! >= (n/2)^(n/2)

2^(k-1) >= (n/2)^(n/2)

Compute the log of both sides

log2(2^(k-1)) >= log2((n/2)^(n/2)), assuming 2^(k-1) is at least 2.

log2(2^a) = a

log2(x^y) = ylog2x

k-1 >= n/2(log2(n/2))
    >= n/2(log2n - 1)

k >= n/2(log2n - 1) + 1

k in Omega(n\*log2n)

k represents the number of comparisons we had to do in our sorting algorithm.

Thereofore, any sorting algorithm based on comparisons is Omega(n\*log2n)

Q.E.D.
