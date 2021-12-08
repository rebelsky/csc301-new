---
title: "EBoard 25: Shortest Paths"
number: 25
section: eboards
held: 2021-10-29
link: true
---
# {{ page.title }}

_Approximate overview_

Administrative stuff
--------------------

* Today's theme song is the Eurythmic's "Here Comes the Rain Again".
    * We'll see if the system permits me to play it.  (Nope)
* Bonus handouts at the back of the room.
    * Please follow health protocols when using.

### Obligatory jokes

### Friday PSA

* Moderation in everything (except, perhaps, sleep).
* Consent is absolutely, positively, essential.

### Upcoming token-generating activities

* Football, Saturday, 1pm
* Any one Grinnell prize event this weekend.
* Vegan potluck.  You know the drill.
* Tuesday night discussion of "Arrival" the movie.  Aliens!
* International Food Fest November 14
* November 18-21, _Do You Feel Anger?_

### Upcoming other activities

* Mid-Autumn Festival 6-8pm in Harris.  Food and Boba Tea.
* Improv in the Wall in Bucksbaum tonight at 7:30 p.m.
* Women's Volleyball Saturday at 11:00 a.m.
* Swim meet Saturday at 1pm
* Women's Basketball vs. Alumnae Saturday at 4:00 p.m.
* Men's Basketball vs. Alumni Saturday at 6:00 p.m.
* Piano Duel Saturday.
* The Dark Side of Indo-European Studies Tuesday at 8:30 a.m.

### Upcoming activities that you may fail for attending.

* Epistemology of Street Protests during my class next Friday.

### Upcoming work

* [HW8](../assignments/assignment08) due next Thursday.
* Read chapters 7 and 9 (Volume 2) for Monday.

### Q&A

Can I add another event?

> Sure.

Graphs
------

_TPS_

### What is a graph/network?

A collection of vertices/nodes and edges.  Edges connect nodes.

[Not recursive, like most of our favorite CS definitions.]

### Why do computer scientists care about graphs?

They can be used to store information, such as geographical information.

Also: Computer networks, social networks (edges are friendships)

### What are some key characteristics of graphs?

* Directed: Edges only go in one direction.  (Useful for some
  kinds of models.)
* Weighted: We add values to edges.  Cost of traversing an
  edge (e.g., tolls on road), real-life length, capacity,
  speed, ....
* Cyclic: There is a path from a node to itself.  (Acyclic graphs:
  No node has a path back to itself.)
* [Tree-like.]
* Connected.  There is a path from every node to every other node.
* Complete.  Every node is connected to every other note.
* Bipartite: We can divide the graph into two halves; edges are only 
  between the two halves.
* Independent.  (Characteristic of subgraphs: No edges between nodes
  in the set.)

### How do we represent a graph or network on the computer?

### Option 1: Node objects

Each node is an object.  Each node has a list of outgoing edges?

```
class Node<T> {
  T val;
  List<Pair<Node<T>,Integer> neighbors;
}
```

Neighbors could be hash tables

```
class Node<T> {
  T val;
  Map<T,Integer> neighbors;
}
```

If we use this approach, how do we get a list of all the nodes
in the graph?

* Pick one node:  Use an algorithm to traverse to all the neighbors,
  and neighbors of neighbors and neighbors of neighbors of neighbors.
  Mark things as we go.
    * Problem: Won't work for non-connected graphs.
* Alternative: Add a graph class that contains a list (or other
  iterable) of all the nodes in the graph.
    * Note: Many algorithms have a line that reads "for each node"
  
### Representing edges

```
class Edge<T> {
  int weight;
  Node<T> from;
  Node<T> to;
}
```

Sam's concern: If we have edges in nodes and nodes in edges, which means
we replicate information.  Historically, programmers suck at keeping
replicated information in sync.

Some algorithms have a line that reads "for each edge".

### Edge lists

Lists of edges.  See prior note: Great for algorithms that have a "for each
edge".

### Adjacency matrix

Rows and columns are labeled by nodes.  Entries are the weight.

* Diagonal is all 0's.
* 0 represents "this is me"
* infinite represents "no such edge" (you can choose other representations)

Really fast to find the cost from getting between two places.

* Note: Matrix algorithms can be fun!
* For each node is relatively cheap.

### Why discuss this?

The representation affects running time.

The shortest-path problem
-------------------------

_Quick survey: Who has seen this before?_

Given a directed, weighted (non-negative), graph, as well as two
identified nodes (S, the source, and T, the sink), find the path
from S to T with the shortest sum of weights (assuming there is
such a path).

### An Example

_Why am I not smart enough to keep my examples from past semesters?_

This one is undirected.  That's okay.

```
     1     5     4
  A --- B --- C --- D
  |       \   |   /
  |3      7\  |3 / 1
  |         \ | /
  E --- F --- G
     2     2
```

Goal: A to D.

Dijkstra's shortest-path algorithm
----------------------------------

_Group work (Possibly)_

### Hints: 

* Find the shortest path from S to *every* node, not just T.
* Use greed.  (Local optimum is the overall optimum.)
* Initially, we won't worry about the representation of the graph.

Keep track of our best guess of the distance from S to each node.

* For some of these, we are confident that we have the right answer.
  Keep track of those.

As long as there are nodes that remain with a finite distance,

* Choose the closest of those
* Mark it as "done"
* Update the distance to all of its neighbors to
  min(prior distance, distance-to-node + node-to-neighbor)

The Example, using Dijkstra's Shortest Path
-------------------------------------------

```
     1     5     4
  A --- B --- C --- D
  |       \   |   /
  |3      7\  |3 / 1
  |         \ | /
  E --- F --- G     H
     2     2
```

Goal: A to D.

* Initially: 
  [A/0, B/inf, C/inf, D/inf, E/inf, F/inf, G/inf, H/inf]
* Mark A, add neighbors: 
  [A/0!, B/1/A, C/inf, D/inf, E/3/A, F/inf, G/inf, H/inf]
* Mark B, add neighbors: 
  [A/0!, B/1/A!, C/6/B, D/inf, E/3/A, F/inf, G/8/B, H/inf]
* Why can we mark B?  Why is there no shorter path to B?
  Because any other path to B would require that we go through
  a node further from A, and so would be worse.
* Mark E, add neighbors
  [A/0!, B/1/A!, C/6/B, D/inf, E/3/A!, F/5/E, G/8/B, H/inf]
* Mark F, add neighbors
  [A/0!, B/1/A!, C/6/B, D/inf, E/3/A!, F/5/E!, G/7/F, H/inf]
    * Note: We updated G.
    * We felt comfortable finalizing F because (a) we should
      have reached it already, by choosing the  minimum value;
      (b) We have to go through some node; all the others
      are further, so going through them will not serve us well.
* Mark C, add neighbors
  [A/0!, B/1/A!, C/6/B!, D/10/C, E/3/A!, F/5/E!, G/7/F, H/inf]
* Mark G, add neighbors
  [A/0!, B/1/A!, C/6/B!, D/8/G, E/3/A!, F/5/E!, G/7/F!, H/inf]
     * We updated D!
* Mark D
  [A/0!, B/1/A!, C/6/B!, D/8/G!, E/3/A!, F/5/E!, G/7/F!, H/inf]
* We're done!  We can read the path to D from our table.
    * D <- G <- F <- E <- A.

We can stop the algorithm when we reach D or we can keep going until
we cover all the reachable nodes.

### Reflection

Why do we care?  (That is, what are real-world problems we might
model with graphs?)

Analyzing Dijkstra's shortest-path algorithm
--------------------------------------------

_Quick survey: Who has seen/done this before?_

_TPS_

### What is the running time of Dijkstra's algorithm?

n: Number of nodes
m: number of edges

Version one:

```
While unmarked nodes remain (n repetitions)
  Find the closest unmarked node (can be done in n)
  For each neighbor (up to n)
    update the distance (1)

So O(n*(n+n)) = O(n^2)
```

Version two:

```
While unmarked nodes remain (n repetitions)
  Find the closest unmarked node (?)

Observation: We follow each adge at most twice.
So we spend O(m) updating distances

If find the closest unmarked node remains O(n), the first
loop remains O(n^2)
```

Can we do better for finding the closest unmarked node?  Yes.
We can do it in O(logn) by storing the unmarked nodes in healp.

### What assumptions are you making as you get that running time?

### How might we improve the running time of Dijkstra?

### How do we know that Dijkstra's algorithm is correct?

### Would a "reverse Dijkstra" work as well?

That is, find the shortest path from every node to T, rather than
from S to every node?

All-pairs shortest-path algorithms
----------------------------------

_Quick survey: Who has seen/done this before?_

Suppose, instead of the shortest path from S to T or from S to any
node, we want *all* of the shortest paths.  That is, for *all* pairs
S,T in the graph, we want the shortest path from S to T.

### A quick approach

For each node, run Dijkstra.

Running time?  (_TPS_)

### Doing better?

_TPS_

Note: We expect to continue this question next class.
