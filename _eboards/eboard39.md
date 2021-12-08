---
title: "EBoard 39: String matching, revisited" 
number: 39
section: eboards
held: 2021-12-06
link: true
---
# {{ page.title }}

_Approximate overview_

* Approximate string matching, revisited.
* Exact substring matching.
* Analysis of the naïve/brute force subtring matching algorithm.
* Other techniques.

Administrative stuff
--------------------

### Notes

* I'll work on getting sign-up-sheets for finals week set up.
* Happy CS Ed week!
* They've found the Omicron variant in Minnesota, Wisconsin, Illinois,
  Nebraska, and Missouri.  Why haven't they seen it in Iowa?
    * It's Iowa.  Who wants to visit Iowa?
    * If you don't test, you don't have it.
    * Our amazing legislature's policies that required universal
      masking and testing and distancing made a difference.
* I'm trying to schedule grading time for this class.  But I'm still in 
  exam-writing mode for CSC-151 and have some administrative 
  responsibilities that must take priority.

### Upcoming token-generating activities

### Other fun things

* "I Dig You" this weekend.  Ticketing this Wednesday, we think.

### Upcoming work

* [HW12](../assignments/assignment12) due THURSDAY
    * Some dynamic programming problems
    * Topological sort
* [HW11](../assignments/assignment11) due LAST WEEK (ish)
    * Implement skip lists

### Q&A

How are we interpreting the grades?

> Grade on assignments are irrelevant, other than right/wrong.

> The only thing that matters is the number of learning goals you've
  demonstrated that you've achieved.

Can I challenge the grades?

> Sure.

Approximate String Matching, reviewed
-------------------------------------

Given two strings, `s` and `t`, find the minimum edit distance that
will convert `s` to `t` given a cost of `d` to delete a character and
`a` to add a character and `r` to replace a character.

_A lot of TPS_

Here's the table.  s{i} represents "the first i characters of s"

```
            T A R G E T
    C  t{0} t{1} t{2} t{3} t{4}  ...
      +----+----+----+----+----+--
S s{0}| 0  | a  | 2a |    |    | ...
      +----+----+----+----+----+--
O s{1}| d  |    |    |    |    | ...
      +----+----+----+----+----+--
U s{2}| 2d |    |    |    |    | ...
      +----+----+----+----+----+--
R s{3}|    |    |    |    |    | ...
      +----+----+----+----+----+--
C s{4}|    |    |    |    |    | ...
      +----+----+----+----+----+--
E s{5}|    |    |    |    |    | ...
   .    .    .    .    .    .
   .    .    .    .    .    .
   .    .    .    .    .    .
```

What's the recursive statement about the minimum edit distance
between two prefixes, `s{i}` and `t{j}`, which we phrase as
cost(s{i},t{j})?  You can use `s[i]` for the ith character of `i`.

Reminder: For most dynamic programming problems, writing the
recursive statement is 90% of the work.

```
cost(s{i}, t{j}) = 
  if (0 == i)
    return a*j
  else if (0 == j)
    return d*i
  else if (s[i] == t[j])
    return cost(s{i-1}, t{j-1})
  else
    return min(d + cost(s{i-1},t{j}),   // deletion
               a + cost(s{i},t{j-1}),   // insertion
               r + cost(s{i-1},t{j-1})) // replacement
```

"Mathematics is invariant of notation."

"Computer science likes to pretend it's mathematics."

### Edit Steps

How would we update the edit distance algorithm so that we know not
only the edit distance, but also step necessary to change the source
to the target?

Set up another table, as you insert or delete, add to the table.
In each cell, you mark which choice you've made (add, delete, replace,
keep).  You can then read the steps backwards in the table.  

### Approximate substring matching

What if `s` is much smaller than `t` and we care about finding the
optimal alignment?  E.g., we match "habit" or "phat" or "shab"
against "alphabetical"?

Hint: Change the table initialization.

Related idea: Update the table so that it's okay to start anywhere
in `t`.

```
    C  t{0} t{1} t{2} t{3} t{4}  ...
      +----+----+----+----+----+--
S s{0}| 0  | 0  | 0  | 0  | 0  | ...
      +----+----+----+----+----+--
```

Running time O(mn), where m is the length of s and n is the length of t.

Probably as good as we can do.

Exact substring matching
------------------------

There are many variants of the problem.

* Given strings `s` and `t`, find the index of the first match of `s` to a substring of `t`.
* Given strings `s` and `t`, find the index of any one match of `s` to a substring of `t`.
* Given strings `s` and `t`, find all indices of the matches of `s` to a substring of `t`.
* Given strings `s` and `t`, does `s` match any substrings of `t`?

We'll focus on the first.  E.g., find "ska" in "triskaidekaphobia"

Brute force algorithms
----------------------

_TPS_

What's the "obvious" brute force algorithm?

```
for pos = 0 to (length(t) - length(s))
  if (0 == strcmp(s, t[pos,pos+length(s)-1])) then
    return pos
return "not found"
```

What is the cost of that algorithm?  O(mn); no better than the one above.

What is an instance in which we find a match and still come close to the 
upper bound?  s should be length 5, t should length 100.

> Mediocre example: abcde vs abcd-abcd-abcd-abcd-abcd-abcd-....abcde.
  Cost: Approximately 2n.

> `vwxyz` vs `abcdefghijklmnopqrstuvwxyz`.  This is O(n), which is
  pretty fast.

> Source `aaaac` target `aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaac`
  This is O(mn).

What is an instance in which we don't find a match but are far from the
upper bound?  (E.g., one that is close to length(t).)  s should be length
5 (or, preferably, any length), t should be length 100.

> `vwxyv` vs `abcdefghijklmnopqrstuvwxyz`.  This is O(n), which is
  pretty fast.

Improving on the brute force algorithm?
---------------------------------------

_TPS_

Suppose we are doing many matches.  Are there ways we can pre-process
the target string so that the amortized cost is much less?  Does it matter
if all the source strings are the same length?

What other techniques can we use to solve this problem more quickly?

Sam's favorite mechanism ...

* Compute the hash code of each substring of `t` of the appropriate length
  (that is, `length(s)`).
* To determine everywhere `s` appears, compute its hash code and look in
  the hash table.  (You may have to filter that index in the hash table.)

Criticisms

* Requires O(n) space.  (n is length(t)).
* Computing the hash code is important.  It usually costs O(m) to
  compute the hash code of a string of length m.  This approach is
  therefore O(mn).

Here's a good hash algorithm to use that solves the problem.

Our string is t[1] ... t[m].  p is a prime.  t[1]xp^m + t[2]xp^(m-1) +
s[3]xp^(m-2) + ... s[m-1]xp^2 + s[m]xp^1.

If we have the hash code for t[1..m], can we easily compute the hash
code for t[2..m+1]?  ("easily" = "in constant time")

We will return to the question next class.
