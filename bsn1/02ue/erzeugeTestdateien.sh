#!/bin/bash
#
# Betriebssysteme und Netze 1
#
# WS 2020/2021
#
# Erzeuge viele Testdateien in einem Verzeichnis
#
[ ! -d testverz ] && mkdir testverz
cd testverz
for pre in bild foto xy abc video musik prog
do
   for mid in klaus gabi susi dirk olaf
   do
      for post in heute morgen gestern alt neu speziell
      do
         for suf in jpeg avi txt java bak py
         do
            file=$pre-$mid-$post.$suf
            touch $file
         done
      done
      [ ! -d $mid ] && mkdir $mid
   done
done
