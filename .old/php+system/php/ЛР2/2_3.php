<?php

echo "Введите длину массива: \n";
$length = fgets(STDIN, 255);

$array = array();

for ($i = 1; $i<$length+1; $i++){

    $rand = rand(1, 100);

    //Избавляемся от одинаковых значений
    while (in_array($rand, $array)) {
        $rand = rand(1, 100);
    }
    $array[] = $rand;
}

echo "Создан массив: \n";
echo print_r($array)." \n";
echo "Сумма его элементов равна: \n". array_sum($array);

?>