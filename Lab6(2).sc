(define (evaluate-atom atom)
  (cond ((number? atom) atom)
        ((string? atom) atom)
        ((symbol? atom) atom) ;; Тут можна розширити обробку для змінних
        (else 'NIL)))

(define (apply-function func args)
  (cond ((eq? func '+) (apply + args))
        ((eq? func '-) (apply - args))
        ((eq? func '*) (apply * args))
        ((eq? func '/) (apply / args))
        (else (map evaluate-expression args)))) ;; Якщо функція невідома

(define (evaluate-list lst)
  (if (null? lst)
      'NIL
      (let ((func (car lst))
            (args (map evaluate-expression (cdr lst))))
        (apply-function func args))))

(define (evaluate-expression expr)
  (if (list? expr)
      (evaluate-list expr)
      (evaluate-atom expr)))

(define (read-and-evaluate)
  (display "Enter an expression: ")
  (let ((input (read)))
    (display (evaluate-expression input))
    (newline)))

;; Запуск програми
(read-and-evaluate)