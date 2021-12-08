---
title: "Assignment 10: Max Flow"
number: 10
link: true
assigned: 2021-11-10
due: 2021-11-18
due-time: 10:30pm
---
# {{ page.title }}

*Due*: {{ page.due | date: '%A, %-d %B %Y' }} by {{ page.due-time }}

*Summary*: In this assignment, you will explore a variety of problems
related to max flow.

*Purposes*: To enhance your understanding of the max flow problem.
To provide further evidence that you have achieved particular
course goals.

*Collaboration* (written): You may discuss this assignment with
anyone you like, provided you credit such discussion when you submit
the assignment.  However, you should have such discussion before putting
pen to paper (or stylus to screen, or fingers to keyboard).

*Submitting*: Turn in your printed/scanned work on Gradescope.  Make
sure to include your name, course information, and date.

*Warning*: So that this assignment is a learning experience for everyone,
we may spend class time publicly critiquing your work.

---

We have recently learned the Ford-Fulkerson algorithm for finding the
maximum flow in a weighted, directed graph.  We've also started to 
explore how Max-Flow can be used to solve seemingly unrelated graph
algorithms, such as finding the maximum number of connections in
a bipartite graph (e.g., to assign people to jobs).

## Problem 1: Applying Ford-Fulkerson

Consider graph given by the following edges.

```
S -16-> A (that is, there is an edge from S to A of weight 16)
A -12-> B
B -06-> T
S -13-> C
C -14-> D
D -20-> T
C -04-> A
B -09-> C
D -07-> B
```

Show the sequence of graphs (both updated original
graphs and intermediate max flow graphs) for finding 
the max flow for that graph.

## Problem 2: Bipartite Matching and Ford-Fulkerson

Consider a bipartite graph with nodes (A, B, C, D, E) on the left
and the nodes (F, G, H, I) on the right.  We have the following edges.

* From A to F
* From B to F and H
* From C to G, H, and I
* From D to H
* From E to H

Draw this graph as appropriate for the max flow problem and show
the graph after each step in finding the max flow.  When given the
choice of augmenting paths, choose the one that comes lexicographically
first (e.g., choose the path through BF before the path through BH,
and the path through CI before the path through DH).

_Note: This problem is adapted from CLRS 26.3-1._

## Problem 3: Reducing Task Assignment to Max Flow

_This problem is flawed enough that you are not expected to complete it.
If you show me reasonable work on this problem, you will earn at least 
on token._

In the *task assignment* problem, we are given a set of `n` workers and
a set of `m` tasks.  Each worker has an integer workload capacity, which
you can think of as the number of hours that the worker is available to
work.  Each worker also has a list of tasks they have the background
to complete.  Each task has an expected number of hours it takes to
complete.

For example, we might have the following

Workers:

* w1: capacity 10, background for t1, t2, t3.
* w2: capacity 8, background for t1, t3, t4.
* w3: capacity 7, background for t2, t3, t5.

Tasks:

* t1: 7 hours
* t2: 5 hours
* t3: 5 hours
* t4: 2 hours
* t5: 3 hours

In a "task assignment", you assign workers to tasks so that no
worker works more than their capacity, workers only work on tasks
they have the background to complete.  No task has more than one
worker.  (Read _The Mythical Man Month_ for why we can't assume
that k workers who each contribute h hours, don't produce k\*h
hours of work.)

In the example above, we might assign worker w1 to tasks t2 and t3
(maximizing w1's work), worker w2 to task t1 (the larger of the
two tasks still available to it), and worker w3 to task t5 (the
only task still available to it), leaving t4 unassigned.  In
this model, we complete 22 of the 20 hours available.

We could also make the less sensible assignments of worker w1
to t2, worker w2 to t4, and worker w3 to t5, completing only
12 hours of tasks.

There should also be an assignment that completes all the tasks,
but we'll leave that as an exercise for the reader.

The task assignment problem asks you to find the task assignment
that gives the highest total amount of assigned work.

Write an algorithm that solve the task assignment problem.

_Hint_: Express the task assignment problem as a graph in which the
maximum flow also gives the optimal task assignment.

_Note_: If you can't solve the unlikely-to-be-solvable problem, you
can remove the "at most one worker per shift" problem.

## Exercise 4: Assigning Shifts

As you may know, it can be difficult to assign workers to weekend
shifts.  You would like to distribute shifts so that every shift
is covered.  You also have to ensure that each worker works no more
than one weekend shift.  Let's look at how we model the problem.

You have a set of _w_ workers and _s_ shifts.  (_Sounds somewhat familiar,
doesn't it?_)  Each worker has a list of shifts they are available
to work.  (_The similarities continue._)  Each worker can work at
most _c_ shifts.  (_It feels simpler than the earlier problem._)
Shifts are grouped together, with each shift in exactly one group;
you can think of these groups as representing weekends.  (_Ah!  Now
we have something new!_)

Write an O(_cws_) algorithm that determines whether all the shifts can be
covered and, if so, what that coverage is.  As you might expect,
you should represent the problem as a graph and use the max-flow algorithm
to find the assignment (or to show that one is not possible).

You should also include a short argument that the algorithm runs in the
O(_cws_) time.

_Hint_: You will likely need to add an extra set of nodes as compared
to, say, the bipartite matching problem.  In particular, you will find
it helpful to add a node per worker/group pair.

_Note: This problem is adapted from a problem by Kleinberg and Tardos._

