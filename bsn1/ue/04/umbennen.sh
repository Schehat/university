#!/bin/bash

# Note: flags need to be passed first as one block then the regular arguments
warning=0;  # wheater warning should be printed
force=0;  # overrides existing files with same name
n_flags=0
while getopts ":vf" arg; 
do
  case ${arg} in
    v)
      warning=1;
	  n_flags=$(( $n_flags + 1 ))
      ;;
	f)
      force=1;
	  n_flags=$(( $n_flags + 1 ))
      ;;
    esac
done

if [ $n_flags -gt 0 ]
then
	shift 1;
fi

if [ $# -ne 2 ] 
then
	echo 'bitte geben Sie 2 Parameter an: 1. aktueller Name und 2. neuer Name';
	exit 1;
fi

old_suffix=$1;
new_suffix=$2;

for file in *.$old_suffix
do
	filename=$(basename $file .$old_suffix);

	# does new file exist?
	if [ -f $filename.$new_suffix ]
	then
		# print warning?
		if [ $warning -eq 1 ]
		then 
			echo "$filename.$new_suffix existiert bereits";
		fi

		# override existing file?
		if [ $force -eq 1 ]
		then
			 mv $filename.$old_suffix $filename.$new_suffix;
		fi
	else 
		mv $filename.$old_suffix $filename.$new_suffix;
	fi
done
exit 0
