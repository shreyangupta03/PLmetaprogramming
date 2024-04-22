(ns getter-setter.core
  (:gen-class))

(defmacro defaccessor [prop]
  `(do
     (defn ~(symbol (str "set-" prop)) [m# value#] (assoc m# ~(keyword prop) value#))
     (defn ~(symbol (str "get-" prop)) [m#] (get m# ~(keyword prop)))))

(def person1 {:fname "Shreyan" :lname "Gupta" :rno "IMT2021039"})
(def person2 {:fname "Pannaga" :lname "Bhat" :rno "IMT2021080"})
(def person3 {:fname "Vidhu" :lname "Arora" :rno "IMT2021082"})

(defaccessor fname)
(defaccessor lname)
(defaccessor rno)

(defn print-person [person]
  (println (str "fname: " (get-fname person)))
  (println (str "lname: " (get-lname person)))
  (println (str "rno: " (get-rno person))))

(defn -main
  [& args]
  (println "Person 1:")
  (print-person person1)
  (println "Person 2:")
  (print-person person2)
  (println "Person 3:")
  (print-person person3)
  (println "Changing Person 2 to Place Holder")
  (def person2_new (set-fname (set-lname person2 "Holder") "Place")) 
  (println "Person 2:")
  (print-person person2_new))
