;; Definition for user agents. This is a good template to build on to produce
;; smarter agents.

(ns pucks.agents.keeper 
  (:use [pucks globals util vec2D]
        [pucks.agents active]))

(defn keeper-proposals [p]
  {:acceleration 0
   :rotation (direction->rotation (:velocity p))})

(defn keeper []
  (merge (active)
         {:keeper true
          :player true
          :proposal-function keeper-proposals
          :color [0 0 255]}))
