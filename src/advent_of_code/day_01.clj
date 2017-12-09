(ns advent-of-code.day-01
  (:require [clojure.java.io :as io]))

(def input (mapv
            (comp read-string str)
            (slurp (io/resource "2017/day01"))))

(defn solve-captcha
  ([[h & _ :as captcha]]
   (solve-captcha (conj captcha h) 0))

  ([[h & coll] sum]
   (cond
     (empty? coll) sum
     (= h (first coll)) (recur coll (+ sum h))
     :else (recur coll sum))))

(defn result
  "Returns the answer to the puzzle"
  []
  (solve-captcha input))

(defn solve-halfway-captcha [captcha]
  (let [step (/ (count captcha) 2)]
    (->> captcha
         cycle
         (drop step)
         (map vector captcha)
         (filter (fn [[x y]] (= x y)))
         (map first)
         (reduce + 0))))

(defn result-part-2 []
  (solve-halfway-captcha input))
