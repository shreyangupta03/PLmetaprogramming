(ns runtime-meta-programming)

;;create a function to add n
(defn create-adder [n]
  (fn [x] (+ n x)))

(defmacro define-adders [n]
  `(intern *ns* (symbol (str "adder-" ~n)) (create-adder ~n)))

;;create adder-5 function at runtime
(define-adders 5)

;;get adder-5
(let [n 5
      adder (resolve (symbol (str "adder-" n)))
      result (adder 7)]
  (println (str "Result: " result)))