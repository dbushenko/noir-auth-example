(ns noir-auth-example.handler
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [noir.util.middleware :as noir]
            [noir-auth.core :as auth]))

(derive ::root ::user)

(defroutes app-routes
  (POST "/login" [user password] (fn [a] (if (auth/authenticate user password
                                                                [{:user "dim"
                                                                  :password (auth/generate-password "dim")
                                                                  :roles #{::root}}])
                                           "authenticated"
                                           "not authenticated")))
  
  (GET "/user" [] (auth/authorized-for "User route"
                                       ::user))

  (GET "/root" [] (auth/authorized-for "Root route"
                                       ::root))

  (GET "/admin" [] (auth/authorized-for "Admin route"
                                        ::admin))

  (GET "/logout" [] (auth/logout))

  (GET "/current-user" [] (str (auth/current-user)))

  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (->
   [(handler/site app-routes)]
   noir/app-handler))