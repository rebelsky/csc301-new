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
* I forgot my hearing aids today.  Expect a lot of "what?"
* Advance question: Do you want class on November 24?
    * We're missing a few people today, so we'll vote on Monday.
* Is Guy Fawkes day a response to Diwali?

### Friday PSA

* Sunday at 2am, turn off your clock for an hour.  An extra hour
  of sleep.
* Please be moderate in what you do.
* Consent is essential!

### Upcoming token-generating activities

* Elbica Coffee-Free Chat, Today, 5pm
* Diwali Celebration, Saturday, 6:00 to 8:30, Harris.
    * 6:30 if you didn't RSVP.
* Cool CS Talk, Thursday, November 11, 4:00 p.m.
* Orchestra, 2pm, November 13, in Sebring Lewis.
* International Food Fest November 14
* November 18-21, _Do You Feel Anger?_ 

Other good things

* Men's Basketball vs. Coe, 7 pm Friday, Darby.
* Swimming and Diving vs. Grinnell, Saturday, 1 pm.
* Epistemology of Street Protests during the last twenty minutes of 
  my class today
    * Yes, you can leave class at 3:20.

### Upcoming work

* Read Sections 15.6 and 15.8 (Vol. 3) for Monday
* [HW9](../assignments/assignment09) due next Thursday
    * Do four hours by Wednesday, let's check back in.
    * Please choose a reasonable language (not Whitespace)

### Q&A

Why don't you like Python?

> Because Python encourages "get the job the done" rather than
  "get the job done well/efficiently/beautifully".

> Why not?

Proving Kruskal's Algorithm Correct, revisited
----------------------------------------------

### The algorithm

```
sort edges from smallest to largest
repeat until you've added n-1 edges (or run out of edges)
  if adding the next edge doesn't create a cycle
    add it
```

### Running time

O(m x cost-of-checking-whether-adding-creates-a-cycle)

### Theorem 2: Kruskal's returns the MST

Proof by contradiction

* We'll assume that all the edges are different weight.
* Kruskal finds a spanning tree, K.
* Assume that Kruskal's algorithm does not find the MST.
* Hence, there is a tree, M, that is the MST of the graph (|M| < |K|)
* There exist edges in K that are not in M.
* Let e be the smallest such edge. **This is new.**
* e connects two nodes/vertices, A and B
* M is connected.  So there is a path, P, between A and B.
* What do we know about the edges in P
    * If edge f is in P, can f also be in K?  Yes.  Proof by construction.
      (See the board).
    * Not all the edges in P are in K.  Not all of P can be in K, because
      P + e is a cycle.
    * If edge f is in P but not in K, what do we know about the weight
      of f?  weight of f is greater than weight of e.  Because Kruskal's
      examines edges in order of weight. If weight of f is less
      than the weight of e, Kruskal's would have selected f before
      selecting e.
* Consider graph M' = M + { e } - { f }.
    * |M'| < |M|
    * M' is a spanning tree.  Cutting any one edge of a cycle retains
      connectivity
    * Whoops, M was not minimal.
* QED

This is one model of proof of greedy algorithms.  Assume there's a smaller
(or larger).  Show that it's not the smallest/largest.

### Alternate proof: Using Minimum Bottlenecks

* A minimum bottleneck is an edge that connects two points for which
  there are no smaller edges on any path between those two points.
* Thm: A spanning tree consisting of only minimum bottlenecks is an MST.
* Thm: Kruskal's only chooses minimum bottlenecks.

Improving Kruskal's Algorithm
-----------------------------

* The naive "Check for a cycle" is O(m) which is O(n) in a Kruskal
  intermediate graph, because Kruskal never adds more than n edges.
    * Naive Kruskal is O(mn).
* Instead of "find the shortest edge that does not create a cycle",
  we can think of the step as "find the shortest edge that connects
  two disconnected components".
    * It's the same thing.
* We'll use a set of nodes to represent each connected component.
* How should we implement the set?
* It's **Data structure design time**!
    * Examine the algorithm
    * Consider the way the data are used/grouped
    * Summarize as a set of procedures
    * Decide on an implementation

### Kruskal's restated

```
sort the edges
put each node in its own set
repeat until you have only one set
  grab the next edge
  if the edge connects nodes in two different sets
    add the edge to the MST
    combine the two sets into a single set (a bigger connected component)
  end if
end repeat
```

### Primary operations (ADT)

_What are the primary operations we do on sets in Kruskal's? (TPS)_

General ideas

* create a new set with one element
* union: combine two sets into a single set
* we need a way to determine whether two nodes are in the same set
    * Translate: Does this set contain this node?

Issue: If you have `setContains`, given an edge (a,b), we need to
look through each set to see if it contains a.  Then we can just
see if the set contains b.  That first part seems inefficient.

* Alternate: `findSet(Node)` operation.

So we have three operations.

* `Set makeSet(Node n)` - Make a new set
* `Set find(Node n)` - Find the set
* `union(Set1, Set2)` - Marks that they are a union.  Afterwards,
  `find(n)` returns the same value for all the values in Set1 and
  all the values in Set2.

Implementing sets
-----------------

_How would you implement sets?  What is the cost of each operation? (TPS)_

### Option 1: With a hashmap

* keys are vertices
* values are edges
* To find: Traverse the edges until ????

### Option 2: With a hashmap

* keys are vertices
* values are the sets
* Find is just lookup in the hashmap O(1)
* union is "update all of the sets associated with the value in
  the smaller set" O(n)
* Side note: If we use numbers for vertices (and sets), we can use arrays 
  rather than hashmaps.

Implementing sets with union-find structures
--------------------------------------------

Idea 1: Use a tree, rather than a hashmap to store information.

Idea 2: We will identify sets by one designated member of each set.
When you ask what set a vertex is in, you'll get the "master vertex"
for that set.

To create a new set, you indicate that the parent of a vertex is
itself.  O(1)

To find the "master vertex",  you follow your parent pointer until
you reach a vertex with no parent (or whose parent is itself)

To union two sets: Make the parent of the "master vertex" (root) of
the smaller tree the "master vertex" (root) of the larger tree.

Why make smaller pointer to larger?  It keeps the trees shorter.  We
can keep the height O(logn)

`find`: O(logn)

`union`: O(logn)

Our Kruskal's algorithm is O(mlogn)

You can improve union/find by updating parent nodes during find.

Implementation: If node names are integers, use an array to represent
the parent links.  Otherwise, a hashmap will suffice.

```  
     ---------------
  2 /     --------- \
   /    9/         \ \
  A -7- B -3- C -1- D \
   \   / \   / \       |
   6\ /9 5\ /8  \1     |
     E -2- F -3- G -9- H
           0\         /11
             I --8---J
```

```
       K = { } 
       A B C D E F G H I J
parent A B C D E F G H I J

       K = { (FI) } 
       A B C D E F G H I J
parent A B C D E I G H I J

       K = { (FI), (CD) } 
       A B C D E F G H I J
parent A B D D E I G H I J

       K = { FI, CD, CG } 
       A B C D E F G H I J
parent A B D D E I D H I J
```

Note: You also need a table to keep track of set sizes.
