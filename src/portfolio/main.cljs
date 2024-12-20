(ns main
  (:require
   [icons :refer [fa6-github fa6-linkedin fa6-pen-fancy fa6-x-twitter md-mail
                  remix-bluesky]]
   [uix.core :refer [$ defui]]
   [uix.dom :refer [create-root render-root]]))

(defonce root (create-root (js/document.getElementById "root")))

(def link-configs
  [{:icon fa6-pen-fancy
    :href "https://blog.saketpatel.me"
    :text "/ writings"
    :tooltip "Blog"}
   {:icon fa6-github
    :href "https://github.com/Samy-33"
    :text "/ Samy-33"
    :tooltip "Github"}
   {:icon fa6-linkedin
    :href "https://linkedin.com/in/saketsm"
    :text "/ saketsm"
    :tooltip "LinkedIn"}
   {:icon fa6-x-twitter
    :href "https://x.com/saak3t"
    :text "/ saak3t"
    :tooltip "Twitter / X"}
   {:icon remix-bluesky
    :href "https://bsky.app/profile/sak3t.bsky.social"
    :text "/ sak3t"
    :tooltip "BlueSky"}])

(defui link [{:keys [icon text href key tooltip]}]
  ($ :.tooltip {:data-tip tooltip
                :key key}
     ($ :a {:href href
            :target :_default}
        ($ :button.btn.btn-sm.btn-block
           ($ icon {:class "h-3.5 w-3.5"})
           ($ :span.text-sm text)))))

(defui main-elem []
  ($ :.div.h-full.w-full.flex.justify-center.items-center
     ($ :.card.md.flex.flex-col.md:flex-row
        ($ :img.avatar.w-80.hidden.md:block.rounded {:src "/imgs/me-min.jpg"
                                                     :alt "My photo"})
        ($ :.card-body.prose
           ($ :.card-title "Hey. I am Saket!")
           ($ :ul.mt-0
              ($ :li.text-sm "A Software Engineer by profession.")
              ($ :li.text-sm "A mathematician, philoshopher and musician by hobby!")
              ($ :li.text-sm "A " ($ :a {:href "https://github.com/Samy-33/dotfiles"} "btw" ($ :sup "TM")) " Enthusiast"))
           ($ :.grid.md:grid-cols-3.sm:grid-cols-2.grid-cols-1.gap-2
              (map-indexed
               (fn [idx link-cfg]
                 ($ link (assoc link-cfg :key idx)))
               link-configs))
           ($ link {:icon md-mail
                    :href "mailto:sak3t.is@gmail.com"
                    :text "/ sak3t.is@gmail.com"})))))

(defn ^:export start-app! []
  (render-root ($ main-elem) root))
