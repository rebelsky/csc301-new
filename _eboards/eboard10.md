---
title: "EBoard 10: BSTs, revisited"
number: 10
section: eboards
held: 2021-09-17
link: true
---
# {{ page.title }}

_Approximate overview_

* Admin
* Tree basics & terminology
* Trees, formalized
* Binary trees
* Traversing trees
* Binary search trees
* The Recurrence Formula Theorem

Administrative stuff
--------------------

* I forgot my hearing aids again.
* Random assignment through magic cards.
* Advance notice: Prof. Eikmeier will be teaching balanced trees on
  Monday and Wednesday next week.
* Enough people had trouble with assignment 3 that I'm giving you
  another week.  
    * Problem 2 was complex, and Scheme is less familiar.
    * Problem 1 should have been more straightforward, given that
      you've already implemented Quicksort in Java.  (At least
      I hope you have.)
* I'm also trying to make assignment four (also due Thursday) much shorter.
* If you finished assignment 3, you'll have a quieter week.

### Upcoming token-generating activities

* Football, 1pm, Saturday
* Grinnell Vegans Potluck, Saturday, 7pm.  Email or DM the person
  who is hosting.

### Upcoming other activities

### Upcoming work

* Think about how to add something to a BST and to remove something.
* Read sections 5.1--5.5 and 6.1--6.2.  That finishes book 1.
* [Assignment 3](../assignments/assignment03) due next Thursday.
* [Assignment 4](../assignments/assignment04) due next Thursday.
    * Shorter! (I hope.)

### Q&A

If I offered up a token as sacrifice for a late assignment 3, does it come
back?

> Yes.

Trees, introduced
-----------------

_Talk with your group about the following questions._

Is "Tree" an ADT (Abstract Data Type) or a Data Structure?  Both?
Neither?

Detour: List is an ADT (we are organizing elements for iteration
and support the following operations: ...).  LinkedList or ArrayList
is a Data Structure (each element has a link to the next; the elements
are stored in an array)

* ADT: Almost every one.  "When I think about a tree, I think about
  the general structure and what it can provide, rather than how
  I implement it."  (You can store binary trees in arrays or as 
  pointers.)
* Data Structure: We conceive of them as linked structures (and draw
  them that way), and we use them to implement ADTs, such as using
  BSTs to implement dictionaries.

A conclusion: Maybe it's a not-useful distinction, but I appreciate that
you all said ADT.

Trees, formalized
-----------------

### Definition of lists

* null is a list.
* if x is an X and L is a list of X's, then cons(x, L) is a list of X's.

### Basic definition

We will denote "a tree of values of type X" as Tree<X>.

* If x is an X, `Leaf(x)` is a Tree<X>
* If x is an X and T1 ... Tn are all Tree<X>s, then so is
  `Node(x,T1,T2,...,Tn)`.

### Empty leaves

We will denote "a tree of values of type X" as Tree<X>.

* `Leaf` is a Tree<X>
* If x is an X and T1 ... Tn are all Tree<X>s, then so is
  `Node(x,T1,T2,...,Tn)`.

### Values only at leaves

* If x is an X, Leaf(x) is a Tree<X>
* If T1 ... Tn are all Tree<X>s, then so is Node(T1,T2,...,Tn).

### Summary

* There are at least three common ways people think of trees.
* They are all usually defined recursively
* They differ in how one thinks of the leaves and interior nodes.
  (Do leaves have values or are they NULLs?) (Do nodes have values?)
* How you implement your algorithm is affected by how you think of
  your tree.

Terminology
-----------

_Are there any of these terms that you don't know?_

Binary trees

Root

Node

Arity: Is the number of children a node has.

Leaf

Parent

Child

Subtree

Path

Depth (of node): Distance from the root.

Height (of tree): Depth of the furthest node.

Level

Ancestor - Generalization of parent

Descendent - Generalization of child.  It's a property. ("a is a 
descendent of "b).  (For all a s.t. a is a descendent of b ...)

Forest - A collection of trees

Complete tree - All internal nodes have all children. 

BSTs
----

A binary search tree (BST) is a tree (usually binary) of values 
(or key/value pairs) with the property that

* The keys of all the nodes in the left subtree are less than the key
  of the root.
* The keys of all the nodes in the right subtree are greater than the key
  of the root.
* The same property applies for all subtrees.
* We assume each key appears only once.

Detour: Dictionaries
--------------------

Dictionary (also known as "Table", "Hash", and "Map") is an ADT in which
we associate values with keys.  Traditionally a `Dictionary<K,V>` implements
two primary methods: 

* `set(K key, V value)` - Remember that value is associated with key
* `get(K key)` - Retrieve the last value associated with key

Detour: Why BSTs?
-----------------

_Group discussions_

Given that a balanced BST is still O(logn) for `set` and `get`, while a
hash table is expected amortized O(1), why would I use BSTs rather than
hash tables to implement dictionaries?

Some notes ...

* Expected = usually
* Amortized = (add all costs) then divide by all operations.
    * Hash tables sometimes have to get larger.  That's expensive.
      But if we spread out that cost over all the operations (and
      expand sensibly, it's slow).

Some answers ...

* BSTs have a natural ordering, so, say, if we wanted to iterate the
  elements in increasing order, it's useful to do so.
    * Also for finding "nearby" elements in the ordering.
        * Next largest thing is leftmost part of right tree.
        * Next smaller thing is rightmost part of left tree.
* It seems that hash tables waste space; for hash tables to work well,
  we generally need about half of the cells to be empty.  (Depending
  on how you store your BSTs, the pointers may make up for the empty
  cells.)
* There is some debate about which is easier to iterate.
* Amortized time is not acceptable in all cases.  (Slow predictability
  beats fast amortized unpredictability.)
* It can be hard to come up with good hash functions.

On the other hand ...

* BSTs do require comparable/orderable elements.
* And they are slower.

Traversing trees
----------------

_Group discussions_

There are approximately eight standard orderings for traversing binary trees.
What are they?

* Breadth-first: Visit all of the values on each level before progressing
  to the next.
     * Left-to-right vs Right-to-left
     * Top-to-bottom vs Bottom-to-top
     * That's four!
* Depth-first: Visit all of one subtree before visiting the other subtree
     * Preorder: Visit/process/print parent before children
     * Inorder: Visit/process/print one subtree , then parent, then other subtree
     * Postorder: Visit/process/print both subtrees before parent
     * Left-to-rigth or right-to-left
     * That's six!
* Generally, we do top-down left-to-rigth breadth-first or one of the
  three left-to-right depth-first.

How do you implement breadth-first, top-down, left-to-right iteratively?

* add the root to a queue
* While the queue is not empty ...  
     * Grab the first thing in the queue
     * Process it
     * Add its left child (if it has one)
     * Add its right child (if it has one)

How do you implement depth-first, preorder-left-to-right iteratively?

* add the root to a stack
* While the stack is not empty
    * Grab the first thing in the stack
    * Process it
    * Add its right child (if it has one)
    * Add its left child (if it has one)

You should be able to write generic code for traversal (but I'm not going
to make you do so).

The Recurrence Relation Formula Theorem
---------------------------------------

* A general way to express T(n) <= a\*T(n/b) + O(n^d)
* _I don't know why c doesn't appeaer._
* We want to have a formula for the value of T(n).  As you'd expect,
  it depends on a, b, and d.
* There are three basic possibilities.
    * Case 1: T(n) is in O((n^d) logn) if a = b^d
    * Case 2: T(n) is in O(n^d) if a < b^d
    * Case 3: T(n) Is in O(n^(logb(a))) if a > b^d
* Does this match our analyses from earlier?

Let's try it

* T(n) <= 2T(n/2) + n.  a = 2, b = 2, d = 1.  Case 1: O(nlogn).
* T(n) <= 2T(n/2) + c.  a = 2, b = 2, d = 0.  Case 3: O(n^(log2(2))), so O(n)
* T(n) <= 2T(n/2) + n^2.  a = 2, b = 2, d = 2.  Case 2: O(n^2)

Proving the theorem
-------------------

* How might/do we prove this?
