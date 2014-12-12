;; A pucks world.

(ns pucks.worlds.ai.quidditch
  (:use [pucks core globals]
        [pucks.agents stone vent1 vent2 snitch beater1 beater2 chaser1 chaser2 seeker1 seeker2 keeper1 keeper2]))

(defn agents []
  (concat (for [y (take 41 (iterate #(+ % 20) 0))]
            (merge (stone) {:position [0 y]}))
          (for [y (take 41 (iterate #(+ % 20) 0))]
            (merge (stone) {:position [799 y]}))
          ;(for [x (take 40 (iterate #(+ % 20) 0))]
           ; (merge (stone) {:position [x 0]}))
          ;(for [x (take 40 (iterate #(+ % 20) 0))]
            ;(merge (stone) {:position [x 799]}))
          [(merge (vent2) {:position [750 375]})
          (merge (vent2) {:position [750 175]})
          (merge (vent2) {:position [750 575]})
          (merge (vent1) {:position [50 175]})
          (merge (vent1) {:position [50 375]})
          (merge (vent1) {:position [50 575]})
          (merge (keeper1) {:position [75 375]})
          (merge (keeper2) {:position [725 375]})
          (merge (seeker1) {:position [100 375]})
          (merge (seeker2) {:position [700 375]})
          (merge (chaser1) {:position [100 575]})
          (merge (chaser2) {:position [700 175]})
          (merge (beater1) {:position [100 175]})
          (merge (beater2) {:position [700 575]})
           (merge (snitch :key) {:position [375 375]})]))

(defn settings []
  {})

;(run-pucks (agents) (settings))