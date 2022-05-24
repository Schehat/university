#!/bin/bash

i=0

while [ $i -lt 3 ] 
do
	touch pic$i.jpeg
	i=$(( $i + 1 ))
done
