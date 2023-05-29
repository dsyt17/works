#!/bin/bash

for file in *; do
    if [[ "$file" =~ ^[[:alpha:]]+\.txt$ ]]; then
        echo "$file"
    fi
done
