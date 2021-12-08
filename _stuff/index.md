---
title: Functional Problem Solving
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
Welcome to CSC 151-{{ site.section_number }}, Grinnell College's introductory computer science course. In this
course, we will work to develop your experience with algorithmic problem
solving. While we will be using Scheme as our programming language for
this course, you will quickly see that the problem solving skills we
learn in this class are applicable to other languages and in settings
that don't involve programming at all.

We will be emphasizing data science, the application of algorithmic
problem solving techniques to collections of data. We will focus
specifically on cleaning, analyzing, and visualizing data.  We may also
consider techniques for wrangling data.

CSC 151 requires no prior knowledge of computer science or computer
programming. We'll teach you everything we want you to know. It's okay
if you have some experience (although this may sometimes put you at a
disadvantage; we do things differently), but it's certainly not necessary.

There is [another section]({{ site.other_section_website }})
of this course taught by {{ site.other_section_instructor
}}. The sections will often be in sync, but make sure you refer to your
section's course website when checking due dates and course policies.

Read more about the course in [the syllabus](syllabus) and 
[the schedule](schedule).

{% if site.extra_homepage_text %}
{{ site.extra_homepage_text | markdownify }}
{% endif %}
