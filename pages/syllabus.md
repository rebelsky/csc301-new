---
title: Algorithm Analysis
permalink: /syllabus/
---
# Algorithm Analysis

<dl class="dl-horizontal">
  <dt>Instructor</dt>
  <dd>
    <p><a href="{{ site.instructor_homepage }}">{{ site.instructor }}</a></p>
  </dd>

  <dt>Meeting Times</dt>
  <dd>
    <ul class="list-unstyled">
      {% for item in site.meeting_times %}
        <li>{{ item | markdownify | remove: "<p>" | remove: "</p>" }}</li>
      {% endfor %}
    </ul>
  </dd>

  <dt>Office Hours</dt>
  <dd>
    <ul class="list-unstyled">
      {% for item in site.office_hours %}
        <li>{{ item | markdownify | remove: "<p>" | remove: "</p>" }}</li>
      {% endfor %}
    </ul>
  </dd>

  {% if site.review_sessions %}
    <dt>Review Sessions</dt>
    <dd>
      <ul class="list-unstyled">
        {% for session in site.review_sessions %}
          <li>{{ session }}</li>
        {% endfor %}
      </ul>
    </dd>
  {% endif %}

  {% if site.textbook %}
    <dt>Textbook</dt>
    <dd>
      {{ site.textbook | markdownify | remove: "<p>" | remove: "</p>" }}
    </dd>
  {% endif %}

  {% if site.mentors %}
    <dt>Class Mentors</dt>
    <dd>
      <ul class="list-unstyled">
        {% for mentor in site.mentors %}
          <li>{{ mentor }}</li>
        {% endfor %}
      </ul>
    </dd>
  {% endif %}

  {% if site.mentor_sessions %}
    <dt>Mentor Sessions</dt>
    <dd>
      <ul class="list-unstyled">
        {% for session in site.mentor_sessions %}
          <li>{{ session | markdownify | remove: "<p>" | remove: "</p>" }}</li>
        {% endfor %}
      </ul>
    </dd>
  {% endif %}

  {% if site.tutors %}
    <dt>CS Tutors</dt>
    <dd>
      <ul class="list-unstyled">
        {% for tutor in site.tutors %}
          <li>{{ tutor }}</li>
        {% endfor %}
      </ul>
    </dd>
  {% endif %}
</dl>

## About this course

Welcome to the Fall 2021 section of Grinnell College's *CSC-301, Algorithm Analysis*.  CSC
-301 is the department's advanced course in algorithms.
It serves as a successor to CSC-207, Algorithms and Object-Oriented Design.
In this course, we will work to develop your
skills in the design, implementation, analysis, and verification of
algorithms, abstract data types, and data structures.  

Along the way, we will consider a variety of classic algorithms, ADTs,
and data structures - the "literature" of CS, as it were.  Why do we
read the literature?  Because knowing how problems have been solved in
the past helps us solve future problems.  A not-so-recent article on 
mathematics suggests the value of knowing the literature.

> Yet, as they told me, the proof [of the Green-Tao Theorem] depended
on the insights of many other mathematicians. In the game of devil's
chess [mathematics], players have no real hope if they haven't studied
the winning games of the masters. A proof establishes facts that can
be used in subsequent proofs, but it also offers a set of moves and
strategies that forced the devil to submit — a devious way to pin
one of his pieces or shut down a counterattack, or an endgame move that
sacrifices a bishop to gain a winning position. Just as a chess player
might examine variations of the Ruy Lopez and King's Indian Defense,
a mathematician might study particularly clever applications of the
Chinese remainder theorem or the sieve of Eratosthenes. The wise player
has a vast repertoire to draw on, and the crafty player intuits the move
that suits the moment.

> Cook, Gareth (2015).  The Singular Mind of Terry Tao.  *The New
York Times Magazine*.  26 July 2015.  Available online at <http://www.nytimes.com/2015/07/26/magazine/the-singular-mind-of-terry-tao.html>.

This course will expand your "repertoire to draw on".

## Course content and related issues

These Learning outcomes were formed by Nicole Eikmeier, Peter-Michael Osera, and Anya Vostinar with the help of Vanessa Preast in Spring-Summer 2020.  They were adapted and edited by Samuel A. Rebelsky in Summer 2021 and further updated in Fall 2021.  The list of topics is derived from one developed by the whole CS department a few years ago.

### List of core topics

a. Program/Algorithm correctness/verification by construction

b. Loop Invariants

c. Formal proof of asymptotic classes: Little oh, big Omega, Big Theta

d. Solving recurrence relations

e. Using the Recurrence Formula Theorem

f. Comparison Based Sorts are lower bounded by nlog(n)

g. Bucket Sort & Radix Sort

h. Topological Sort

i. Algorithm Design Strategies:
    * Exhaustive Search
    * Divide & Conquer
    * Greedy Algorithms
    * Dynamic Programming

j. Network flow

k. Bipartite graphs/matching

l. Tries

m. Union find/Disjoint sets

n. Something from the primary literature

o. Balanced trees

### Learning outcomes

* Given a problem statement, students can write/develop a loop invariant alongside an algorithm.
* Students can prove the correctness of their algorithm via a loop-invariant technique. 
* Students can recite the formal definition of Big-Oh, little-oh, Big-Omega and Big-Theta.
* Students can formally prove properties of these classes.
* Students can prove or compute asymptotic bounds on iterative algorithms with non-trivial nesting.
* Students can explain why all comparison-based sorts have an input that takes order Omega(nlogn).
* Students can reproduce Radix Sort and Bucket Sort and explain contexts in which these algorithms are useful.
* Students can reproduce Topological sort and explain contexts in which this algorithm is useful.
* Given an algorithm which uses Divide-and-Conquer, students can develop a recurrence relation for that algorithm.
* Given a recurrence relation, students can solve the relation using the Recurrence Formula Theorem and other techniques.
* Students can consider different algorithmic design strategies when solving problems.
* Students can solve problems using divide and conquer techniques.
* Students can solve problems using greedy techniques.
* Students can solve problems using dynamic programming techniques.
* Students can adapt network flow algorithms to solve appropriate network problems.
* Students can implement an advanced data structure or algorithm, demonstrating good software design practices including documentation and testing.
* Students can explain the tradeoffs between different data structures when they are used for similar problems.
* Given an incorrect algorithm, students can find an example on which it fails.
* Students can implement a balanced tree.
* Students can read and understand a primary source from the literature of algorithms.
* Students can explain how structural racism or other unexpected consequences can manifest in algorithm design.

### Types of writing 

This course employs a variety of genres of writing typically used in the discipline.  In particular, students will write,

* _Proofs_ in mathematical English.
* _Program code_ in a variety of languages (including Scheme, C, and Java)
* _Documentation_ that explains the goals and expectations of functions, data structures, and compositions of functions and data structures, such as in objects/classes or full programs.
* _Unit tests_ that help verify the correctness of code.
* _Claim-based essays_ in English.

## Class Format

I firmly believe that you learn by doing.  While I do not expect to make
this a full workshop-style course, akin to CSC 151 or CSC 161, I
will do my best to regularly give you the opportunity to work
together and individually on problems during class time.  I am also
likely to conduct many class sessions using my standard "pseudo
recitation" (Socratic lite?) style - I will randomly select students
and ask a series of questions.  You should do your best to answer
those questions, but you should feel free to say "I'm not sure" or
to ask me your own questions.  I employ that style not only because
I find that it helps model problem solving processes, but also
because it exposes you to other ways of thinking about problems.

## Time and workload

Grinnell has indicated that a 4-credit course, like this one, should involve approximately 180 hours of work, which matches some guidance from the U.S. government.
Across a 14-week term (plus a week finals), that ends up being approximately 12 hours of work per week.
I have not been able to get anyone to answer the question of "180 hours *for whom* and *for what grade*?", I've been given the impression that I should strive for that workload for the "average" student in a course.
If you find yourself working much more than the expected amount in this course, please let me know.
It could be that other approaches, or better support resources, can help.

## Diversity and inclusion

I believe that any college-level course should challenge you and put you outside of your comfort zone.
My mission as an instructor is to help you manage that discomfort so that you can grow in knowledge and maturity.
Therefore, I strive to create a fully inclusive setting so that we all can ultimately succeed in the classroom.

### Learning needs

I welcome you to talk to me as early as possible about your distinctive learning needs.
I particularly encourage students with disabilities to meet with me and discuss how our classroom and course activities could impact their work and what accommodations would be essential.
I will also make adjustments for students without documented disabilities.  However, I do recommend that you seek official accommodations.
As part of the accommodations process, I recommend talking to our Coordinator for Student Disability Resources for guidance and further instructions:

+ Jae Hirschman, Steiner Hall, 1st floor (x3089)

You can find some additional details in [my statement on
accommodations and adjustments](../handouts/accommodations).

### Religious observance policy

I also support the class's religious diversity and anyone who needs to balance academic work with religious observations.
Please let me know by **week two** if you will need to be absent from class for any religious holidays this semester, and we can work out an appropriate schedule for making up absences or missed work.

### Community guidelines

Our class is a community.  We should behave as such.  Among other things, that means treating others with respect, not only in the language that we use (no slurs, please), but also in taking ideas, approaches, and perspectives seriously.  We will discuss appropriate guidelines for the class throughout the semester, developing those guidelines as a community.

### Pandemic issues

The normal instructional structure of this course requires that you be present, physically and mentally, each day.
However, the current pandemic may disrupt some of your ability to be present physically.
If you are ill, do not attend class.
But let me know.
I will adapt as necessary for those who must join the class remotely or who cannot attend in either way.
Please provide advance notice if possible.

### Other accommodations

There are a limitless number of dimensions to diversity and inclusion, the totality of which are unaddressable with a finite set of policies.
These may include other issues best addressed earlier in the semester (*e.g.*, student-athlete scheduling) or as they arise (*e.g.*, chronic health flare-ups).
I will do my best to be flexible in these cases with the overall goal of facilitating your growth in this course.
To do this, I need to receive advanced notice from you **at least one week in advance** so that we can make suitable arrangements.
For situations that arise within a given week, I will ask you to utilize the token system (described in the evaluation section) to manage your workload.

## Textbooks and similar resources

This semester, I am trying a new set of textbooks for the course.  They
look to be a bit friendlier than "The Brick" (aka CLRS, aka Cormen, Leiserson,
Rivest, Stein, _Introduction to Algorithms_, 3rd edition).

> Roughgarden, Tim (2017). _Algorithms Illuminated Part 1: The Basics_.
San Francisco, CA: Soundlikeyourself Publishing.

> Roughgarden, Tim (2018). _Algorithms Illuminated Part 2: Graph
Algorithms and Data Structures._ San Francisco, CA: Soundlikeyourself
Publishing.

> Roughgarden, Tim (2019). _Algorithms Illuminated Part 3: Greedy
Algorithms and Dynamic Programming._ San Francisco, CA: Soundlikeyourself
Publishing.

These books were developed as part of an online course in algorithms,
which means that videos are also available.

> [Part 1](https://www.youtube.com/playlist?list=PLEGCF-WLh2RLHqXx6-GZr_w7LgqKDXxN_)

> [Part 2](https://www.youtube.com/playlist?list=PLEGCF-WLh2RJ5W-pt-KE9GUArTDzVwL1P)

> [Part 3](https://www.youtube.com/playlist?list=PLEGCF-WLh2RI5H8JBWxq0Q4AN7XVaj-h-)

## Evaluation and grading

This course employs a grading system based on [*mastery grading* and *specifications grading*](https://docs.google.com/document/d/13V1fsPve19IU-tFNt4AeQ78VepuqVakp3xizJrj5KwY/edit) to evaluate your work.
These systems, inspired by adult learning theory, are designed to create a "low-threat" learning environment where:

+ Mastery obtained via exploration, experimentation, and failure is encouraged and valued as highly as "getting it right" the first time.
+ Your final grade accurately reflects your mastery of the learning goals of the course.

To achieve high grades, some of you may find that you have to re-do some of the work in the class.
Many of the components of the course have "no penalty" redos available.

### Work

This semester, we will have multiple kinds of work.

* In-class work, such as to design algorithms
* Regular homework assignments 
    * Some design
    * Some proof
    * Some implementation
* Potentially "short assessments" like those we are now using in CSC-151
* An essay or two

### Letter grades

Letter grades for the course will depend on the number of the core learning outcomes you demonstrate to my satisfaction.  You will demonstrate mastery of most of those outcomes through homework assignments.  I may ask for followup demonstrate through short quizzes or interviews.  At the end of the semester, I will ask you to provide me with a *portfolio* of work in which you demonstrate your accomplishment of the class's learning goals.

Your base grade depends on the number of learning outcomes for which you have provided compelling evidence of appropriate mastery.

* **A**: Clear evidence of having met _all twenty_ learning outcomes.
* **A-**: Clear evidence of having met _nineteen_ learning outcomes.
* **B+**: Clear evidence of having met _eighteen_ learning outcomes.
* **B**: Clear evidence of having met _seventeen_ learning outcomes.
* **B-**: Clear evidence of having met _sixteen_ learning outcomes.
* **C+**: Clear evidence of having met _fifteen_ learning outcomes.
* **C**: Clear evidence of having met _fourteen_ learning outcomes.
* **D**: Clear evidence of having met _twelve or thirteen_ learning outcomes.
* **F**: Insufficient evidence to demonstrate meeting twelve or more learning
  outcomes.

Your grade may also be impacted by attendance, class participation, and timeliness in completing work.

Note that I reserve the right to update requirements for grades as circumstances dictate over the course of the semester, *e.g.*, if a deliverable is cut.
I will always update the requirements so that they are approximately as strict as they were previously.

---

### Final deadline for all work

Note that *all* work must be submitted by {{ site.all_work_deadline }}.
This is College policy and cannot be waived for any reason.
If you find yourself needing to turn in work past this deadline, you must consult with me as soon as possible to submit an *incomplete request* for the course.
If you take an incomplete in the course, the only work you can make up will be the mini projects.

## Tokens

Tokens reflect that life inevitably rears its ugly head in some fashion and ruins your best-laid plans.
You begin the course with **3 tokens**, and you may:

In most cases, I will charge tokens automatically.

You will have opportunities to earn additional tokens throughout the semester by participating in extra-curricular activities.
To earn a token, attend the event (or watch a recording within one day) and submit a one-paragraph reflection on the event in the Tokens assignment on Gradescope.
You must submit your response paragraph within a week of the event.
Additional information about these opportunities will be posted to Teams as they arise.

If you use more tokens than you have, I will count the extras against lab writeups, readings, or quizzes, whichever affects your grade the least.
But please try not to use more tokens than you have.
A token debt at the end of the semester will decrease your grade.

## Languages

At this point in your career, you should be comfortable with
Scheme/Racket, C, and Java.  You should be prepared to implement
algorithms in any of those languages.

## Help, collaboration, academic honesty, and academic integrity

To help expedite your learning, you can rely on me, our class mentor, and your peers as outlets in this course.

**The Instructor, course staff, and other resources**

When contacting the course staff, please use direct messages (DM) on Microsoft Teams.
While we will generally not respond immediately—we will check our messages at fixed times throughout the day—we will prioritize responses to student questions over Teams versus queries sent through other means, *e.g.*, email.

The **course mentors** also hold optional *mentor sessions* outside of regular class time.
In these sessions, the mentors guide you through practice problems designed to help you master the material and answer any questions you have about the material.
I highly recommend you attend each of these sessions, even if you feel like you understand the material.
You never know what you don't know, and the purpose of these sessions is to bring these blind spots to light!

Finally, if you would like to discuss things in more detail—--course content, more general questions about computer science, or other things—--feel free to schedule a (virtual) meeting with me, either [during office hours](https://bit.ly/book-samr) or, if those don't work, by sending me a message with available times.

Note that if I find that you have fallen behind on assignments or are showing difficulty on quizzes or learning assessments, I will invite you to meet with me.  Please accept those invitations; they are intended to be supportive, not punative.

**Peer learning**

Utilizing discussion with peers to facilitate your learning is a critical skill for success in computer science.
However, at the same time, you must be aware that getting stuck and pushing through challenging problems is essential for robust learning.
To this end, we allow the following forms of collaboration.

+ You are encouraged to collaborate with your peers on most work.
  You may also consult the course staff as well as other people and external resources.
  In all cases, you (or your group in the case of group work) should independently write up your solutions and cite all the resources you used in authoring your work.
+ You may only discuss exams and quizzes with the course staff.
  When completing examinations and quizzes, you may only consult the course website, the textbook, and the ntoes  you have taken.
  You may not collaborate with peers, consult external resources beyond the ones mentioned above, or share information about these assignments with others.

Keep in mind that *adaptation of pre-existing code* whether it comes from a peer, myself, or the Internet, requires a citation in cases where it is allowed.
Also, whenever you are expected to show your code's output, you are expected to reproduce the output faithfully.
In other words, you should not forge the results of your programs!

In all cases, the work that you produce should be your own.
The golden rule is that you should be capable of reproducing your deliverable on the spot with minimal effort if it was accidentally deleted.

If you feel that the stress and pressure of the course are compelling you to violate the academic honesty policies of the course and the college as explained in the [student handbook](https://catalog.grinnell.edu/content.php?catoid=12&navoid=2537#Honesty
_in_Academic_Work), **please talk to me as soon as possible**.
The course's grading policies as designed to help you manage your time in light of the different stressors in your life.
I will do my best to work with you to figure out how to help you better manage your time relative to your learning goals and desired achievement level for the course.

And just if that wasn't enough, you should check out [my extended statement
on academic honesty and integrity](../handouts/academic-honesty).

**Sharing of course materials**

Our goal is to create an inclusive learning environment where people feel free to share, fail, and ultimately grow in knowledge.
To create such an environment, it is imperative that we be mindful of what we share outside of our learning space.
To this end, I request that you refraining from sharing any recordings of our class meetings with others.
Recordings of class meetings that we provide, *e.g.*, recorded through Microsoft Teams, are meant for your *personal use* and should not be shared outside of the class.

Furthermore, while you retain [copyright](https://www.plagiarism.org/blog/2017/09/25/do-i-own-my-work-even-if-im-just-a-student) of the work you produce in this course, we must still uphold the academic integrity of this course.
To this end, you may not share copies of your assignments with others (unless otherwise allowed by the course policies) or upload your assignments to third party websites unless substantial changes are made to the assignment (*e.g.*, significant extensions and improvements to your code) so that it is clear that the end product is significantly different from what was asked in original assignment.
I do recognize that there are times where you want to do this, *e.g.*, uploading projects to Github for your resume or to show to friendds and family, and so I encourage you come talk to me in advance, so that we can ensure that you upload a meaningful project that does not run afoul of this policy.

ITS has released and then temporarily withdrawn policies that may limit your ability to share your work with others.
I consider those policies inappropriate for many reasons.
The CS department managed to convince the College to revisit them, but we are not sure what the new policies will look like.  Stay tuned.

## Other issues

**Names**

I get names wrong.  I get names wrong all the time.  Evidence
suggests that I am not just bad at remembering names, I also have
some brain differencees that regularly lead me to mix up peoples'
names.  I think, for example, of two of my favorite research students,
one with blonde hair, from Minnesota, who also served as a teaching
assistant for my software design course; the other with dark hair,
from Massachusetts, who brought a wealth of background in education
to my research projects.  I can tell you a lot about each student
(although I wouldn't without their permission), including hobbies,
where they studied abroad, what they are doing now (or at least
what they were doing before the pandemic hit), and more.  But I
inevitably reversed their names, calling Minnesota Massachusetts
and Massachusetts Minnesota.

When I discussed this issue with my family, my sons laughed and said "Dad,
you get *our* names backwards, too; we just ignore you when you do so."
And I've heard from other students I value highly that I do this and
don't always notice.  (The other day, I almost referred to an alum
by a different name.)

If I use the wrong name for you, it is not a sign that I do not
respect your or that I do not care about you.  It's a deficiency
in my processing, and one that I seem unable to fix.  Please accept
and understand that disability, just as I will do my best to accept
and understand your own differences.

**My health**

I had a heart attack last spring.
For my health, I am limiting my work hours to appropriate amounts, typically 40 hours per week.
I apologize if that means that I am not always caught up on my work or available at times you would like.

I will also try to be respectful of your time.
Please let me know if you find yourself regularly spending more than twelve of so hours per week on this class, which is what the College considers appropriate for a four-credit course.  
(We have four hours in class each week, we suggests that you have eight hours out-of-class for readings, review, and mini projects.)

The state of the pandemic also suggests that I should not meet with you one-on-one in person in my office.
I will hold most "office hours" online.
If our discussion does not require a computer, I am also happy to walk outside with you.
