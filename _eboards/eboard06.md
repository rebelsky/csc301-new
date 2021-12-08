---
title: "EBoard 06: Pause for breath"
number: 6
section: eboards
held: 2021-09-08
link: true
---
# {{ page.title }}

_Approximate overview_

* Admin
* More on nearest neighbors
* Other Roughgarden examples

Administrative stuff
--------------------

* Please ask questions on Teams (and mention me).  That way, those
  who hadn't thought of the question still have access to both the
  question and the answer.

### Upcoming activities

* Any suggestions?

### Upcoming work

* [Assignment 2](../assignments/assignment02) due tonight.
* [Assignment 3](../assignments/assignment03) due next Thursday.
* No reading for Friday!

### Q&A

For assignment 2, we had to order functions according to their order.
Should we be able to do that without graphing them?

> I'm comfortable with you using whatever strategy you find best.
  However, it's nice if you can do the mathematical manipulation
  to make the argument.

Let's choose an example, sqrt(n) vs 2^sqrt(log2(n)).  Are you willing
to make a fool of yourself trying to solve this one?

> 2^(x^y): Are there other ways to think of that?  **This did not help**

> I know that 2^(log2(n)) = n by definition

> Let k be log2(n).  **This is the important step, I think.**

> sqrt(2^k) vs 2^sqrt(k) 

> 2^(k/2) vs. 2^sqrt(k)

> k/2 dominates sqrt(k), so 2^(k/2) dominates 2^sqrt(k) _Should I prove this?  Nah_

> I think 2^sqrt(log2(n)) is in O(sqrt(n))

Can number eight be optional because Sam typed it wrong?

> Yes.

If I can answer questions when you call on me and wake me up, can I
sleep in class?

> I'd prefer that you didn't.

I'm not sure how to approach 2.1.  Can we go over that one?

> Summary: Suppose f(n) is in O(g(n)) and some other stuff.  
  Is f(n)\*log2(f(n)^c) in O(g(n)\*log2(g(n)))

> Four options: Yes, no, sometimes/depends on c; sometimes/depends on f
  and/or g.

> As you learned taking the SAT/ACT/..., multiple choice questions
  can be evil.  We sometimes try to discard the obvious false choices.

> Or we can try to see how to analyze.  log2(f(n)^c) = c\*log2(f(n)).
  That's why there are handy-dandy log rules.

> Am I screwed if c is negative?  (Suggests answer 3.)  Fortunately,
  we've been told that c is positive.

> c\*f(n)\*log2(f(n)) vs. g(n)\*log2(g(n))

> Big Oh says I can throw away constants.

> f(n)\*log2(f(n)) vs. g(n)\*log2(g(n))

> The stupid c answer is wrong.

> If f(n) is in O(g(n)), is log2(f(n)) in O(log2(g(n)))?  Yes, 
  provided g(n) is at least 2.

> The book says f(n) and g(n) are at least 2.

> So the answer is "Yes", the original relation holds.

> Moral: Math is necessary.  Sometimes you have to look it up.
  Develop intuition?

> Growth mindset says we can all develop mathematical intuition.

Nearest neighbors
-----------------

_What questions do you have about the Nearest Neighbors algorithm?_

Did we find the running time?

> No.  We might do that today.  Or maybe Friday.

What is the running time?

> Preview: O(nlogn)

Why do we need the points sorted by x and y?

> We have them sorted by x to make it easy to split into "left half"
  and "right half".

> We have them sorted by y to make it easier to check the "crossover"
  pairs.

> We can split the y list by identifying the largest x on the left half
  and taking only the points that are <= that (left) and > (right)

What's a crossover pair?

> One in which one point is on the left and one is on the right.

Was there something we were supposed to remember about crossover pairs?

> Yes.  

> First, you look for them by iterating through the relevant points
  vertically.   If a point is on the left, you also have to look
  at potentially nearby points on the right.  If a point is on the
  right, you have to look at potentially nearby points on the right.

> Second, you will only have to look for at most *four* nearby points
  on the other side.  

Can it be less than four?

> Yes.  It could be zero.

Can we do an example in class?

> Maybe Friday.

Do the coordinates have to be integers?

> I don't think so.

Are there any steps we do before finding the split pairs?

> You filter out any points that are not within delta of the
  dividing line between left and right.

_What did you learn from the Nearest Neighbors algorithm?_

* Divide and conquer can provide solutions in unexpected situations.
* Divide and conquer can lead to more efficient solutions, at least
  in terms of time.
* Proof techniques come into play in algorithm design.
    * Pigeonhole principle and proof by contradiction to show that
      there could be only four points on the other side that are
      sufficiently near.
* Some algorithm design is not intuitive and really hard.
* Sometimes you need to use other algorithms that you don't expect
  to be more costly than the core one.  In this case, we needed to
  sort the points.  That means we are in Omega(nlogn).

Other Roughgarden examples
--------------------------

* Integer multiplication
* Matrix multiplication
* Count inversions

Recurrence relations
--------------------

While you are used to loop counting for iterative algorithms, recursive
algorithms generally require a different strategy.

1. We define a function, T(n), that represents the running time on 
   an inputs of size n.

2. We write a recursive formulation of T(n) based on the behavior
   of the algorithm.  For examples, I might say that because
   merge sort requires two recursive calls on half the size plus
   about n work to merge, T(n) <= 2\*T(n/2) + n.  I also know that
   T(1) = 1.

3. We attempt to convert that relation to a "fixed form" that does not
involve a recursive reference.
 
Some other common (or otherwise interesting) recurrence relations

* T(n) <= T(n/2) + n
* T(n) <= T(n/2) + c
* T(n) <= T(n/2) + n + c
* T(n) <= T(n-1) + n
* T(n) <= T(n-1) + c
* T(n) <= T(n-1) + c + n
* T(n) <= 2\*T(n/2) + c
* T(n) <= 2\*T(n/2) + n + c
* T(n) <= 7\*T(n/8) + n ; Matrix multiplication

Techniques for solving recurrence relations
-------------------------------------------

There are five main techniques people use when they encounter a
recurrence relation.

* Compute T(2), T(4), T(8) (or whatever a reasonable sequence is)
  and see if you can identify a pattern.
* Repeatedly expand the right side of T(n) and see if there's a pattern.
* Draw a tree, count the cost at each level and then add 'em up.
* Rely on a reference that lists all the common patterns.
* Use a formula.

We'll look at the first three today and the last tomorrow.
