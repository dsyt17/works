<?php

function stringCount($string){

    $length = iconv_strlen($string,'UTF-8');

    return $length;
}

$string = '3rty4e3g';
echo "Длина сообщения ".$string." равна: ".stringCount($string);

?>