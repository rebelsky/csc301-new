---
title: "EBoard 08: Nearest Neighbor, Revisited"
number: 8
section: eboards
held: 2021-09-13
link: true
---
# {{ page.title }}

_Approximate overview_

* Admin
* Notes on the DNF partitioning algorithm
* Notes on and examples of the nearest neighbor algorithm

Administrative stuff
--------------------

* Happy Monday!
* Even exceeding my forty-hour weeks by a bunch, I'm falling behind.
  Apologies.
* I finished assignment 3.  I think it took me about three hours,
  and there are some odd issues with nearest neighbor.
    * I did verify my theory that implementing algorithms helps you
      learn about them.
    * It's nice to see something like "5950 tests passed".
    * I've cut some parts and provided some helpful code.

### Upcoming token-generating activities

* Football, 1pm, Saturday

### Upcoming other activities

### Upcoming work

* [Assignment 3](../assignments/assignment03) due Thursday.
* No reading for Wednesday

### Q&A

Can I use mutable pairs?

> Ugh.  I suppose if you have a good rationale.

Could you explain what you want in the csv file for HW3?

> Sure.  You'll be looking at different size arrays.  And you'll
  be looking at each size multiple times.

> In trying each size, you'll find a minimum number of swaps, a maximum
  number, and you should be able to find the average using the legendary
  method of "add all the trials and divide by the number of trials"

> You'll then print out the info in a useful form.

> And even graph them in your favorite graphing program.

Notes about the DNF partitioning algorithm
------------------------------------------

* Drawings help as you design and implement algorithms.
* Thinking about the *state* of the system and how you maintain
  characteristics of that state helps you design algorithms.
* Running algorithms by hand helps you understand them.
  It can also help you design them.

A nearest neighbor example
--------------------------

You can find starter code in [nn.rkt](../examples/nearest-neighbor/nn.rkt).

Our points are as follows

```
'((0 . 0) 
  (1 . 6) 
  (4 . 2) 
  (8 . 0) 
  (8 . 5) 
  (8 . 14)
  (9 . 8) 
  (9 . 13) 
  (12 . 5) 
  (14 . 8) 
  (18 . 9) 
  (15 . 12))
```

* Sort based on x and y
        (define pointsx
          (sort points (lambda (p1 p2) (< (px p1) (px p2)))))
        (define pointsy
          (sort points (lambda (p1 p2) (< (py p1) (py p2)))))
* Sorting is often done as a precondition to the real algorithm

The real algorithm, which starts with sorted lists.

* Find the length ; an extra O(n) work hurt
        (define len (length pointsx))
        (define half (quotient len 2))
* Divide the xpoints into left half and right half
        (define leftx (take pointsx half))
        (define rightx (drop pointsx half))
* Find the dividing point, call it `div`.  For this example, it's 8.
        (define div 8)
* `div` is really the largest value in left.  It's another O(n) step.  Deal.
        (define div (px (last leftx)))
* It would be better to use `(px (first rightx))`
* Divide the ypoints into left half and right half.  
        (define lefty (filter (lambda (pt) (<= (px pt) div) pointsy))
        (define righty (filter (lambda (pt) (> (px pt) div)) pointsy))
* Recurse on the left half and the right half
* Find the closest distance of those two (sqrt 13)
* Find crossovers

**Explore crossovers** - Walk through the points in increasing y order,
looking at potential close elements on the others side

* Filter points on left and right
        (define lfy (filter (lambda (pt) (< (- div (px pt)) delta)) lefty))
        (define rfy (filter (lambda (pt) (< (px pt) (+ div delta))) righty))
        (define rfy (filter (lambda (pt) (< (- (px pt) div) delta) righty))
  other side.
* We are only looking equal or above, which means we have to compare
  those on the left to those on the right and those on the right to those
  on the left.  We could instead only start with those on the left and
  look delta above and delta below.

Run example by hand, then go back and look at code.

Consider our algorithm, as run on the points 
`'(1 . 1) (1 . 3) (1 . 4) (1 . 8))`

* Length is 4
* Half is 2
* div is 1
* leftx = all the points
* rightx = empty
* Two problems: 
* Problem 1: We don't have anything to do with an empty set.  
    * Handle the special case of "there's no pair on this side"
    * You'll also have that for a singleton
* Problem 2: We haven't made the problem smaller, which is necessary
  for recursion.  So we will get "runaway recursion"
    * We address problem 2 by ensuring that no two points have the same
      x coordinate.
* How else might we ensure that we divide correctly?
    * Switch to dividing by y.  May still have the same problem.
    * Check if one side is empty and, if so, use a different algorithm
      `'(1 . 1) (1 . 3) (1 . 4) (1 . 8) (2 . 1))`

Consider our algorithm, as run on the points 
`'(0 . 1) (1 . 3) (1 . 4) (1 . 8))`

More examples
-------------

You will be divided into four groups.  Each group will try a different
strategy on each problem.  You can assume T(1) = 1 unless it's more
convenient to assume T(1) = c or T(0) = c.

### T(n) = T(n/2) + n

* Group 1: Bottom-up
* Group 2: Tree
* Group 3: Top-down
* Group 4: Top-down

### T(n) = T(n/2) + c

* Group 1: Tree
* Group 2: Top-down
* Group 3: Bottom-up
* Group 4: Bottom-up

### T(n) = T(n-1) + c

* Group 1: Top-down
* Group 2: Bottom-up
* Group 3: Tree
* Group 4: Tree

### T(n) = T(n-1) + n

* Group 1: Bottom-up
* Group 2: Tree
* Group 3: Top-down
* Group 4: Top-down

### T(n) = 3\*T(n/4) + n

* Group 1: Tree
* Group 2: Top-down
* Group 3: Bottom-up
* Group 4: Bottom-up

### T(n) = 3\*T(n/2) + n

* Group 1: Top-down
* Group 2: Bottom-up
* Group 3: Tree
* Group 4: Tree

### T(n) = 2\*T(n/2) + nlog2n

* Group 1: Bottom-up
* Group 2: Tree
* Group 3: Top-down
* Group 4: Top-down

Discussion (if time)
--------------------
