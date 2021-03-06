(ns gorilla.geschichte-core
  (:require [gorilla.geschichte-vega :as vega]
            [gorilla.geschichte-quilesque :as quilesque]
            [gorilla.geschichte-graph :as graph]))


(defn vega-commit-graph
  "Create vega structure to embed in a gorilla-repl view."
  [commit-graph branches commits & {:keys [width aspect-ratio color opacity]
           :or {width 600
                aspect-ratio 1.618
                opacity 1}}]
  (let [height (float (/ width aspect-ratio))]
    (merge
     (vega/frame width height)
     (vega/graph-marks)
     (-> (graph/compute-positions commit-graph branches commits)
         (vega/graph-data width height)))))


(defn quil-commit-graph
  "Draw commit graph using quil.
  Provide width or aspect ratio for the frame."
  [commit-graph branches commits & {:keys [width aspect-ratio outfile]
                          :or {width 800
                               aspect-ratio 1.618}}]
  (let [height (float (/ width aspect-ratio))]
    (quilesque/sketch
     (graph/compute-positions commit-graph branches commits)
     :width width :height height :outfile outfile)))
