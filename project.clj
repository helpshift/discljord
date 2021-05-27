(defproject org.suskalo/discljord "1.2.3-helpshift"
  :description " A Clojure wrapper library for the Discord API, with full API coverage (except voice, for now), and high scalability."
  :url "https://github.com/IGJoshua/discljord"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :repositories [["private" {:url "s3p://maven.helpshift.com/releases/"
                             ;; assumes LEIN_USERNAME and LEIN_PASSPHRASE
                             ;; environment variables
                             :username :env
                             :passphrase :env}]]
  :plugins [[s3-wagon-private "1.1.2"]]
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [org.clojure/core.async "1.2.603"]
                 [org.clojure/data.json "1.0.0"]
                 [org.clojure/tools.logging "1.1.0"]
                 [http-kit "2.4.0-alpha6"]
                 [stylefruits/gniazdo "1.2.0"]]
  :target-path "target/%s"
  :jar-name "discljord-%s.jar"
  :deploy-branches ["master" "release" "hotfix" "feature/resume-session-between--process"]
  :profiles {:dev {:dependencies [[http-kit.fake "0.2.2"]
                                  [ch.qos.logback/logback-classic "1.2.3"]]
                   :plugins [[lein-codox "0.10.7"]]
                   :exclusions [http-kit]
                   :jvm-opts ["-Dclojure.tools.logging.factory=clojure.tools.logging.impl/slf4j-factory"]}})
