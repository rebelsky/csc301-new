---
title: "Assignment 2: Algorithm analysis"
number: 2
link: true
assigned: 2021-09-03
due: 2021-09-08
due-time: 10:30pm
---
# {{ page.title }}

*Due*: {{ page.due | date: '%A, %-d %B %Y' }} by {{ page.due-time }}

*Summary*: In this assignment, you will both explore some issues
pertaining to algorithm analysis and further your skills at developing
algorithms.

*Purpose*: To ground/refresh your understanding of complexity analysis.
To encourage you to think more broadly about algorithm design.

*Collaboration* (written): You may discuss this assignment with anyone you
like, provided you credit such discussion when you submit the assignment.
You will find that you learn the material better more if you follow 
initial design discussions in a group with individual writing.  Each 
person should write up his, her, zir, or their own work and submit it
individually.

*Submitting*: Turn in your work on gradescope.  While I would prefer
that you use LaTeX, you may certainly do your work by hand and scan
it.  Make sure to include your name, course information, and date
at the top of the page.

*Evaluation*: We will primarily evaluate your work on its *correctness*
(e.g., does it compute what it is supposed to; does it meet the
requirements of the assignment) and *clarity* (e.g., is it easy to read,
is it well formatted and documented).  

*Warning*: So that this assignment is a learning experience for everyone,
we may spend class time publicly critiquing your work.

---

1. Do problems 2.1--2.6 from Roughgarden 1.

   Problem 2.6 reads 

   > Let f(n), g(n) denote functions from the positive integers to the positive real
     numbers.  Prove that f(n) = O(g(n)) if and only if g(n) = Omega(f(n)).

   _Problem 2.6 is optional._

2. Do problem 2.7a from Roughgarden 1.

   > Let T(n), f(n) denote two functions from the positive integers to the positive
     real numbers.  Recall the formal definitions of big-O (Section 2.2.3) and little-o
    (Section 2.4.3) notation.

   > (a) Suppose we replace the inequality (2.1) in the definition of big-O notation
     with a strict inequality (T(n) < c\*f(n)) and leave the definition otherwise 
     unchanged.  Prove that T(n) = O(f(n)) under this alternative definition if and
     only if T(n) = O(f(n)) under the original definition.

3. Determine a Big-Oh bound for the following loop

    ```
    function fun(n)
      r := 0
      for i := 1 to n-1 do
        for j := i+1 to n do
          for k := 1 to j do
            r := r+1
      return r
    ```

4. Determine a Big-Oh bound for the following loop 

    ```
    function fun(n)
      r := 0
      for i := 1 to n do
        for j := 1 to i do
          for k := j to i+j do
            for l := 1 to i + j - k do
              r := r+1
      return r
    ```

5. For each of the following functions, determine whether f(n) is
in O(g(n)), g(n) is in O(f(n)), or both.  No formal proofs needed.
Note that log2 is "log base 2".

    a. f(n) = log(n); g(n) = log2(n)

    b. f(n) = log(n<sup>2</sup>); g(n) = log(n) + 5

    c. f(n) = sqrt(n); g(n) = log(n<sup>2</sup>)

    d. f(n) = (log(n))<sup>2</sup>; g(n) = log(log(n))

    e. f(n) = 10; g(n) = log(n)

6. Suppose that f(n) = 3(n<sup>4</sup>) + 2(n<sup>2</sup>) - 5n + 1.  Prove that f(n) is in
Theta(n<sup>4</sup>).  You may not rely on our earlier lemmas about Big-Oh.

7. For each of the following, give an answer and a brief explanation
for your answer.

    a. If I prove that an algorithm takes O(n<sup>2</sup>) worst-case
    time, is it possible that it takes O(n) on some inputs?

    b. If I prove that an algorithm takes O(n<sup>2</sup>) worst-case
    time, is it possible that it takes O(n) on all inputs?

    c. If I prove that an algorithm takes Theta(n<sup>2</sup>)
    time, is it possible that it takes O(n) on some inputs?

    d. If I prove that an algorithm takes Theta(n<sup>2</sup>) 
    time, is it possible that it takes O(n) on all inputs?

    e. Consider the function f(n) = 100(n<sup>2</sup>) for even n and 20(n<sup>2</sup>)-10nlogn
       for odd n.  Is f(n) in Theta(n<sup>2</sup>)?

_Problem 7 is optional!_

8. Prove that 1<sup>2</sup> - 2<sup>2</sup> + 3<sup>2</sup> - 4<sup>2</sup> + ... + (-1)<sup>(k-1)</sup>\*(k<sup>2</sup>) =
   (-1)<sup>(k-1)</sup>\*k(k+1)/2

_Problem 8 is optional!_

*Problems 3--8 were adapted from Skiena.*

---

Questions and answers
---------------------

What is "worst case time"?

> When analyzing algorithms, we can look at the best case, the average
  case, or the worst case.  For example, insertion sort is incredibly
  fast with already-sorted arrays.  O(n).  It is also slow O(n^2) on
  reverse-sorted arrays.  That's the worst case.  

> When we say "worst case time is bounded by O(g(n))", we mean that
  the worst case never takes more than c\*g(n) for sufficiently
  large inputs.  We say nothing about the average or best cases.

For 3 and 4 can I write a program rather than doing the careful
analysis that a responsible computer scientist would do.

> Sure.  At least to check your analysis.  Or maybe to inspire
  your analysis.

Can this assignment be due Thursday night?

> Sure.

Can this assignment be due Friday night?

> No.

Do we have to give arguments for 2.1--2.4?

> No.  But arguments might earn you partial credit.
