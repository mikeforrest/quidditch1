;; Definition for user agents. This is a good template to build on to produce
;; smarter agents.

(ns pucks.agents.beater
  (:use [pucks globals util vec2D]
        [pucks.agents active]))

(defn beater-proposals [p]
  {:acceleration 0
   :rotation (direction->rotation (:velocity p))})

(defn beater []
  (merge (active)
         {:beater true
          :player true
          :proposal-function beater-proposals
          :color [255 0 0]}))
