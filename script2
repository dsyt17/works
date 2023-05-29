#!/bin/bash

dir=`pwd`

#имя текущего скрипта
current=$dir/`basename -- "$0";`

newest=""

echo Your files in $dir:
for file in $dir/*
do
	if [ -f "$file" ]
	then
		#не выводим текущий скрипт
		if [ $current = $file ]
		then continue
		fi 

		#проверяем владельца
		owner=`stat --format '%U' $file`
		if [ $owner = $USER ]
		then 
			echo " $file"
			#находим самый новый файл
			if [ -z "$newest" ] || [ "$file" -nt "$newest" ]; then
            newest="$file"
        	fi
		fi
	fi
done
echo Newest file: $newest
echo -----------------------
echo `cat $newest`
