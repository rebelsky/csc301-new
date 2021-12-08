---
title: "EBoard 36: Dynamic Programming 4" 
number: 36
section: eboards
held: 2021-11-29
link: true
---
# {{ page.title }}

_Approximate overview_

* Admin
* Start of class activity: Tree shapes
* Questions on skip lists
* Minimum edit distance, continued
* Adding a substitution cost (if time)
* OCR (if time)

Administrative stuff
--------------------

* I may be late to today's class.
* Please remember to fill out the mentor evaluations if you have not
  done so already.
* Professor Weinman is visiting class today to observe me.

### Upcoming token-generating activities

* Vegan Potluck this Saturday.
* Learning from Alumni tomorrow at 2pm: Larry Boateng Asante '17 (remotely)
* Hidden Disabilities Panel tomorrow at 4pm in JRC 101.
* Technical Interviews Workshop, Tuesday, 7pm
* Wix workshop, Wednesday, ??? (see CLS email)

Other good things

* Potential SEPC thing 7pm Tuesday
* Dec. 2, 5-6pm, Harp Concert in the JR 1925 Center
* Swim meet this weekend.  Earn money by timing!

### Upcoming work

* [HW11](../assignments/assignment11) due Thursday
    * Implement skip lists
    * Wednesday is planned as a discussion/work day.
* [HW12](../assignments/assignment12) due in about one and a half weeks.
    * Some dynamic programming problems
    * Topological sort

### Q&A (not on Skip Lists)

Do we get extra points for doing optional parts?

> Sure.  But remember that your grade in the class depends on whether
  you've demonstrated the ability to manage the key learning goals of
  the class.

When are we covering topological sort?

> Friday, I think.

Q on Skip Lists
---------------

What needs to be in our program?

* All the key dictionary operations: Create, add/update, get, remove
* A nice display operation to print it out
* Optional: Iterators, size, isEmpty

If we write in Java, do we need to use JUnit?

> No.  But it's a good idea.

Should we write remove so that it's an O(logn) operation.

> Maybe.  Upon reflection, it may be O(logn x logn).

> But it should not be linear.

Can we do that without back pointers?

> Of course.  Look for predecessors.

Can we put back pointers in our skip lists?

> Yes.

What's a back pointer?

> It's the "inverse" of the next pointer.  It makes linked lists more fun, 
  because you can go in both directions.

How sophisticated should our test suite be?

> How much credit do you want on the problem?  If your code is correct
  and your test suite is minimal, that's good.  If your code is incorrect
  but you write a giant test suite that fails to catch errors, that's bad.

Opening Problem: Binary trees of size n
---------------------------------------

_Just in case I'm not here on time._

The other day, students in CSC-151 were considering how many binary 
tree "shapes" there are of size _n_.  We might be able to work out
a formula.  We might also write a program to compute it.

We might start with a few examples.

How many trees are there of size three?

```
    *      *   *  *   *
   / \    /   /    \   \
  *   *  *   *      *   *
        /     \    /     \
       *       *  *       *
```

Five, unless I've missed some.

How many trees are there of size six?  Well, we could have a left subtree
of size five and no right subtree, or a left subtree of size four and a
right subtree of size one, or a left subtree of size three and a right
subtree of size two, and so on and so forth.

```
    *        *         *         *         *         *
   /        / \       / \       / \       / \         \
T(5)     T(4) T(1) T(3) T(2) T(2) T(3) T(1) T(4)      T(5)
```

How do we solve that?  We solve for T(5) and T(4) and ....

Detour: T(4) (number of trees of size 4)

```
    *     *           *        *
   /     / \         / \        \
  T(3) T(2) T(1)  T(1) T(2)     T(3)
```

T(4) = 5 + 2x1 + 1x2 + 5 = 14

T(6) = T(5) + 14x1 + 5x2 + 2x5 + 1x14 + T(5) = 

T(5) = T(4) + T(3)xT(1) + T(2)xT(2) + T(1)xT(3) + T(4) = 42

T(7) = 2xT(?) + 2xT(?)xT(?) + 2xT(?)xT(?) + T(?)xT(?)

T(8) = 2xT(?) + 2xT(?)xT(?) + 2xT(?)xT(?) + 2xT(?)xT(?)

T(n) = 2xT(n-1) + more junk!

### Approaches

Math: Write the recursive formulation and attempt to solve using your
vast array of mathematical knowledge.

Engineering: Write a recursive formulation, write a program, gather numbers, 
see what you can figure out.

**Design a dynamic-programming algorithm that determines how many trees
there are of size _n_.  Then use it to find how many trees there are of
sizes 1 .. 20.**

Dynamic programming is useful for more than just optimization.

Edit Distance
-------------

We have two strings, s and t.  We want to know the fewest number
of "edits" (delete a letter, insert a letter) necessary to go from
s to t.

### Phrase recursively

Think about working with the last letter in each string, and
shortening one or both strings.  You can use `last(str)` to
get the last character and `allButLast(str)` to delete the
last character.

Side note: We could also do this front-to-back, but it ends up
being harder once we build the DP table.

```
editDistance("","") = 0
editDistance(s,"") = length(s) * deleteCost
editDistance("",t) = length(t) * insertCost
editDistance(s,t) = ? (some recursive formulation)
  min(????)
```

#### Some examples

_Same last letter_: Suppose we want to change "????a" to "????a".  

* E.g., hella to spella

_Different last letter_: Suppose we want to change "????a" to "????b".  

* E.g., "bla" to "blab"         // Insertion
* E.g., "spella" to "spell"     // Deletion
* E.g., "ba" to "bb"            // Substitution (insertion + deletion)

#### A recursive formulation

Use: `lastChar(str)`, `allButLast(str)`, and `editDistance(str,str)`.

```
editDistance(s,t) = 
  if (last(s) == last(t))
    editDistance(allButLast(s), allButLast(t))
  else
    // Delete the last of the source (not necc. when the source is longer bbbas to basa)
    // or Insert the last of the target
    min (deleteCost + editDistance(allButLast(s), t),
         insertCost + editDistance(s, allButLast(t)))
```

Make a table

Fill in the table from small to large

### What does our cache table look like?

```
    "" t1 t2 t3 t4 t5 t6 ... tn
""   0  i 2i 3i 4i 5i 6i 
s1   d
s2  2d
s3  3d
s4  4d
s5  5d
s6  6d
...
```

### Dynamic programming solution

```
    ""  a  l  p  h  a  b  e  t
""   0  i 2i 3i 4i 5i 6i 7i 8i
a    d  0  i
l   2d     0
f   3d        ?
a   4d
b   5d
e   6d
t   7d
a   8d
```

## Adding a substitution cost (if time)

Depending on the situtation, substitution may be "cheaper" (at least
more likely) than an insertion followed by a deletion.

```
editDistance(s,t) = 
  if (last(s) == last(t))
    editDistance(allButLast(s), allButLast(t))
  else
    // Delete the last of the source 
    // or Insert the last of the target
    // or Substitute the last of the target for the last of the sourc
    // substeCost
    min (deleteCost + editDistance(allButLast(s), t),
         insertCost + editDistance(s, allButLast(t))
         substeCost + editDistance(allButLast(s), allButLast(t)))
```

## Parameterizing costs

What if insertion, deletion, and substitution all depending on what
you were inserting, deleting, or substituting?

## DP wrapup

Usually solving an optimization problem.

Using a recursive formulation that recurses multiple times.

Approach: 

* Write the recursive formulation (yay exhaustive computation)
* Design a table
* Fill in the table

