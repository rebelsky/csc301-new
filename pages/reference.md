---
title: CSC 151 Reference
permalink: /reference/
---
# {{ page.title }}

The main reference for the Racket language and its libraries is the [The Racket Reference](https://docs.racket-lang.org/reference/index.html) available on the Racket website.
Here, we summarize some of the parts of the language and libraries we use in this course.

## Keywords

**`(and ex0 ex1 ...)`** --- Evaluate each expression until you reach
`#f` (in which case the result is `#f`) or you run out of expressions,
in which case the result is the last expression.

**`(cond ([guard0 exp0] [guard1 exp1] ... [else alternative]))`** ---
Evaluate each guard in turn until one holds (is not false).  Then
evaluate the corresponding expression and return its value.  If no guards
hold, evaluate the alternative and return its value.

**`(define name exp)`** --- Evaluate `exp` and then assign the value
to `name`.

**`(if guard true-part false-part)`** --- Evaluate the `guard`.  If it holds (is not
`#f`), evaluate the `true-part`.  Otherwise, evaluate the `false-part`.

**`(lambda (params) body)`** --- A procedure with the given formal parameters
and body.  When applied, we substitute the arguments (actuals) for the 
parameters in the body.

**`(or ex0 ex1 ...)`** --- Evaluate each expression until you reach
a truish case (in which case the result is the last truish value) or 
you run out of expressions, in which case the result is `#f`.

## Procedures

**`(+ v0 v1 v2 ...)`** --- Add numbers together.

**`(- v0)`** --- Compute the opposite of `v0`.  Read as "negate".

**`(- v0 v1 v2 ...)`** --- Subtract each of `v1`, `v2`, ... from `v0`.

**`(* v0 v1 v2 ...)`** --- Multiply numbers

**`(/ v0)`** --- Compute one divided by `v0`.

**`(/ v0 v1 v2 ...)`** --- Divide `v0` by each of `v1`, `v2`, ....

**`(< num0 num1 ...)`** --- Determine if the numbers are in strictly
increasing order.

**`(<= num0 num1 ...)`** --- Determine if the numbers are in 
non-decreasing order.

**`(= num0 num1 ...)`** --- Determine if all the numbers are equal.

**`(>= num0 num1 ...)`** --- Determine if the numbers are in 
non-increasing order.

**`(> num0 num1 ...)`** --- Determine if the numbers are in strictly
decreasing order.

### A

**`(above img0 img1 ...)`** --- Create a new image by stacking all of the images vertically, centered.  `img0` is at the top.

**`(above/align alignment img0 img1 ...)`** --- Create a new image by stacking all of the images vertically, aligned as specified (`'left`, `'center`, or `'right`).  `img0` is at the top.

**`(abs num)`** --- Take the absolute value of a number.

**`(append lst0 lst1 ...)`** --- Combine lists together into a single list.

**`(apply proc lst)`** --- Apply `proc` to the elements of `lst` _en masse_.  `(apply proc (list v0 v1 v2 v3 ...))` is the same as `(proc v0 v1 v2 v3 ...)`.

### B

**`(beside img0 img1 ...)`** --- Create a new image by combining all of the images horizontally, centered.  `img0` is at left.

**`(beside/align alignment img0 img1 ...)`** --- Create a new image by combining all of the images horizontally, aligned as specified (`'top`, `'bottom`, or `'center`).  `img0` is at left.

### C

**`(car lst)`** --- Get the first element of a non-empty list.

**`(cdr lst)`** --- Get all but the first element of a non-empty list.

**`(ceiling num)`** --- "Round up".

**`(char? val)`** --- Determine if val is a character.

**`(char<? ch0 ch1 ...)`** --- Determine if the characters are in strictly
increasing order (by collating sequence).

**`(char<=? ch0 ch1 ...)`** --- Determine if the characters are in 
non-decreasing order (by collating sequence).

**`(char=? ch0 ch1 ...)`** --- Determine if the characters are all the same.

**`(char>=? ch0 ch1 ...)`** --- Determine if the characters are in 
non-increasing order (by collating sequence).

**`(char>? ch0 ch1 ...)`** --- Determine if the characters are in strictly
decreasing order (by collating sequence).

**`(char-alphabetic? char)`** --- Determine if `char` is an alphabetic character.

**`(char-ci<? letter0 letter1 ...)`** --- Determine if the letters are in strictly increasing order, ignoring case.

**`(char-ci<=? letter0 letter1 ...)`** --- Determine if the letters are in non-decreasing order, ignoring case.

**`(char-ci=? letter0 letter1 ...)`** --- Determine if the letters are equal, ignoring case.

**`(char-ci>=? letter0 letter1 ...)`** --- Determine if the letters are in non-increasing order, ignoring case.

**`(char-ci>? letter0 letter1 ...)`** --- Determine if the letters are in strictly increasing order, ignoring case.

**`(char->integer char)`** --- Find the collating sequence number of `char`.

**`(char-lower-case? char)`** --- Determine if `char` is a lowercase letter.

**`(char-numeric? char)`** --- Determine if `char` is a numeric character.  (A digit, so to speak.)

**`(char-upper-case? char)`** --- Determine if `char` is an uppercase letter.

**`(char-whitespace? char)`** --- Determine if `char` is a whitespace character, such as space, tab, or return.

**`(circle radius mode color)`** --- Create the circle that matches the description.  `mode` can be `'solid` or `'outline` or a number between 0 and 255, which represents the opacity.  `color` can also be a pen.

**`(complex? val)`** --- Determine if `val` is a complex number (one
that can have an imaginary part).

**`(cons x xs)`** --- Add `x` to the front of the list `xs`.

### D

**`(denominator num)`** --- Compute the denominator of the internal 
representation of a real number.

**`(drop lst n)`** --- Create a new list consisting of all but the
first `n` elements of `lst`.

### E

**`(eq? val0 val1 val2 ...)`** --- Determine if all the values have
the same location in the computer's memory.

**`(equal? val0 val1 val2 ...)`** --- Determine if all the values are equal.

**`(error str ...)`** --- Report an error and stop the computation immediately.
 
**`(exact? val)`** --- Determine if `val` is an exact number.

**`(expt base power)`** --- Compute `base` to the `power`'th power or
`base`<sup>`power`</sup>

**`(even? i)`** --- Determine if the integer `i` is even.

### F

**`(filter pred? lst)`** --- Select the elements of `lst` for which
`pred?` holds.

**`(floor num)`** --- "Round down".

### I

**`(imag-part num)`** --- Extract the imaginary part of a complex number.

**`(index-of lst val)`** --- Find an index of `val` in `lst`.  (Note:
In some versions, you'll find the two parameters reversed.)

**`(indexes-of lst val)`** --- Get a list of all of the indices of
`val` in `lst`.

**`(inexact? val)`** --- Determine if `val` is an inexact number.

**`(integer? val)`** --- Determine if `val` is an integer.

**`(integer->char i)`** --- Find the character associated with `i` in the collating sequence.

### L

**`(list v0 v1 ...)`** --- Create a list consisting of the values v0, v1, etc.

**`(list? val)`** --- Determine if `val` is a list.

**`(list-ref lst pos)`** --- Find the value at the given position in `str`.

**`(list->string list-of-characters)`** --- Build a string from a list of characters.

### M

**`(make-list n val)`** --- Make a list of `n` copies of `val`.

**`(map proc lst)`** --- Apply `proc` to each element of `lst`, individually, creating a new list of the same length.  If `lst` has the form `'(v0 v1 ...)`, the result has the form `((proc v0) (proc v1) ...)`. 

**`(map proc lst1 lst2 lst3 ...)`** --- Apply `proc` to the corresponding elements of each list (which all must have the same length) creating a new list of the same length.  If `lsti` has the form `'(vi0 vi1 vi2 ...)`, the result has the form `((proc v10 v20 v30 ...) (proc v11 v21 v31) (proc v12 v22 v32 ...))`. 

**`(max v0 v1 v2 ...)`** --- Find the largest of the specified values.

**`(max v0 v1 v2 ...)`** --- Find the smallest of the specified values.

### N

**`(negative? num)`** --- Determine if the real number `num` is negative.

**`(number->string num)`** --- Convert a number to its string/textual representation.

**`(not val)`** --- Compute the logical opposite of `val`.  `(not #f)` is
`#t`.  `(not anything-else)` is `#f`.

**`(numerator num)`** --- Compute the numerator of the internal 
representation of a real number.

### O

**`(o f1 f2 f3 ...)`** --- Create a new procedure that applies each
of the other procedures, one by one, from right to left.

**`(odd? i)`** --- Determine if the integer `i` is odd.

**`(overlay img0 img1 img2 ...)`** --- Overlay images on top of each other.

**`(overlay/align halign valign img0 img1 img2 ...)`** --- Overlay images on top of each other.

### P

**`(pen color width style cap join)`** --- Create a pen for use in
drawing circles and squares and such.

**`(positive? num)`** --- Determine if the real number `num` is positive.

**`(procedure? val)`** --- Determine if `val` is a procedure.

### Q

**`(quotient dividend divisor)`** --- Integer division.  Divide
`dividend` by `divisor`, giving the whole number result.

### R

**`(range n)`** --- Create the list `'(0 1 2 ... n-1)`.

**`(range start finish)`** --- Create a list of the integers from `start`
(inclusive) to `finish` (exclusive).

**`(range start finish offset)`** --- Create a list of the integers from `start`
(inclusive) to `finish` (exclusive), adding `offset` each time.

**`(rational? val)`** --- Determine if `val` is a real number.

**`(real? val)`** --- Determine if `val` is a real number.

**`(real-part num)`** --- Extract the real part of a complex number.

**`(rectangle width height mode color)`** --- Create a rectangle of the specified characteristics. `mode` can be `'solid` or `'outline` or a number between 0 and 255, which represents the opacity.  `color` can also be a pen.

**`(reduce proc lst)`** --- Reduce a list to a single value by
repeatedly combining neighboring elements with `proc`.

**`(reduce-left proc lst)`** --- Reduce a list to a single value by
repeatedly combining neighboring elements with `proc`, moving from
left to right.

**`(reduce-right proc lst)`** --- Reduce a list to a single value by
repeatedly combining neighboring elements with `proc`, moving 
from right to left.

**`(regexp-match* regexp string)`** --- Make a list of all the portions
of `string` that match the regular expression.

**`(remainder dividend divisor)`** --- Remainder from integer division.
Give what remains after dividing `dividend` by `divisor`.

**`(rex-any-char)`** --- Generate a regular expression that matches any single character.

**`(rex-any-of rex1 rex2 ... rexn)`** --- Generate a regular expression that matches any of `rex1` or `rex2` or ....

**`(rex-char-antiset str)`** --- Generate a regular expression that matches any character *not* in `str`.

**`(rex-char-range start finish)`** --- Generate a regualr expression that matches any character that falls between `start` and `finish`, inclusive.  `(rex-char-range #\a #\z)` matches any lowercase letter.

**`(rex-char-set str)`** --- Generate a regular expression that matches any character in `str`.

**`(rex-concat rex1 rex2 ... rexn)`** --- Generate a regular expression that matches a string that begins with a substring that matches `rex1`, then has a subsequent substring that matches `rex2`, and so on.

**`(rex-empty)`** --- Generate a regular expression that matches the empty string.  (Primarily useful to make optional parts of a string.)

**`(rex-end-of-string)`** --- Generate a regular expression that matches the end of a string.

**`(rex-find-matches rex str)`** --- Find all of the matches of a regular expression in a string.

**`(rex-match? rex str)`** --- Determine if a regular expression matches a string.

**`(rex->regexp rex)`** --- Convert a rex-style regular expression to one of the most standard Racket-style regular expression.

**`(rex-repeat rex)`** --- Generate a regular expression that matches one or more repetitions of `rex`.

**`(rex-repeat-0 rex)`** --- Generate a regular expression that matches one or more repetitions of `rex`.

**`(rex-split-string rex str)`** --- Split a string at every instance of rex.

**`(rex-start-of-string)`** --- Generate an expression that matches the start of a string.

**`(rex-string str)`** --- Generate a regular expression that exactly matches `str`.
**`(rex-string str)`** --- Generate a regular expression that exactly matches `str`.

**`(round num)`** --- Round a number toward the closest integer.
Halves round toward the closest even integer.

### S

**`(section proc val-or-hole val-or-hole ..._)`** - Create a new procedure
by selectively filling in some values as inputs to `proc`.

**`(sort lst compare?)`** - Sort the given list by comparing neighboring
values with `compare?`.

**`(sqr num)`** --- Compute the square of a number.

**`(sqrt num)`** --- Compute the square root of a number.

**`(square size mode color)`** --- Create a square of the specified characteristics. `mode` can be `'solid` or `'outline` or a number between 0 and 255, which represents the opacity.  `color` can also be a pen.

**`(string ch0 ch1 ...)`** --- Convert the sequence of characters into a string.

**`(string? val)`** --- Determine if `val` is a string.

**`(string<? str0 str1 ...)`** --- Determine if the strings are in strictly increasing order, using character comparison at each position.

**`(string<=? str0 str1 ...)`** --- Determine if the strings are in non-decreasing order, using character comparison at each position.

**`(string=? str0 str1 ...)`** --- Determine if the strings are all the same.

**`(string>=? str0 str1 ...)`** --- Determine if the strings are in non-increasing order, using character comparison at each position.

**`(string>=? str0 str1 ...)`** --- Determine if the strings are in strictly decreasing order, using character comparison at each position.

**`(string>? str0 str1 ...)`** --- Determine if the strings are in strictly decreasing order, using character comparison at each position.

**`(string-append str0 str1 ...)`** --- Combine strings together into a single string.

**`(string-ci<? str0 str1 ...)`** --- Determine if the strings are in strictly increasing order, using character comparison at each position.

**`(string-ci<=? str0 str1 ...)`** --- Determine if the strings are in non-decreasing order, using character comparison at each position and ignoring case.

**`(string-ci=? str0 str1 ...)`** --- Determine if the strings are all the same, ignoring case.

**`(string-ci>=? str0 str1 ...)`** --- Determine if the strings are in non-increasing order, using character comparison at each position and ignoring case.

**`(string>=? str0 str1 ...)`** --- Determine if the strings are in strictly decreasing order, using character comparison at each position and ignoring case.

**`(string>? str0 str1 ...)`** --- Determine if the strings are in strictly decreasing order, using character comparison at each position.

**`(string-length str)`** --- Determine how many characters are in `str`.

**`(string->list str)`** --- Convert a string into a list of characters.

**`(string->number str)`** --- Convert a string to the corresponding number.  Returns `#f` if it cannot be converted.

**`(string-ref str pos)`** --- Find the character at the given position in `str`.

**`(string-replace str old new)`** --- Replace all copies of `old` in `str` with `new`.

**`(string-split str)`** --- Split `str` into a list of strings at sequences of spaces.

**`(string-split str separator)`** --- Split `str` into a list of strings, splitting at every instance of `separator`.

**`(substring str start)`** --- Extract the substring of `str` starting at `start` and finishing at the end of the string.

**`(substring str start finish)`** --- Extract the substring of `str`
starting at index `start` and finishing immediately before index `finish`.

### T

**`(take lst n)`** --- Create a new list consisting of the first `n`
elements of `lst`.

**`(tally pred? lst)`** --- Count how many elements of `lst` meet `pred?`.

**`(tally-value lst val)`** --- Count how many times `val` appears in `lst`.

**`(triangle edge style color)`** --- Create an equilateral triangle
of the specified edge length.  Style is as in other shapes.

**`(truncate num)`** --- Round a number by cutting off anything after
the decimal.  (Rounds toward zero.)

### Z

**`(zero? num)`** --- Determines if the number is zero.

## Syntax Reference

Here is a concise description of the subset of the Racket programming language we use in this course.
This description is given in a variant of [Extended Backnus-Naur Form (EBNF)](https://en.wikipedia.org/wiki/Extended_Backus%E2%80%93Naur_form).

Note that the description is not entirely consistent with the formal definition of the language; in particular, we only distinguish between two syntactic classes: top-level declarations and expressions.

~~~
<top-level> ::= (define <id> <expr>)
              | (require <module>)
              | <expr>

<expr> ::= <number>
         | <string>
         | #t
         | #f
         | #px<string>
         | '(<expr1> ... <exprk>)
         | x
         | (<expr> <expr> ... <expr>)
         | (lambda (<id1> ... <idk>) <expr>)
         | (<let-kind> ([<id1> <expr1> ... <idk> <exprk>]) <expr>)
         | (if <expr1> <expr2> <expr3>)
         | (cond [<expr11> <expr21>] ... [<expr1k> <expr2k>])
         | (begin <expr1> ... <exprk>)

<let-kind> ::= let | let* | letrec

<id> ::= a set of characters with no whitespace in between
         incl. letters, numbers, and most symbols
~~~

Throughout, you may interchange any bracket symbols---parentheses (`(...)`), square brackets (`[...]`), and curly brackets (`{...}`)---as long each open-bracket is closed by the same kind of bracket.
By convention, parentheses are used in most circumstances with the exception being the pairs of binding-expression pairs for `let` expressions and expression-expression pairs for `cond` expressions.

Single-line comments in Racket are lines of text prepended with semi-colons (`;`).

Multi-line comments in Racket are blocks of text that begin with hash-pipe (`#|`) and end in pipe-hash (`|#`).

## API Reference

Equally important as the syntax of a language is its *standard library*.
The standard library are the modules bundled with the language that require no additional installation to use.
These libraries typically include the functions we use to manipulate the built-in types of the language, *e.g.*, numbers, strings, and lists, as well as perform fundamental operations such as file input-output.

Below are [the API documentation](https://docs.racket-lang.org/reference/data.html) for each of the built-in types we use in Racket:

+   [Booleans](https://docs.racket-lang.org/reference/booleans.html)
+   [Numbers](https://docs.racket-lang.org/reference/numbers.html)
+   [Strings](https://docs.racket-lang.org/reference/strings.html)
+   [Characters](https://docs.racket-lang.org/reference/characters.html)
+   [Regular Expressions](https://docs.racket-lang.org/reference/regexp.html)
+   [Pairs and Lists](https://docs.racket-lang.org/reference/pairs.html)
+   [Vectors](https://docs.racket-lang.org/reference/vectors.html)
+   [Dictionaries](https://docs.racket-lang.org/reference/dicts.html)
