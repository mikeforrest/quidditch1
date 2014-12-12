;; Definition for user agents. This is a good template to build on to produce
;; smarter agents.

(ns pucks.agents.seeker  
  (:use [pucks globals util vec2D]
        [pucks.agents active]))

(defn seeker-proposals [p]
  {:acceleration 0
   :rotation (direction->rotation (:velocity p))})

(defn seeker []
  (merge (active)
         {:seeker true
          :player true
          :proposal-function seeker-proposals
          :color [255 255 255]}))
