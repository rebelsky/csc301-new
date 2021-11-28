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
* Start of class activity: Tree permutations
* Questions on skip lists
* Minimum edit distance, continued
* Adding a substitution cost (if time)
* OCR (if time)

Administrative stuff
--------------------

* Today's class may start late.
    * Plan on being here at 2:30; I'll have an activity in the eboard.
* Please remember to fill out the mentor evaluations if you have not
  done so already.
* Professor Weinman is visiting class today to observe me.

### Upcoming token-generating activities

* Really small Vegan Potluck this Saturday.
* Learning from Alumni tomorrow: Larry Boateng Asante '17 (remotely)

Other good things

### Upcoming work

* [HW11](../assignments/assignment11) due Thursday
    * Implement skip lists
    * Wednesday is planned as a discussion/work day.
* [HW12](../assignments/assignment12) due in about one and a half weeks.
    * Some dynamic programming problems
    * Topological sort

### Q&A (not on Skip Lists)

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

Sounds familiar, doesn't it?

**Design a dynamic-programming algorithm that determines how many trees
there are of size _n_.  Then use it to find how many trees there are of
sizes 1 .. 20.**

Skip Lists
----------

* How are the implementations going?
* Do you have any questions?

We have two strings, s and t.  We want to know the fewest number
of "edits" (delete a letter, insert a letter) necessary to go from
s to t.

### Phrase recursively

Think about working with the last letter in each string, and
shortening one or both strings.  You can use `last(str)` to
get the last character and `allbutlast(str)` to delete the
last character.

```
editDistance("","") = 0
editDistance(s,"") = length(s) * deleteCost
editDistance("",t) = length(s) * insertCost
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

### What does our cache table look like?

```
```

### Dynamic programming solution

```
editDistance(s,t) {
}

## Adding a substitution cost (if time)

Depending on the situtation, substitution may be "cheaper" (at least
more likely) than an insertion followed by a deletion.

## OCR substitution cost (if time)
