---
title: "EBoard 04: Asymptotic Analysis, Continued"
number: 4
section: eboards
held: 2021-09-03
link: true
---
# {{ page.title }}

_Approximate overview_

* Administrative stuff
* A note on notation
* Additional properties of Big-Oh
* Why have Big-Oh (and other notations)
* Casual and careful loop counting
* Other notations

Administrative stuff
--------------------

* Hi.  We're still Sam and Shane.
* The site is still under construction.  It may remain under construction
  until the end of the semester.

### Upcoming activities

* A play, sometime in the distant future.

### Upcoming work

* Read Chapters 2 and 3 of Roughgarden 1, if you have not done so already.
    * There are copies of Roughgarden in the learning center.
* [Assignment 2](../assignments/assignment02) due Wednesday

### Friday PSA

* Please consume in moderation
* Beware laws
* Consent is essential
* Lots of people care about you, please take care of yourselves.

### Q&A

Why does Microsoft Bookins send me scheduling appointments in PDT?

> I have no idea.

> Pay attention to the timezone it says

How do we meet with you on Teams?

> Wait until your appointment.

> I should DM (Chat) you a message like, "Are you ready to meet?"

> Respond.

> I will then click the magic camera button to connect.

> Note: Sometimes meetings run over.  If I am not available, just DM me
  and say "Aren't we meeting?" or something like that.

What if we don't have an appointment?

> DM me to see if I'm available or to ask a question.

What's a reasonable time to wait before asking again.

> For normal people, two days.

> For me, twelve hours.

A note on notation
------------------

_Or note-ation?_

* By definition, O(g(n)) represents the *set* of functions bounded above
  by g(n).
* Hence, we properly write f(n) is in O(g(n)).
* By custom, many computer scientists instead write f(n) = O(g(n))
* Although that abuse of notation makes my skin crawl, I accept that
  it is a custom (one approved by Knuth, if I recall correctly)
* I will, nonetheless, primarily use "is in".

What do we call it

* Some people call it Big-O
* Some people call it Big-Oh
* Some people call it Big-Omicron

Some characteristics of Big-Oh
------------------------------

### Big Oh is transitive

* `If f(n) is in O(g(n)) and g(n) is in O(h(n)), then f(n) is in O(h(n))`
* E.g., `if f(n) is in O(n^2) and n^2 is in O(n^3), then f(n) is in O(n^3)`
* We proved this last class.

### We can remove lower-order terms

* E.g., `if f(n) is in O(10n + n^2), then f(n) is in O(n^2)`
* `If f(n) is in O(g(n) + h(n)) and g(n) is in O(h(n)), then f(n) is in O(h(n))`

Work as a group on a proof.  Look back at how we prove such things.

Reminder: `f(n) is in O(g(n)) iff there exist c>0 and n0>0 s.t. f(n)<=c*g(n) for all n > n0.`

Normally: 

* Use the definition of Big-Oh to identify the c and n0.
* Do some algebra to identify a new c' and n0'
* Use the definition of Big-Oh backwards to prove.

0. Note: `We want a and m s.t., f(n) <= a*h(n) for all n > m`.

1. `There exist c0 and n0 s.t., f(n) <= c0*(g(n) + h(n)) for all n > n0`.
   _By definition of Big-Oh and first condition._

2. `There exist c1 and n1 s.t., g(n) <= c1*h(n) for all n > n1`.
   _By definition of Big-Oh and second condition._

3. `If f(n) <= c0*(g(n) + h(n)) and g(n) <= c1*h(n) then
    f(n) <= c0*(c1*h(n) + h(n)) for all n > n1,n0`
   _By transitivitity of <= (and some other algebra_

4. `f(n) <= (c0*c1 + c0)*h(n)` for all n > n1,n0
   _By the distributive property of mulitplcation over addition_

5. `Let d=c0*c1 + c0`.  Let `m=max(n1,n0)`

6. `f(n) <= d*h(n) for all n > m`.
   _Substitution_

7. `f(n) is in O(h(n))` 
   _by the definition of big-Oh_

### We can ignore constant mulipliers

* `If f(n) is in O(cg(n)) for some c > 0, then f() is in O(g(n))`

### A note about typical proofs of properties of Big-Oh

A different proof
-----------------

Suppose f(n) is in O(3n + 5).  Prove that f(n) is in O(n).

### Technique one

1. `f(n) is in O(3n+5) implies f(n) is in O(3n)`.
   _See lemma entitled "You can ignore lower-order terms."_

2. `f(n) is in O(3n) implies f(n) is in O(n)`
   _See lemma entitled "You can ignore constant multipliers."_

3. Q.E.D.

### Technique two

1. `There exist c, n0 s.t., f(n) <= c*(3n+5) for all n>n0`.
   _By definition of big-O._

2. `f(n) <= 3cn+5c for all n > n0`
   _By algebra_

3. `f(n) <= 3cn + 5c <= 3cn + cn if n > 5 (and n > n0)`

4. `f(n) <= 4cn if n > 5 (and n > n0)`

4. `Let d = 4c.  Let n1 = max(5,n0)`

5. `f(n) <= d*n for all n > n1`

6. `f(n) is in O(n)`

Why Big-Oh?
-----------

_Why do we have Big-Oh notation?_

* We use Big-Oh notation to represent the running time of algorithms.
* That may allow us to compare the running time, at least if we choose tight bounds.
* A O(n) algorithm is generally better than an O(n^2) algorithm
* We may also use Big-Oh to compare space.
* Most computer scientists use Big-Oh informally, for "this is the shape of
  the algorithm in the worst case"
* Grinnell wants you to exercise your math brain, so we will ask for proofs
  in this course.

Casual and careful loop counting
--------------------------------

For iterative algorithms, we often look at (analyze) loop behavior.

### Example zero

Conveniently, the bound on this algorithm should be the same as the
result.

```
int loopZero(int n) {
  int result = 0;
  for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= n; j++) {
      result += 1;
    } // for j
  } // for i
  return result;
} // loopZero
```

loopZero is in O(n^2)

For nested loops, the easiest (although not necessarily most accurate) strategy
is to count the worst case of the number of repetitions of the outer loop, the
worst case of the inner loop, and multiply them together.

In this case, the outer loop should run n times, and the inner loop will run
n times, so this should be n^2.

### Example one

_Let's change the outer loop to double i, rather than increment it._

```
int loopOne(int n) {
  int result = 0;
  for (int i = 1; i <= n; i *= 2) {
    for (int j = 1; j <= n; j++) {
      result += 1;
    } // for j
  } // for i
  return result;
} // loopOne
```

How does the result differ?

loopOne is in O(...)

The outer loop runs no more than n times, since doubling is no worse than adding 1.

The inner loop runs n times.

So, it's O(n^2)

We can get a tighter bound.

The outer loop runs no more than func(n) times, where func(n) is "the number of
times I have to double 1 before I exceed or equal n"  That function is log2(n).

The inner loop runs n times.

This algorithm is `O(n*log2(n))`

One of your homework assignments is to determine whether O(log(n)) == O(log2(n)).

### Example two

_Let's change the inner loop to go up to i rather than n._

```
int loopTwo(int n) {
  int result = 0;
  for (int i = 1; i <= n; i *= 2) {
    for (int j = 1; j <= i; j++) {
      result += 1;
    } // for j
  } // for i
  return result;
} // loopTwo
```

Idea one: Outer loop runs log2(n) times.  When i is n, inner loop runs n times.
So, we still have O(nlog2(n)).

Idea two: Tease apare the loop

1 + 2 + 4 + 8 + 16 + 32 + 64 + 128 + ... + 2^k

Where 2^k = n.

That sum ends up being 2^(k+1) - 1

### Example three

_I probably stole this example from Skienna._

```
function loopThree(n)
  r := 0
  for i := 1 to n do
    for j := i + 1 to n do
      for k := j to i+j to n do 
        r := r + 1
  return(r)
```

Other notations
---------------

### Big Omega

### Big Theta

### Little Oh

