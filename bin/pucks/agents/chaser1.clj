;; Definition for user agents. This is a good template to build on to produce
;; smarter agents.

(ns pucks.agents.chaser1
  (:use [pucks globals util vec2D]
        [pucks.agents active]))

(defn chaser1-proposals [p]
   (let [target (filter :vent2 (:sensed p))
       avoid (filter :team2 (:sensed p))
       wall (filter :stone (:sense p))]
  {:acceleration (if (empty? avoid)   
                   (if (> (mod (:steps p) 100) 25)
                     1
                     0.1)       
                   (* 0.25 (- (length (:velocity p)))))
   :rotation 
       (if (and (empty? target) (not (empty? wall)))
          (direction->rotation [750 200])
         (if (empty? target)
                (if (empty? avoid) 
                   (- (direction->rotation [700 575]) (/ pi 4))
                   (+ (direction->rotation (:position (first avoid))) pi))
            (if (< (:energy (first target)) 0.01)
               (+ (direction->rotation (:position (last target))) (/ (* 3 pi) 2))
                    (direction->rotation (:position (first target))))))}))

(defn chaser1 []
  (merge (active)
         {:chaser true
          :team1 true
          :player true
          :proposal-function chaser1-proposals
          :color [0 255 0]}))
