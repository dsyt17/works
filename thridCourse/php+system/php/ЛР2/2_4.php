<?php

function createArray($len){

    $array = array();

    for ($i = 0; $i<$len; $i++){

        $rand = rand(1, 100);
        //Избавляемся от одинаковых значений
        while (in_array($rand, $array)) {
            $rand = rand(1, 100);
        }
        $array[$i] = $rand;
    }
    return $array;

}

echo "Введите длину массива: \n";
$length = fgets(STDIN, 255);

$array = createArray($length);
echo "Создан массив: \n";
echo print_r($array)." \n";
echo "Произведение его элементов равно: \n". array_product($array);

?>