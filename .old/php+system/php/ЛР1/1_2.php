<?php

function quadraticEquation($a, $b, $c){

    echo "Введено уравнение ($a)x^2+($b)x+($c) = 0\n";

    $D = pow($b, 2) - 4*$a*$c;

    echo "Дискриминант равен $D\n";

    if ($D<0) 
        {echo "Уравнение не имеет действительных корней \n";
        return;}

    $x1 = (-$b+sqrt($D))/(2*$a);
    $x2 = (-$b-sqrt($D))/(2*$a);

    $result = "Корни уравнения: \n".'x1: '.$x1."\n".'x2: '.$x2."\n";
    return $result;

}

while (true) {

    echo "Введите коэффиценты уравнения: \n";
    $a = fgets(STDIN, 255);
    $b = fgets(STDIN, 255);
    $c = fgets(STDIN, 255);

    echo quadraticEquation($a, $b, $c);
    
}

?>