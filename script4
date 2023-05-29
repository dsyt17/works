#!/bin/bash

if [ -f $1 ] && [ -f $2 ]; then

echo Merging $1 with $2
newfile=merged_file

exec 3<&0
exec 0<$1
while read line; do
	echo $line > $newfile
done
exec 0<&3

exec 4<&0
exec 0<$2
while read line; do
	echo $line >> $newfile
done
exec 0<&4

echo Result - $newfile

else
echo Enter parameters: two files for merge
fi
