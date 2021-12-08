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
* Analysis of the hashing technique
* Other algorithms

Administrative stuff
--------------------

### Notes

* Please use the booking assistant on Teams or Outlook to book a
  meeting or more with me during finals week.
* I've released some grades.  More are forthcoming.
* I've also added all the LOs.

### Upcoming token-generating activities

### Other fun things

* "I Dig You" this weekend.  Ticketing starts today, we think.

### Upcoming work

* [HW12](../assignments/assignment12) due TOMORROW
    * Some dynamic programming problems
    * Topological sort
* [HW11](../assignments/assignment11) due LAST WEEK (ish)
    * Implement skip lists

### Q&A

Grading
-------

* Goal: Count how many of the Learning Outcomes (LOs) you've demonstrated.
* What are the Learning Outcomes?
    * They are on the syllabus.  (Not necessarily in the most sensible order.)

Substring matching with hash codes
----------------------------------

* Compute the hash code of each substring of `t` of the appropriate length
  (that is, `length(s)`).
* To determine everywhere `s` appears, compute its hash code and look in
  the hash table.  (You may have to filter that index in the hash table.)
* Hash algorithm
    * Our string is t[1] ... t[m].  
    * p is some prime.  
    * Hash code is: 
      t[1]xp^m + t[2]xp^(m-1) + s[3]xp^(m-2) + ... s[m-1]xp^2 + s[m]xp^1.

Question:

> If we have the hash code for t[1..m], can we easily compute the hash
  code for t[2..m+1]?  ("easily" = "in constant time")

If so, the hash algorithm is O(n+m), which seems about as good as we
can do.  

### Advantages

* Straightforward
* Relatively easy to implement.
* We can amortize it over all searches of length m.

### Disadvantages

* Requires extra space.

Other approaches to substring matching
--------------------------------------
