<?php

function stringCount($string){

    $length = iconv_strlen($string,'UTF-8');
    $wordCount = str_word_count($string);

    return array('length' => $length,'wordCount' => $wordCount);
}

$string = 'adsdf sdf jsa n';
$values = stringCount($string);
echo "Длина сообщения \"".$string."\" равна: ".$values['length']."\n"
    ."Количество слов: ".$values['wordCount'];


?>