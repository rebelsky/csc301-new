---
title: "EBoard 02: An introduction to the course, continued"
number: 2
section: eboards
held: 2021-08-30
link: true
---
# {{ page.title }}

**Please grab a playing card.  They are at the front of the room!**

_Approximate overview_

* Approaching algorithms and proofs
* Testing priority queue algorithms
* More details on heaps
* Problem: Getting from here to there 
* Problem: Robot soldering
* Problem: Task optimization

Administrative stuff
--------------------

* Hi.  We're still Sam and Shane.
* Attendance.
* You can find stuff in the [Examples](../examples) directory.
* Disclaimer: I like the command line.  Deal with it.

### Apologies

* The site is still under construction.
* It's been too long since I've used Java.

### Upcoming activities

Policies

* You earn tokens by attending events.
* You can trade in tokens to turn in work late.

Events

* First Scholars' Convocation, 11 am, Thursday, September 2.
    * Sam will give a shpiel about Scholars' Convocation this week

### Upcoming work

* Do assignment 1 (to be distributed this weekend) before 10:30 p.m.
  on Wednesday.
    * GradeScope link to be posted soon.
* No reading for Wednesday.  Yay!

Approaching algorithms
----------------------

_You are now experienced computer science students. When some gives you a problem that admits an algorithmic solution, what do you do?_

_Think->Pair->Share_

* Copy code from StackOverflow!  (No!)  Or Hugh's Toob.  (No!)
* Draw pictures to better understand the problem and/or the solution.
    * Pictures also help you develop solutions.
* Make sure that you understand the problem.  E.g., develop some sample
  inputs and outputs.
    * You may also want to formalize the prereqs and postconditions.
* Design or choose data structures that may help.
* Write the algorithm and check it by hand.
    * Decompose / Break it down into smaller parts.
        * Think about the algorithm as a sequence of transformations of data
        * Look for procedures that will help with the smaller parts
    * Start with a concrete example and think about how I'd do it by hand.
        * Or think about each value in the algorithm and how it might
          transform.
        * Look for patterns in the examples you are working by hand
    * Work backwards from solution to input
    * Thinking about the proof early may help you come up with a design
    * Look for similar problems and adapt their solution.
    * See if "standard" techniques apply
        * Divide and conquer
        * Exhaustive search
        * Greed
        * Dynamic programming (coming soon)
        * Transform to another problem  (and transform the solution back)
* Run your algorithm by hand; Try to find counter-examples, instances
  in which it may not work
* Write tests.
* Write some code and hope it works!  [Don't worry about edge cases when
  doing so.]
* Analyze your algorithm for efficiency.
    * Think about what you are trying to optimize.
* Try to prove your algorithm correct.
* Ask "Can I do better?"
* Ask "Can I generalize?"

Testing priority queues
-----------------------

* Reminder: Priority queues are linear structures that let you add and
  get information.  When you get something, you should get the "highest
  priority" value, depending on some prioritization.
    * In Java, priority is probably determined by a `java.util.Comparator`.

* How would you test an implementation of priority queues to give yourself
  confidence that it works correctly?
* We also need an interface.  
  See [`Examples/priority-queues/PriorityQueue.java`](../examples/priority-queues/PriorityQueue.java)
* What tests would you write?
    * We are doing **black box** testing.  We know *what* the operations
      do, but not *how*.
* Make sure that I can add an element without the structure crashing.
* Side note:
     * `() -> EXP` is a lambda expression
     * An interface with exactly one function in it is called a "Functional
       Interface".
     * You can use a lambda to build an object that meets the functional
       interface.
     * `() -> ints.add(5)` is an object that provides one function,
       `execute`, and the `execute` operation calls `ints.add(5)`.
     * "Syntactic sugar"
* Add an element that is higher priority, immediately remove it, and 
  determine if it's the same.
* Add two equal elements to an empty priority queue and make sure we 
  can remove both.  Try with numbers (5,5) and strings ("five", "five").
* Verify that remove and peek fail on the empty queue.
* Verify that the empty queue `isEmpty`. 
* Make sure that peek doesn't remove.
    * Add one element (32), peek, make sure it's not empty.
    * Add one element (32), peek a dozen times, ensuring that you keep
      getting the same value.

Systematic and randomized tests

* Randomize the integers from 1 to 100, add them all to the queue,
  remove them all, ensuring that you get them out in the appropriate
  order.
* Randomize order of insertions and deletions.
    * Sometimes this involves additional work keeping track of what
      you should get next.
    * One case is when you have one implementation of an ADT and you
      want to test a more efficient implementation of the ADT.

Assignment
----------

* Write some more tests, including at least one systematic and/or randomized
  test.
* Implement the Array-based Priority Queue.
* Impelment Heaps.
* In an ideal world, the tests you've written will work for both Array-based
  Priority Queues and Heaps.
    * Polymorphism / Inheritance
* The Heap class has a Comparator that includes a `compare(T x, T y)`
  opeeration.  `peek` and `remove` return the *largest* value.
* You will need to copy the .java files and download the Junit thingy.

Heaps, continued
----------------

* A heap is a (a) nearly-complete binary tree with (b) the heap property
  (each node is larger than or equal to the nodes below it).
* Heaps implement priority queues.  (One of the best known implementations.)
* To add: Put a value at the end of the last level and "heap up".
* To remove: Grab the root, put the last element of the last level at the
  top and "heap down".
* Question: How do you store the tree?  In an array.  Number the elements
  in breadth-first, left-to-right order.  That gives you the index of
  each element.
* Question: How do you find the last element at the last level?
  You can use the size of the array to determine that.
* Question: How do you find children/parent
     * Left child of index i: 2*i + 1
     * Right child of index i: 2*(i+1) = 2*i + 2
     * Parent of index i = floor((i-1)/2)
     * It looks true for the heap I true.  How can we be confident?
       We could write a proof.  Inductively!

Problem: Scheduling Overlapping Tasks
-------------------------------------

*Stolen/modified from Skienna's "The Algorithm Design Manual"*

* You have a bunch of tasks, each of which has a start time and a length.
* You can only do one task at a time.
* How do you maximize the number of tasks you complete?

Extension

* What if each task also has a value?  How do you maximize the value
  of the tasks you complete?

Problem: Getting From Here to There
-----------------------------------

* Because net neutrality no longer exists, providers can charge, or
  throttle speed, or ... for data that flows along their network.
* We have a problem: We need to get information from place to place,
  and we may want the least expensive path, or the quickest, or ....

_Have you seen this problem in CSC-207?_

We start by modeling the the problem

Then we try to design the algorithm.  

Problem: Optimal Soldering Plans
--------------------------------

*Stolen/modified from Skienna's "The Algorithm Design Manual"*

* We have a bunch of points that we need to have a robot solder
  on a circuit board.
* We want the least wear and tear on the robot.  (So it should move
  the least distance.)
* How do we determine how to order the points?

