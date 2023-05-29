#!/bin/bash

if [ $1 ] && [ $2 ]; then
result="data_processed.txt"

sed -e '/#/d; y/;/,/' $1 > $result

echo First 10 lines $result:
head $result | nl -s '. '

cat $2 >> $result

else
echo Enter parameters: data file, 2. footer;
fi

