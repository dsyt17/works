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

//Функция замены
function replacement($m, $n, $matrix){

    $min = 100;
    $max = 0;
    $idMin = 0; //Ключи вложенных массивов, в которых находится минимальное и максимальное значения
    $idMax = 0;

    for ($i=0; $i<$m; $i++){

        for ($j=0; $j<$n; $j++){

            if ($min>$matrix[$i][$j]) 
            {
                $min = $matrix[$i][$j]; //проходимся по матрице и присвоиваем значения
                $idMin = $i; //запоминаем ключ элемента (массива, в данном случае)
            }
            if ($max<$matrix[$i][$j]) 
            {
                $max = $matrix[$i][$j];
                $idMax = $i;
            }
            
            }

        }  

    echo "Минимальное значение: ". $min ." Максимальное значение: ". $max . "\n";  

    echo "Строки поменяны местами: \n";
    $tmpMatrix = $matrix[$idMin];
    $matrix[$idMin] = $matrix[$idMax];
    $matrix[$idMax] = $tmpMatrix;
    
    echo print_r($matrix)." \n";
    
}

echo "Введите размерность матрицы (строки, затем столбцы): \n";
$m = fgets(STDIN, 255);
$n = fgets(STDIN, 255);

echo "Создана матрица: \n";
$result = createMatrix($m, $n, $matrix1);
echo print_r($result)." \n";

$mm = replacement($m, $n, $result);
echo $mm;
?>