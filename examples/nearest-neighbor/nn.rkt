#lang racket

;;; nn.rkt
;;;   Portions of a simple implementation of the O(nlogn) nearest neighbor
;;;   algorithm, intended for discussion in class.
;;;
;;; Samuel A. Rebelsky
;;; CSC-301-02 2021Fa

; +---------+--------------------------------------------------------
; | Logging |
; +---------+

; Choose one of the following two definitions of `(log val)` to
; turn logging off or on.

; (define log (lambda (val) (displayln val (current-error-port))))
(define log (lambda (val) (void)))

; +--------+---------------------------------------------------------
; | Points |
; +--------+

;;; (point x y) -> point?
;;;   x : real?
;;;   y : real?
;;; Create an x,y point.
(define point cons)

;;; (px pt) -> real?
;;;   pt : point?
;;; Extract the x coordinate of a point
(define px car)

;;; (py pt) -> real?
;;;   pt : point?
;;; Extract the y coordinate of a point
(define py cdr)

;;; (point? val) -> boolean?
;;;   val : any?
;;; Determine if val is a point.
(define point?
  (lambda (val)
    (and (pair? val)
         (real? (car val))
         (real? (cdr val)))))

;;; (random-point) -> point?
;;; Randomly generate a point
(define random-point  
  (lambda ()
    (point (random 1000) (random 1000))))

;;; (random-points n) -> list-of point?
;;;   n : non-negative integer
;;; Generate a list of n random points, no two of which have the
;;; same x or y coordinate.
(define random-points
  (lambda (n)
    (letrec ([kernel (lambda (m points delta)
                       (if (zero? m)
                           points
                           (let ([pt (random-point)])
                             (kernel (- m 1)
                                     (cons (point (+ (px pt) delta)
                                                  (+ (py pt) delta))
                                           points)
                                     (+ delta (/ 1 n))))))])
      (kernel n null 0))))

; +---------+--------------------------------------------------------
; | Helpers |
; +---------+

;;; (distance points) -> real?
;;;   points : list-of point?
;;; Compute the distance between the first two points in points.
(define distance
  (lambda (points)
    (log (list 'distance points))
    (let ([p1 (car points)]
          [p2 (cadr points)])
      (sqrt (+ (sqr (- (px p1) (px p2)))
               (sqr (- (py p1) (py p2))))))))

;;; (closest pt points) -> point?
;;;   pt : point?
;;;   points: listof point?
;;; Finds the closest element in points
(define closest
  (lambda (pt points)
    (letrec [(kernel (lambda (candidate remaining)
                       (cond
                         [(null? remaining)
                          candidate]
                         [(< (distance (list pt (car remaining)))
                             (distance (list pt candidate)))
                          (kernel (car remaining) (cdr remaining))]
                         [else
                          (kernel candidate (cdr remaining))])))]
      (kernel (car points) (cdr points)))))

; +----------+-------------------------------------------------------
; | Analysis |
; +----------+

;;; (vector-increment! vec pos) -> void?
;;;   vec : vector?
;;;   pos : index?
;;; Adds 1 to the specified location of vec
(define vector-increment!
  (lambda (vec pos)
    (vector-set! vec pos
                 (+ 1 (vector-ref vec pos)))))

;;; counts : vector-of integer?
;;; Counts of all the neighbors processed
(define counts (make-vector 6 0))

;;; (reset-counts!) -> void?
;;; Reset all of the values in counts
(define reset-counts!
  (lambda ()
    (vector-fill! counts 0)))

;;; (count! n) -> void?
;;;   n : integer
;;; Store one of the candidate neighbor counts
(define count!
  (lambda (n)
    (cond
      [(>= n (- (vector-length counts) 1))
       (fprintf (current-error-port) "Problem: Found ~s candidates; shouldn't have more than four.\n" n)
       (vector-increment! counts (- (vector-length counts) 1))]
      [else
       (vector-increment! counts n)])))

; +-------------------+----------------------------------------------
; | Primary algorithm |
; +-------------------+

;;; (nn points) -> list-of point? or #f
;;;   points : list-of point?
;;; Compute the nearest neighbor using the slow algorithm
(define nn
  (lambda (points)
    (if (null? (cddr points))
        points
        (let ([option1 (list (car points) (closest (car points) (cdr points)))]
              [option2 (nn (cdr points))])
          (if (<= (distance option1) (distance option2))
              option1
              option2)))))

(define nn-core
  (lambda (pointsx pointsy)
    (nn pointsx)))


; +---------------------------------+--------------------------------
; | Sample data for study "by hand" |
; +---------------------------------+

(define points
  '((0 . 0)
    (1 . 6)
    (4 . 2)
    (8 . 0)
    (8 . 5)
    (8 . 14)
    (9 . 8)
    (9 . 13)
    (12 . 5)
    (14 . 8)
    (18 . 9)
    (15 . 12)))

