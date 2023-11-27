(define (print-atom-info atom)
  (cond ((number? atom) (display "Number: "))
        ((symbol? atom) (display "Symbol: "))
        ((string? atom) (display "String: "))
        (else (display "Unknown: ")))
  (display atom)
  (newline))

(define (print-list-info lst)
  (display "List: (")
  (if (null? lst)
      (display "empty")
      (process-elements lst))
  (display ")")
  (newline))

(define (process-elements lst)
  (if (null? lst)
      '()
      (begin
        (process-element (car lst))
        (process-elements (cdr lst)))))

(define (process-element element)
  (if (list? element)
      (print-list-info element)
      (print-atom-info element)))

(define (read-and-process)
  (display "Enter an atom or list: ")
  (let ((input (read)))
    (process-element input)
    (newline)))

;; Запуск програми
(read-and-process)