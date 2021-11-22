---
title: "Assignment 11: Skip Lists"
number: 11
link: true
assigned: 2021-11-17
due: 2021-12-02
due-time: 10:30pm
---
# {{ page.title }}

*Due*: {{ page.due | date: '%A, %-d %B %Y' }} by {{ page.due-time }}

*Summary*: In this assignment, you will implement an algorithm from
the literature.

*Purposes*: To give you practice reading algorithms as described for
practitioners.  To give you you more practice programming.

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

Read the following article.

William Pugh. 1990. Skip lists: a probabilistic alternative to balanced trees. _Commun. ACM_ 33, 6 (June 1990), 668-676. DOI=10.1145/78973.78977. <http://doi.acm.org/10.1145/78973.78977.>

Then implement skip lists in either Scheme, C, or Java. Your implementation should include a procedure that prints out the current state of the skip list. (You may find it easier to print them vertically, rather than horizontally.) You should also provide an appropriate test suite.

Note Although you can easily find some implementations online, you will not gain the necessary understanding if you rely on those implementations. As one of my colleagues says, “There’s a benefit to the pain of debugging a data structure.”

Submit your work on Gradescope.
