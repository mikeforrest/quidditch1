;; Definition for user agents. This is a good template to build on to produce
;; smarter agents.

(ns pucks.agents.beater2
  (:use [pucks globals util vec2D]
        [pucks.agents active]))

(defn beater2-proposals [p]
  (let [target (filter :team1 (:sensed p))
        avoid (filter :beater (:sensed p))
        wall (filter :stone (:sensed p))]
  {:acceleration (if (empty? avoid)   
                   (if (> (mod (:steps p) 100) 25)
                     0.8
                     0.5)       
                   (* 0.25 (- (length (:velocity p)))))
   :rotation 
            (if (empty? target)
               (if (empty? avoid) 
                   (if (empty? wall)
                       (+ (direction->rotation [100 575]) (/ pi 2))
                       (+ (direction->rotation (:position (last wall))) pi))
                   (+ (direction->rotation (:position (first avoid))) pi))
               (direction->rotation (:position (first target))))}))

(defn beater2 []
  (merge (active)
         {:beater true
          :beater2 true
          :player true
          :proposal-function beater2-proposals
          :color [255 0 0]}))
