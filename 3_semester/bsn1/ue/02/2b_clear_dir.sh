#!/bin/bash

# alternative way
# dir_paths=$(ls -d $PWD/testverz/*/)

dir_paths=$PWD/testverz/*/

for dir_path in $dir_paths 
do
	dir=$(basename $dir_path) 
	
	files_path=$(find $PWD -type f -name "*$dir*.*")

	for file_path in $files_path
	do
		mv $file_path $dir_path
	done
done
