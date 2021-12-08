---
title: "EBoard 17: Prep for Assignment 6"
number: 17
section: eboards
held: 2021-10-04
link: true
---
# {{ page.title }}

_Approximate overview_

* Admin
* On code-writing velocity
* Code review
* Writing merge
* Writing merge sort recursively
* Modifying recursive merge sort
* Writing merge sort iteratively
* Other notes on the assignment

Administrative stuff
--------------------

* Did anyone make it to Uncle Bill's?

### Upcoming token-generating activities

* Learning from CS Alumni, 2pm, Tuesday, 3821.
* Convo Thursday: Profs. John Garrison and Dustin Dixon
* CS Extras 4pm Thursday: CLS
* Prof. Eliott's Coffee Chat in ELBICA lab (across from CS Learning Center)
  some Fridays 5-6 p.m. 
* Arcadia, October 8--10. (7 p.m. Friday and Saturday, 2 p.m. Sunday.)
  (I think.)
    * Theatre.  Show by Tom Stoppard.  Mathy.
    * Ticketing Wednesday
* Vegan Potluck, Saturday at 7pm

### Upcoming other activities

### Upcoming work

* [HW5](../assignments/assignment05) due Thursday night.  Implement
  AVL trees in Racket or Java.
* [HW6](../assignments/assignment06) partially out today.  Implement 
  the best stable sorting algorithm you can.  Implement radix sort
  for strings.  Implement a hybrid bucket sort for strings, bucketing
  on the first two characters. 
    * We'll look at parts in class today.
    * Sam still needs to write the linked lists.

### Q&A

On code-writing velocity
------------------------

On Friday, we discovered that together, we can write a working radix 
sort in 15 minutes.  That may have implications for how fast Sam thinks
you should be able to code.

Keep me posted on workload.  I'll work on extensions and keeping it 
moderate.

Assignment five is hard because ...

* Sam's code needs to be parsed.
* I have not yet mastered the idea of asking people for help.
* Knuth is hard to read.
    * Knuth expects you to have read/remembered everything, not just 
      skimmed.
* Sam expects recursive solutions; Knuth expects more iterative
  solutions.

But hard is good for you.  This is just harder than Sam expected.  Sam
is sorry.

Code review
-----------

Code is in [examples/sorting](../examples/sorting).

Your goal: Start to familiarize yourself with the code.

Some things to think about:

* How do you test a sorting routine?
  (Hint: look at `insertion-sort-tests.c`)
* What tests are run?
  (Hint: look at `sort-tester.c`)
* What should you do if you want to see all of the tests that are run?
* How does the `main` in `isort` work?
* How do we time a sorting routine?
  (Hint: look at `competition.c`)
* How would you add a new sorting routine to the mixture?

Also: What else don't you understand; what needs an explanation?
(You can't say *everything*.)

### Some questions

Why is Sam using `bcopy`?

> It's a faster way to copy arrays.

What is the `#ifdef TRACE` thing?

> It's a trick in C to turn sections of the code on and off.

What is `(*sort)`?

> We're passing around function pointers, which helps us write generic
  code.  `sort` is declared as a pointer to a function that takes (1) an
  array of strings and (2) an integer as parameters.

Is `isort.c` just a smart-alecky piece of code?

> I try to factor out common code.  I didn't completely succeed here,
  but I think I came close.

> I should have written

        #define MAIN(sorter) \
                int main(int argc, char *argv) { \
                   sorter (argv+1, argc); \
                   for (int i = 1; i < argc; i++) \
                     printf ("%s\n", argv[i]); \
                   return 0; }

> And then written `isort.c` as

        MAIN(insertion_sort)

Why `argv + 1`?

> The wonder of C.  That's "the array that starts at the first element of
  `argv`."

Why don't you use `srand` with the time of day?

> It's bad programming practice.  But I'll find something better
  than what I do.

### Writing a new sorting algorithm

* Add it to the list in `competition.c` (name plus pointer)
* Create a .h file and a .c file (with the appropriate code).
* Test it.  Pass it to that sort thing.
    * Copy test-insertion-sort.c, change, compile, run.
* Perhaps create an equivalent to `isort`
* Update the Makefile appropriately.  In particular, 
    * Create instructions for making the test.
    * Update the dependencies for `competition`.

Writing merge
-------------

Starting point for merge

``` 
    lb          mid     ub
    |           |       |
+---+---+---+---+---+---+---+---+
|   | a | e | i | b | q |   |   |
+---+---+---+---+---+---+---+---+
```

Originally, 

* The portion from [lb .. mid) is sorted in increasing alphabetical order,
* The portion from [mid .. ub) is sorted in increasing alphabetical order.

When we're done ...

* The portion from [lb .. ub) is sorted in inceasing alphabetical order.
* The portion from [lb .. ub) is a permutation of the original values in
  that subarray.

```
      a   b   e   i   q
```

To merge, using a helper array, we ...

* keep a index in each subarray
* compare the elements at each index
* whichever is smaller we copy to the scratch array and advance the
  corresponding indices.
* Stop when we run out of one subarray.
* Copy the other subarray.

```
  lb    p1     mid    p2     ub
  |  A  |   B   |  C  |  D   |
ORIGINAL

  0     p
  | A+C |
    sorted
SCRATCH
```

Midway through the algorithm, what's in the scratch array?

* The elements from lb to p1 in the first array
* Also the elements from mid to p2 in the first array
* Those elements are all in order.


Writing merge sort recursively
------------------------------

Modifying recursive merge sort
------------------------------

Writing merge sort iteratively
------------------------------

Other notes on the assignment
-----------------------------
