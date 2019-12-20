(defproject org.pinkgorilla/ui-geschichte "0.0.1"
  :description "A shapes library"
  :license {:name "Eclipse Public License"
            :url  "http://www.eclipse.org/legal/epl-v10.html"}

  :repositories [["clojars" {:url "https://clojars.org/repo"
                             :username "awb99"
                             :sign-releases false}]]

  :min-lein-version "2.7.1"

  :dependencies
  [[org.clojure/clojure "1.10.1"]
   [org.clojure/clojurescript "1.10.520"]

   [quil "3.0.0"]

   [org.pinkgorilla/gorilla-renderable "2.1.0"]]

  :source-paths ["src"]
  :cljsbuild {:builds []}
  :deploy-via :clojars
  :lein-release {:deploy-via :clojars
                 :scm        :git})