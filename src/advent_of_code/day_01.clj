(ns advent-of-code.day-01
  (:require [clojure.java.io :as io]))

(def input (mapv
            (comp read-string str)
            (slurp (io/resource "2017/day01"))))

(defn solve-captcha
  ([captcha]
   (let [[h & rest] captcha]
     (solve-captcha (conj captcha h) 0)))

  ([[h & coll] sum]
   (if (empty? coll)
     sum
     (let [sum (if (= h (first coll)) (+ sum h) sum)]
       (recur coll sum)))))

(solve-captcha input)
