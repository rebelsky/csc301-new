---
title: "EBoard 28: Sets and Union Find"
number: 28
section: eboards
held: 2021-11-05
link: true
---
# {{ page.title }}

_Approximate overview_

* Admin
* Kruskal correctness, revisited
* A simple set ADT
* Implementing simple sets
* Union find

Administrative stuff
--------------------

* I was wrong about the school board elections.  I didn't count Jasper
  county.  We had very different results.
* Advance question: Do you want class on November 24?

### Friday PSA

### Upcoming token-generating activities

* Diwali Celebration, Saturday, 6ish to 8:30ish, Harris.
* Orchestra, 2pm, November 13, in Sebring Lewis.
* International Food Fest November 14
* November 18-21, _Do You Feel Anger?_ 

Other good things

* Men's Basketball vs. Coe, 7 pm Friday, Darby.
* Swimming and Diving vs. Luther, Saturday, 1 pm.

### Upcoming other activities

* Epistemology of Street Protests during the last twenty minutes of 
  my class on Friday.
    * Yes, you can leave class at 3:20.

### Upcoming work

* Read Sections ??? (Vol. 3) for Monday
* [HW9](../assignments/assignment09) due next Thursday

### Q&A

Proving Kruskal's Algorithm Correct, revisited
----------------------------------------------

### The algorithm

```
sort edges from smallest to largest
repeat until you've added n-1 edges (or run out of edges)
  if adding the next edge doesn't create a cycle
    add it
```

### Theorem 2: Kruskal's returns the MST

Proof by contradiction

* Kruskal finds a tree, T.
* Assume that Kruskal's algorithm does not find the MST.
* T is not the MST.
* There is a tree, S, that is the MST of the graph (|S| < |T|)
* There exist edges in T that are not in S.
* Let e be the smallest such edge. **This is new.**
* Add e to S, creating S'.
* S' has a cycle.
* Let f be the shortest edge in that cycle.

Improving Kruskal's Algorithm
-----------------------------

* Instead of "find the shortest edge that does not create a cycle",
  we can think of the step as "find the shortest edge that connects
  two disconnected components".
* We'll use a set of nodes to represent each connected component.
* How should we implement the set?
* Data structure design time!

### Kruskal's revised

```
sort the edges
put each node in its own set
repeat until you have only one set
  grab the next edge
  if the edge connects nodes in two different sets
    add the edge to the MST
    combine the two sets
  end if
end repeat
```

### Primary operations (ADT)

_What are the primary operations we do on sets in Kruskal's?_

Implementing sets
-----------------

_How would you implement sets?  What is the cost of each operation? (TPS)_

Implementing sets with union-find structrues
--------------------------------------------
