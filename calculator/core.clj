(ns calculator.core
  (:gen-class))

(defmacro generate-arithmetic-function [op-symbol]
  `(fn [a# b#] (~op-symbol (double a#) (double b#))))

(defn factorial [n]
  (if (<= n 1)
    1
    (* n (factorial (dec n)))))

(defn log-function [f]
  (fn [& args]
    (let [result (apply f args)]
      (println (str "Calling function: " (str f) ", Arguments: " args ", Result: " result))
      result)))

(defn add-with-logging [a b]
  ((log-function +) a b))

(defn sub-with-logging [a b]
  ((log-function -) a b))

(defn mul-with-logging [a b]
  ((log-function *) a b))

(defn div-with-logging [a b]
  ((log-function /) a b))

(defn exp-with-logging [a b]
  ((log-function (fn [x y] (Math/pow x y))) a b))

(defn mod-with-logging [a b]
  ((log-function mod) a b))

(defn fact-with-logging [a b]
  ((log-function factorial) a))

(def add (generate-arithmetic-function add-with-logging))
(def sub (generate-arithmetic-function sub-with-logging))
(def mul (generate-arithmetic-function mul-with-logging))
(def div (generate-arithmetic-function div-with-logging))
(def exp (generate-arithmetic-function exp-with-logging))
(def modu (generate-arithmetic-function mod-with-logging))
(def fact (generate-arithmetic-function fact-with-logging))

(defn perform-operation [operation a b]
  (let [op-fn (get {:add add :sub sub :mul mul :div div :exp exp :mod modu :fact fact} operation)]
    (if op-fn
      (op-fn a b)
      (println "Invalid operation"))))

(defn -main
  [& args]
  (loop []
    (println "Choose the operation: (add, sub, mul, div, exp, mod, fact)")
    (let [operation (-> (read-line) keyword)
          num1 (Double/parseDouble (read-line))
          num2 (Double/parseDouble (read-line))]
      (perform-operation operation num1 num2)
      (recur))))
