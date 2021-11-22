---
title: "EBoard 35: Skip-Lists 1 and Dynamic Programming 3" 
number: 35
section: eboards
held: 2021-11-22
link: true
---
# {{ page.title }}

_Approximate overview_

* Admin
* Skip lists
* Knapsack, continued
* Minimum edit distance

Administrative stuff
--------------------

* I've made some revisions to the schedule. At least I think I have.
* We do not have class on Wednesday.
* I hope that those of you who celebrate Thanksgiving have a wonderful time.
    * We acknowledge that Grinnell is on traditional Ioway lands, as is
      the Meskwaki settlement.  (The Meskwaki were orignally from along
      the Saint Lawrence river and were pushed westerward by settlers.)
    * I look forward to the time when the College makes a more substantial
      acknowledgement of this issue, perhaps by offering scholarships
      to members of the Ioway.
* Class Monday may start late.

### Upcoming token-generating activities

* Vegan Potluck this Saturday.
* Learning from Alumni tomorrow: William Rebelsky '17.  (Possibly in
  person, possibly remotely.)

Other good things

### Upcoming work

* [HW11](../assignments/assignment11) due in about a week and a half.
    * Implement skip lists
    * I have a full Q&A day planned next week
* [HW12](../assignments/assignment12) due in about two and a half weeks.
    * Some dynamic programming problems
    * Topological sort

### Q&A (not on Skip Lists)

Skip Lists
----------

The Knapsack Problem, Revised
-----------------------------

You are a burglar.

You have a backpack that can hold up to k cubic centimetres of stuff.

You are in a warehouse.  It's unguarded, so you have a lot of time
to look at what's there.

In the warehouse are a variety of boxes.  Each box has a value v[i],
and size s[i].  Your backpack is magic!  It can stretch to hold exactly
k cubic centimeters (i.e., you don't have to worry about layout).

Your goal: Get the most value for the size.

### Our example

```
Box     Size    Value
0       0       0

1       1       1
2       1       5

3       2       2
4       2       1
5       2       7

6       3       2
7       5       2
8       6       11
9       8       3
10      10      19
11      15      10
```

### A recursive formulation

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

Two problems:

* Running time O(n!)
* Less commonality of recursive formulations

### An alternate recursive formulation

_TPS_

Suppose we've solved the problem using boxes 0 through k.  How does
it help us solve the problem for boxes 0 through k+1?

```
; knapsack(c, k, const boxes) - Find the maximum value for 
; a capacity of c using boxes 0 .. k.
knapsack(c, k+1, const boxes) =
  ???
```

### A dynamic programming approach

_TPS_

What does your table/cache look like?  (Note: A two-dimensional table
might be better.)

How do we fill it in iteratively?

Minimum edit distance
---------------------

We have two strings, s1 and s2.  We want to know the fewest number
of "edits" (delete a letter, insert a letter) necessary to go from
s1 to s2.

### Phrase recursively

Think about working with the last letter in each string, and
shortening.

```
editDistance("","") = 0
editDistance(s1,"") = length(s1) * deleteCost
editDistance("",s2) = length(s2) * deleteCost
editDistance(s1,s2) = ?
```

### What does our cache table look like?

### Dynamic programming solution
