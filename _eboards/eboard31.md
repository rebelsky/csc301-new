---
title: "EBoard 31: Maximum Flow, Continued" 
number: 31
section: eboards
held: 2021-11-12
link: true
---
# {{ page.title }}

_Approximate overview_

* Admin
* Strategies for solving Max Flow
* The Ford-Fulkerson algorithm
* Analyzing FF

Administrative stuff
--------------------

* Clementines!
* Since ITS has decided to disable my primary email app on my phone,
  I will be much less likely to answer email out of 8-5 weekdays.
* I've realized that I care about one more learning outcome from 
  this class, which I will not require, but which we will work 
  on today:
  _Given an incorrect algorithm, find an example for which the
  algorithm gives an incorrect solution._  (Aka "Prove the
  algorithm incorrect."  By example.)

### Friday PSA

* Drinking makes you colder, not warmer.
* Please do things in moderation.  (Sleep need not be in moderation.)
* Consent is essential.

### Upcoming token-generating activities

* SEPC Event, Friday, 7pm
* Football, Noon, November 13 vs. Cornell (College)
* Orchestra, 2pm, November 13, in Sebring Lewis.
* Vegan Potluck Saturday at 7pm.  Bonus token!
* International Food Fest November 14  Dahi puri and more!, Fried rice-noodles!
* November 18-21, _Do You Feel Anger?_ 

Other good things

* Grinnell Singers Sunday at 2pm

### Upcoming work

* No new readings.
* [HW10](../assignments/assignment10) due next Thursday
    * Not yet written..

Strategies for solving Max-Flow
-------------------------------

A Sample Graph

```
S->A: 4
A->B: 3
B->T: 8
S->C: 5
C->D: 7
D->T: 3
D->B: 2
C->A: 6
```

Our revised algorithm 

```
While augmenting paths remain in G
  Find the augmenting path with CRITERION
  Find the lowest weight edge on that path
  Let its weight be w.
  Decrement every edge in P by w.
  Increment every corresponding edge in the flow graph by w
```

Possible criteria

* 1 Choose the path with the fewest branches.
* Use the shortest path from S to T
    * 2 In terms of edges
    * 3 In terms of total weight (lightest)
* 4 Use the heaviest path from S to T (in terms of total weight)
* 5 A path that goes through the highest-capacity edge in the graph
  (or at least the highest capacity of edges in augmenting paths)

All of these are wrong!

Recall that without the criterion, Taking SCABT then SCDT eliminates 
any other augmenting paths, but only gives us a flow of 5.

### Counter-example, "fewest branches"

Add some pointless edges to make us take the SCABT route.

``` 
    I<H -> J (to A)
    |/   
    G   A -> B --> F
   /    ^    ^       \
  S     |    |        T
   \    |    |       /
    H > C -> D --> E
             |
             |
             v
             F
```

### Counter-example, "fewest edges"

Put a bunch of edges between S and A (all with the same weight as SA).

Put a bunch of edges between C and D (all with the same weight as CD).

```
 
  A -> B 
 *^    ^\
S |    | T
 \|    |/
  C ** D 
```

### Counter example, "lightest"

```
  A -> B 
 /^    ^\
S |    | T
 \|    |/
  C -> D 
```

### Counter example, "heaviest"

```
  A -> B 
 /^    ^\
S |    | T
 \|    |/
  C -> D 
```

### Counter example, "through highest-capacity edge"

```
  A -> B 
 /^    ^\
S |    | T
 \|    |/
  C -> D 
```

Ford-Fulkerson
--------------

Key idea: 

* Any path that goes through an edge might have sent less
  through that edge if there's another path through the source of
  the edge.  
* We'll keep track of that with a "back edge" with weight 0 for each edge.

```
While augmenting paths remain in G
  Find an augmenting path
  Find the lowest weight edge on that path
  Let its weight be w.
  Decrement every edge in P by w.
  Increment the corresponding back edges by w.
    (Note: The back edge of a back edge is the original edge.)
  Increment every corresponding edge in the flow graph by w
```

Note: Augmenting paths do not loop.

### Running FF on our original graph

_See whiteboard._

### Proof of correctness

Long and involved.

Analyzing FF
------------

* How long does it take to find an augmenting path?
* How long can an augmenting path be?
* How many times can the main loop run?

```
#loops x cost of finding augmenting path x cost of updating along path
```

* O(m): Find augmenting path; may visit every edge
* O(n): Update things along the path (paths can't be longer than n-1 edges)
* O(max edge weight): Possible augmenting paths

```
  A
 /^\
S | T
 \|/
  B
```

```
SBAT
SABT
SBAT
SABT
``

Whoops! 

Moral: Choose good augmenting paths!

Applying Max Flow
-----------------

### Bipartite matching

You have two subgraphs A and B.

Edges run only from nodes in A to nodes in B.

Find the largest possible set of edges given the restriction
that no element in A has more than one outgoing edge, and no
element in B has more than one incoming edge.

Applications: Pet adoption.  Job assignments.  Gift giving.

### Solving bipartite matching

How does max flow help with bipartite matching?

We extend the graph with two extra nodes, S and T

There is an edge from S to everything in set A.

There is an edge from everything in set B to T.

The weight of all edges is 1.

Find the max flow.

That's the largest set of edges between A and B.

Important issue: Max Flow ends up being a great way to solve a
wide variety of other problems.

### Task assignments

We have n workers, each of whom can complete a certain integer workload
(w1 ... wn).

We have t tasks, each of which requires a corresponding integer workload
(v1 ... vt).

Each worker has a set of tasks that they are able to do.  (Not all workers
are able to do all tasks.)

Find the set of assignments that will maximize the amount of work that
gets done.

### Approach

