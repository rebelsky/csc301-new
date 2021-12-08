---
title: "EBoard 40: String matching, concluded" 
number: 40
section: eboards
held: 2021-12-08
link: true
---
# {{ page.title }}

_Approximate overview_

* Admin
* Discussion of grading
* Analysis of the hashing technique for string matching
* Other algorithms

Administrative stuff
--------------------

### Notes

* Please use the booking assistant on Teams or Outlook to book a
  meeting or more with me during finals week.
* I've released some grades.  More are forthcoming.
* I've also added all the LOs.

### Upcoming token-generating activities

* Equity in CS talk tonight.  See email from SamR yesterday.
* Summer Opportunities in CS tomorrow at 4:00 p.m. in 3821.

### Other fun things

* "I Dig You" this weekend.  Ticketing starts today, we think.

### Upcoming work

* [HW12](../assignments/assignment12) due TOMORROW
    * Some dynamic programming problems (pseudocode)
    * Topological sort (real code)
* [HW11](../assignments/assignment11) due LAST WEEK (ish)
    * Implement skip lists

### Q&A

Do we have class on Friday?

> Yes!  I expect you to be here.  With a pen.

Why do we need a pen?

> It's a surprise!

Can I use a tablet?

> Probably not.  I want output on paper.

Grading
-------

* Approach: Count how many of the Learning Outcomes (LOs) you've demonstrated.
* There are 21 one of them.  
    * All 21: A+
    * 20: A
    * 19: A-
    * 18: B+
    * ...
* What are the Learning Outcomes?
    * They are on the syllabus.  (Not necessarily in the most sensible order.)
* How do you demonstrate that you've met them?
    * Usually, with successful completion of a homework assignment.
    * In some cases, it's up to you to come up with the demonstration.
* We'll look at them together.

Substring matching with hash codes
----------------------------------

* Compute the hash code of each substring of `t` of the appropriate length
  (that is, `length(s)`).
* To determine everywhere `s` appears, compute its hash code and look in
  the hash table.  (You may have to filter that index in the hash table.)
* Hash algorithm/function
    * Our string is t[1] ... t[n].  We're hashing t[1] ... t[m].
    * p is some prime.  
    * Hash code h[1] is ...
      t[1]xp^m + t[2]xp^(m-1) + t[3]xp^(m-2) + ... t[m-1]xp^2 + t[m]xp^1.

Question:

> If we have h[1], the hash code for t[1..m], can we quickly compute 
  h[2], the hash code for t[2..m+1]?  ("quickly" = "in constant time")

> If we have h[2], the hash code for t[2..m+1], can we quickly compute 
  h[3], the hash code for t[3..m+2]?

> If we have h[i], the hash code for t[i..i+m-1], can we quickly compute
  h[i+1], the hash code for t[i+1..i+m]?

If so, the hash algorithm is O(m+n), which seems about as good as we
can do.  

### Strategy?

* t[i]xp^m + t[i+1]xp^(m-1) + t[i+2]xp^(m-2) + ... t[i+m-2]xp^2 + t[i+m-1]xp^1.
* t[i+1]xp^m + t[i+2]xp^(m-1) + t[i+3]xp^(m-2) + ... t[i+m-1]xp^2 + t[i+m]xp^1.

We've dropped the first term of the first one and added the last term of
the second one.

* h[i+1] = (h[i] - t[i]xp^m)xp + t[i+m]xp^1
* We can have pre-computed p^m., so it's just three mult, one subtraction,
  and one addition.  (We can write it in other ways that may change
  that slightly.)

Yay!  We have an O(m+n) algorithm for exact substring matching.

### Advantages

* Straightforward
* Relatively easy to implement.
* Can give *all* matching positions, not just first.
* Optional: We can amortize it over all searches of length m.

### Disadvantages

* May have overlapping hash codes, once we mod by the table size.
* Need to choose an appropriate prime.  (2 and 3 are probably not good.)
* Requires extra space for the hash table.

### Can we do without the hash table?

Assume that we're only looking for the first match, can we use a similar
strategy to find the match in O(m+n) time and O(1) additional space?

```
m = strlen(s);
hs = hash(s,m); // Compute hash code of first m letters of s
ht = hash(t,m); // Compute hash code of first m letters of t

for (int i = 0; i < n-m-1; i++) 
  {
    if (hs == ht) 
      {
        if (0 == strncmp(s,t+i,m)) 
          {
            return i;   // Position of match
          }
      }
    else 
      {
        ht = ...; formula above
      }
  } // for
return -1;      // "no match"
```

### Morals

* We don't always have to use dynamic programming.
* Good choices of hash functions can make an important difference.
  (The one we used has a name that I forget.)
* My classmate says smart things.
* Sometimes it's useful to amortize, sometimes you just want to solve it
  once and be done.
* "Can I do better?"
* We have a large toolbox; sometimes the unexpected tool is best for
  the job.
* Analyze carefully.
* Ask questions.
* KISS: Keep it simple, Sam

Other approaches to substring matching
--------------------------------------

### A bit of preparation

The source strings that give us the most problem are things like `aaaaaab` 
or `ababababc` or `abcabcabcd` or ...; that is, strings that repeat their
prefixes.

Why?  Consider matching `aaaaaab` against `aaaaaaab...`.  When we fail
to match the `b` against that last `a`, what should we do?

Consider matching `ababababac` against `ababababababababac`.

In constrast, consider, instead, matching `abcdefg`, against 
`abcdefabcdefg`.  When we fail to match the `g` against the `a`, 
what should we do?

How might those examples inspire us to develop a new algorithm?

### Algorithm design time

_TPS_

### A new algorithm?

Idea: When you hit a mismatch, don't back up all the way to the beginning 
of `s`, don't back up at all in `t`.  

Instead, make a table that says how far you need to back up in `s` upon 
a mismatch.

```
aaaaaaab
*******1
```

```
aaaacaaaaa
```

```
ababababab
**23......
```

### An alternate; this will make no sense to anyone not in class

_Idea: Move backwardds in the string.

Source: `baaaaaaaa`

Target: `abaaaaaaaa`
