#!/bin/bash

for file in *; do
    if [[ -f "$file" && "$file" =~ ^[[:alpha:]]{3} ]]; then
        echo "$file"
    fi
done
