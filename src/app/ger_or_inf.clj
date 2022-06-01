(ns app.ger-or-inf
  (:require
   [clojure.term.colors :refer [on-green on-red]]
   [clojure.edn :as edn]
   [clojure.java.io :as io])
  (:gen-class))

(defn- load-data
  []
  (edn/read-string
              (slurp (io/resource "ger-or-inf.edn"))))

(defn -main
  [& _args]
  (println "Lets check you out")

  (let [data (load-data)]
    (loop [words (shuffle (concat (:gerund data)
                                  (:infinitive data)))]
      (let [word (first words)]
        ;; TODO: quit
        (println "gerund or infinitive g or i, h help ? " (:word word))

        (let [answer (keyword (read-line))]
          (cond
            (= answer "h")
            (do
              (println (:word word))
              (recur (rest words)))
            
            (= answer (:type word))
            (do 
              (println (on-green "Correct!"))
              (println "Example: " (:example word) "\n")
              (recur (rest words)))


            (not= answer (:type word))
            (do 
              (println (on-red "Wrong!"))
              (println "Example: " (:example word) "\n")
              (recur (rest words)))

            (= :q answer)
            (println "Buy!")

            :else
            (println "type g/i or h, q")))))))

(comment
  (+ 1 1)

  )
