(ns html-generator.core
  (:gen-class))

(defn html-tag-generator [tag & body]
  (apply str "<" tag ">" (apply str body) "</" tag ">"))

(defmacro generate-html-function [tag]
  `(fn [& content#] (apply html-tag-generator ~tag content#)))

(def div (generate-html-function "div"))
(def p (generate-html-function "p"))
(def head (generate-html-function "head"))
(def body (generate-html-function "body"))
(def html (generate-html-function "html"))

(defn -main
  [& args]
  (println 
   (html 
    (head "Title") 
    (body 
     (div 
      (p "Hello World")
      (p "Second paragraph"))))))
