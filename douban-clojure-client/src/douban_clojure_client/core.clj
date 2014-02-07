(ns douban-clojure-client.core
  (:require [org.httpkit.client :as http]))

(defn get-douban
  "Send HTTP GET request to douban.com."
  []
  (let [response (http/get "http://www.douban.com")]
    (:status @response)))

(defn auth
  ""
  []
  (let [params {:query-params {
                               :client_id ""
                               :redirect_uri ""
                               :response_type "token"
                               }
                :follow-redirects false}
        {:keys [status headers body error] :as resp} @(http/get "https://www.douban.com/service/auth2/auth" params)]
    status))
