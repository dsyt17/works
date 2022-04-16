<?php

$matrix1 = array();  
$matrix2 = array();  

function createMatrix($n, $matrix){

    for ($i=0; $i<$n; $i++){

        for ($j=0; $j<$n; $j++){

        $rand = rand(2, 10);

        //Избавляемся от повторяющихся значений
        foreach($matrix as $value)
            {
                if(in_array($rand, $value, true))
                {
                    $rand = rand(2, 10);
                }
            }

        $matrix[$i][$j] = $rand;
        }
    }
    return $matrix;
}

function matrixMultiply($matrix1, $matrix2){

    $result = array();
    $n1 = count($matrix1);
    $n2 = count($matrix2);

        if ($n1 != $n2) {
            throw new Exception('Матрицы разной размерности');
            return;
        }

        for ($i=0; $i < $n1; $i++){
            for($j=0; $j < $n1; $j++){
                $result[$i][$j] = 0;
                for($k=0; $k < $n1; $k++){
                    $result[$i][$j] += $matrix1[$i][$k] * $matrix2[$k][$j];
                }
            }
        }
    return $result;
}

echo "Введите размерность квадратных матриц: \n";
$n = fgets(STDIN, 255);

echo "Созданы матрицы: \n";
$m1 = createMatrix($n, $matrix1);
$m2 = createMatrix($n, $matrix2);
echo print_r($m1)." \n";
echo print_r($m2)." \n";

echo "Умножение матриц: \n";
$result = matrixMultiply($m1, $m2);
echo print_r($result)." \n";

?>