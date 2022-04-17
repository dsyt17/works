<?php

function mirroring($string){

    $strArray = str_split($string, 1);
    $mirrArray = array_reverse($strArray);
    $result = implode($mirrArray);
    return $result;
}

echo "Введите строку: \n";
$s = fgets(STDIN, 255);

echo "Зеркальное отображение введенной строки: \n".mirroring($s);

?>