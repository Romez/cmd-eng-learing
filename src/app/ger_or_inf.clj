(ns app.ger-or-inf
  (:require
   [clojure.term.colors :refer [on-green on-red]]
   [clojure.edn :as edn]
   [clojure.java.io :as io])
  (:gen-class))

(defn -main
  [& args]
  (println "Lets check you out")

  (let [data (edn/read-string
              (slurp (io/resource "ger-or-inf.edn")))
        words (concat (:gerund data) (:infinitive data))]
    (loop [word (first (shuffle words))]
      (println "gerund or infinitive (g/i) ? " (:word word))

      (let [answer (keyword (read-line))]
        (cond
          (= answer (:type word))
          (do 
            (println (on-green "Correct!"))
            (println "Example: " (:example word) "\n")
            (recur (first (shuffle words))))


          (not= answer (:type word))
          (do 
            (println (on-red "Wrong!"))
            (println "Example: " (:example word) "\n")
            (recur (first (shuffle words))))

          (= :exit answer)
          (println "Buy!")

          :else
          (println "type g/i"))))))

(comment
  (+ 1 1)

  )
