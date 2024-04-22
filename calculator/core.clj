(ns calculator.core
  (:gen-class))

(defmacro generate-arithmetic-function [op-symbol]
  `(fn [a# b#] (~op-symbol (double a#) (double b#))))

(defn factorial [n m]
  (if (<= n 1)
    1
    (* n (factorial (dec n) m))))

(defn log-function [f]
  (fn [& args]
    (let [result (apply f args)]
      (println (str "Calling function: " (str f) ", Arguments: " args ", Result: " result))
      result)))

(def add (generate-arithmetic-function (log-function +)))
(def sub (generate-arithmetic-function (log-function -)))
(def mul (generate-arithmetic-function (log-function *)))
(def div (generate-arithmetic-function (log-function /)))
(def exp (generate-arithmetic-function (log-function (fn [x y] (Math/pow x y)))))
(def modu (generate-arithmetic-function (log-function mod)))
(def fact (generate-arithmetic-function (log-function factorial)))

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
