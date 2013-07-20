(defproject noir-auth-example "0.1.0-SNAPSHOT"
  :description "Example for the noir-auth library"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [compojure "1.1.5"]
                 [lib-noir "0.6.6"]
                 [noir-auth "0.2.0-SNAPSHOT"]]
  :plugins [[lein-ring "0.8.5"]]
  :ring {:handler noir-auth-example.handler/app}
  :profiles
  {:dev {:dependencies [[ring-mock "0.1.5"]]}})
