(ns douban-clojure-client.core
  (:require [org.httpkit.client :as http]))

(defn get-douban
  "Send HTTP GET request to douban.com."
  []
  (let [response (http/get "http://www.douban.com")]
    (:status @response)))
