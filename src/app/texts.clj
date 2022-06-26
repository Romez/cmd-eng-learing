(ns app.texts
  (:require [taoensso.tempura :as tempura]))

(def en {:hello "Let's play"
         :correct "Correct!"
         :try-again "Try again"
         :buy "Buy!"
         :ger-or-inf {:question "gerund or infinitive g or i, h help ?"
                      :example "Example:"
                      :help "type g/i or h, q"}})

(def tr (partial tempura/tr {:dict {:en en}} [:en]))
