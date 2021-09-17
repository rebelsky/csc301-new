---
title: Assignment 4
subtitle: Recurrence relations
number: 4
link: true
assigned:
due: 2021-09-23
due-time: 10:30pm
---
# {{ page.title }}

*Due*: {{ page.due | date: '%A, %-d %B %Y' }} by {{ page.due-time }}

*Summary*: In this assignment, you will explore some issues related
to asymptotic analysis and recurrence relations.

*Purpose*: To enhance your understanding of how to solve recurrence
relations.  To give you practice with the recurrence formula theorem
and proof by induction.

*Collaboration* (written): You may discuss this assignment with anyone you
like, provided you credit such discussion when you submit the assignment.
You will find that you learn the material better more if you follow 
initial design discussions in a group with individual writing.  Each 
person should write up his, her, zir, or their own work and submit it
individually.

*Submitting*:  Turn in your work on Gradescope.  While I
would prefer that you use LaTeX, you may certainly do your work by hand.
Make sure to include your name, course information, and date at the
top of the page.  

*Evaluation*: We will primarily evaluate your work on its *correctness*
(e.g., does it compute what it is supposed to; does it meet the
requirements of the assignment) and *clarity* (e.g., is it easy to
read, is it well formatted and documented). These criteria will be
modified, as appropriate, for written and coding assignments.

*Warning*: So that this assignment is a learning experience for everyone,
we may spend class time publicly critiquing your work.

---

Consider the following recurrence relations.

* a. T(n) <= 3T(n/3) + n<sup>2</sup>.
* b. T(n) <= 3T(n/3) + n.
* c. T(n) <= 3T(n/3) + c.
* d. T(n) <= 3T(n/5) + n<sup>2</sup>.
* e. T(n) <= 3T(n/5) + n.
* f. T(n) <= 3T(n/5) + c.
* g. T(n) <= 9T(n/3) + n<sup>2</sup>.
* h. T(n) <= 9T(n/3) + n.
* i. T(n) <= 9T(n/3) + c.
* j. T(n) <= T(2n/3) + n<sup>2</sup>.
* k. T(n) <= T(2n/3) + n.
* l. T(n) <= T(2n/3) + c.

## Part 1: Manual analysis

Analyze a, b, and c using (i) the bottom-up approach, (ii) the top-down
approach, and (iii) recurrence trees.  It's fine if you don't find a
formula based on the bottom-up approach; we just want to see you do a
few examples.

## Part 2: Applying the recurrence formula

Find bounds for each of the following by using the recurrence formula.

## Part 3: Verifying results

Prove the bounds of a and b using induction on n.

