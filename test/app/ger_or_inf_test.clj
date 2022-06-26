(ns app.ger-or-inf-test
  (:require  [clojure.test :as t]
             [app.ger-or-inf :as sut]))

(t/deftest test-rest-words
  (t/is (= [{:word "would like"}]
           (sut/rest-words 
            [{:word "want"}
             {:word "would like"}])
                      )))
