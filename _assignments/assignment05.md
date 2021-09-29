---
title: "Assignment 5: Balanced (more or less) Trees"
number: 5
link: true
assigned: 2021-09-24
due: 2021-09-30
due-time: 10:30pm
---
# {{ page.title }}

*Due*: {{ page.due | date: '%A, %-d %B %Y' }} by {{ page.due-time }}

*Summary*: In this assignment, you will implement and analyze a mechanism
for keeping binary trees balanced first described by Adelson-Velskey and
Landis.

*Purposes*: To enhance your understanding of balanced trees.  To give
you more practice programming.  To give you practice with working from
more formal descriptions.

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

You have now explored at least one primary mechanisms for keeping
binary search trees balanced.  For this assignment, you will be
working with a somewhat simpler technique for balancing trees, one
first described by Adelson-Velsky and Landis in 1962.  In these
trees, we require that the heights of the left and right subtrees
of any node differ by no more than one.  After each insertion or
deletion, we may need to rearrange the tree to maintain that property.

Since our textbook does not contain the full description of such
trees, you will rely on [a description by Donald
Knuth](../files/Knuth-Balanced-Trees.pdf).

**a. Implement Algorithm A (insertion) and Algorithm B (kth element) in Racket.**

To help with that implementation, you can use [a basic implementation
of BSTs](../files/bst.rkt) as a starting point.  I've also included
[a short example of its usage](../files/bst-examples.rkt).

**b. Determine the minimum, maximum, and average height for a large
number of randomly generated trees of sizes 64, 128, 256, 512, 1024,
2048, and 4096.  Show your work and summarize what you've learned.**

Ideally you would make at least a few dozen trees of each size.  

You should make sure to compare the heights of the "balanced" trees to
the heights of other randomly generated trees. 

You should also make sure to check what happens with trees that are
created with keys in strict alphabetical order and reverse alphabetical
order.
