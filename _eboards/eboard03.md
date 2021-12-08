---
title: "EBoard 03: Asymptotic Analysis"
number: 3
section: eboards
held: 2021-08-30
link: true
---
# {{ page.title }}

_Approximate overview_

* Administrative stuff
* Q&A on homework
* Q&A on everything else
* More memories of 207
* Big-Oh, formalized
* Additional properties of Big-Oh (incomplete)
* Casual and careful loop counting (skipped)
* Other notations (skipped)

Administrative stuff
--------------------

* Hi.  We're still Sam and Shane.
* Attendance.
* The site is still under construction.  It may remain under construction
  until the end of the semester.
* Plan to meet with me on Teams, not in person.
* When sending me questions, it is useful if you include
    * Your operating system
    * Your version of Java
    * A transcript of what is happening, including what you've typed
      and what the error messages are.
    * Any hypotheses you have

### Upcoming activities

Policies

* You earn tokens by attending events.
* You can trade in tokens to turn in work late.
    * 1 token = 24 hour extension
    * 2 tokens = 24 hour extension
* Everyone starts with three tokens.

Events

* First Scholars' Convocation, 11 am, Thursday, September 2.
    * Sam will give a shpiel about Scholars' Convocation.

### Upcoming work

* Do assignment 1 before 10:30 p.m. tonight!
    * GradeScope link now posted.
* Read Chapters 2 and 3.  Yay!

Questions on HW 1
-----------------

When is the homework due?

> 10:30 p.m.

Will future assignments be more detailed?

> Probably.

Why does JUnit suck?

> Because it's at negative pressure?

> That's just because you are inexperienced.

Can we use VSCode, Eclipse, UnintelliJ, etc?

> Certainly.

How should we do array-based priority queues?

> Add: Add to the end.

> Remove: Look for largest, swap to the end, remove from there.

What is the relationship between APQ and Heap

> Two different implementations of the same interface/ADT.

When would we throw `CollectionFullException`?

> Probably never.

> In C, when you try to malloc a larger array and the malloc returns null.

> In Java, when you get an out of memory exception (but you don't have to
  worry about that).

> If you were implementing collections with a fixed-size array.  (Sam likes
  generalized ADTs.)

> You do not need to throw `CollectionFullException`s.

What comparator should we use?

> The constructor for your structure should take in a comparator.

> So the code in your structure should use `this.compare` to compare things.

> The tests create their own comparators already.

What are those comparators?

> `(x,y) -> x-y`

```
public class MyIntegerComparator implements Comparator<Integer> {
  public int compare (Integer x, Integer y) {
    return x - y;
  } // compare (Integer, Integer)
} // class MyIntegerComparator
new MyIntegerComparator();
```

> `(x,y) -> x.compareTo(y)`

```
public class MyStringComparator implements Comparator<String> {
  public int compare (String x, String y) {
    return x.compareTo(y);
  } // compare(String, String)
} // class MyStringComparator
```

That's an awful integer comparator.  Should we not worry about overflow or underflow?

> Don't worry about overflow or underflow.

When we run `HeapTest.java`, it implicitly runs all the tests in `PriorityQueueTest.java`.  Should we add anything to `HeapTest.java`?

> This is the wonder of inheritance.  If you add tests *only* to `PriorityQueueTest.java`, they will be available for both `HeapTest.java` and `APQTests.java`.

> If you wanted to test other kinds of values, you might need something more sophisticated.

The integer comparator always returns 0

> Not for me.  Send me your code and we'll figure it out.

How do we submit the homework?

> On Gradescope.

> Submit *all* the Java files.

Why isn't there an autograder?

> Because I have a life.

Why does Java complain to me in MathLAN?

> Computers are evil.

Can we change the names or packages of the Java files.

> Generally, no.  In this case, yes.

> I'll try to be more careful in my naming.

More general questions
----------------------

When I criticize Sam's code, will that affect my grade?

> If your critiques are appropriate, you might earn extra tokens.

> You should tell me when I write bad code.

Review of complexity analysis from 207
--------------------------------------

f(n) is in O(g(n)) means ...

* Formal definition: There exist constants, `n0` > 0 and `c` > 0 such that 
  `f(n) <= c*g(n)` for all n > n0.
* Informal definition: When n is big enough, g(n) is bigger than f(n),
  at least if we scale it a bit (by c).
* The n0 is "when the input gets big enough"
* The C is "constant multipliers don't matter"
* When we see a function f(n) is in O(n^2), we mean that for big enough input,
  it will be less than `c*n^2` (and, in fact, I think it will be less than `n^2`,
  but that input may be bigger).
    * Proof forthcoming another day.
* Goal: Tight bounds
    * if f(n) is in O(n^2), then f(n) is also in O(n^3) and O(n^4) and O(2^n)
    * We'll learn some notation about closer bounds.

Additional characteristics of Big-Oh
------------------------------------

Hint: Proof techniques

* Contradiction
* Construction
* Induction
* Cases (exhaustive cases)
* Wavy hands
* ...

Theorem: If f(n) is in O(g(n)) and g(n) is in O(h(n)), f(n) is in O(h(n))

Proof: 

```
f(n) is in O(g(n)) implies exist c and n1 s.t. for all n > n1, f(n) <= c*g(n)

g(n) is in O(h(n)) implies exist d and n2 s.t. for all n > n2, g(n) <= d*h(n)

Let a = c*d, n0 = max(n1,n2)

g(n) <= d*h(n), for all n > n2  // See above

c*g(n) <= c*d*h(n), for all n > n2      // if x < y, then cx < cy for all positive c

f(n) <= c*g(n) <= c*d*h(n), for all n > n1, n > n2  // See above

f(n) <= c*d*h(n), for all n > n1, n > n2 // x <= y <= z implies x <= z

f(n) <= a*h(n), for all n > n1, n > n2 // Notation

f(n) <= a*h(n), for all n > n0 // Notation

f(n) is in O(h(n)) // by definition.

Want: exist a and n0 s.t., for all n > n0, f(n) <= a*h(n), then
f(n) is in O(h(n))
```

