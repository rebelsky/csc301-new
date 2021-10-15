---
title: "Assignment 7: Loop Invariants"
number: 7
link: true
assigned: 2021-10-15
due: 2021-10-25
due-time: 10:30pm
---
# {{ page.title }}

*Due*: {{ page.due | date: '%A, %-d %B %Y' }} by {{ page.due-time }}

*Summary*: In this assignment, you will write some algorithms and develop
proofs of corrects using loop invariants and related techniques.

*Purposes*: To give you practice with loop invariants.  To introduce
you to some other important algorithms.

*Collaboration*: You may discuss this assignment with
anyone you like, provided you credit such discussion when you submit
the assignment.  You should not look for solutions online.

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

Problem 1: Dutch National Flag
------------------------------

[Wikipedia](https://en.wikipedia.org/wiki/Dutch_national_flag_problem) describes the Dutch National Flag (DNF) problem as follows.

> The Dutch national flag problem is a computer science programming problem proposed by Edsger Dijkstra. The flag of the Netherlands consists of three colors: red, white, and blue. Given balls of these three colors arranged randomly in a line (it does not matter how many balls there are), the task is to arrange them such that all balls of the same color are together and their collective color groups are in the correct order.

A traditional loop invariant for this problem divides the array of values into four sections: elements we've already identified as red, elements we've already identified as white, elements we have not yet processed, and elements we've identified as blue.  It might be drawn as follows.

```
+-----------+-------+-----------------------------+-------+
|    red    | white |       unprocessed           |  blue |
+-----------+-------+-----------------------------+-------+
```

Using the techniques we've discussed and used in class, develop an iterative in-place algorithm that solves the DNF problem and prove your algorithm correct.  Make sure to prove that the final array has the form "all reds, all whites, all blues" and that the central loop terminates.

You need not implement your algorithm; pseudocode suffices.

Problem 2: Selection Sort
-------------------------

As you may recall, the Selection Sort algorithm works by repeatedly finding
the largest (or smallest) remaining element in the array and putting it
in the correct position.  Develop an appropriate loop invariant for 
Selection sort and then prove the algorithm correct.

You need not implement your algorithm; pseudocode suffices.

### Problem 3: Randomly selecting courses

Professor R and their advisee are working on preregistration. While they’ve agreed on the first three courses (CS, Studio Art, and Foreign Language), they are debating what the student should take for the fourth course. It could be a course in the Humanities it could be be a course in one of the Social Sciences. They’ve made a list of possible courses. They decide to repeatedly apply the following process for narrowing down the list of courses.

* Randomly pick two courses from the list.
* If the two courses are in the same division, that’s a sign that that division dominates too much. Get rid of both courses. But to make sure that we still have a reasonable selection, add a new humanities course to the list. (You can assume that there are arbitrarily many new humanities courses to add.)
* If the two courses are in different divisions, keep the social science and drop the humanities course. (Dropping the humanities course in this case conceptually offsets the addition of the humanities course in the prior case.)

I didn’t say that it was a sensible approach. Just that it was an approach. Still, my advisees may be familiar with it.

a. Prove that the process terminates with only one course.

b. Write a loop invariant that provides useful information about the state of the system (e.g., the number of humanities and/or social science courses that remain).

c. Using that invariant, determine the division of the final course based on the number of initial courses in each division.

---

**Citations**.  The Dutch National Flag problem is due to Dijkstra.  The
Course Selection problem is taken from an exam in an earlier section of
CSC-301.  It is based on a common loop invariant problem.
