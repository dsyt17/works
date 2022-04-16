<?php

function season($num){

$summer = array(6, 7, 8);
$autumn = array(9, 10, 11);
$winter = array(1, 2, 12);
$spring = array(3, 4, 5);

if (in_array($num, $summer)) {
    return 'Summer';
}
if (in_array($num, $autumn)) {
    return 'Autumn';
}
if (in_array($num, $winter)) {
    return 'Winter';
}
if (in_array($num, $spring)) {
    return 'Spring';
}
}

echo "Введите месяц: \n";
$a = fgets(STDIN, 255);
echo season($a);
?>