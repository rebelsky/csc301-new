---
title: "Assignment 12: Dynamic Programming and More"
number: 12
link: true
assigned: 2021-11-22
due: 2021-12-09
due-time: 10:30pm
---
# {{ page.title }}

*Due*: {{ page.due | date: '%A, %-d %B %Y' }} by {{ page.due-time }}

*Summary*: In this assignment, you will explore dynamic programming as
well as a few other unrelated algorithms.

*Purposes*: To enhance your understanding of sorting algorithms.  To give
you more practice programming.

*Collaboration* (programming): You may discuss this assignment with
anyone you like, provided you credit such discussion when you submit
the assignment.  Each person should write up his, her, zir, or their
own work and submit it individually.

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

## Problems

### Problem 1: Transpositions

Typists often make _transposition errors_ when they type, exchanging
neighboring characters.  For example, I first typed "trnasposition"
instead of "transposition".  Under the edit distance algorithm we 
developed in class, that would require two deletions and two insertions.

Incorporate a _swap_ operation and cost in our edit distance algorithm.

### Problem 2: Interleaving

Suppose you are given three strings, X, Y, and Z, where
|X| = _n_, |Y| = _m_, and |Z| = _m_ + _n_.  _Z_ is an _interleaf_
of X and Y if and only if Z can be formed by interleaving
sequences of characters from X and Y in a way that maintains
the left-to-right ordering of X and Y.  For example, "split"
is an interleaving of "spit" and "l", but "splti" is not.

a. Show that "cchocohilaptes" is an interleaf of "chocolate" and
"chips", assuming the first c comes from "chocolate".

b. Show that "cchocohilaptes" is an interleaf of "chocolate" and
"chips", assuming the first c comes from "chips".

c. Give an efficient dynamic programing algorithm that takes
X, Y, and Z as parameters and determines whether Z is an in
interleaf of X and Y.

_Hint_: The values of the dynamic programming matrix should be
Booleans.

### Problem 3: Longest common substrings

The _longest common substring_ of two strings, X and Y, is the
longst string that appears as a run of consecutive letters in
both strings.  For example, the longest common substring of 
"photograph" and "tomography" is "ograph".

Write a dynamic programming algorithm to solve the longest
common substring problem.

### Problem 4: One of these things is not like the others

a. Implement topological sort in Scheme, C, or Java.

b. Give three "real world" problems that could be solved by
topological sort.

## Citations

Problems 1 through 3 were adapted from Skienna.
