---
title: "EBoard 22: Program verification and loop invariants (3)"
number: 22
section: eboards
held: 2021-10-15
link: true
---
# {{ page.title }}

_Approximate overview_

* Admin
* About HW3
* Efficient exponentiation, iterative

Administrative stuff
--------------------

* Happy rainy Friday, if such a thing is possible.
    * Lots of rainy class days this week.
* Colds are going around campus; if you're using a MathLAN workstation,
  make sure to use one of the keyboard/mouse wipes.
* If you're going to miss class, please DM me or drop me an email.

### Upcoming token-generating activities

### Upcoming other activities

* Scarlet and Black Swim Meet Saturday at noon

### Upcoming work

* [HW7](../assignments/assignment07) due Thursday after break.  To
  be discussed soon. 

### Q&A

Do we have to do HW7 over fall break?

> No, you can do it the week you return.  Most of you seem to do work the week
  it is due, not the weekend before.

Is it okay if I turn in HW6 late?

> Yes.

About HW7
---------

Efficient exponentiation, iterative
-----------------------------------

Your goal: Rewrite `expmod` iteratively.  In case you've forgetten, we
want to compute `x^n mod m`, with appropriate restrictions.

* You may want to add at least one other variable to handle odd exponents.
* Use invariants to help keep your code correct.
* Hint: If n is even, x^n = (x^2)^(n/2) = (x^(n/2))^2

An example that may or may not help.  Let's compute 5^23.

More Invariants
---------------

More broadly, an invariant is a characteristic of something, a characteristic
that you intend to maintain.  

Can you think of other characteristics we've tried to maintain?  (TPS)
