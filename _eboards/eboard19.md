---
title: "EBoard 19: Tries"
number: 19
section: eboards
held: 2021-10-08
link: true
---
# {{ page.title }}

_Approximate overview_

* Admin
* Dictionaries
* Implementing dictionaries
* Tries
* Implementing tries

Administrative stuff
--------------------

* Sorry for the confusion about Convocation.  I'm not sure why they moved
  it to noon.
* Today's fun phishy email.

### Friday PSA

_Two "new" approaches_

_WAG data_

* At least 20% of Grinnellians report not having had alcohol in the past
  two weeks.
* Only 20% of Grinnellians report having used drugs in the past two weeks.
* 30% of Grinnellians report having no sexual partners in the past year;
  30% report being managamaus; 40% engage in riskier behavior.
    * CONSENT IS ESSENTIAL
* 1% of Grinnellians report participating in Vegan Potluck

_Ten_

* Moderation

### Upcoming token-generating activities

* Prof. Eliott's Coffee-free Chat in ELBICA lab (across from CS Learning Center)
  some Fridays 5-6 p.m. (but not today)
* Arcadia, October 8--10. (7:30ish p.m. Friday and Saturday, 2 p.m. Sunday.)
* MET in HD, Saturday, 11:55 am.  Boris Godunov
* Football, Saturday, 1pm.
* Vegan Potluck Saturday at 7pm.
* Learning from CS Alumni, 2pm, Tuesday, 3821.

### Upcoming other activities

* Swimming Time Trials, today at 4:30.
* Scarlet and Black Meet next weekend.

### Upcoming work

* [HW6](../assignments/assignment06) due next Thursday.

### Notes from Survey

* Many (most?) of you are finding the programming assignments long, 
  but helpful.
* Walking through examples in class is useful.
* Discussing the provided code is also useful.
  (Sam does want you to practice code reading.)
* The two divide-and-conquer algorithms took a lot of work.
* The AVL tree assignment took many people about 16 hours, making it
  appropriate as a two-week assignment.  (Sniff.)
* Proof assignments take less time than programming assignments.
* Best comment so far: "I may not understand what you're talking about,
  but I enjoy hearing you talk about it."
    * If you ask questions, I'll talk more.
* You generally appreciate the group work.
* It would have been helpful if I had reviewed C and Scheme at the
  beginning of the semester.
  (Can't fix that now; most of you have learned enough.)
* Casual approaches to deadlines are good.

### Q&A

Can you answer my question on assignment 6; I ran out of memory.

> Memory is cheap, buy more.

> I'll take a look at it soon.

> Remind me hourly.

Can we get feedback on our work?

> Soon.

How are we being graded?

> Scaling with stairs.

> Ignore that.

> Mastery grading.

Dictionaries or Map
-------------------

A structure that allows you to access data by key!

```
class Dictionary<K,V>
{
  /**
   * Get the value with a particular key.
   */
  V get(K key)

  /**
   * Set the value for a particular key
   */
  void set(K key, V value)
} // class Dictionary
```

How many (semi-sensible) ways do you know to implement dictionaries?

* Linked lists
    * Sorted
    * Unordered
* Arrays
    * Sorted
    * Unsorted
* Hash Tables
    * Buckets
    * Probing
* Binary (or n-ary) search trees
    * Red-Black
    * AVL
    * There are not (yet) ROYGBIV trees.

Hash Table Strategies

* Hash tables: Dictionaries implemented through a clever use of arrays.
  Idea: Convert any key to an integer; then reduce that integer to the
  range [0..n) by modding by n.  That potentially gives you a place in 
  the array to store the key/value pair.
* What do you do in `set` when you hash a key and there's already
  a key/value pair in the cell.
    * hash("hello") = 12512, table size 100, 12; table size 200, slot 112
    * hash("elephantitis") 42434212, table size 100, 12
    * What do we do about that collison?
* Options for collisions
    * Eliminate the old value.  BAD idea, removes info from table.
    * Store more than one thing in the same cell.  "Bucketed hash table."
    * Look nearby in the table.  "Probing"  If cell x is full, look at
      x+p, x+p+p, x+p+p, ....  If `p` is relatively prime to the size of
      the table, and there is an empty space in the table,  you will 
      eventually find an open space.
    * Sam's informal survey: Most languages use bucketing for their
      built-in hash tables.
* When the hash table gets too full,
    * The buckets get long
    * The probing takes a lot of steps
* Most hash tables expand.  (Many have a criteron for expanding, like
  "50% full")
* To expand a hash table, you allocate more memory.  (How much?)  And
  then re-hash all the key/value pairs in the table.
* Normal strategy: Double the size of the table.

N basic strategies

* Sorted array 
    * Running time `set`: O(n)
    * Running time `get`: O(logn): Use binary search
    * Space overhead: Perhaps twice as many spaces in the array as you need.
    * Advantages: Easy to implement
* Unsorted array
    * Running time `set`: O(1)
    * Running time `get`: O(n)
    * Space overhead: Perhaps twice as many spaces in the array as you need.
    * Advantages: Easy to implement; doesn't require ordered elements.
* Balanced BST
    * Running time `set`: O(logn)
    * Running time `get`: O(logn)
    * Space overhead: Pointers galore!
    * Advantages: Can also do other things, like iterate in order, get
      kth element, etc.; Most CSC-301 students can implement in approximately
      sixteen hours of fun time.
* Hash table
    * Running time `set`: Amortized expected O(1)
    * Running time `get`: Expected O(1)
    * Space overhead: Potentially four times as many spaces in the array
      as you need.
    * Advantages: Seems faster than the rest.; doesn't require ordered
      elements.
* Note: In most of these (maybe all), we store the key/value pair.

Why don't we just increase the size of an array or hash table by 1
when it "fills"?  We'll do a sorted array.

```
+---+
|   |
+---+

Add P

+---+
| P |
+---+

Add A

+---+---+
| A | P |
+---+---+

Add B

+---+---+---+
| A | B | P |
+---+---+---+

vs.

+---+---+---+---+
| A | B | P |   |
+---+---+---+---+

Add Q

+---+---+---+---+
| A | B | P | Q |
+---+---+---+---+

vs. 

+---+---+---+---+
| A | B | P | Q |
+---+---+---+---+

Add R

+---+---+---+---+---+
| A | B | P | Q | R |
+---+---+---+---+---+

vs. 

+---+---+---+---+---+---+---+---+
| A | B | P | Q | R |   |   |   |
+---+---+---+---+---+---+---+---+
```

The cost of copying when we add n values.

* 1 + 2 + 3 + 4 + 5 + ... + n = n(n+1)/2 in O(n^2)
* vs.
* 1 + 2 + 4 + 8 + ... + n = uh n+n-1 in O(n)

I have a question intended to intimidate my classmates and confuse my
instructor.  Is it okay if I ask it?

> Yes, but I'll make fun of you and refuse to answer because, well, I
  have no idea.

On a separate note, there is a hidden cost in each of these: Looking at all 
of the bits in the key.  When we think about looking at the letters in a
string as part of our work, we might come up with another way to implement
dictionaries.

Tries: Another dictionary implementation
----------------------------------------

* trie, come from "reTRIEval"; structures that make it fast to retrieve
  things.
* Trees
* Idea: Nodes represent *prefixes* (not always proper) of keys.
* Edges are therefore "labeled" with letters.
* We'll do an example, focusing on the keys following keys, and only
  drawing the edges that are necessary.
    * hi, i, me, ma, mat, meat, mean, meanie

Questions:

* Running time set: O(s) It's independent of `n`.  O(1) if we don't
  pay attention to the cost of traversing the string, and we haven't.
    * When you cut down trees, you get logs, so it should have
      a log time.
* Running time get: O(s)
    * Conceptually, these are fast.
* Memory overhead?
    * One node per character per string in the tree.  That's a lot.
* Advantages?
    * Guaranteed fast!
* Other issues
    * Stuff isn't necessarily nearby.  Pointer chasing is usually
      slower than array indexing.

_But Sam, I can't tell you the running time unless you tell me what
variables I can use!!!_

* `n` is the number of strings in the Trie
* `s` is the length of the string you are setting or getting

How do you implement `get`?

```
V get(String key) {
  return get(this.root, key, 0);
}
V get(TrieNode node, String key, int depth) {
  if (null == node)
    return null;
  else if (depth == key.length)
    return node.value;
  else
    return get(node.subtree(key.charAt(depth)), key, depth+1);
}
```

How do you implement `set`?

Note: Sam prefers to phrase `set` recursively.  (We'll see why later.)

Implementing tries in practice
------------------------------

See [examples/tries](../examples/tries/).
