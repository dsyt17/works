#!/bin/bash

txt_files=()
total_word_count=0

function count_words {
    file="$1"
    word_count=$(wc -w < "$file")
    total_word_count=$((total_word_count + word_count))
}

function scan_directory {
    dir="$1"
    for file in "$dir"/*; do
        if [ -d "$file" ]; then
            # Рекурсивный вызов для поддиректорий
            scan_directory "$file"
        elif [ -f "$file" ]; then
            # Проверка расширения файла
            if [[ "$file" == *.txt ]]; then
                # Добавление файла в массив
                txt_files+=("$file")
                # Подсчет слов в файле
                count_words "$file"
            fi
        fi
    done
}

if [ $1 ]; then
scan_directory "$1"

echo "List files .txt (${#txt_files[@]}):"
for file in "${txt_files[@]}"; do
	echo -e "$file"
done

echo "Words count: $total_word_count"

else
echo "Enter directory"
fi
