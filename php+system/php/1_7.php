<?php

function biggestNumber($a, $b, $c){

    $result = $a;
    if ($result<$b) {$result = $b;}
    if ($result<$c) {$result = $c;}
    return $result;
}

while (true){
echo "Введите три числа: \n";
    $a = fgets(STDIN, 255);
    $b = fgets(STDIN, 255);
    $c = fgets(STDIN, 255);

echo "Наибольшее из них: ".biggestNumber($a, $b, $c);
}
?>