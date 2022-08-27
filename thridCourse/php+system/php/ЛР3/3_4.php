<?php

$alphabet = array(' ', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
                'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 
                's', 't', 'u', 'v', 'w', 'x', 'y', 'z');

function cezarEncryption($string, $n, $alphabet){

    $strArray = str_split($string, 1);
    $alphabetLength = count($alphabet);

    for ($i=0; $i<count($strArray)-2; $i++){
        $symbol = $strArray[$i];
        $keyAlpabet = array_search($symbol, $alphabet);
        $newKey = $keyAlpabet+$n;
        
        if ($newKey>$alphabetLength - 1){
            $newKey = $newKey - $alphabetLength;
        }

        $strArray[$i] = $alphabet[$newKey];
    }

    $eString = implode($strArray);
    return $eString;

}
    
function cezarDecryption($string, $n, $alphabet){

    $strArray = str_split($string, 1);
    $alphabetLength = count($alphabet);

    for ($i=0; $i<count($strArray)-2; $i++){
        $symbol = $strArray[$i];
        $keyAlpabet = array_search($symbol, $alphabet);
        $newKey = $keyAlpabet-$n;
        
        if ($newKey<0){
            $newKey = $alphabetLength + $newKey;
        }

        $strArray[$i] = $alphabet[$newKey];
    }

    $deString = implode($strArray);
    return $deString;

}

echo "Введите строку для шифрования: \n";
$s = fgets(STDIN, 255);
echo "Введите смещение: ";
$n = fgets(STDIN, 255);

$encString = cezarEncryption($s, $n, $alphabet);
echo "Зашифрованная строка: " .$encString;

echo "Расшифрование строки ".$encString.": "
        .cezarDecryption($encString, $n, $alphabet);

?>