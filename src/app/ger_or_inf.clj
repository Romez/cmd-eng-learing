(ns app.ger-or-inf
  (:require
   [clojure.term.colors :refer [on-green on-red]])
  (:gen-class))

(def words
  [{:word "admit" :type :g :example "In court the accused admitted (to) stealing the documents."}
   {:word "avoid" :type :g :example "I always try to avoid driving in the rush hours."}
   {:word "be worth" :type :g :example "It isn't worth going to exhibition. It's really boring."}
   {:word "can't help" :type :g :example "We can't help laughing when my dad tries to speak French."}
   {:word "can't stand" :type :g :example "I can't stand talking to people who only talk about themselves."}
   {:word "mind" :type :g :example "I don't mind doing housework."}
   {:word "practise" :type :g :example "The more you practise speaking English the more fluent you'll get."}
   {:word "recommend" :type :g :example "I recommend doing a double-decker bus tour as the best way to see London."}
   {:word "suggest" :type :g :example "A friend of mine suggeted visiting London in the autumn."}

   {:word "afford" :type :i :example "I can't afford to go on holiday this summer."}
   {:word "agree" :type :i :example "I have agreed to support the scientist's theory."}
   {:word "decide" :type :i :example "They've decided to call off the wedding."}
   {:word "would like" :type :i :example "Would you like to try the dress on?"}
   {:word "be able" :type :i :example "I won't be able to work for two weeks after the operation."}
   ])

(defn -main
  [& args]
  (println "Lets check you out")

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
        (println "type g/i")))))
