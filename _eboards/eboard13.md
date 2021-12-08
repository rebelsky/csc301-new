---
title: "EBoard 13: Balanced Trees, Continued"
number: 13
section: eboards
held: 2021-09-24
link: true
---
# {{ page.title }}

_Approximate overview_

* Admin
* Red-Black Tree Review
* More About HW5

Administrative stuff
--------------------

* Happy Friday!
    * Unfortunately, it's Friday the 13th (Class)
* I do hope to get more grading done this weekend.
    * Unfortunately, I said the same thing to my other class.

### Friday PSA 

* You're awesome.
* Keep yourself that way.
* Remember: People care about you.
* Moderation!
* Consent is ESSENTIAL!

### Prerequisite material

* The practice in this class is intended to be good for you; it helps 
  you develop programming skills from prior classes and extends your
  knowledge.
* Some of you are struggling with material from prerequisite classes,
  particularly language details.
* Pandemic teaching had an effect, particularly the second half of
  Spring 2020 and the seven-week terms.
* How do we balance all of that?
* Particularly for C and Scheme, make use of evening tutors (or fellow
  CS majors).
* Ask me questions!  I do (sometimes) enjoy looking at code.  The one
  problem is that I'll also comment on "irrelevant" things, like your
  style.
* And I'll probably cut down the pace of the course (slightly).

### Upcoming token-generating activities

* Prof. Eliott's Coffee Chat in ELBICA lab (across from CS Learning Center)
  Fridays 5-6 p.m.
* Pioneer Weekend introductory talk, 7:00 p.m. Friday, October 1.
* Pioneer Weekend, October 1--3.
    * Yes, I agree that Pioneer Weekend should be renamed.
* Grinnell Vegans Potluck, this Saturday, 7pm, you know where.
  Or you know who to ask where.

### Upcoming other activities

* Women's volleyball today at home.  7:00 p.m.
* Kites Over Grinnell Saturday 10:00 a.m.
* Women's soccer Saturday at home. 11:00 a.m.
* Women's volleyball Saturday at home. 1:00 p.m.
* Men's soccer Saturday at home.  1:30 p.m.
* GSO Concert Saturday at 2:00 pm in Sebring-Lewis
* Grinnell Singers Saturday 7:30 in Sebring-Lewis.
* Lunar New Year Celebration next weekend.

### Upcoming work

* Read Chapter 11 in book 2.  (Balancing BSTs)
* [Assignment 5](../assignments/assignment05) due next Thursday.

### Q&A

How long do you expect the assigment to take us?

> Eight hours.  If it takes me more than two, I'll revise it.

> I think I need to take a survey on how long the prior assignments
  took.  Stay tuned!

Red-Black Trees
---------------

A red-black tree is binary search tree with codes colored red and
black and some properties.

* The root is always black.
* Every nil at the fringe is black.
* If a node is red, then both its children are black.
* The "black height" of left and right part of each node are
  the same.  (For each node, all simple paths from the root
  to the leaves have the same number of black nodes.)

With some careful analysis, we can show that the height is at most
2logn+1.

When inserting, you have to pay attention to the color of the nodes.

Two basic operations to transform the tree (other than recoloring).

Assignment 5
------------

Semi-balanced trees have the property that the height of the left and
right differ by at most one.

What happens when we insert on the right and it increases the height
of the right?

Three possibilities

```
    X                  X
  /   \         =>   /   \
 Y(k)  Z(k-1)      Y(k) Z(k)

    X                  X
  /   \         =>   /   \
 Y(k)  Z(k)        Y(k) Z(k+1)

    X                  X
  /   \         =>   /   \
 Y(k)  Z(k+1)      Y(k) Z(k+2)
```

The last case causes a violation.  How do we fix it?  We need to think
about ways to draw that last tree in more detail to think about them.

Let's think about insertion.  We're just going to do part of the
insertion.

insert(node, key, value)
  if (key == node.key)
    node.value = value
    return
  else if (key < node.key)
    node.left = insert(node.left, key, value)
    cleanupLeft(node)
  else // (key > node.key)
    node.right = insert(node.right, key, value)
    cleanupRight(node)

cleanupRight(node)
  if (node.right.height - node.left.height > 1) {
    // Need to clean up
    // Case A from our diagram
    if (node.right.right.height > node.right.left.height) {
      rotateLeft(node)
    }
    // Cases B and C from our diagram
    else if (node.right.left.height > node.right.right.height) {
      node.right = rotateRight(node.right)
      rotateLeft(node)
    }
  }  
  node.height = 1 + max(node.left.height, node.right.height)
