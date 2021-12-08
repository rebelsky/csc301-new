---
title: "EBoard 24: Coded Bias, Continued"
number: 24
section: eboards
held: 2021-10-27
link: true
---
# {{ page.title }}

_Approximate overview_

* Admin
* Background
* High- and lowlights of *Coded Bias*
* Defining "Algorithm" (and related concepts)
* Biased sorting
* A detour
* Arguing the other side
* Professional responsibilities
* Final thoughts

Administrative stuff
--------------------

* Colds are going around campus; if you're using a MathLAN workstation,
  make sure to use one of the keyboard/mouse wipes.

### Upcoming token-generating activities

* CS Extras, Thursday, 4pm.  PL?
* Football, Saturday, 1pm
* Any one Grinnell prize event this weekend.
* Pot Veganluck
* Tuesday night discussion of "Arrival" the movie.  Aliens!
* International Food Fest November 14

### Upcoming other activities

* Women's Volleyball tonight at 7:00 p.m.
* Women's Basketball tomorrow at 6:00 p.m. 
* Women's Volleyball Saturday at 11:00 a.m.
* Swim meet Saturday at 1pm
* Women's Basketball vs. Alumnae Saturday at 4:00 p.m.
* Men's Basketball vs. Alumni Saturday at 6:00 p.m.
* The Dark Side of Indo-European Studies Tuesday at 8:30 a.m.

### Upcoming work

* [HW7](../assignments/assignment07) due tomorrow night.
* HW8 will be a one-page essay on the topics we are discussing.
  Basically: What are the ways in which bias can affect algorithms
  and how can a computer scientist / developer / programmer
  address those potential issues of bias?
    * Due next Thursday
    * Single spaced, one inch margins, 8.5x11 paper, 12pt Times Roman,
      Times New Roman, or CMR.  You may also use italic or bold 12 pt
      Times (or variant) as appropriate.
    * Yes, it can be a few lines over or under one page.
    * PDF, please.
  
### Q&A

How do we prove that the loop terminates?

* Usually a paragraph.  You set a "size" for the input and show that each
  iteration of the loop reduces the size of the input.
    * E.g., for binary search, we used the number of elements in the 
      subarray as our size.

Background
----------

ACO Paraphrase: "So what we're seeing is a bunch of white men building
software that benefits white men?"

* That's why most of my career, I've been trying to get other people
  to pursue computing.

Last year, the department discussed having "understand bias in algorithms"
be one of the learning outcomes for CSC-301.  This year, all of the sections
are covering that issue in some way.  (Everyone is requiring an essay.)

High- and lowlights of *Coded Bias*
-----------------------------------

Cold Calling

_What portions of the film were meaningful?  Surprising?  What portions
do you want to remember?_

* Keep in mind that the face recognition algorithms were sometimes doing
  a bad job, which potentially caused harm.
* The movie did a lot of fear mongering.  Appropriate?
* The "Big Brother Watch" was interesting.  What would it mean in the US
  where police are armed.
* "We think of the newest technology of going to the rich, but we ignore
  that the most invasive experimental technology is often tested on the
  poor."
    * And of course, all of our technological waste goes to poor countries.
* Most modern AI is built from collections of data.
    * Those collections of data often focus on particular groups.
    * It turns out that better sets of data give better results (e.g.,
      IBM updating their facial recogniation algorithm)
* Facebook election experiment.  How much power does Facebook have to throw
  elections?  "They could if they wanted to."
    * Lots of this is happening behind the scenes?
* 1984 and all of the CCTVs in London.  It's happening in real life.
* How do you fight back against it?  Lasers, common helmets, spray painting
  CCTV.
* Mass surveillance in mainland China seems scary.
    * The presentation of the point system may have been biased.
    * The need to use a face
    * But perhaps there are collectivist values at play that are not
      sufficiently mentioned.
* Mass surveillance in the US is even scarier, because we don't discuss it.
* Why did the film we have to focus on China to make us worry?
    * Why don't we look at what we're doing here.
    * Really fed into fearmongering.
    * Not multiple views.
    * We should watch the Black Mirror episode about social credit scores.
* The Microsoft Twitterbot that became evil was interesting.  (Did it learn
  from its DMs.)
* Are there benefits to facial recognition software?  There can be.
* Regulation!
* How do you get justice in a system when you don't know how the algorithm
  works?
* Would regulation slow down the development of technology?
* It's weird that "No one knows how the algorithm works."
* A model of what ML/AI is would have been helpful.
* "We like to think of technology as an ever escalating process of improvement;
  but when we talk about AI, we're using our past and baking our history into
  the algorithms that we write."

Defining "Algorithm"
--------------------

* To Sam, an algorithm is a sequence of human-readable (and, usually,
  human created) instructions that achieve a goal.
* In the movie, an algorithm is a sequence of instructions that make
  a probabaliistic recomendation or decision.  ("Heuristic" "Model")
    * It is now common parlance to use "Algorithm" for this, too.
* The latter kind of algorithms are unlikely to be transparent, although
  their is some work on it.  Fair, Accountable, and Transparent.  FAT-AI!
* It turns out that different models of fairness are mutually exclusive!
* In this class, we will use "algorithm" the way Sam uses algorithm, and
  either "heuristic" or "model" for the way in which the movie uses 
  "algorithm".

Biased Sorting
--------------

TPS

_Can we see similar biases in the application or external manipulation
of the kinds of algorithms we've been writing in class?  What biases
might appear, say, in the use of a sorting algorithm?_

External use of sorting algorithm.  There doesn't seem to be a bias
if you sort numbers or strings, but once you give them values (e.g.,
your citizenship score).

If you impose other assumptions on the results of the sorting.

What happens if the original list is presorted and we take advantage
of that?

Google autocomplete once showed you the most recent searches based
on number of searches.  You could manipulate this by sending in a lot
of search requests (particularly if you have the power of, say 4Chan,
behind you).  But you don't need that; the world is biased.

Detour: Big Brother Watch
-------------------------

Volunteers

_Does your opinion of Big Brother Watch change if you learn that they
oppose "vaccine passports"?_

Arguing the Other Side
----------------------

TPS

_The film *Coded Bias*, suggests that there must be a problem with the
teacher classification heuristic/model because it classifies an award-winning
teacher as far below average._

_Suppose you worked for the company that made the classification software
AND that you believed that the software revealed valuable information.
Provide counter-arguments to the claims in the movie.  (E.g., you can
suggest reasons that there would be the discrepancy and that the discrepancy 
reveals important information.)_

Awards can be based on social capital, rather than actual qualities.

Awards can be based on the wrong criteria; perhaps the software uses
the right criteria.

It depends on how you want to judge a teacher's performance.  Awards might
be based on qualitative issues.  "It looks like he's having a positive
impact on these students."  

Side note: Too often, teachers are rated on how students score on standardized
tests, rather than how much their students understand.

Hacking Criterion: How well do students do in the next class?  

* Teach them all the content for all the next class.
* Identify the likely low performers and encourage them to drop out.

Hacking Criterion: Retention rate to next grade

Designing good criteria is hard

Professional Responsibilities
-----------------------------

Essay

_What can you do as a software professional to counter these potential
biases?_

Final Thoughts
--------------

Was this a good exercise?  Vote (Sam's eyes closed)

* Conclusion: Yes.
