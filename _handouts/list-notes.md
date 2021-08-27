
Working with list procedures (helpful for MP3)
----------------------------------------------

You should think about the list procedures in terms of decomposing
a list-based problem into problems having to do with individual elements.

With many of the list procedures (e.g., `map`, `filter`, `tally`) ask
you solve a problem for one element and then use the list procedure
to solve it for all of the elements of the list.

With `reduce`, you solve a problem for pairs of elements and use it
to combine a list into a single value.

Let's look at two ways of counting all the vowels in a string.

### First approach

Here's one approach.  We're going to write a procedure that counts
how many times a character appears in a string.  

```drracket
;;; (tally-character ch str) -> integer?
;;;   ch : character?
;;;   str : string?
;;; Count how many times ch appears in str
```

How can we write this?  We'll convert the string to a list of
characters.  Then we can use `tally-value`.

```drracket
(define tally-character
  (lambda (ch str)
    (tally-value (string->list str) ch)))
```

And we'll write some quick tests.  

### Second approach

Here's another approach: We start by writing a procedure that checks
whether or not a letter is a vowel.

```drracket
;;; (vowel? char) -> boolean?
;;;   char : character?
;;; Determines if char is a vowel
(define vowel?
  (lambda (ch)
    (or (char-ci=? ch #\a)
        (char-ci=? ch #\e)
        (char-ci=? ch #\i)
        (char-ci=? ch #\o)
        (char-ci=? ch #\u))))
```

Once we can tell whether or not a letter is a vowel, we convert the
list to a string and use `tally.

```drracket
;;; (tally-vowels str) -> integer
;;;    str : string?
;;; Counts all the vowels in str.
(define tally-vowels
  (lambda (str)
    (tally vowel? (string->list str))))
```

