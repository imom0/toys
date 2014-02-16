(ns douban-clojure-client.core
  (:require [org.httpkit.client :as http]
            [clj-oauth2.client :as oauth2]
            ))

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

(def douban-oauth2
  {:authorization-uri "https://www.douban.com/service/auth2/auth"
   :access-token-uri "https://www.douban.com/service/auth2/token"
   :redirect-uri "http://localhost:8989/"
   :client-id ""
   :client-secret ""
   :access-query-param :access_token
   :scope ["douban_basic_common" "movie_basic"]
   :grant-type "authorization_code"})

(def auth-req
    (oauth2/make-auth-request douban-oauth2))
