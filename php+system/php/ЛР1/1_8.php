<?php

function permutation($num){

    $array = array();
    while ($num > 0) {
        $array[] = $num % 10;
        $num = intval($num / 10); 
    }
    $array = array_reverse($array);

    $strNum = "$array[2]" . "$array[1]" . "$array[0]";
    $newNum = (int)$strNum;
    return $newNum;
}

while (true){
echo "Введите число: \n";
    $a = fgets(STDIN, 255);

echo 'Переставляем первую и последнюю цифры: '.permutation($a)."\n";
}
?>