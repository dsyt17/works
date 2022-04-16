<?php

const Pi = 3.1415;

//Объем цилиндра
function getCylinderVolume($radius, $height) {
    
    $volumeCyl = Pi*pow($radius, 2)*$height;

    return $volumeCyl;
}

//Объем конуса
function getConeVolume($radius, $height) {
    
    $volumeCone = (Pi*pow($radius, 2)*$height)/3;

    return $volumeCone;
}

//Объем призмы с основаниями a и b
function getPrismVolume($a, $b, $height) {
    
    $volumePrism = $a*$b*$height;

    return $volumePrism;
}

while (true) {

    echo "Выберите фигуру: (1) - цилиндр, (2) - конус, (3) - призма \n";
    $i = fgets(STDIN, 255);

    switch ($i) {
        case 1:
            echo "Введите радиус цилиндра: \n";
            $r = fgets(STDIN, 255);
            echo "Введите высоту цилиндра: \n";
            $h = fgets(STDIN, 255);
            system('cls');
            echo "Введен цилиндр с радиусом $r и высотой $h \n";
            echo 'Объем цилиндра равен: '.getCylinderVolume($r, $h)."\n";
            break;
        case 2:
            echo "Введите радиус конуса: \n";
            $r = fgets(STDIN, 255);
            echo "Введите высоту конуса: \n";
            $h = fgets(STDIN, 255);
            system('cls');
            echo "Введен конус с радиусом $r и высотой $h \n";
            echo 'Объем конуса равен: '.getConeVolume($r, $h)."\n";
            break;

        case 3:
            echo "Введите первую сторону: \n";
            $a = fgets(STDIN, 255);
            echo "Введите вторую сторону: \n";
            $b = fgets(STDIN, 255);
            echo "Введите высоту призмы: \n";
            $h = fgets(STDIN, 255);
            system('cls');
            echo "Введена призма со сторонами $a и $b и высотой $h \n";
            echo 'Объем призмы равен: '.getPrismVolume($a, $b, $h)."\n";
            break;
    }
    
}

?>