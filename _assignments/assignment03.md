---
title: "Assignment 3: Divide and conquer algorithms"
number: 3
link: true
assigned: 2021-09-08
due: 2021-09-15
due-time: 10:30pm
---
# {{ page.title }}

*Due*: {{ page.due | date: '%A, %-d %B %Y' }} by {{ page.due-time }}

*Summary*: In this assignment, you will implement and analyze two of 
the divide-and-conquer algorithms we have recently encountered.

*Purpose*: To enhance your understanding of these algorithms.
To encourage you to think more broadly about algorithm design.

*Collaboration* (programming): You may discuss this assignment with
anyone you like, provided you credit such discussion when you submit
the assignment.  You may also look for solutions online, although
you will likely learn more if you try to implement them yourself
before relying online solutions.  You should not develop code
together, but you may certainly help each other debug code.  Each
person should write up his, her, zir, or their own work and submit
it individually.

*Submitting*: Turn in your work on Gradescope.  Make sure to include
your name, course information, and date at the top of each code
file.

*Evaluation*: We will primarily evaluate your work on its *correctness*
(e.g., does it compute what it is supposed to; does it meet the
requirements of the assignment) and *clarity* (e.g., is it easy to read,
is it well formatted and documented).  

*Warning*: So that this assignment is a learning experience for everyone,
we may spend class time publicly critiquing your work.

---

Part one: Finding the kth-smallest element
------------------------------------------

As you may recall, we developed an algorithm in class to find
the kth smallest element in a collection, V, of values, where
the kth smallest element is the element that would be in position
k in the collection if it were sorted in increasing order.  

The algorithm goes something like this.

Given _k_ and _V_, find the kth smallest element as follows.

* Pick a random value, _p_, from _V_, which we will call "the pivot".
* Partition _V_ into three parts: _L_, the elements less than _p_, _E_,
  the elements equal to _p_, and _G_, the elements greater than _p_.
    * In an array, we do the partitioning in place.
    * In a list, we'd create three separate lists.
* Let _l_ be the number of lesser elements, _e_ be the number of 
  equal elements, and _g_ be the number of greater elements.
    * We don't really need _g_.
* If _k_ < _l_, recurse on _k_ and _L_.
* If _k_ >= _l_ and _k_ < _l_ + _e_, return _p_.
* If _k_ >= _l_ + _e_, recurse on (_k_ - _l_ - _e_) and _G_.

a\. Implement a C program, `kth`, that takes an integer (_k_) and a
collection of strings (_V_) as command-line parameters and prints
out the kth-largest element of _V_.  You must do the partitioning
_in place_ in an array, and you may only allocate a new array once.
You may not allocate any new strings.
(You should be able to avoid allocating any new arrays.)

```
$ kth 0 beta alpha gamma
alpha
$ kth 1 beta alpha gamma
beta
$ kth 2 beta alpha gamma
gamma
$ kth 2 beta alpha beta gamma beta
beta
```

b\. Instrument your code to count the number of swaps in the array. 
Then run some experiments to determine whether this algorithm appears
to be linear in practice.  In your experiments, you should

* Generate a variety of random arrays of strings of various sizes,
  ensuring at least five of each size.
* Search in each array for different k's (perhaps for all k's).
* Find the maximum, minimum, and average for each size.
* Print out the data in a handy-dandy CSV format, using columns
  `size,min,max,average` or `size,k,min,max,average`.

For this part of the assignment, you should turn in seven files.

* `kth-core.h`, a header file that declares the `kth(int k, char *V[], int n)`
  function.
* `kth-core.c`, a file that defines the `kth` function.  If you choose 
  to implement `kth` recursively, you'll probably also define your 
  recursive helper here.  If you write a separate `partition` function,
  you'll also want to implement that here.
* `kth-tests.c`, a file that runs a set of tests that help verify the
  correctness of your `kth` function.
* `kth.c`, a file that defines the command-line interface for your `kth` 
  function.  (See above for the details.)
* `kth-experiments.c`, a file that runs the suggested experiments and
  prints out the CSV.
* `Makefile`, the makefile for the project.

Optionally: You can try your solution at
<https://www.hackerrank.com/challenges/find-the-median/problem>.

Part two: Finding nearest neighbors
-----------------------------------

As you may recall, we developed a variant of the nearest-neighbor
algorihm in class, one in which during the search for crossovers,
we only look for elements on the right that are vertically near
elements on the left, and elements on the left that are vertically
near elements on the left.  It goes something like this (I don't
guarantee that it's correct).

```
np(Pairs)
To find the nearest pair in Pairs
  Let Px be Pairs sorted by x coordinate
  Let Py be Pairs sorted by y coordinate
  Use our helper on Px and Py

helper(Px,Py)
To find the nearest pair given Px and Py
where Px and Py are the same set of points,
with Px sorted by x coordinate and Py sorted
by y coordinate. 
  Let maxx be the median x value in Px
  Let Lx be all the elements of Px whose x coordinate
    is less than or equal to maxx
  Let Rx be all the elements of Px whose x coordinate
    is greater than maxx
  Let Ly be elements of Lx sorted by y value
    We can identify these by iterating Py, keeping 
    the points with x coordinates <= maxx
  Let Ry be the elements of Rx sorted by y value
    We can identify these by iterating Py, keeping
    the points with x coordinates > maxx
  Let left = helper(Lx,Ly)
  Let right = helper(Rx,Ry)
  Let Ldelta = distance(left)
  Let Rdelta = distance(right)
  Let delta = min(Ldelta, Rdelta)
  Let best = delta 
  Let Lf = the elements of Ly whose x coordinate is >= maxx - delta ; filtered
  Let Rf = the elements of Ly whose x coordinate is <= maxx + delta 
  For each element, p, of Lf
    For all elements, q, of Rf whose y coordinate is between
    p.y and p.y+delta,
      if distance(p, q) < best
        best = distance (p, q)
        Remember p and q
  For each element, p, of Rf
    For all elements, q, of Lf whose y coordinate is between
    p.y and p.y+delta,
      if distance(p, q) < best
        best = distance (p, q)
        Remember p and q
  Return the pair that corresponds to best.
```

a. Implement the nearest neighbors algorithm in Racket.  You will
represent each point as a pair (cons cell) and all of the lists of
points as, well, lists of points.  The signature of your method
should be `(nn points)`.

b. Instrument your code to count how many points on the "other side"
have a y coordinate between p.y and p.y+delta and to keep track of
how many times each count occurs.  You'll store that information
in a global vector, `candidates`.  That is, `(vector-ref candidates
0)` should tell me for how many points the algorithm found no
candidate partners on the other side, `(vector-ref candidates 1)`
should tell me for how many points the algorithm found just one
candidate partner on the other side, and so on and so forth.

Your code should be in the file `nn.rkt`.
