---
title: "EBoard 18: More Prep for Assignment 6"
number: 18
section: eboards
held: 2021-10-06
link: true
---
# {{ page.title }}

_Approximate overview_

* Admin
* Modifying recursive merge sort
* Writing merge sort iteratively
* Other notes on the assignment
* Dictionaries

Administrative stuff
--------------------

* Report from Dean: 2/3 of students are experiencing significant stress.
    * More than normal for this point of the semester.
    * It's fine if you're part of the 1/3.
    * If you're part of the 2/3, you're not alone.
* It would be nice to have more folks there for LFA.  This week's was
  also great.
* If the SEPC contacts you for an interview, please participate.
* Quicksort can be made stable (stabilized?) by using helper arrays.
  Instead of partitioning in place, you put smaller and larger values
  into the helper arrays.

### Upcoming token-generating activities

* Convo Thursday: Profs. John Garrison and Dustin Dixon
* CS Extras 4pm Thursday: CLS
* Prof. Eliott's Coffee Chat in ELBICA lab (across from CS Learning Center)
  some Fridays 5-6 p.m. 
* Arcadia, October 8--10. (7 p.m. Friday and Saturday, 2 p.m. Sunday.)
  (I think.)
    * Theatre.  Show by Tom Stoppard.  Mathy.
    * Ticketing Wednesday
* Vegan Potluck, Saturday at 7pm
* Participate in SEPC interview about faculty under review.

### Upcoming other activities

### Upcoming work

* [HW5](../assignments/assignment05) due Thursday night.  Implement
  AVL trees in Racket or Java.
* [HW6](../assignments/assignment06) due next Thursday.  
    * Implement the best stable sorting algorithm you can.  (Within
      time reason.)  Make sure to include comments to explain what
      you did.
    * Implement radix sort for strings of up to eight letters.
    * Implement a hybrid bucket sort for strings, bucketing
      on the first two characters and then sorting with whatever
      sorting algorithm you choose.
    * We'll continue to look at parts in class today.

Today's code

* Find the code in either [examples/sorting](../examples/sorting/) or
  [sort.tar](../examples/sort.tar).
* Our merge sort was correct, other than my mis-typing the parameter.
* I fixed the random stuff.

### Some questions

Why do you have non-inclusive upper-bounds for procedures that
take a range?

> Long-standing experience suggests I make fewer off-by-one errors
  when I do so.

> The Scheme procedures I use regularly, like `substring`, use that
  policy.

> The policy works well with passing in the length of something.
  I'd rather type `subsort (stuff, 0, len)` than 
  `subsort (stuff, 0, len-1)`.  
  (See prior note about off-by-one errors.)

> The policy works well for many divide-and-conquer array
  algorithms.  `recurse (stuff, lb, mid); recurse (stuff, mid, ub);`
  (See prior note about off-by-one errors.)

What is going on with `rms_kernel(strings+halfsize, len-halfsize, scratch);`?

> It's the joy of C!  `strings` is a pointer (an array of `char *`s).  
  Hence `strings+halfsize` is also a pointer.  In this case, it gives
  us the slice of the array starting at `strings[halfsize]`.

> `pointer + x` advances a pointer over `x` things and gives you the
  new thing it points to.

We are going to use insertion sort if the input size is small and
merge sort if the input is large.  But the time complexity of merge
sort is better.

> Suppose merge sort is `1000*nlogn` and insertion sort is `5*n*n`.
  If `n` is 5, merge sort will take about 10,000 steps, insertion
  sort will take 125 steps.  Which would you prefer?  Moral one:
  The multiplier matters.

> Suppose we call merge sort on { 0, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1 }.
  Merge sort doesn't take advantage of the ordering.  However, insertion
  sort will only need to shove the 1 left, doing only O(n) work.

Is Tim Sort broken?

> The original Tim Sort used a stack for saved computations.  It made 
  incorrect assumptions on the size of that stack.  If you overflowed
  that stack, it broke.

> Most implementations of Tim Sort have fixed that issue by increasing
  the size of the stack, either statically or dynamically.

> You need not understand Tim Sort to do this assignment.

Modifying recursive merge sort
------------------------------

* Make it iterative
    * Using the traditional iterative merge sort algorithm.
        * [Coming up]
    * Managing the stack ourselves.
        * [A lot of work]
* Rewrite the merge algorithm
    * [Out of scope]
* Split into parts 
    * [Might flatten]
* Use insertion sort for small enough arrays

Writing merge sort iteratively
------------------------------

Basic idea: 

* Merge neighboring blocks of size 1 to create sorted blocks of size 2.  
* Merge neighboring blocks of size 2 to create sorted blocks of size 4.
* Merge neighboring blocks of size 4 to create sorted blocks of size 8.
* ...

Complexities:

* Sometimes there's no right block to merge.
* Sometimes the right block is smaller than the left block.

Basic framework

```
  for (int size = 1; size < ???; size += size)
    {
      for (int pos = 0; pos < ???; pos += ???)
        {
          if (???)
            {
              merge (strs, ???, ???, ???);
            }
        } // for
    } // for size
```

If you use iterative merge sort, I might start size at 32 or more,
and first insertion sort on each block of size 32.

Other notes on the assignment
-----------------------------

### Goals for YouSort

* Open-ended algorithm experimentation / design!
    * Not quite traditional "research", but it's close.
* Try not to spend more than an hour or two on this.

### Goals for radix sort

* Prove to me that you can write a radix sort.
* First order by rightmost character (character 7)
* Then by the next character to the left (character 6)
* ...
* Then by the first character.
* I would use 27 arrays.
* `ithchar` will give you the ith character in a string.
* Goal: < 3 hours

### Goals for bucket sort

* Prove to me that you can write a bucket sort.
* (26+1)\*(26+1) buckets
* Put each word in the appropriate bucket.
* Sort the buckets.
* Put them back together.
* Goal: < 3 hours
