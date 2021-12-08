---
title: "EBoard 26: Minimum Spanning Trees (MSTs)"
number: 26
section: eboards
held: 2021-11-01
link: true
---
# {{ page.title }}

_Approximate overview_

* Admin
* Shortest path, continued
    * Running time
    * Applications
    * Proof of correctness
    * Generalizing
* Minimum spanning trees
    * The problem
    * Approaches
    * Attempts to design
    * Attempts to prove/break
    * Famous algorithms (if time)

Administrative stuff
--------------------

* Happy Monday!
* Pair with same color/value.
* This is a two-day topic.  We'll be continuing on Wednesday.

### Upcoming token-generating activities

* Learning from CS Alums Tuesday at 2 p.m. in 3821: Alex Turner '16 or so.
  Effective Altruism, Grad School, and More.
* Tuesday night discussion of "Arrival" the movie.  Aliens!  7pm Harris Cinema.
* Scholars' Convocation Thursday at 11 am.
  Lara Janson ‘05.
  _Humanizing Title IX: Centering Student Needs in Campus Community Responses 
  to Sexual Violence_.
* Diwali, Saturday, place to be determined.
* Orchestra, November 13, in Sea Bring Lou Us. (Sebring-Lewis)
* International Food Fest November 14
* November 18-21, _Do You Feel Anger?_

Other good things

* Men's Basketball vs. Coe, 7 pm Friday, Darby.
* Swimming vs. Luther, Saturday, 1 pm.

### Upcoming other activities

* The Dark Side of Indo-European Studies Tuesday at 8:30 a.m.
* Epistemology of Street Protests during my class on Friday.

### Upcoming work

* Read Chapter 13 (Vol. 3), _Greedy Algorithms_, for Wednesday.
* [HW8](../assignments/assignment08) due Thursday.
    * One page on bias in algorithms and ways to address it
    * One paragraph on "How to teach this stuff better"

### Q&A

Do we need numerous citations?

> No.  But if you refer to sources (e.g., look at them), please cite.

> You can use the movie and your intuition.

Do we have to do general consideration of bias, or can we consinder
particular algorithms (or those things they call "algorithms" in the
movie).

> Either.

Running time of Dijkstra's Algorithm, Revisited
-----------------------------------------------

You may recall that our analysis was, approximately,

```
O(n*cost-to-find-nearest-remaining-node + m)
```

A naive mechanism for finding the nearest remaining node is
O(n).

A heap brings it down to O(logn).  

So Dijkstra's algorithm is O(nlogn + m).  That's much better for
sparse graphs.  If our graph is fairly populated, it's probably
O(n^2).

Sam does not know a formal definition of sparse.  But if nlogn << m,
this analysis is helpful and this implementation is much faster.
We might say O(nlogn) edges is "sparse", Theta(n^2) edges is "populated",
and everything in between is "something else".

However, using a heap complicates the implementation significantly,
because we need to "re-heap" a value when its distance changes.

Applications of Shortest Path
-----------------------------

_Why do we care about shortest path?_ (_TPS_)

"It's good for optimizing things"

* Minimum distance (e.g, in a graph with edges that represent distance
  between places).  Reduces energy.
* Minimum cost (e.g., in a graph where edges represent charges for something,
  such as plane flights).
* Minimum time (e.g., packet routing in the Interweb, driving with Google)

Note: Other kinds of graph optimizations, such as, "the path with the
largest smallest edge"

"More general optimizations"

* Potentially, to come up with a better representation of the graph.
* Use with decision graphs to find the most probable path to an event.

"Other reasons"

* A good example of graph algorithms
* A good example of the greedy approach
    * Greed works
    * Greed is relatively efficient
* Fun analysis
* Unexpected improvement (see book)
* Moderately elegant

Proof of Correctness
--------------------

_TPS_

You, paraphrased

> I'm not sure why so many people insist on proofs of correctness.  They 
  are usually annoyingly detailed, but also relatively straightforward.
  More importantly, they reveal little important about the algorithm.

Rebelsky, paraphrased

> Nonetheless, there are many "algorithms" that look correct at first
  glance.  And second glance.  Proofs help us ensure that they are
  correct (or help us find counter-examples).

> Unfortunately, many of us are as likely to make mistakes in our
  proofs as we are in our algorithms.

> Practice is good.

The argument

> By induction.

> Midway through, we have two sets: V (all vertices) and X (verticies
  we've marked).  Dijstra's algorithm chooses the element, e, in V-X that
  is "closest" to start node, given the knowledge so far.

> Why is this acceptable?  If we go through some other node in V-X, the
  path must be longer.

All-pairs shortest-path algorithms
----------------------------------

_Quick survey: Who has seen/done this before?_

Suppose, instead of the shortest path from S to T or from S to any
node, we want *all* of the shortest paths.  That is, for *all* pairs
S,T in the graph, we want the shortest path from S to T.  (We're
building a matrix, this must be at least n^2 work.)

### A quick approach

For each node, run Dijkstra.

Running time?  O(n)xO(nlogn + m) = O((n^2)logn + nm)

Of course, this requires that we build heaps and use them correctly.

### A better approach? (Floyd-Warshall)

```
First, seed the matrix with edges.  

Then, update the matrix

for each Node, N, in the graph
  cost(A,B) = min(cost(A,B), cost(A,N) + cost(N,B))
```

In something like C

```
for (int i = 0; i < n; i++)
  for (int s = 0; s < n; s++)
    for (int t = 0; t < n; t++)
      cost[s,t] = min(cost[s,t], cost[s,i] + cost[i,t]);
```

Unfortunately, O(n^3)

Proof of correctness?  Left to later.

This might also work with negative weights, provided you have no negative
loops.

Reminder: 

* Sometimes there are very different approaches for very similar problems.
* Sometimes you can just run another algorithm multiple times.

Minimum Spanning Trees (MSTs)
-----------------------------

Casual: Given a connected, weighted, undirected graph, find 
a subset of edges that maintain connectedness and have the
minimum sum of weights.

_Quick survey: Who has seen/done this before?_

Why care? (Concrete examples?)

* "What roads can we close and still permit people to get from here to there."
* "How many flights can we close and still pretend we have a way to get
  people between any two cities we serve?"
* "How many video game servers can we close and still ...."
* Note: Sometimes models are hard to generate
* Related: "How many of our power plants have to stay up before people
  lose power."  or "How likely are people to lose power."  "How many
  nodes do we delete before ..."

Implementation strategies? (_TPS_)

* Greed: Removing edges greedily
    * Q: Which edge?
* Greed: Adding edges greedily
    * Q: Which edge?
* Greed: Adding nodes greedily
    * Q: Which node?
* Divide and conquer: Find MST in each half, combine
    * Q: How do we decide how to split?
* Exhaustive search/brute force

Implementation Strategies
-------------------------

_Pairs, with assigned approaches_

* Work out the details
* Look for counter-examples
* Try to prove correct
* Consider running time

Be prepared to discuss next class

### Questions: 

How do I determine if a graph is connected?

> Search!  O(n+m)

How do I determine if a connected graph has a cycle?

> Count the number of edges.  You need only n-1 edges for a cycle.

Exploration
-----------

_Write and present your algorithms._

_Can we break any of these algorithms?_

_Can we argue/prove any of these correct?_

Famous algorithms (1): Prim's Algorithm
---------------------------------------

_We probably won't get to this._

Famous algorithms (2): Kruskal's Algorithm
------------------------------------------

_We probably won't get to this._

