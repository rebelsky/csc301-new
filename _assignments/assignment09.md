---
title: "Assignment 9: Minimum Spanning Trees"
number: 9
link: true
assigned: 2021-11-05
due: 2021-11-11
due-time: 10:30pm
---
# {{ page.title }}

*Due*: {{ page.due | date: '%A, %-d %B %Y' }} by {{ page.due-time }}

*Summary*: In this assignment, you will implement three greedy MST
algorithms. 

*Purposes*: To enhance your understanding of the MST algorithms.  To
experimentally compare algorithms.

*Collaboration* (programming): You may discuss this assignment with
anyone you like, provided you credit such discussion when you submit
the assignment.  You may also look for solutions online, although
you will likely learn more if you try to implement them yourself
before relying online solutions.  You should not develop code
together, but you may certainly help each other debug code.  Each
person should write up his, her, zir, or their own work and submit
it individually.

*Submitting*: Turn in your work on Gradescope.  Make sure to include
your name, course information, and date at the top of each code
file.

*Evaluation*: We will primarily evaluate your work on its *correctness*
(e.g., does it compute what it is supposed to; does it meet the
requirements of the assignment) and *clarity* (e.g., is it easy to read,
is it well formatted and documented).  

*Warning*: So that this assignment is a learning experience for everyone,
we may spend class time publicly critiquing your work.

---

We've encountered three greedy MST algorithms

* Prim's algorithm with heaps, which picks a random starting node
  and repeatedly adds the smallest edge to a node not yet in the 
  MST.  (You'll probably want to mark nodes.)
* Kruskal's algorithm with union-find structures, which repeatedly
  grabs the smallest edge that joins two unconnected subgraphs.
* An unnamed algorithm that repeatedly removes the largest edge
  that does not disconnect the graph.

a. Implement all three algorithms and the associated data structures
in the programming language of your choice.  You must use the same
language for all three algorithms.  If you can find implementations of
the data structures and you trust those implementations, you may use
them, provided you cite them appropriately.  However, you should attempt
to implement the algorithms without relying on the Web.

b. Gather timing data on randomly generated graphs to find the growth
curves of each algorithm.  You might also use the randomly generated
graphs to test the correctness of each algorithm, perhaps by comparing
the results of the three algorithms.

c. Summarize what you've discovered in a few sentences.
