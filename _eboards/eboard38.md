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
* Implementing topological sort

Administrative stuff
--------------------

### Notes

* Sorry that we're doing topological sort a bit out of order.  For some
  reason, I thought it got covered in CSC-207.
* I'll work on getting sign-up-sheets for finals week set up.
* A friendly reminder that the authors work hard to create their textbooks.

### Friday PSA

### Upcoming token-generating activities

* Vegan Potluck this Saturday.

Other good things

* Swim meet this weekend.  Earn money by timing!  And pizza!
* Synchronized swimming performance some time this weekend.

### Upcoming work

* [HW11](../assignments/assignment11) due YESTERDAY (ish)
    * Implement skip lists
* Reading for Monday

* [HW12](../assignments/assignment12) due in about one week and one day.
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

Implementing topological sort
-----------------------------

_Group and Share_

Analysis of topological sort
----------------------------

_What's the running time? (Group and share)_

Implementing topological sort
-----------------------------

_How should we represent the graph? (Group and share)_
