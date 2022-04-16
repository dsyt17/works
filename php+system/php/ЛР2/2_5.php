<?php

$matrix1 = array();  

function createMatrix($m, $n, $matrix){

    for ($i=0; $i<$m; $i++){

        for ($j=0; $j<$n; $j++){

        $rand = rand(1, 100);

        //Избавляемся от повторяющихся значений
        foreach($matrix as $value)
            {
                if(in_array($rand, $value, true))
                {
                    $rand = rand(1, 100);
                }
            }

        $matrix[$i][$j] = $rand;
        }
    }
    return $matrix;
}

function transposition($matrix){

    //Транспонируем?
    return array_map(null, ...$matrix);
}


echo "Введите размерность матрицы (строки, затем столбцы): \n";
$m = fgets(STDIN, 255);
$n = fgets(STDIN, 255);

echo "Создана матрица: \n";
$result = createMatrix($m, $n, $matrix1);
echo print_r($result)." \n";

echo "Транспонированная матрица: \n";
$transMatrix = transposition($result, $m, $n);
echo print_r($transMatrix)." \n";

?>