---
title: "EBoard 37: Skip Lists" 
number: 37
section: eboards
held: 2021-12-01
link: true
---
# {{ page.title }}

_Approximate overview_

* Admin
* Full-class questions/discussion on skip lists
* Work time with help from Sam and Shane and claSSmateS

Administrative stuff
--------------------

### Minute of silence

_We will begin with a minute of silence in memory of the students in
Michigan who lost their lives yesterday._

### Notes

* Thanks for making Monday's class a great day!
* Please attend next semester's session on students with invisible
  disabilities.
* Please do not use the traditional Grinnell term for next week.

### Upcoming token-generating activities

* Vegan Potluck this Saturday.
* Wix workshop, Wednesday, ??? (see CLS email)

Other good things

* Dec. 2, 5-6pm, Harp Concert in the JRC.
* Swim meet this weekend.  Earn money by timing!  And pizza!
* Synchronized swimming performance some time this weekend.

### Upcoming work

* [HW11](../assignments/assignment11) due TOMORROW (ish)
    * Implement skip lists
* [HW12](../assignments/assignment12) due in about one week and one day.
    * Some dynamic programming problems
    * Topological sort

### Discussion topic: Potential makeup strategy for missed learning goals

Rather than having you redo or replace missed learning goals (mostly from
insufficient assignments), we could do one-on-one interviews during finals 
week.

Thoughts?

### Q&A (not on skip lists)

When is the last time I can submit assignments?

> 5pm on Friday of finals week.

> Earlier increases the chance of opportunities for make-up work.

Why can't I fill out the end-of-course evaluation?

> We'll do them in class on the last day of class.  (I can't believe that
  one of you

When are grades due?

> Usually right before or right after Christmas.

What are your incomplete policies?

> I generally follow College policies on incompletes.  There's a form
  to fill out.  There's a deadline.  There's a way you have to turn in
  work.

> I very much prefer that you turn in the form the last day of class.

Skip List Issues
----------------

My program is crashing.  Why do I have a null pointer exception?

> I'm happy to look at it once we get to individual work time.

Warnings from other students?

> Understand the expectations.  It's a dictionary, damn it!

> Pointers lead to null pointer exceptions.  Except them.  Work
  through examples by hand.  

> The debugger is your friend.

> Make the print procedure "adequate".

What should the output look like?

```
START   *  *  *  *  *
        |  |  |  |  |
first   *  *  *  |  |
        |  |  |  |  |
second  *  |  |  |  |
        |  |  |  |  |
third   *  *  *  *  |
        |  |  |  |  |
END     *  *  *  *  *
```

Can I use integers for my keys, rather than strings?

> That seems wimpy.  But I suppose so.  Strings would be better.
  If you're working in Java, generic `Comparable`s would be even better 
  (or use Objects and Comparators).

How many levels deep should my lists be?

> Ideally, determined by your random height procedure.  If it gets
  higher, it gets higher.

> It seems it should be capped at `Integer.MAX_VALUE`.  But you should
  not make arrays of that size to start with.

> If you find it easier, you can cap them at 16.

> Your classmate says that you might want to cap smaller while developing.

Can I start writing the code in a group?  

> Only during class today.

Should I feel inadequate that my code breaks when I drop the cap on the max level?

> Only if you're a CS major.  We expect less of others.
