---
title: "EBoard 27: Minimum Spanning Trees (MSTs), Continued"
number: 27
section: eboards
held: 2021-11-03
link: true
---
# {{ page.title }}

_Approximate overview_

* Admin
* Minimum spanning trees
    * Designs!
    * Attempts to defend/break designs
* Famous algorithms
    * Prim's
    * Kruskal's
* Analyzing Kruskal's
    * Proof of correctness
    * Analyzing running time
* Improving Kruskal's

Administrative stuff
--------------------

* Please pair with your partner from Monday.
* Here are the results of the school board at-large election.
    * Belcher: 1243
    * Bair: 1260
    * Starrett: 1229
    * Brown: 1210
    * Write-in: 20.
    * _Every vote counts!_
* Recent Google Doodle: <https://g.co/doodle/wm8e7g4>

### Upcoming token-generating activities

* Scholars' Convocation Thursday at 11 am.
  Lara Janson ‘05.
  _Humanizing Title IX: Centering Student Needs in Campus Community Responses 
  to Sexual Violence_.
* Thursday Extra, Thursday at 4pm: _Declaring a CS Major_.
* Diwali Celebration, Saturday, 6ish to 8:30ish, Harris.
* Orchestra, 2pm, November 13, in Sea Bring Lou Us. (Sebring-Lewis)
* International Food Fest November 14
* November 18-21, _Do You Feel Anger?_  Yes.

Other good things

* Men's Basketball vs. Coe, 7 pm Friday, Darby.
* Swimming and Diving vs. Luther, Saturday, 1 pm.

### Upcoming other activities

* Epistemology of Street Protests during the last twenty minutes of 
  my class on Friday.

### Upcoming work

* Read Sections 15.1, 15.2, 15.5, and 15.7 (Vol. 3) for Friday,
* [HW8](../assignments/assignment08) due Thursday.
    * One page on bias in algorithms and ways to address it
    * One paragraph on "How to teach this stuff better"

### Q&A

Which corporate entries are given officer of the College status so
that they can grab our FERPA-protected data.

> Microsoft.

> Proofpoint.

> Ellucian.

> Blackboard.

> Gradescope.

> Qualtrics?

> Sam will ask our FERPA officer.

Implementation Strategies
-------------------------

* Work out the details
* Look for counter-examples
* Consider running time
* Try to prove correct
* During presentation, others will also think about counter-examples

### Exhaustive search/brute force

* Find all spanning trees.
    * Using traversal methods?
    * Find all sets of n-1 edges. There are (m choose (n-1)).
      m! / (....).  Many!
    * Determine if connected. O(n)
* Calculate the weight of each tree.
    * O(n)
* Take the smallest.
    * O(1)
* Approximately n times m!

### Divide and conquer: Find MST in each half, combine

Failing example

```
      7
  A ----- B
8 |       | 8
  C ----- D
      2
```

If we make (A,C) and (B,D) our subgraphs, we get a non-minimal spanning
tree.

### Greed: Removing edges greedily

Version 1

```
sort edges in decreasing edge length
while |E| > n-1
  if removing the longest unchecked edge does not disconnect the graph
    remove it
```

Version 2

```
while cycles exist in the graph
  remove the edge with the highest cost
```

Comments

* We're not sure that Version 2 is correct.
* Version 1 seems easier to understand, implement, check for
  correctness, and analyze.
* Running time of version 1: O(m) repetitions of "is it disconnected"?
  O(m) to check for connectness.  So O(m^2)
* Is it correct?

### Greed: Adding edges greedily

Version 1

```
sort edges from smallest to largest
repeat until you've added n-1 edges
  if adding the next edge doesn't create a cycle
    add it
```

Version 2

```
throw all the edges in a heap
repeat until you have a connected graph
  if adding the next edge doesn't create a cycle
    add it
```

Run time of version 2.

* mlogm to add everything to a heap
* m repetitions of work that costs n
* O(mlogm + mn)

Version 3

* Pick a random vertex
    * Add all of its outgoing edges to a heap
* Repeat until we have all the vertices
    * Pick the smallest outgoing edge that doesn't create a cycle
    * Add the neighbor to the list of checked nodes
    * Add all the outgoing edges from the neighbor to the heap

Advantage compared to version 2 that the heap is often smaller.
(The heap is implicit.)

* We potentially add every edge to the heap O(mlogm)
* Repetition: m times, check for a cycle is O(n)
* Running time O(mlogm + mn), perhaps with a smaller constant
   in practicemultiplier.

Famous algorithms (1): Prim's Algorithm
---------------------------------------

Version 3.

Famous algorithms (2): Kruskal's Algorithm
------------------------------------------

Version 1 or Version 2.

Proving Kruskal's Algorithm Correct
-----------------------------------

Techniques we know for proving things correct that we will not use.

* Look it up in the book.
* Incantations.
* Put on music and wave your hands.

Other techniques for proving things correct.

* Brute force
* Induction
* Direct
* Using a loop invariant
* Contradiction

### The algorithm

```
sort edges from smallest to largest
repeat until you've added n-1 edges (or run out of edges)
  if adding the next edge doesn't create a cycle
    add it
```

### Theorem 0: Kruskal's terminates

QED.

### Theorem 1: Kruskal's returns a spanning tree

If the graph is connected, we should be able to find n-1 edges that do not
create a cycle.  "Wave those hands".

### Theorem 2: Kruskal's returns the MST

Proof by contradiction

* Kruskal finds a tree, T.
* Assume that Kruskal's algorithm does not find the MST.
* T is not the MST.
* There is a tree, S, that is the MST of the graph (|S| < |T|)
* There exists an edge, e, in T that is not in S.
    * T is not the same as S.
    * S and T contain the same number of edges (n-1)
    * Counting tells us this
* Add e to S, creating S'.
* S' has a cycle.
* Let f be the shortest edge in that cycle.
* Three possibilities
    * f is longer than e (both are in the cycle, so the shortest edge
      must be less than or equal to e)
    * f is equal to e (???)
    * f is shorter than e (...)
* If f is shorter than e, then Kruskal's should have chosen it instead
  of e.
* Whoops.  

Why might Kruskal's have chosen.  Suppose f connects A and B.  It could
be that A and B were already connected before we got to f.  And so 
Kruskal's wouldn't have added it.

Improving Kruskal's Algorithm
-----------------------------

We can turn "does this create a cycle?" from O(n) to O(logn)
