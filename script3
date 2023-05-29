#!/bin/bash

if [ $1 ] && [ $2 ]; then

echo Backup from: $1 to: $2

START=$(date +%s)
echo Files to backup:
tar czfv "$2/backup_`date '+%x_%H:%M'`.tar.gz" $1
END=$(date +%s)
DIFF=$(( $END - $START ))

echo "Success backup in $DIFF seconds"
else
echo Enter parameters: 1. From, 2. Destination;
fi
