---
title: "EBoard 07: Analyzing recursive algorithms"
number: 7
section: eboards
held: 2021-09-10
link: true
---
# {{ page.title }}

_Approximate overview_

* Admin
* Recurrence relations
* Three techniques for solving recurrence relations by hand
* Practice
* Discussion (if time)

Administrative stuff
--------------------

* When you ask questions on Teams, it's nice to give your question a subject
  so that others can more easily find it.
    * I will (attempt to) demo.
* I've done something to my foot, so I will mostly be sitting today.
* In helping folks, I've seen some struggles with various issues in
  math, including notation, proofs, and induction.
    * Please ask!
    * We'll need practice.  We may use mentor sessions, we may use
      class time.
* I will attempt assignment 3 this weekend (perhaps even this evening)
  and let you know how long it takes me.  
    * N hours for Sam is 4\*N hours for students.
    * If it's an eight-hour assignment for students, Sam should spend 8/4.
    * If either half takes Sam significantly more than an hour, we'll see
      about changing the assignment.
* Some questions for looking ahead:
    * How many of you have seen loop invariants? [0]
    * How many of you have implemented hash tables? [Everyone; it's just fuzzy.]
    * How many of you know what I mean when I say `Dictionary` or `Map`?
    * Who wants to revisit Hash Tables in CSC-301? [0]

### Friday PSA

* Moderation in everything (except perhaps sleep)
* Consent is essential
* Mask

### Upcoming token-generating activities

* CS meet and greet, 4pm today.
* Theatre and Dance Mixer tonight

### Upcoming other activities

* Cross-country meet this weekend
* Elephantitis - Ultimate tournament
* Org Fair - Tomorrow

### Upcoming work

* [Assignment 3](../assignments/assignment03) due next Thursday.
    * It may change, but it's still good to spend some time thinking
      about it over the weekend.
* No reading for Monday!

### Q&A

Will there be regular readings?

> The goal is that you do the readings on a topic *after* we cover the topic.

Can you work through the in-place swapping for question 1?

> I can try.  We need an array.  Here goes.

```
  0   1   2   3   4   5   6   7   8   9   10
+---+---+---+---+---+---+---+---+---+---+---+
| B | G | C | C | E | Z | D | A | Q | C | A |   
+---+---+---+---+---+---+---+---+---+---+---+
```

> There are two ways to rearrange the array.  We can split it into
  two parts (<= pivot; > pivot) or into three parts (< pivot, = pivot,
  > pivot).

> The assignment asks for the second.

> I need a model of the array.  I have four parts
  (ignoring the pivot).  The stuff < pivot, the stuff
  equal to the pivot, the stuff > pivot, the stuff I
  haven't looked at yet.

```
    s           e       i           l
    |  smaller  | equal | unknown   | larger
+---+---+---+---+---+---+---+---+---+---+---+
|   |   |   |   |   |   |   |   |   |   |   |   
+---+---+---+---+---+---+---+---+---+---+---+
```

> I need names for all of those.  
  `s` marks the start of the values I know are
  smaller, `e` marks the start of the values I know are equal,
  `i` marks the start of the unprocessed values, `l` marks the
  start of the values I know are larger.

> Initially, we're going to put the pivot at the beginning of
  the array (or subarray).  We'll need to swap it to the correct
  place later.

```
  0   1   2   3   4   5   6   7   8   9   10
+---+---+---+---+---+---+---+---+---+---+---+
| C | G | C | C | E | Z | D | A | Q | B | A |   
+---+---+---+---+---+---+---+---+---+---+---+
```

> Let's initialize all of our variables.

```
  s,e,i                                     l
  0 | 1   2   3   4   5   6   7   8   9   10|
+---+---+---+---+---+---+---+---+---+---+---+
| C | G | C | C | E | Z | D | A | Q | B | A |   
+---+---+---+---+---+---+---+---+---+---+---+
```

> Key idea is to look at each value in turn,
  swapping things around as necessary, and
  maintaining those three barriers.

> `i` will allow us to do that.

> Look at the thing at position `i`.  It's `G`

> It's greater than the pivot (`C`).

> So we want to put it at the end.  We swap A and G.  
  And we can reduce `l`

```
  s,e,i                                 l    
  0 | 1   2   3   4   5   6   7   8   9 | 10 
+---+---+---+---+---+---+---+---+---+---+---+
| C | A | C | C | E | Z | D | A | Q | B | G |   
+---+---+---+---+---+---+---+---+---+---+---+
```

> We look at the thing at position `i` again.  We see an `A`, which
  is smaller than the pivot.  We increment `e` and `i`.

```
    s   e,i                             l    
  0 | 1 | 2   3   4   5   6   7   8   9 | 10 
+---+---+---+---+---+---+---+---+---+---+---+
| C | A | C | C | E | Z | D | A | Q | B | G |   
+---+---+---+---+---+---+---+---+---+---+---+
```

> We look at the thing at position `i` again.  We see a `C`, which
  is equal to the pivot.  We increment `i` by one.

```
    s   e   i                           l    
  0 | 1 | 2 | 3   4   5   6   7   8   9 | 10 
+---+---+---+---+---+---+---+---+---+---+---+
| C | A | C | C | E | Z | D | A | Q | B | G |   
+---+---+---+---+---+---+---+---+---+---+---+
```

> The next thing is C, so we do the same thing again (i.e., increment `i`).

```
    s   e       i                       l    
  0 | 1 | 2   3 | 4   5   6   7   8   9 | 10 
+---+---+---+---+---+---+---+---+---+---+---+
| C | A | C | C | E | Z | D | A | Q | B | G |   
+---+---+---+---+---+---+---+---+---+---+---+
```

> The next thing is `E`, which is larger.  Swap to the end and
  decrement `l`.

```
    s   e       i                   l        
  0 | 1 | 2   3 | 4   5   6   7   8 | 9   10 
+---+---+---+---+---+---+---+---+---+---+---+
| C | A | C | C | B | Z | D | A | Q | E | G |   
+---+---+---+---+---+---+---+---+---+---+---+
```

> The next thing is `B`.  This looks hard.  What should we do to
  maintain all of our goals.  Swap with the first C and increment e.
  Also increment i, since we know that we have an equal thing at position
  i.

```
    s       e       i               l        
  0 | 1   2 | 3   4 | 5   6   7   8 | 9   10 
+---+---+---+---+---+---+---+---+---+---+---+
| C | A | B | C | C | Z | D | A | Q | E | G |   
+---+---+---+---+---+---+---+---+---+---+---+
```

> The next thing is `Z` which is large.  Swap into position 8 and
  decrement `l`.  `swap (i, --l);` in C.

```
    s       e       i           l            
  0 | 1   2 | 3   4 | 5   6   7 | 8   9   10 
+---+---+---+---+---+---+---+---+---+---+---+
| C | A | B | C | C | Q | D | A | Z | E | G |   
+---+---+---+---+---+---+---+---+---+---+---+
```

> The next thing is `Q`, which is also large.  Swap

```
    s       e       i       l                
  0 | 1   2 | 3   4 | 5   6 |     8   9   10 
+---+---+---+---+---+---+---+---+---+---+---+
| C | A | B | C | C | A | D | Q | Z | E | G |   
+---+---+---+---+---+---+---+---+---+---+---+
```

> The next thing is `A`, which is small.  Swap position `i` with position
  `e` and then increment e and i. `swap(e++, i++);`

```
    s           e       i   l                
  0 | 1   2   3 | 4   5 | 6 | 7   8   9   10 
+---+---+---+---+---+---+---+---+---+---+---+
| C | A | B | A | C | C | D | Q | Z | E | G |   
+---+---+---+---+---+---+---+---+---+---+---+
```

> The next thing is `D`, which is large.  Decrement `l` and swap with `i`

```
    s           e       i,l                 
  0 | 1   2   3 | 4   5 | 6   7   8   9   10 
+---+---+---+---+---+---+---+---+---+---+---+
| C | A | B | A | C | C | D | Q | Z | E | G |   
+---+---+---+---+---+---+---+---+---+---+---+
```

> There are no unknown/unprocessed elements left.  We're almost done.
  Swap the thing at position 0 with the thing at position e-1 and decrement
  both s and e.  `swap(--s, --e)`.

```
s           e           i,l                 
| 0   1   2 | 3   4   5 | 6   7   8   9   10 
+---+---+---+---+---+---+---+---+---+---+---+
| A | A | B | C | C | C | D | Q | Z | E | G |   
+---+---+---+---+---+---+---+---+---+---+---+
```

> Now we're ready for the next step.

> Congratulations, you've now solved the Dutch National Flag problem.

> Your goal is to turn that algorithm into code.

Recurrence relations
--------------------

While you are used to loop counting for iterative algorithms, recursive
algorithms generally require a different strategy.

1. We define a function, T(n), that represents the running time on 
   inputs of size n.  (We might also define M(n) for the memory
   usage, although that's usually not as complicated to determine.)

2. We write a recursive formulation of T(n) based on the behavior
   of the algorithm.  For examples, I might say that because
   merge sort requires two recursive calls on half the size plus
   about n work to merge, T(n) <= 2\*T(n/2) + n.  I also know that
   T(1) = 1.  Does it matter whether we use n or cn?  We'll see.

3. We attempt to convert that relation to a "fixed form" that does not
   involve recursion.  There are many ways to do so.
 
Some common (or otherwise interesting) recurrence relations, not 
necessarily in order.

* T(n) <= T(n/2) + n
* T(n) <= T(n/2) + c
* T(n) <= T(n/2) + n + c
* T(n) <= T(n-1) + n
* T(n) <= T(n-1) + c
* T(n) <= T(n-1) + c + n
* T(n) <= 2\*T(n/2) + n
* T(n) <= 2\*T(n/2) + c
* T(n) <= 2\*T(n/2) + n + c
* T(n) <= 7\*T(n/8) + n ; Matrix multiplication

Techniques for solving recurrence relations
-------------------------------------------

There are five main techniques people use when they encounter a
recurrence relation.

* Compute T(2), T(4), T(8) (or whatever a reasonable sequence is)
  and see if you can identify a pattern.  "Bottom up".
* Repeatedly expand the right side of T(n) and see if there's a pattern.
  "Top down".
* Draw a tree, count the cost at each level and then add 'em up.
* Rely on a reference that lists all the common patterns.
* Use a formula.

We'll look at the first three today and the last one next class.

Example one: The Merge Sort Recurrence
--------------------------------------

* T(n) = 2\*T(n/2) + n
* T(1) = 1

### Bottom-up

* T(1) <= 1
* T(2) <= 2\*T(1) + 2 <= 2\*1 + 2 = 2\*2 = 4 = (2 \* 2)
* T(4) <= 2\*T(2) + 4 <= 2\*4 + 4 = 3\*4 = 12 = (4 \* 3)
* T(8) <= 2\*T(4) + 8 <= 2\*12 + 8 = 32 = (8 \* 4)
* T(16) = 2\*T(8) + 16 <= 2\*32 + 16 = 80  = (16 \* 5)
* T(32) = 2\*T(16) + 32 = 2\*80 + 32 = 192 = (32 \* 6)

Is there a pattern?

* T(2^k) = 2^k * (k+1)
* If n is 2^k, k is log2n
* T(n) = n * (log2n + 1) = n\*log2n + n = O(nlog2n)

### Top-down

* T(n) = 2\*T(n/2) + n 
* = 2\*(2\*T(n/4) + n/2) + n ; by def'n of T
* = 4\*T(n/4) + n + n ; Distribute
* = 4\*T(n/4) + 2n ; Simplify
* = 4\*(2\*T(n/8) + n/4) + 2n ; by def'n of T
* = 8\*T(n/8) + n + 2n ; Distribute
* = 8\*T(n/8) + 3n ; simplify
* Predict: 16\*T(n/16) + 4n

Pattern: T(n) is (2^k)\*T(n/(2^k)) + kn

Let 2^k = n (k = log2n)

Pattern: T(n) is n\*T(1) + (log2n)n

We know T(1) is 1

So T(n) is n + n(log2n) which is in O(nlog2n)

### Tree

_See whiteboard._

In this case, there are log2(n) levels in the tree, each of which has
a cost of n, so we can see that it's O(nlog2n).

### Detour

Do we have to prove our results?

> We could, probably using induction.

> But we won't.  I care more that you can do the informal analysis.

More examples
-------------

You will be divided into four groups.  Each group will try a different
strategy on each problem.  You can assume T(1) = 1 unless it's more
convenient to assume T(1) = c or T(0) = c.

### T(n) = 2\*T(n/2) + c

* Group 1: Top-down
* Group 2: Bottom-up
* Group 3: Tree
* Group 4: Tree

### T(n) = T(n/2) + n

* Group 1: Bottom-up
* Group 2: Tree
* Group 3: Top-down
* Group 4: Top-down

### T(n) = T(n/2) + c

* Group 1: Tree
* Group 2: Top-down
* Group 3: Bottom-up
* Group 4: Bottom-up

### T(n) = T(n-1) + c

* Group 1: Top-down
* Group 2: Bottom-up
* Group 3: Tree
* Group 4: Tree

### T(n) = T(n-1) + n

* Group 1: Bottom-up
* Group 2: Tree
* Group 3: Top-down
* Group 4: Top-down

### T(n) = 3\*T(n/4) + n

* Group 1: Tree
* Group 2: Top-down
* Group 3: Bottom-up
* Group 4: Bottom-up

### T(n) = 3\*T(n/2) + n

* Group 1: Top-down
* Group 2: Bottom-up
* Group 3: Tree
* Group 4: Tree

Discussion (if time)
--------------------
