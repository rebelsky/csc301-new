---
title: "EBoard 09: Recurrence Relations, Continued"
number: 9
section: eboards
held: 2021-09-15
link: true
---
# {{ page.title }}

_Approximate overview_

* Admin
* A bit more practice solving recurrence relations
* Discussion
* The Recurrence Formula Theorem

Administrative stuff
--------------------

* Warning!  I'm attending/supporting the Tapia Conference this week,
  and so will be even more split than normal.
* Advance notice: Prof. Eikmeier will be teaching balanced trees on
  Monday and Wednesday next week.

### Upcoming token-generating activities

* Football, 1pm (2pm?), Saturday
* Grinnell Vegans Potluck, Friday, 7pm.  Location TBD.

### Upcoming other activities

### Upcoming work

* [Assignment 3](../assignments/assignment03) due Thursday.
* Read Chapter 4 for Friday.
* Assignment 4 will be released on Friday.

### Q&A

Why doesn't my code work?

> Most common error: When you've finished partitioning, the system
  state should be something like ...

```
      s        e,l    
      |        | 
+--+--+--+--+--+--+--+--+--+--+--+
|E |S |E |E |E |L |L |L |L |L |L |
+--+--+--+--+--+--+--+--+--+--+--+
```

> Here's what some people write.  `swap (--s, --e)`

> Since the pivot is equal, we want to put something small where
  the pivot was and the pivot at the start of the equal section.

> We want `swap (0, --s)`, at least if this is our system state.

```
   s           e,l    
   |           | 
+--+--+--+--+--+--+--+--+--+--+--+
|S |E |E |E |E |L |L |L |L |L |L |
+--+--+--+--+--+--+--+--+--+--+--+
```
> Worry: What if there were no small elements?

```
   s        e,l    
   |        | 
+--+--+--+--+--+--+--+--+--+--+--+
|E |E |E |E |L |L |L |L |L |L |L |
+--+--+--+--+--+--+--+--+--+--+--+
```

> `--s` is 0.  We end up swapping 0 and 0.

```
s           e,l    
|           | 
+--+--+--+--+--+--+--+--+--+--+--+
|E |E |E |E |L |L |L |L |L |L |L |
+--+--+--+--+--+--+--+--+--+--+--+
```

Do you have recommendations on tracking segfaults?

> Use address sanitizer.

> Often: Compile and link with `-sanitize=address`
 
> Often: Use your debugger.

> Unfortunately: Addl code to print things out.

Thank you Sam for gaiving us a C assignment.  It's fund to beat our
heads against the wall trying to figure out memory errors?

> You're welcome.

More examples
-------------

You will be divided into four groups.  Each group will try a different
strategy on each problem.  You can assume T(1) = 1 unless it's more
convenient to assume T(1) = c or T(0) = c.

### T(n) = T(n/2) + n

* Group 1: Bottom-up
* Group 2: Tree
* Group 3: Top-down
* Group 4: Top-down

### T(n) = T(n/2) + c; T(1) = c

* Group 1: Tree
* Group 2: Top-down
* Group 3: Bottom-up
    * T(1) = c
    * T(2) = T(2/2) + c = T(1) + c = c + c = 2c
    * T(4) = T(4/2) + c = T(2) + c = 2c + c = 3c
    * T(8) = T(8/2) + c = T(4) + c = 3c + c = 4c
    * T(16) = T(16/2) + c = T(8) + c = 4c + c = 5c
    * Hypothesis: T(2^k) = (k+1)\*c
    * Let k =  log2n
    * T(n) = (log2n+1)\*c in O(log2n)
    * If we said T(1) = d.  d + logn\*c in O(log2n)
    * Mostly, when we're adding constants, we can play with what
      constant it is.  (This doesn't hold for multiplying.)
* Group 4: Bottom-up

### T(n) = T(n-1) + c; T(1) = c

* Group 1: Top-down
    * T(n) = T(n-1) + c
    * T(n) = T(n-1-1) + c + c = T(n-2) + c + c = T(n-2) + 2c
    * T(n) = T(n-2-1) + c + 2c = T(n-3) + c + 2c = T(n-3) + 3c
    * T(n) = T(n-4) + c + 3c = T(n-4) + 4c
    * Hypothesis: T(n) = T(n-m) + mc
    * Let m = n-1.
    * T(n) = T(n-(n-1)) + (n-1)c = T(1) + (n-1)c = c + (n-1)c = cn in O(n)
* Group 2: Bottom-up
* Group 3: Tree
* Group 4: Tree

### Detour: Quick debrief

* Our strategies generally give the same answer (details and big-Oh)
* Which do you prefer using and why?
     * Top down: 
         * Less possibility for error in math
         * Others have more possibility
     * Bottom up
         * Concrete examples are nice
         * Easier to think about things this way.
     * Trees
         * Give me the things I like about top-down, but fewer errors
         * "Wow, that's a lot to draw."
* Sam's experience is that when doesn't work for you, try another.

### T(n) = 2\*T(n/2) + n + c

* Group 1: Bottom-up
* Group 2: Tree
* Group 3: Top-down
* Group 4: Top-down
    * T(n) = 2T(n/2) + n + c
    * T(n) = 2(2T(n/4) + n/2 + c) + n + c
    * T(n) = 4T(n/4) + n + 2c + n + c 
    * T(n) = **4T(n/4) + 2n + 3c** ; hmmm
    * T(n) = 4(2T(n/8) + n/4 + c) + 2n + 3c
    * T(n) = 8T(n/8) + n + 4c + 2n + 3c
    * T(n) = **8T(n/8) + 3n + 7c** ; hmmm
    * T(n) = 8(2T(n/16) + n/8 + c) + 3n + 7c
    * T(n) = 16T(n/16) + n + 8c + 3n + 7c
    * T(n) = **16T(n/16) + 4n + 15c** ; hmmm
    * T(n) is in O(nlog2n)

### T(n) = 3\*T(n/4) + n is in O(n)

* Group 1: Tree
* Group 2: Top-down
* Group 3: Bottom-up
* Group 4: Bottom-up

### T(n) = 3\*T(n/2) + n

* Group 1: Top-down
* Group 2: Bottom-up
* Group 3: Tree
* Group 4: Tree
* ???

### T(n) = 2\*T(n/2) + nlog2n

* Group 1: Bottom-up
* Group 2: Tree
* Group 3: Top-down
* Group 4: Top-down

Discussion
----------

The Recurrence Relation Formula Theorem
---------------------------------------

* A general way to express T(n) <= a\*T(n/b) + O(n^d)
* _I don't know why c doesn't appeaer._
* We want to have a formula for the value of T(n).  As you'd expect,
  it depends on a, b, and d.
* There are three basic possibilities.
    * Case 1: T(n) is in O((n^d) logn) if a = b^d
    * Case 2: T(n) is in O(n^d) if a < b^d
    * Case 3: T(n) Is in O(n^(logb(a))) if a > b^d
* Does this match our analyses above?
* 

