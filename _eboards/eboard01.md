---
title: "EBoard 01: An introduction to the course"
number: 1
section: eboards
held: 2021-08-27
link: true
---
# {{ page.title }}

_Approximate overview_

* Preliminaries
* Course goals
* Course format
* Approach algorithms and proofs
* Problem: Getting from here to there (maybe)
* Problem: Robot soldering
* Problem: Task optimization

Administrative stuff
--------------------

* Hi.  I'm Sam.  You should call me "Sam".
* Shane is your class mentor.
* Welcome back to in-person classes!
* Attendance.
* I will use the whiteboard more than I do in a typical class (e.g.,
  to draw).
  If you want copies of what's on the whiteboard, feel free to take
  pictures.

### Apologies

* I am old.  My hearing is not great, even with hearing aids.
* Some combination of age + weight + meds + temperature in room + 
  air movement in room (or lack of such) means I sweat a lot.
* Our Web site is not as up to date as I'd like.  But it will be.  Soon.
  Ish.
* I am traditionally bad at names+faces.  I will be worse with masks.
* More to come ....

### Upcoming activities

Policies

* Still to be determined.

Events

* First Scholars' Convocation, 11 am, Thursday, September 2.
    * Sam will give a shpiel about Scholars' Convocation next week

### Upcoming work

* Read ??? before Monday's class.
* Do assignment 1 (to be distributed this weekend) before 10:30 p.m.
  on Wednesday.

Course goals
------------

* Think of CSC-301 as _CSC-207, enhanced/extended/made more challenging_.
* We will learn how to design and analyze algorithms and data structures
    * Tools, such as methodologies for design
    * Verification techniques
    * Mechanisms for analyzing efficiency
* More of the core literature
* Side note: I assume that you know
    * Trees + BSTs
    * Merge sort
        * Break into two halves
        * Sort each half
        * Combine them back together
        * Merge sort has the disadvantage that it cannot be done
          in place, and so requires O(n) extra storage.
        * Application of divide and conquer to sorting
    * Quicksort
        * Pick a random element (pivot).  Rearrange so that smaller
          things (things smaller than pivot) are at the left and larger 
          things (larger than or equal to the pivot are at the right)
          and then recurse on both halves.
        * *Can* be done in place in an array.
        * Running time? O(nlogn) *if we choose good pivots*.  As
          bad as O(n^2) us we choose bad pivots.
        * Hand wavy proof: Suppose we always choose the smallest element
          as the pivot.  n-1 steps to break into pivot + everything else.
          n-2 steps to break into next pivot + everything else.  And so
          on and so forth.  n-1 + n-2 + n-3 + .... + 1 = O(n^2).
          More precisely, that's n*(n-1)/2.
        * Algorithm analysis will require you knowing (or being able to
          rederive) a lot of different finite sums.
        * We will prove that no compare+swap sorting algorithm can be
          more efficient than O(nlogn)
        * There is no good way to efficiently choose a *guaranteed* good
          pivot.  We can do a proof based on a random pivot.  (But we will
          probably not do that proof.)
        * Application of divide and conquer to sorting + randomness
        * Cannot implement without recursion (or your own stack)
    * Binary search
        * Look in the middle of the collection.  If the middle element
          is smaller than the target value, throw away everything to the
          left.  If the middle element is larger, throw away everything
          to the right.
        * The collection has to be sorted.
        * Typically, we do this by keeping track of a range (lower bound
          to upper bound) and working with arrays.
        * Divide and conquer algorithm
        * Running time is O(logn)
    * Map/Reduce
        * Map: Apply an operation to each value in a list or array
        * Reduce: Take all the values in the list and combine them into
          a single value
        * A lot simpler than using loops
        * Can be more efficient because it can be parallelized
    * Priority Queues
        * A linear structure (like a queue or a stack): You have two
          or so basic operations: add and remove (empty?, full?, peek)
        * Each element in the structure has an explicit or implicit
          priority.
        * The remove operation removes the highest-priority element
    * How might we implement priority queues?
        * As a linearly linked structure (e.g., linked list)
        * As an array-based structure
        * Using hash tables
        * Using a multi-dimensional linked structure
        * Note: For the linear approaches we can choose to store in 
          "random" order or in hightest-to-lowest priority order
        * Linked list, don't care about order,
            * Add: Put at the front or back O(1)
            * Remove/Peek (the highest priority element): Look through
              all of the elements, keeping track of the highest priority
              we've seen (and the prior element).  O(n)
       * Linked list, stored in sorted order, highest to lowest priority
            * Add: Look for the correct place to insert it.  O(n)
            * Remove/Peek: Look at the front/top O(1)
       * Are these different for arrays?  Arrays can't grow in size.
         Eventually, if we keep adding, we'll need to resize.
            * Tip from Sam: If you double the size when you resize,
              it amortizes out to nearly free.
       * Should we use "unsorted" or "sorted"?  They seem to be the same
         cost.  "Sorted" seems nicer.
       * In practice, unsorted is likely to be better because you will often
         do fewer "remove"s than "add"s.
    * Priority Queues implemented as Heaps
    * Hash tables with multiple probing techniques
    * Graph basics
    * Linked and array-based structures
    * Proof techniques

What proof techniques do we know?

* Induction: Strong and Weak
* Brute force: Check every possibility
* Contradiction: Assume the opposite and show that it cannot be true
* Construction
* "Hand waving" (informal)

How do we remove from a BST?

* Suggestion 0: "Bubble Up", which may mean moving multiple things.
* Suggestion 1: Find the farthest right on the right subtree of the node
  being deleted.  Delete it.  Move it to the node being deleted.  Then
  "bubble down".
* Task
    * Express suggestion 0 or suggestion 1 in more detail
    * Find a counter-example to suggestion 0 or suggestion 1 as you understand
      it
    * Design a real algorithms

A heap is a tree-based data structure

* A nearly complete binary tree
     * All the levels (except possibly the lsat one) are full.
     * If there is an un-full level, all the elements are at the left.
* Wthe the heap property: The priority of the value stored in a node 
  is higher than or equal to the priorities of the left and and
  right children (implicitly: anything in the left and righ subtrees)
* Why are heaps useful?
     * If we peek at the top, we can find the highest priority element.
     * We can usually design algorithms that are O(height).  The height
       of a tree with N elements is log(N)
* To add to a heap, just put it at the end of the last level and then
  "clean up"
     * Putting it at the end of the last level keeps the tree nearly 
       complete
     * We "bubble up", swapping with the parent if the parent is
       smaller
     * Yay, that's O(logN)
* To remove from a heap
     * Take away the root.  Whoops.  Wrong shape
     * Take the rightmost element on the last level and put it at the
       root
     * Restore the heap property by swapping down, swapping with the
       higher priority of the two children
     * Yay, that's also O(logN)

Course format
-------------

* I try to employ an active learning format
* Rather than having you read about one of the core algorithms, I will
  likely challenge you to design/implement/analyze them, perhaps assigning 
  different approaches to different groups.
* I will randomly call on people after you've had time to work in small
  groups.
* Once we've tried to design an algorithm ourselves, we will read about
  what people have done in the past.
* We will also have the normal course trappings: Homework assignments,
  readings, some kind of exams, etc.
* I am trying to match assessments to the desired learning outcomes.
  Stay tuned!

Approaching algorithms
----------------------

**Skipped.**

_You are now experienced computer science students. When some gives you a problem that admits an algorithmic solution, what do you do?_

_Think->Pair->Share_

Problem: Getting From Here to There
-----------------------------------

**Skipped.**

* Because net neutrality no longer exists, providers can charge, or
  throttle speed, or ... for data that flows along their network.
* We have a problem: We need to get information from place to place,
  and we may want the least expensive path, or the quickest, or ....

_Have you seen this problem in CSC-207?_

We start by modeling the the problem

Then we try to design the algorithm.  

Problem: Optimal Soldering Plans
--------------------------------

**Skipped.**

*Stolen/modified from Skienna's "The Algorithm Design Manual"*

* We have a bunch of points that we need to have a robot solder
  on a circuit board.
* We want the least wear and tear on the robot.  (So it should move
  the least distance.)
* How do we determine how to order the points?

Problem: Scheduling Overlapping Tasks
-------------------------------------

**Skipped.**

*Stolen/modified from Skienna's "The Algorithm Design Manual"*

* You have a bunch of tasks, each of which has a start time and a length.
* You can only do one task at a time.
* How do you maximize the number of tasks you complete?

Extension

* What if each task also has a value?  How do you maximize the value
  of the tasks you complete?

