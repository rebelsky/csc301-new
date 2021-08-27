---
title: "EBoard 01: An introduction to the course"
number: 1
section: eboards
held: 2021-08-27
link: true
---
# {{ page.title }}

_Approximate overview_

* Preliminaries
* Course goals
* Course format
* Approach algorithms
* Problem: Getting from here to there
* Problem: Robot soldering
* Problem: Task optimization

Administrative stuff
--------------------

* Hi.  I'm Sam.  You should call me "Sam".
* Welcome back to in-person classes!
* Attendance.
* I will use the whiteboard more than I do in a typical class (e.g.,
  to draw).
  If you want copies of what's on the whiteboard, feel free to take
  pictures.

### Apologies

* I am old.  My hearing is not great, even with hearing aids.
* Some combination of age + weight + meds + temperature in room + 
  air movement in room (or lack of such) means I sweat a lot.
* Our Web site is not as up to date as I'd like.  But it will be.  Soon.
  Ish.
* I am traditionally bad at names+faces.  I will be worse with masks.
* More to come ....

### Upcoming activities

Policies

* Still to be determined.

Events

* First Scholars' Convocation, 11 am, Thursday, September 2.
    * Sam will give a shpiel about Scholars' Convocation next week

### Upcoming work

* Read ??? before Monday's class.
* Do assignment 1 (to be distributed this weekend) before 10:30 p.m.
  on Wednesday.

Course goals
------------

* Think of CSC-301 as _CSC-207, enhanced/extended/made more challenging_.
* We will learn how to design and analyze algorithms and data structures
    * Tools, such as methodologies for design
    * Verification techniques
    * Mechanisms for analyzing efficiency
* More of the core literature
* Side note: I assume that you know
    * Trees
    * Merge sort
    * Quicksort
    * Binary search
    * Map/Reduce
    * Priority Queues
    * Priority Queues implemented as Heaps
    * Hash tables with multiple probing techniques
    * Graph basics
    * Linked and array-based structures
    * Proof techniques

Course format
-------------

* I try to employ an active learning format
* Rather than having you read about one of the core algorithms, I will
  likely challenge you to design/implement/analyze them, perhaps assigning 
  different approaches to different groups.
* I will randomly call on people after you've had time to work in small
  groups.
* Once we've tried to design an algorithm ourselves, we will read about
  what people have done in the past.
* We will also have the normal course trappings: Homework assignments,
  some kind of exams, etc.
* I am trying to match assessments to the desired learning outcomes.
  Stay tuned!

Approaching algorithms
----------------------

_You are now experienced computer science students. When some gives you a problem that admits an algorithmic solution, what do you do?_

_Think->Pair->Share_

Problem: Getting From Here to There
-----------------------------------

* Because net neutrality no longer exists, providers can charge, or
  throttle speed, or ... for data that flows along their network.
* We have a problem: We need to get information from place to place,
  and we may want the least expensive path, or the quickest, or ....

_Have you seen this problem in CSC-207?_

We start by modeling the the problem

Then we try to design the algorithm.  

Problem: Optimal Soldering Plans
--------------------------------

*Stolen/modified from Skienna's "The Algorithm Design Manual"*

* We have a bunch of points that we need to have a robot solder
  on a circuit board.
* We want the least wear and tear on the robot.  (So it should move
  the least distance.)
* How do we determine how to order the points?

Problem: Scheduling Overlapping Tasks
-------------------------------------

*Stolen/modified from Skienna's "The Algorithm Design Manual"*

* You have a bunch of tasks, each of which has a start time and a length.
* You can only do one task at a time.
* How do you maximize the number of tasks you complete?

Extension

* What if each task also has a value?  How do you maximize the value
  of the tasks you complete?

