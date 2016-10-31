(ns am.core
  (:import [javax.sound.sampled Clip AudioInputStream AudioSystem]
           [java.io File]))

(defn make-sound
  [filepath]
  (let [sound-file (File. filepath)
        sound      (AudioSystem/getAudioInputStream sound-file)
        sound-clip (AudioSystem/getClip)]
    (.open sound-clip sound)
    (.setFramePosition sound-clip 0)
    (.start sound-clip)))

(comment
  (let [filepath "/Users/pthomas/Downloads/[99Sounds] 99 Drum Samples/Samples/kick-oldschool.wav"]
    (dotimes [_ 16]
      (make-sound filepath)
      (Thread/sleep 100))))

(comment
  ;; TOOD: make this work
  
  (defcomp test-comp
    e-major ;; scale
    {:times [4] :variation 2} ;; each note will be able to go at most 2 whole steps up or down from note at beginning of grouping)
    {:times [2] :variation 3})

  )


