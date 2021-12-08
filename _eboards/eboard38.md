---
title: "EBoard 38: Topological sort" 
number: 38
section: eboards
held: 2021-12-03
link: true
---
# {{ page.title }}

_Approximate overview_

* Admin
* The problem of topological sort
* Applications of topological sort
* Topological sort algorithms
* Analyzing topological sort
* Implementing topological sort algorithms

Administrative stuff
--------------------

### Notes

* Sorry that we're doing topological sort a bit out of order.  For some
  reason, I thought it got covered in CSC-207.
* I'll work on getting sign-up-sheets for finals week set up.
* A friendly reminder that the authors work hard to create their textbooks.

### Friday PSA

* If you indulge, please indulge in moderation.
* Consent is essential.
* Make the choices that are right for you.

### Upcoming token-generating activities

* Prof. Eliott's Elbica Non-Coffee Chat today.
* Chamber Ensemble Sunday at 7:30 pm in Sebring-Lewis
* Old people and student vocal concert Sunday at 2pm in Herrick.

Other good things

* Swim meet this weekend.  Earn money by timing!  And pizza!
* Synchronized swimming performance 4:30 p.m. Sunday.

### Upcoming work

* [HW11](../assignments/assignment11) due YESTERDAY (ish)
    * Implement skip lists
* Reading for Monday: Section 8.5, Topological sort
* [HW12](../assignments/assignment12) due in about sixish days.
    * Some dynamic programming problems
    * Topological sort

### Q&A

When are grades due?

> Noon on December 28.

Does that mean that I can turn in things after Friday, December 17?

> No, not unless you take an incomplete.

How many tokens do I have left?

> As many as you need.  The magic recursion fairy has decided to grant
  tokens as you ask.

The problem of topological sort
-------------------------------

Given a directed, acyclic graph G=(V,E), find an ordering of the
vertices in V such that if (u,v) is in E, then u appears before v
in the ordering.

A bad algorithm: Try every permutation of V until you find one that
works.

Applications of topological sort
--------------------------------

_Task completion_: Given a collection of tasks, each of which may depend
on the completion of other tasks, find an ordering so that you complete
each prerequisite task before you attempt a task.

_Course planning_: Given a collection of courses, some of which may have
prerequisites, find an ordering that permits you to take all the courses
without getting special permission from an instruction.  (This one is a
bit more complicated because you also have to deal with terms.)

_Strange word puzzles_: Little Red Riding Hood is heading off to
visit her relatives.  She's supposed to bring bread from Uncle Urkle
to Cousin Char.  But Unkle Urkle needs flour from Friend Fiona.
And Cousin Char has a present for LRR to deliver to Grandma Grin.
Uncle Urcle does, too.  How should Little Red Riding Hood organize
her visits so that she helps all of her relatives, but doesn't visit
any twice?

Sample Graph
------------

Graph: AC, BD, CH, CE, DE, EF, EG, FI, GH, GI, XY

* Goal is an ordered list of nodes/vertices
* We can't do ... G ... E ..., because there's an edge from E to G.

Topological sort algorithms
---------------------------

_Design your own.  (Group and share)_

Goal: To produce a list, which we'll call L.  It's one of those
cool lists that makes it easy to add to the end.  It likely starts
out empty.

Question: Can we think of this as sequentially labeling the vertices
so that edges only point from lower-labeled vertices to higher-labeled
vertices.

Observation: Topological sort can produce many different orderings
on the same graph.

### Algorithm 1

* Identify the set of nodes without incoming edges.  Call it S.
    * Are we sure that there's at least one?  Yes.  It's a
      characteristic of acyclic graphs.
    * How do we find them?
* Pick one of the nodes.
* Add it to L, list of vertices (output)
* Remove all of the outgoing edges.
* Do it all again.

Note: To "do it all again", we might look for a way to more quickly
determine the nodes without incoming edges.

O(n+m) for the "identify a set of nodes"

Hmmm ... O(n(n+m)) overall, since we remove one each time.

#### Helper: Find all nodes without incoming edges

* Go through all the edges, marking all nodes that are the target
  of an edge.  O(m)
* Go through the nodes to find the unmarked ones.  O(n)

### Algorithm 2

* Mark all nodes without outgoing edges with a 0.
* Mark all parents of nodes with a mark of zero with 1.
* Mark all parents of nodes with a mark of 1 with 2.
* Mark all parents of nodes with a mark of 2 with 3.
* Mark all parents of nodes with a mark of 3 with 4.
* ...

Output the nodes in order of mark from highest to lowest.

Running time?

* Requires that you have a way to find parents.
    * O(m) to reverse all the edges.
* Marking can take O(n^2) time.  Consider a "linear" graph in which each
  node has links to all the following nodes.  (See whiteboard.)

Note: You can represent this in a slightly better way, phrasing
it in terms of dfs, and it also ends up O(n+m).

### Algorithm 3

* Mark each node with the number of incoming edges.
    * Set the count in each node to 0. O(n)
    * Iterate all the edges, updating the count in the node. O(m)
* Identify the set of nodes 0 incoming edges.  Call it S.  O(n)
* While nodes remain in S.
    * Pick one, add it to L, remove it from N.
    * Look at all outgoing edges and reduce the incoming edge count by 1.
    * If any of those counts reaches 0, add it to S.

Analysis: 

* We remove n nodes from N. O(n)
* We follow each edge once, to decrement the count.  O(m)
* Initialization was O(n+m)
* Overall is O(n+m)

Analysis of topological sort
----------------------------

_What's the running time? (Group and share)_

See above.

Implementing topological sort
-----------------------------

Note: The `tsort` command on many Linux systems does topological sort.

Assume we're doing version 3 (add a count of incoming edges to each
node).  

_How should we represent the graph? (Group and share)_

### Nodes

* We'll need to iterate these.
* One suggestion: Objects with the label and adjacency lists and indegree
* Another suggestion: Integers!  It makes your life easier, and
  indegree is an application-specific issue.

### Edges

* We'll need to iterate these.
* Three choices?
    * Adjacency matrix
    * Edge list
    * Neighbor list: Each node has a list of outgoing edges
* We'll choose neighbor list because the algorithm includes
  "for all the outgoing edges from this node".

### Counts of incoming edges

* We want to get and change these quickly.
* Store 'em as a field in the node.
* Use a table (e.g., an array, if you've made the sensible decision
  to represent nodes as integers; or a hash table if you've made less
  sensible decisions)
    * Sam likes a separate table, since we don't want to crowd
      our node data type with data used in only one context.

### L

* Probably an array of size n.

### S

* We'll be both adding and removing elements.  Stack or queue or
  priority queue.  

Side node: dequeue (structure) vs dequeue (operation)

