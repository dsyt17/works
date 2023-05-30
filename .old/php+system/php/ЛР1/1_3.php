<?php

function factorial($num){

    $result = 1;

    for ($i=1; $i<($num+1); $i++){

        $result = $result * $i;

    }

    return $result;
}

echo "Введите число, факториал которого нужно вычислить: \n";

$num = fgets(STDIN, 255);

echo "Факториал числа $num равен: ". factorial($num);

?>