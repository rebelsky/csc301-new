---
title: "EBoard 20: Program verification and loop invariants (1)"
number: 20
section: eboards
held: 2021-10-11
link: true
---
# {{ page.title }}

_Approximate overview_

* Admin
* Goals for the unit
* Verifying imperative code
* Detour: Some problems with state
* Detour: Binary search
* Loop invariants
* Extended example: Binary search
* Extended example: A variant of binary search (if time)

Administrative stuff
--------------------

* Happy rainy Monday, if such a thing is possible.
* Colds are going around campus; if you're using a MathLAN workstation,
  make sure to use one of the keyboard/mouse wipes.
* If you're going to miss class, please DM me or drop me an email.

### Upcoming token-generating activities

* Learning from CS Alumni, 2pm, Tuesday, 3821.

### Upcoming other activities

* Women's Soccer, Tuesday, 4:30 pm
* Men's Soccer, Wednesday, 4:30 pm
* Volleyball, Wednesday, 7:00 pm
* Scarlet and Black Meet this coming weekend.

### Upcoming work

* [HW6](../assignments/assignment06) due Thursday.
    * Sam will eventually post a place on Gradescope.

### Q&A

Why did you point out the strange output in a student's HW6?

> Here's what the student submitted as times.

        round,size,insertion,rms,bucket-sort-1,bucket-sort-2,radix-sort,mysort
        r000,2000,8615,311,320,3066,5433,271
        r001,2000,7477,299,290,5360,2662,118
        r002,2000,9162,342,286,3678,20936,175
        r003,2000,15612,7212,391,12442,3816,202
        r004,2000,24189,337,368,5816,4448,206
        r005,2000,10127,353,336,16125,7496,219
        r006,2000,20656,364,373,7828,4612,196
        r007,2000,15277,1258,4806,10338,34602,353
        r008,2000,22096,41912,14551,6007,3430,186
        r009,2000,11505,333,329,7208,5642,119

> When you see data like this, you should be asking "why"?

> Form hypotheses: (1) There are some inputs for which these procedures are
  really slow.  (2) My CPU was spending time on other processes for a bit, which
  slowed things down.  (3) There is a ghost in my computer that doesn't like me.
  (4) Allocating 10GB with repeated calls to `malloc(1)` is not a good idea.:w

> Graphing helps us form hypotheses.

> Perhaps gather more data.  Maybe run 100 trials rather than 10.  Maybe gather
  the input data (in a file) and re-run to see if you get similar times.

Goals for this unit
-------------------

This unit is "Program Verification and Loop Invariants"

* Think about / practice a common technique for "proving" that a program
  or algorithm is correct. 
    * Make PM happy.
* Practice thinking about the "state" of an imperative program.
    * Values associated with local variables (and parameters).
    * Values associated with global variables.
    * The "stuff" on the stack.
    * The "stuff" on the heap.
* Use program verification techniques to improve your algorithm and
  program design.

Verifying imperative code
-------------------------

* Basic approach: Annotate the code with your knowledge about the
  state of the system (mostly the values of variables) throughout
  the program.
* Ideally, you reach a state in which you know that you've achieved
  the goal of your program or procedure.
* It should be provable that each instruction brings you from one
  state to the next state.

### What's in program state?

* Settings or characteristics of variables  `x = 5`, `x is positive`, `x > y`
* For arrays, potentially characteristics of part or all of the array.
  All the elements in A[x..y] are less than the elements in A[y+1..z].

### Example: An assignment statement

#### No prior knowledge

```
{ }
x := 5;
{ x = 5 }
```

#### Prior knowledge about other variables

```
{ y < 6 }
x := 5
{ x = 5, y < 6 }
```

#### Helpful side node from a smart student

* "We also know x-y is non-negative, provided x and y are integers."
* Identifying these characteristics is a lot like figuring out the next
  step in a proof.

#### Prior knowledge about `x`

```
{ x > y }
x := 5;
{ x = 5 }
```

* We sometimes eliminate some of the prior state knowledge

### Example: A conditional statement

```
{ S1 }
if (TEST) then
  { S1, TEST holds }
  CONSEQUENT;
  { S2 }
else 
  { S1, TEST does not hold }
  ALTERNATE;
  { S3 }
fi
{ S2 or S3 }  OR { S2 intersect S3 }
```

Side note: You try to ensure that that intersection is non-empty and useful.

### Example: A procedure call

```
{ vals contains one copy each of 6, 1, 3, 2, 5 }
sort(vals);
{ vals is sorted and vals contains one copy each of 6, 1, 3, 2, 5 }
{ combined: vals is [1, 2, 3, 5, 6] }
```

### Example: Loops

```
{ S1 }
while (TEST) do
  { S1, TEST }
  BODY
  { S2 }
done
{ !TEST and not much else }
```

So, we often try to write

```
{ S1 }
while (TEST) do
  { S1, TEST }
  BODY
  { S1 }
done
{ !TEST and S1 }
```

Here's an example where the same S1 represents an increase in knowledge

```
{ A is sorted in positions 0 through i }
while (i < n) do
  { A is sorted in positions 0 through i, i < n }
  BODY
  i += 1
  { A is sorted in positions 0 through i }
done
{ A is sorted in positions 0 through i and i = n }
{ A is sorted in positions 0 through n }
```

We've "proven" that our sorting algorithm is correct, provided it keeps S1 true
at the end of each loop.


Detour: Some dangers
--------------------

Ideally, we should be able to 
```
// { x = 5 }
printf ("%d\n", x); // 5 
// { x = 5 }
foo(y);
// { postconditions of y; ??? }
printf ("%d\n", x); // 6
```

Why might this have happened?

* `x` may be a global variable that gets referenced in `foo`
* `y` may be a pointer to x.  e.g., `void foo(int *y) { *y = 6; }`
* We may have other pointers to x; e.g., `int *z = &x; ...; void foo(int y) { *z = y; }`
* Stack overflow!  We may accidentally overwrite memory.

Most of the time, we'll pretend we're working in a language where none of this happens.
Good programming strategies (e.g., no globals, care with pointers) helps.

Detour: Binary search
---------------------

Write an iterative binary search in C.  You may not do Sam-like things,
such as adding to pointers.  No helper procedures!

```
/**
 * Return an index of val in vals.  If val does not
 * appear in vals, returns -1.
 *
 * @pre: vals is sorted in non-decreasing order.
 */
int
binary_search (int val, int vals[], int n)
{
} // binary_search
```

See [examples/binary-search](../examples/binary-search/) for the
Makefile and test code.

Please record your first set of results (inputs you got wrong, how
many tests you failed, whether it ran forever).

* Passed all the tests [1]
* Ran forever; yay infinite loops [4]
* Failed on some inputs [2]
* Crashed [ ]

You can then revise as you consider appropriate.

### Side notes

* "Video game coding" is probably not the best strategy if you want reliable code.
* Running your code *by hand* on some inputs is likely to be useful.
* Tests help you identify some inputs to run by hand.  However, it's nice to pass
  all of our tests the first time through!

### The Google and Java Story

* There's a famous article by Jon Bentley on binary search.  
    * You should write giant test suites.
    * You should use program verification techniques to try to write correct
      algorithms from the get go.  Care helps you avoid those evil off-by-one errors.
* Bentley provided a "provably correct" version of binary search.
* The binary search in Java was closely based on Bentley's version.
* Then Google used it.  And, um, it crashed.
* Because of this calculation `mid = (lb + ub)/2;`
* If you have a really large array, you might overflow integers with the addition!
  (Java uses 2's complement.)  When you overflow addition, you get a negative number.
* We need to compute it differently: `lb + (ub-lb)/2;`

Loop invariants
---------------

Idea: We look for states for which

* We can show they hold before the loop begins
* We can show that hold at the end of the body if they hold at the start
  of the body
* Provide useful information about the state of the system, related to
  the goals of the loop.

These are "loop invariants".

* If we can show that the loop terminates, termination plus the loop
  invariant often gives us something useful.

Extended Example: Binary Search
-------------------------------

### Overview

I0: If val is in the array, then it's in the subarray [lb..ub).

```
{ I0 }
while (lb < ub)
  { I0 and (lb < ub) }
  CODE
  { I0 }
end while
{ I0 and (lb >= ub) }
{ Whoops!  It's not in the array. }
```

Problems: (a) Maintaining the invariant (I0) and (b) ensuring that the loop
terminates.

Stay tuned for the next class.

### Details

Extended example, revisited
---------------------------

What if, instead of *any* index, we want the *first* index?  (And we want
the search to remain O(logn).)
