(ns compile-time-meta-programming)

;;macro for compile time expansion
(defmacro generate-add-function []
  `(fn [a# b#] (+ a# b#)))

(def add (generate-add-function))

(add 1 5)

