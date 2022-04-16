<?php

$array = array();

//Заполняем массив случайными элементами
for ($i = 1; $i<11; $i++){

    $rand = rand(1, 100);

    //Избавляемся от одинаковых значений
    while (in_array($rand, $array)) {
        $rand = rand(1, 100);
    }
    $array[] = $rand;
}

echo "Исходный массив: \n";
echo print_r($array)." \n";

echo "Отсортированный по возрастанию: \n";
asort($array);
echo print_r($array)." \n";

echo "Отсортированный по убыванию: \n";
arsort($array);
echo print_r($array)." \n";

?>