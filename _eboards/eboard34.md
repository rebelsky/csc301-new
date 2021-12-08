---
title: "EBoard 34: Dynamic Programming 2" 
number: 34
section: eboards
held: 2021-11-19
link: true
---
# {{ page.title }}

_Approximate overview_

* Admin
* Optimization
* Knapsack, continued

Administrative stuff
--------------------

* I've made some revisions to the schedule. At least I think I have.

### Friday PSA

* I care about you.
* Please take care of yourselves.
* Consent is essential.
* Embrace who you are.  Don't feel that you have to behave a certain
  way because "that's what everyone does."

### Upcoming token-generating activities

* November 18-21, _Do You Feel Anger?_
    * It's funny and not tall.
* 5:30-6:00 Saturday arrival for "As long as you're not going to 
  Vegan Potluck ..."

Other good things

### Upcoming work

* Sam will be sending you a new reading.
* [HW11](../assignments/assignment11) due in about two weeks.

### Q&A

Optimization
------------

* As you may have figured, we often use dynamic programming for 
  optimization - finding the minimum or maximum value.
* So let's think a bit more about optimization.

### Thinking back to Calculus

* We can think of continuous functions, y = f(x)
* To find the minimum or maximum, we compute the derivative
  and determine when the derivative is zero.
    * These may be local minima or maxima, rather than overall
      minima or maxima.
* And it's not always easy to determine when the derivative is zero.
  Consider, for example cos(x) + (e^x)/10.
    * Disclaimer: It's been a three decades since I've done Calculus.

### Minimizing/Maximizing Continuous Functions, Continued

* As you learned in 161, we're not going to represent most real numbers
  exactly, so we'll permit some error.
* We will try to converge upon an approximation of the minimum/maximum.
* We have to tolerate some error, _e_.
* Try to figure out a bound on the cost: number of steps is in O(g(_e_))

Some practice
-------------

* Do bisection search to find the minimum of a differentiable f on 
  the interval [a,b].
    * You should assume that 
* We'll find a sequence of x values, x1, x2, ... xn, with each closer 
  to the actual x of the minimum (which we'll just call X).
* How do we do this?
* We may need to rely on the differential.
    * f'(x) < 0 iff x > X
    * f'(x) > 0 iff x < X
* It's a divide and conquer algorithm.
* The size of the window is (b-a)/(2^n).  We'll stop when we know the
  estimate is within e of the optimal x.
* So (b-a)/2^n < e

What if we have multiple variables?

* It turns out that alternating between the variables can get us out
  of range of the target.
* Intuition: Find the direction of steepest descent.
* "Gradiaent descent".

Whoops!
-------

* I need to learn not to take strange detours.  Continuous optimization
  may not have as much to do with 
* But it can be useful if you try to do ML.

The Knapsack Problem, Revised
-----------------------------

You are a burglar.  Not the hamburglar.

You have a backpack that can hold up to k cubic centimetres of stuff.

You are in a warehouse.  It's unguarded, so you have a lot of time
to look at what's there.

In the warehouse are a variety of boxes.  Each box has a value v[i],
and size s[i].  Your backpack is magic!  It can stretch to hold exactly
k cubic centimeters (i.e., you don't have to worry about layout).

Your goal: Get the most value for the size.

_How do we phrase this as a recursive optimization algorithm?_

_How do we turn that recursive algorithm into a dynamic programming algoritm?_

_Does it matter if we can have as many of any size box as we want?_  (Perhaps)

### Idea 1

Build some sort of dynamic programming table, like we did for coins.

### Idea 2

Model as a longest path problem.  Draw a graph in which the x axis is
value and the y axis is.

### Idea 3

Start at 0, build up to highest size.

### Idea 4

```
knapsack(boxes, capacity)
  solution = [];
  value = 0;
  for (int i = 1; i <= n; i++) {
    if (size[i] <= capacity) {
      int hypothesis = value[i] + knapsack(boxes.remove(i), capacity-size[i]);
      if (hypothesis < size) {
        solution = solution + ...
        value = hypothesis;
      }
    } // if small enough
  } // for each box
  return solution,value
} // for
```

Running time O(n!)
