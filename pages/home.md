---
title: Functional Problem Solving
permalink: /home/
---
# Functional Problem Solving
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
Welcome to CSC 151-{{ site.section_number }}, Grinnell College's introductory computer science course.
In this course, we will work to develop your experience with algorithmic problem solving.
While we will be using Racket as our programming language for this course, you will quickly see that the problem solving skills we learn in this class are applicable to other languages and in settings that don't involve programming at all.

This semester, CSC 151 will emphasize the digital humanities, the use of computing technology to explore humanistic subjects.
While we will primarily focus on text-based digital humanities, we are likely to touch on other approaches, too.

CSC 151 requires no prior knowledge of computer science or computer programming.
We'll teach you everything we want you to know.
It's okay if you have some experience (although this may sometimes put you at a disadvantage; we do things differently), but it's certainly not necessary.

Read more about the course in [the syllabus]({{ "/syllabus/" | relative_url}}) and  [the schedule]({{ "/schedule/" | relative_url }}).

{% if site.extra_homepage_text %}
{{ site.extra_homepage_text | markdownify }}
{% endif %}
