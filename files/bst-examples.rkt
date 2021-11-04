#lang racket
(require "bst.rkt")

(define t1 (tree-new))
(for-each (lambda (kv)
            (tree-insert! t1 (car kv) (cadr kv)))
          '(("H" "Hello") ("D" "Drive") ("B" "Billfold") ("F" "Fill") ("Q" "Quux")))

#|
> (tree-keys t1)
'("B" "D" "F" "H" "Q")
> (tree-find t1 "H")
"Hello"
> (tree-insert! t1 "H" "Hamburger")
> (tree-size t1)
5
> (tree-find t1 "H")
"Hamburger"
> (tree-iterate-preorder! t1 (lambda (key value) (fprintf (current-output-port) "~a:~a~n" key value)))
B:Billfold
D:Drive
F:Fill
H:Hamburger
Q:Quux
|#

;;; (random-string-element str) -> char?
;;;   str : string? (nonempty)
;;; Randomly select an element of str
(define random-string-element
  (lambda (str)
    (string-ref str (random (string-length str)))))

;;; (random-vowel) -> char?
;;; Randomly select a lowercase vowel
(define random-vowel
  (lambda ()
    (random-string-element "aeiou")))

;;; (random-consonant) -> char?
;;; Randomly select an lowercase consonant
(define random-consonant
  (lambda ()
    (random-string-element "bcdfghjklmnpqrstvwxyz")))

;;; (random-word) -> string?
;;; Generate a random word-like value
(define random-word
  (lambda ()
    (string (random-consonant) (random-vowel)
            (random-consonant) (random-vowel)
            (random-consonant) (random-vowel))))

;;; (random-tree n) -> tree?
;;;   n : integer? (not negative)
;;; Randomly generate a tree of the appropriate size
(define random-tree
  (lambda (n)
    (letrec ([kernel (lambda (tree)
                       (if (= (tree-size tree) n)
                           tree
                           (let ([word (random-word)])
                             (tree-insert! tree word word)
                             (kernel tree))))])
      (kernel (tree-new)))))

#|
> (define t2 (random-tree 10))
> t2
#<tree>
> (tree-size t2)
10
> (tree-iterate-preorder! t2 (lambda (key value) (fprintf (current-output-port) "~a:~a~n" key value)))
juhuxo:juhuxo
logoke:logoke
loxana:loxana
muqusu:muqusu
pexiza:pexiza
pucago:pucago
punata:punata
qorepa:qorepa
visabi:visabi
zuhavu:zuhavu
> (tree-height t2)
6

> (define t3 (random-tree 1024))
> (tree-size t3)
1024
> (tree-height t3)
25
> (define t4 (random-tree 1024))
> (tree-height t4)
22

|#