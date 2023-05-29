#!/bin/bash

location=`pwd`

if [ -f "$location/backup" ]
then
	echo "backup file exists" >&1;
else
	echo "backup file not found" >&2;
fi
