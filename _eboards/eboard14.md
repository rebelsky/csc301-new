---
title: "EBoard 14: Sorting"
number: 14
section: eboards
held: 2021-09-27
link: true
---
# {{ page.title }}

_Approximate overview_

* Admin
* Choosing a sorting algorithm
    * Attributes worth considering about your data set.
    * Attributes (potential) of sorting algorithms
    * Attributes of our favorite sorting algorithms
* Sorting bounds

Administrative stuff
--------------------

* Happy Monday!
* Among the reasons SamR prefers Scheme/Racket: Writing the starter code 
  in Java took me about twice as long as writing the starter code in
  Racket, and I got less starter code written.
    * Part is the need to compile rather than use a REPL.
      Read-Eval-Print loop.
    * Part is different design criteria for the two.  (E.g., Iterators
      are common in Java, whereas a for-each-style approach is more
      common in Scheme.)
* I was less successful grading this weekend than I would have hoped.
    * Preparing the infrastructure for the Java alternative took a surprising
      amount of time.
    * DUO locked me out of my account.
    * I'd already far exceeded my forty-hour sanity cap.
    * "Excuses, excuses"

### Monday PSA

* All things in moderation, including homework.
* SLEEP is ESSENTIAL 

### Upcoming token-generating activities

* Learning from Alumni, Tomorrow, 2pm, Xinya Yang '20
* Prof. Eliott's Coffee Chat in ELBICA lab (across from CS Learning Center)
  Fridays 5-6 p.m.
* Pioneer Weekend introductory talk, 7:00 p.m. Friday, October 1.
* Pioneer Weekend, October 1--3.

### Upcoming other activities

* Lunar New Year (unofficial) Celebration next weekend.

### Upcoming work

* [HW5](../assignments/assignment05) due Thursday night.  Implement
  AVL trees in Racket or Java.
* HW6 to be assigned Wednesday or Friday.

### Q&A

Where are my missing students?

> Too much vegetarian food.

Detour Bottom-up Merge Sort
---------------------------

Our normal recursive merge sort

```
define sort(stuff)
  s1 = sort(firsthalf(stuff))
  s2 = sort(secondhalf(stuff))
  return merge(s1,s2)
```

An alternate formulation

```
define sort(stuff)
  size = 1
  while (size < stuff.length) 
    merge neighboring blocks of size size into sorted blocks of size size*2
    size *= 2
  elihw
```

Let's try bottom-up merge sort

```
O L P H E B Q T I C N R S T I A
```

Size = 1

```
O L | P H | E B | Q T | I C | N R | S T | I A
L O | H P | B E | Q T | C I | N R | S T | A I
```

Now size = 2

```
H L O P | B E Q T | C I N R | A I S T
```

Now we have four sorted blocks of size 4

```
B E H L O P Q T | A C I I N R S T
```

Now we have two sorted blocks of size 8

And you can do the rest.

Advantages

* Iterative, not recursive
* Can be adapted in interesting ways (e.g., for TimSort)

Choosing sorting algorithms
---------------------------

Why do we learn so many sorting algorithms?

* Some of the inefficient ones are easier to develop/understand.
* Each algorithm teaches you different things about algorithm design.
* Having different algorithms allows us to compare them (by what criteria)?
* Different algorithms are better/worse for different kinds of data.

Although we often just use "the best sorting algorithm we know", if
we have additional knowledge about our data or expectations on the
algorithm, we might choose a different algorithm for the particular
situation.

### Data characteristics

TPS: _What issues might you consider about the data?_

* Are my data stored in a list or vector/array?
    * Are our data (or data structure) mutable or immutable
* The size of data we are dealing with
    * Small enough, it doesn't really matter we use.
    * Large data, we might want to find optimizations.  Large
      data generally implies we should pay attention to Big O
    * Large enough amounts of data won't fit in RAM.  Your algorithm's
      locality may actually matter.
* Are the data structured in any way?  (ints, strings, objects, etc.)
    * We may be able to take advantage of the structure.
* Is the list already partially sorted?
    * Some algorithms might work better with already sorted lists.
* Data variation (e.g., are all values distinct, do we have lots of
  repetitions)
    * For numbers, the range can be useful.  (are all twenty-digits
      long, or are some one-digit and others five-hundred)
* Are data the same size or do they vary in size?

### Algorithm characteristics

TPS: _What are some characteristics of algorithms we consider?_

Three big ones

* Stability
    * Stable sorting algorithms preserve the order of "equal" elements.
    * E.g., if sort you by first name, and then sort you by last
      name (stably), two people with the same last name will stil
      by in the correct order by first name.
    * Most of us want stable sorting algorithms
* Big-O running time.
* Big-O space usage.  (Constant, O(logn), O(n))

* Ease of implementation.
* Ability to parallelize.  Can we break the data up onto multiple
  computers/processors and run those parts simultaneously.
* Types of input they do better/worse on.
* Types you can work with.
* Real-world running time based on operations.

### Language issues

* Sctrings in C can be problematic (although they are really pointers,
  so ...)

### Algorithms

TPS: _Which of those characteristics do you associate with each
of the following core algorithms?_  Assume arrays.

S
E
NW
NE

**Insertion Sort**

* Running time (Big-O): O(n^2)
* Space usage (Big-O): O(1)
* Stability?: Can be made stable
* Special inputs it works well on: Lists with identical elements;
  mostly sorted lists.  If no more than k elements are out of order,
  it's an O(kn) algorithm!
* Ranking:

**Selection Sort**

Traditional in-place implementation:

```
indexofSmallest(array, start)
  gives the index of the smallest value in the subarray starting at start

sort(stuff)
  for i from 0 to stuff.length-1
    swap(stuff, i, indexofSmallest(stuff, i))
```

* Running time (Big-O): O(n^2) 
    * Finding the smallest takes O(n)
    * We do it n times.
    * n + n-1 + n-2 + n-3 + ... in O(n^2)
* Space usage (Big-O): O(1)
* Stability?: Not the traditional one
* Special inputs it works well on: Probably not
* Ranking:

The traditional selection sort is not stable.  Consider

```
+---+---+---+---+---+
| 5a| 2 | 3 | 5b| 1 |
+---+---+---+---+---+
```

So sad.  We can make it stable by sorting into a new array, rather
than swawpping.

**Merge Sort (recusive, top-down)**

* Running time (Big-O): O(nlogn)
* Space usage (Big-O): O(n)
* Stability?: Stable
* Special inputs it works well on:
* Ranking:

**Merge Sort (iterative, bottom-up)**

* Running time (Big-O):
* Space usage (Big-O):
* Stability?:
* Special inputs it works well on:
* Ranking:

**Quick Sort**

* Running time (Big-O): O(nlogn) if we choose the median well;
  O(n^2) if we don't choose the median well.  (In practice, 
  with randomized median, it behavies like an O(nlogn) algorithm.)
* Space usage (Big-O): O(logn) - for the (hidden) stack
* Stability?: Nope
* Special inputs it works well on:
* Ranking:

**Heap Sort**

* Running time (Big-O):
* Space usage (Big-O):
* Stability?:
* Special inputs it works well on:
* Ranking:

_It is sad that Sam remains bad at estimating time, even after thirty
years of teaching._

Sorting in practice
-------------------

* We have lots of O(nlogn) algorithms.
* So which one should languages that provide a `sort` method use as 
  their default sorting algorithm?
* And which one do most languages use as their built-in sorting algorithm?

Sorting bounds
--------------

None of the sorting algorithms we traditionally use is better than
O(nlogn).

As an algorithm designer, you should have two followup thoughts

* Can I do better?  (Perhaps by restricting the input.)
* Can I prove that I can't do better?  (Perhaps by characterizing the
  basic algorithm approach.)

We'll do both, as strange as that is.  Better algorithms will be
tomorrow.  We'll start the theorem today.

### A lower bound on sorting algorithms

Theorem: All comparison-based algorithms have inputs that require
Omega(nlogn) running time.

Proof?  You get to consider how to approach it.

* How can we represent a comparison-based sorting algorithm?
* What proof techniques do we know?

### One proof on the lower bound
