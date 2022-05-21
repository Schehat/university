#!/bin/bash

for file in *.jpeg
do
	filename=$(basename $file .jpeg)
	mv $filename.jpeg $filename.jpg
done
