---
title: "Assignment 8"
number: 8
link: false
assigned: 2021-10-27
due: 2021-11-04
due-time: 10:30pm
---
# {{ page.title }}

*Due*: {{ page.due | date: '%A, %-d %B %Y' }} by {{ page.due-time }}

*Summary*: In this assignment, you will implement two different sorting
algorithms, one of your own design.

*Purposes*: To enhance your understanding of sorting algorithms.  To give
you more practice programming.

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

You now know a variety of sorting algorithms.  In practice, many 
people use variants of these sorting algorithms.  For example,
TimSort, which is used by Python and Java, looks for nearly-sorted
sections, sorts those by using insertion sort, and then combines
neighboring sorted sections using the merge from merge sort.  People
who understand their data well might use a variant of one of the
O(n) sorting algorithms.

## Part One: Design your own sorting algorithm

In the sample code that accompanies this assignment, you will find
implementations of merge sort and insertion sort for arrays of
strings.  As noted above, we can usually achieve better speed both
by taking a less strict approach to merge sort and by using insertion
sort for some chunks.

Your goal is to write a sorting algorithm that "generally" behaves
more quickly than the version of merge sort that we've provided.  Your
algorithm should, at minimum,

* Identify appropriate sequences that are already sorted or close to
  sorted.  In the latter case, it should use insertion sort to sort
  them.
* Merge neighboring sorted sequences as appropriate.

You are also free to make other optimizations.  For example, you
might

* Consider identifying reverse-sorted sequences and how to process them quickly.
* Look at ways to improve individual lines of code.
* Incorporate other stable mechanisms for sorting.

You will use the provided analysis code to determine how much faster
your algorithm is than the original merge sort algorithm on a variety
of sample inputs.

Please create two new files, `name-sort.h` and `name-sort.c`
(substituting in your name for "name") and update the analysis code
to use your code, too.

We will celebrate the best sorting algorithms in class.

If you look for details about TimSort or other fast sorting algorithm,
make sure to cite those details.

## Part Two: Radix sort for strings

As you may recall, *radix sort* for integers works by using the binary
digits of the integer, repeatedly grabbing the 0's at each location and
putting them before the 1's at the same location.  If we move from lower-order
bits to higher-order bits, this mechanism 

