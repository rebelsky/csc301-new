---
title: "EBoard 30: Maximum Flow" 
number: 30
section: eboards
held: 2021-11-10
link: true
---
# {{ page.title }}

_Approximate overview_

* Admin
* Prim's, Revisited 
* Maximum Flow Problem
* Strategies for solving Max Flow

Administrative stuff
--------------------

### Checking in on HW 9

* How is it going?
* New version: Clean up the Kruskal algorithm we developed together.
  Write tests using predefined graphs whose MST you know.
* Newer version: HW 9 is cancelled.

### Upcoming token-generating activities

* Cool CS Talk, Thursday, November 11, 4:00 p.m.
* SEPC Event, Friday, 7pm
* Football, Noon, November 13 vs. Cornell (College)
* Orchestra, 2pm, November 13, in Sebring Lewis.
* Vegan Potluck Saturday at 7pm.  Bonus token!
* International Food Fest November 14
* November 18-21, _Do You Feel Anger?_ 

Other good things

* Men's Basketball Tonight at 7pm
* Grinnell Singers Sunday at 2pm

### Upcoming work

* No new readings.
* [HW9](../assignments/assignment09) due never.

### Q&A

Prim's Algorithm
----------------

Representation: Given a node, we should be able to find all the edges.
So an adjacency list representation (i.e., a hash table that maps
nodes to a list of the outgoing edges) suffices.

* We would have to convert our original list of edges into an adjency
  list.  That's okay, it's only O(m)

```
List<Edge>[] outgoing = new List<Edge>[n+1];
for (int  i = 0; i <= n; i++) {
  outgoing[i] = new ArrayList<Edge>();
}
for (Edge e : edges) {
  outgoing[e.source].add(e);
  outgoing[e.target].add(e);
}
```

Data Structures:

* Some mechanism for marking nodes (e.g., a hash table or field in the struct)
* A min-heap for some of the unprocessed edges.
    * Or unprocessed vertices, but that requires that you have a heap
      in which it's easy to change priorities.
* A list of edges already in the tree

Notes:

* Once again, using integers for nodes makes our life easier; we can use
  arrays rather than hash tables.
* We'll need to convert the edge-list representation to the adjacency-list
  representation.
* We only add edges to the heap when we add a node.

Example

```
   2     1     2
A --- B --- C --- D
|3    |4    |3    | 2
E --- F --- G-----+
   4     1     
```

The Max-Flow Problem
--------------------

Given:

* A directed, weighted, graph G = (V,E)
    * The weight represents the "capacity" or "flow" of the edge.
* A designated source node, s
* A designated sink node, t

Find the maximum "flow" from s to t

Applications:

* Transport of goods.
* Transport of data.
* Predicting flow in pipes.
* ...

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

Getting Started
---------------

We typically build a "flow graph" from s to t.

We may modify the original graph along the way.

Most algorithms rely on an "augmenting path", a path from s to t
with only positive weights.

An Incorrect Algorithm
----------------------

```
While augmenting paths remain in G
  Find an augmenting path, P
  Find the lowest weight edge on that path
  Let its weight be w.
  Decrement every edge in P by w.
  Increment every corresponding edge in the flow graph by w
```

_Why is the algorithm incorrect? (TPS)_

That is, find a graph and a sequence of augmenting paths for which
this algorithm fails.

Yes, it can be the graph we just used.  (Sam is lazy.)

Choose SCABT as the first augmenting path.  That has flow of 3.

Choose SCDT as the next augmenting path.  That has flow of 2.

There are no more augmenting paths.  Our total flow is 5.  But we know
that max flow in the graph is at least 8.  Damn!

_How might we fix the algorithm? (TPS)_

We can ....

* "Burn as few bridges as possible."  Don't use up paths that others
  can use.
* "Choose paths with fewest branches"
* "Ask someone who has seen the algorithm already"
* "Choose shortest path from S to T"
* "Choose longest (highest weight) path from S to T"
* Find all the paths that go through the highest capacity edge in the graph.
