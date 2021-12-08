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
* Knapsack, continued (and concluded)
* Minimum edit distance

Administrative stuff
--------------------

* I've made some revisions to the schedule. At least I think I have.
    * Added Topological Sort, since we need to cover it.
* We do not have class on Wednesday.
* I hope that those of you who celebrate Thanksgiving have a wonderful time.
    * We acknowledge that Grinnell is on traditional Ioway lands, as is
      the Meskwaki settlement.  (The Meskwaki were orignally from along
      the Saint Lawrence river and were pushed westerward by settlers.)
    * I look forward to the time when the College makes a more substantial
      acknowledgement of this issue, perhaps by offering scholarships
      to members of the Ioway.
* Class Monday may start late.
    * Plan on being here at 2:30; I'll have an activity in the eboard.
* Mentor evaluations coming via email.
    * "Comes late to class."
    * "Saves us from Sam's disorganization."
    * "Doesn't return homework assignments."
* No mentor session tomorrow
    * "Cancels mentor sessions unexpectedly."

### Upcoming token-generating activities

* Really small Vegan Potluck this Saturday.
* Learning from Alumni tomorrow: William Rebelsky '17.  (Possibly in
  person, possibly remotely.)
    * Going from almost no CS classes to CS grad school.

Other good things

### Upcoming work

* [HW11](../assignments/assignment11) due in about a week and a half.
    * Implement skip lists
    * I have a full Q&A day planned next week
* [HW12](../assignments/assignment12) due in about two and a half weeks.
    * Some dynamic programming problems
    * Topological sort

### Q&A (not on Skip Lists)

When do we get to redo stuff?

> Finals week.

Are we going to have to redo stuff?

> I hope not.

Are you going to be lenient, given how bad you are at returning stuff?

> Yes.

Can I take an incomplete in this class?

> Yes.

Skip Lists
----------

* An implementation of sorted lists, as linked lists.
* Used for implementing dictionaries.
* Cool idea: Each node can be in multiple lists, the "height" of a node
  determines which list it is in.
    * All the nodes are in the level 1 list.
    * About half the nodes are in the level 2 list.
    * About 1/4 the nodes are in the level 3 list.
    * ...
* We can also use different probabilities.  But generally 1/(p^n) at level
  n.
* We can search the top level list, then the top-1 level, ...
    * Effectively gives us divide and conquer, relying mostly on
      randomness to set up the structure.
* Find: Expected O(logn)
* Insert: Expected O(logn)
* Faster than sorted lists, which have O(n) insert and find.
* Faster than sorted arrays, which have O(logn) find, but O(n) insert
* Slower than hash tables, but also provide "iterate in order"
* BSTs: Also O(logn) for insert and find, but pain to keep balanced.
    * Iterating is also harder.

What will be hard?

> We hate implementing things.

> The layers/levels.

> Writing in three languages at once.

> Getting the probability right.

> Off by one errors.

How do I get the probability right?

> Read the article.

> Start at level 1.  Repeatedly generate a random number.  If it's less
  than p, add another level.  If it's greater than or equal to p, stop.
  If you reach the max level, stop.

Bring more questions on Monday!

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

Size    0   1   2   3   4   5   6   7  8  9  10
Value   0   5   7  12  13 ....
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

### A better recursive formulation

_TPS_

Suppose we've solved the problem using boxes 0 through k-1 (and for
all capacity <= c).  How does it help us solve the problem for boxes
0 through k?

Phrase this recursively in terms of size[k], value[k], and
a recursive call.

```
; knapsack(c, k, const boxes) - Find the maximum value for 
; a capacity of c using boxes 0 .. k.
;   c: capacity of the knapsack
;   k: The portion of the list of boxes we're using
;   boxes: The list of boxes
knapsack(c, k, const boxes) =
  if (k == 0) 
    return 0;
  else if (size[k] > c)
    return knapsack(c, k-1, boxes);
  else
    return max(knapsack(c, k-1, boxes),     // Don't take the kth box
               knapsack(c-size[k], k-1, boxes) + value[k]) // Take the kth box
```

This remains exponential!  Whoops!

### A dynamic programming approach

We know that dynamic programming helps with recursive optimization
algorithms because we can build a table to cache values; we should
build that table iteratively.

We're going to do a two-dimensional table.

Row k gives knapsack for the first k boxes.
Column c gives capacity of c

```
                     Capacity 
k  0   1   2   3   4   5   6   7   8   9  10  11
   ----------------------------------------------
0| 0   0   0   0   0   0   0   0   0   0   0   0
1| 0   0   2   2   2   2   2   2   2   2   2   2        ; size 2, value 2
2| 0   0   2   2   2   3   3   3   3   3   3   3        ; size 3, value 1
3| 0   4   4   6   6   6   7   7   7   7   7   7        ; size 1, value 4
4| 0   4   6   6   8   8   8   9   9   9   9   9        ; size 1, value 2
5| 0   4n  6n  7y 11  13  13  15  15  15  16  16        ; size 3, value 7 
6|
7|
```

Running time?  O(cn), where n is max number of boxes.

How do I know which boxes I took?  

* You could indicate how you got each entry (See y/n.)

Reminder
--------

Phrase recursively, trust the magic recursion fairy.  ("My recursive
call works.")

Turn into a table.

Built table iteratively.

Minimum edit distance
---------------------

We have two strings, s1 and s2.  We want to know the fewest number
of "edits" (delete a letter, insert a letter) necessary to go from
s1 to s2.

```
hello
hlli
```

Requires us to delete the h and the o, and to insert the i.

### Phrase recursively

Think about working with the last letter in each string, and
shortening one or both strings.  You can use `last(str)` to
get the last character and `allbutlast(str)` to delete the
last character.

```
editDistance("","") = 0
editDistance(s1,"") = length(s1) * deleteCost
editDistance("",s2) = length(s2) * insertCost
editDistance(s1,s2) = ? (some recursive formulation)
  min(????)
```

Suppose we want to change "????a" to "????a".  
* E.g., hella to spella

Suppose we want to change "????a" to "????b".  
* E.g., "bla" to "blab" // Insertion
* E.g., "ba" to "b"     // Deletion
* E.g., "ba" to "bb"    // Substitution (insertion + deletion)

### What does our cache table look like?

### Dynamic programming solution
