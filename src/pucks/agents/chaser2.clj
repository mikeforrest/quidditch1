;; Definition for user agents. This is a good template to build on to produce
;; smarter agents.

(ns pucks.agents.chaser2
  (:use [pucks globals util vec2D]
        [pucks.agents active]))

(defn chaser2-proposals [p]
  (let [target (filter :vent1 (:sensed p))
       avoid (filter :team1 (:sensed p))
       wall (filter :stone (:sense p))]
  {:acceleration (if (empty? avoid)   
                   (if (> (mod (:steps p) 100) 25)
                     1
                     0.1)          
                   (* 0.25 (- (length (:velocity p)))))
   :rotation 
       (if (and (empty? target) (not (empty? wall)))
           (direction->rotation [50 200])
         (if (empty? target)
                (if (empty? avoid) 
                   (- (direction->rotation [100 175]) (/ (* 3 pi) 2))
                   (+ (direction->rotation (:position (first avoid))) pi))
            (if (< (:energy (first target)) 0.01)
                (+ (direction->rotation (:position (last target))) (/ pi 2))
                    (direction->rotation (:position (first target))))))}))

(defn chaser2 []
  (merge (active)
         {:chaser true
          :team2 true
          :player true
          :proposal-function chaser2-proposals
          :color [0 255 0]}))

