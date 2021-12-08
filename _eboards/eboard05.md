---
title: "EBoard 05: to Divide and Conquer"
number: 5
section: eboards
held: 2021-09-06
link: true
---
# {{ page.title }}

_Approximate overview_

* Admin
* Leftover from last class: Other notations
* Divide and conquer
* Some important design considerations
* Example: kth smallest
* Example: Nearest neighbors
* Other examples from Roughgarden

Administrative stuff
--------------------

* Hi.  We're still Sam and Shane.
* The site is still under construction.  It may remain under construction
  until the end of the semester.
* Warning: Today has not gone well for me.  That may continue.
* Warning: I made name cards so that I can call on you randomly.  I'll
  also use them for attendance.

### Upcoming activities

* Alex Mitchell '17 visits LFA Tuesday at 2pm in Science 3821.

### Upcoming work

* [Assignment 2](../assignments/assignment02) due Wednesday
    * I *think* I even got the place to post it up.
* No reading for Wednesday!

### Q&A

I don't like proofs.  Will I survive?

> Yes.  If you need me to slow down on the proofs that I do, feel free
  to ask me to explain more.  _You are not alone in being confused._

> I care that you develop some mathematical intuition.  That includes
  finding patterns, doing some abstract manipulation, identifying appropriate
  proof techniques, and understanding how to apply those techniques.

> Embrace a growth mindset.  _You can develop these skills!_

> Shane and I and your classmates are here to help.

I hate sitting for 80 minutes straight.

> You are not alone.  Feel free to get up and stretch during class.  I'll
  probably encourage you to do so at times.

Can I watch the videos for the book instead of just reading?

> I'd prefer that you also read.  It's good to get used to math
  notation, among other things.

> We should have two copies of each book in the CS learning center.
  You can take them elsewhere on Noyce 3rd to read, but please
  return them when you're done.

Do you have answer keys for the homework assignments?

> Nope.

Where is the learning center

> Next to SDA's office.  Across from ELBICA labs.

Other notations
---------------

### Big Oh (aka Big O aka Big Omicron)

f(x) is in O(g(x)) iff there exist c > 0, n0 > 0 s.t.
for all n > n0, f(x) <= c\*g(x).

That stupid backslash before the times symbol is because of markdown.

Big-Oh is used to give us upper bounds.  We usually like moderately
tight upper bounds.  We bound running time and/or space usage.

### Big Omega

f(x) is in Omega(g(x)) iff there exist c > 0, n0 > 0 s.t.
for all n > n0, f(x) >= c\*g(x).

Big Omega is used for lower bounds.

We don't use Big Omega much, but we sometimes bound problems rather
than algorithms.  Famous example: There is no compare-and-swap sorting
algorithm that is faster than nlogn.  That is if T(n) is the running
time of a compare-and-swap sorting algorithm, then T(n) is in Omega(nlogn).

Mergesort and Heapsort and Timsort and Quicksort are about as good
as we can do conceptually.  The constant multiplier comes into play.

### Big Theta

f(x) is in Theta(g(x)) iff there exist c > 0, d > 0, n0 > 0 s.t.
for all n > n0, c\*g(x) <= f(x) <= d\*g(x).

Big Theta is a "approximately equal" bound.  It's hard to derive
such bounds.  For example, insertion sort is bounded above by
O(n^2) and below by O(n).  There is no Theta bound for insertion sort.

### Little Oh

There are times in which Big-Oh doesn't serve naturally for the problems
we work with.  Little-Oh serves as an alternative.

f(n) is in o(g(n)) iff lim (n->ifty) f(n)/g(n) = 0

Both f and g are getting bigger (usually).  g is getting bigger faster than 
f is.

Conceptually, both could be getting smaller, with f getting smaller faster
than g is.  But algorithms generally take more time and more space with
bigger inputs.

Less tight than Big-O

_Sam prepared insufficiently well for a little-oh example._

Divide and conquer
------------------

One of our favorite algorithm design strategies.

By dividing the problem in half (more or less) and recursing on one or
both halves, we can come up with a solution to the whole.  (We might
also use thirds, quarters, eighths, or something similar.)

This not only leads to solutions to problems, it often leads to more
efficient solutions to problems.

What divide-and-conquer algorithms do you know?  What are the important
aspects of that algorithm?

* Merge sort
    * Break the array into two halves (usually first n/2 elements and
      the last n/2 elements)
    * Sort halves
    * Spend some work merging them together.
    * Merge sort requires Omega(n) space (maybe n/2 in practice) to copy
      elements during merging.
* Quick sort
    * Pick a random pivot, split into those <= pivot and those >= pivot
    * Sort halves
    * Merging is easy; all the smaller things are on the left.
* Counting inversions (from the reading)
* Binary search
    * Break into "small" and "large", which is easy because we require
      a sorted array as input
    * Determine whether the thing we are looking for is small or large
    * Recurse on one half

Some important decision points in divide-and-conquer
----------------------------------------------------

* What do we require of the input?  E.g., binary search requires that
  the input is sorted.
* How do we split the input?  Sometimes just "half of the elements"
  "another half of the elements".  Sometimes something fancier.
* How do we combine the results?
* What do we do in the base case?
* What do we do at the same time to provide additional resources?
  For counting inversions, we not only count inversions, we also
  sort, and that doesn't/shouldn't make it more costly (at least
  in Big-O notation)

Kth Smallest
------------

The kth-smallest element is the element for which there are k smaller
elements.

What's an easy way to find the kth-smallest element?

* Sort it O(nlogn).
* Look at index k.

An easier way O(1)

* Require a sorted input.
* Look at index k.

Can we use a kind of divide-and-conquer strategy to find the kth
smallest element in an unsorted array or list of elements?  Assume
no duplicates.

Some initial questions:

* How will we split?
    * As in merge sort
    * As in Quicksort
    * Into k separate arrays (as in merge sort)
* What subproblem should we solve?

A useful tip: Split as in Quicksort "small and large"

Run an example, find the seventh-smallest element in the array

0, -7, -3, 5, 1, 2, 18, 4, 7, 3, 81

Pick a random pivot: 2

Smaller or equal elements: 0, -7, -3, 1, 2 (five of 'em)

Larger elements: 5, 18, 4, 7, 3, 81 (six of 'em)

I want the second-smallest of the larger elements

5, 18, 4, 7, 3, 81.  Pick a random pivot 4

Smaller or equal elements: 4, 3

Larger elements are 5, 18, 7, 81

Find the smallest (0th-smallest) of 5, 18, 7, 81

Pick a pivot: 18

Smaller elements 5, 7, 18

Larger elements: 81

Find the 0th smallest of the smaller elements ...

Running time?  Approximately

n + n/2 + n/4 + n/8 + ... + 1 = 2n-1

How do we know it's 2n-1?

* We've memorized it.
* We have really good intuition
* We've tried some examples.

Examples

16 + 8 + 4 + 2 + 1 = 31

32 + 16 + 8 + 4 + 2 + 1 = 63

64 + 32 + 16 + 8 + 4 + 2 + 1 = 127

So we've gone from an O(nlogn) to an O(2n-1) = O(2n) = O(n) algorithm.

We've done log(n) recursive calls, but each of them required some extra
work.  If each required n, this would be O(nlogn).  However, the amount
of work got smaller each time, so this ends up being better than O(nlogn).

Sometimes we have to do more subtle counting.  This algorithm is worse
than logn but better than nlogn.

Q: Why choose a random element as a pivot rather than say n/2, where
there are n elements?

A: Suppose our elements are 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, ...
5 won't be a very good pivot.  max/2 will be an even worse pivot.
Historically, randomized pivots work better than any systematic pivot,
particularly when you have adversarial arrays.

No, we won't do a formal proof of the value of randomized pivots.

Nearest neighbors
-----------------

You have a set of n points in the plane.  You want to find the pair
of points that are closest together.  How?

_Note: There have been many times that Sam tried to solve nearest neighbors 
problem with divide-and-conquer and gave up.  But it's possible!_

How many folks read the section on nearest neighbors? 3

How many folks understood the section on nearest neighbors? All 3 said "eh"

### The basics

You can assume that we've sorted the points according to X coordinate
and that we've also sorted the points according to the Y coordinate.

How would you divide the points in a plane?

How would finding the nearest pair of neighbors in each half help you?

* Because they are reasonable candidates for the closest pair.
* They give us a delta, a candidate distance

Why might the nearest pair of neighbors in either half not be the nearest
pair of neighbors in the overall set?

* The nearest pair might cross the boundary.

We can throw out some points: Anything further than delta from the
x axis is not useful in finding close points that cross the boundary.

wlog, we'll assume that the point on the left (p) is higher than the
point on the right.  How many points on the right must we search?
All those whose y coordinate is no more than delta bigger (smaller) than 
the y coordinate of p.

In finding crossing distances, we look at at most four things on the 
other side of the split.  So, at worst, we look at 4\*n pairs.

Divide and conquer algorithm

* Split: n
* Recurse: 2T(n/2)
* Look for crossing pairs: 4n

Running time is T(n) = 5n + 2T(n/2)
T(2) = 1

Problem: How do we figure out what T(n) is?

* We learned recurrence relations in some other course.

### Some morals

### Extending the algorithm

Can you find the nearest pair in three-space?  N-space?  Are there 
better/other algorithms?

Other Roughgarden examples
--------------------------

* Integer multiplication
* Matrix multiplication
* Count inversions

