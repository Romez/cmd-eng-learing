(ns app.ger-or-inf
  (:require
   [clojure.term.colors :refer [on-green on-red]]
   [clojure.edn :as edn]
   [clojure.java.io :as io]
   [app.texts :refer [tr]])
  (:gen-class))

(defn- load-data
  []
  (edn/read-string
              (slurp (io/resource "ger-or-inf.edn"))))

(def rest-words rest)

(def append-word conj)

(defn -main
  [& _args]
  (println (tr [:hello]))

  (let [data (load-data)]
    (loop [words (vec (shuffle (concat (map (fn [w]
                                              (assoc w :type :g))
                                            (:gerund data))
                                       (map (fn [w]
                                              (assoc w :type :i))
                                            (:infinitive data)))))]
      (let [word (first words)]
        ;; TODO: quit
        (println (tr [:ger-or-inf/question]) (:word word))

        (let [answer (keyword (read-line))]
          (cond
            (= answer :h)
            (do
              (println (:word word) " - " (:type word))
              (recur (rest words)))

            (= answer (:type word))
            (do
              (println (on-green (tr [:correct])))
              (println (tr [:ger-or-inf/example]) (:example word) "\n")
              (recur (rest-words words)))

            (not= answer (:type word))
            (do
              (println (on-red (tr [:try-again])))

              (println (tr [:ger-or-inf/example]) (:example word) "\n")

              (recur (append-word
                      (rest-words words)
                      word)))

            (= :q answer)
            (println (tr [:buy]))

            :else
            (println (tr [:ger-or-inf/help]))))))))
