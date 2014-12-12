;; Definition for user agents. This is a good template to build on to produce
;; smarter agents.

(ns pucks.agents.chaser
  (:use [pucks globals util vec2D]
        [pucks.agents active]))

(defn chaser-proposals [p]
  {:acceleration 0
   :rotation (direction->rotation (:velocity p))})

(defn chaser []
  (merge (active)
         {:chaser true
          :player true
          :proposal-function chaser-proposals
          :color [0 255 0]}))
