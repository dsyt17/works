<?php

$url = $argv[1];
//Инициализируем сеанс
	$curl = curl_init();

	//Указываем адрес страницы
	curl_setopt($curl, CURLOPT_URL, $url);

	//Ответ сервера сохранять в переменную, а не на экран	
	curl_setopt($curl, CURLOPT_RETURNTRANSFER, 1);
	//Переходить по редиректам
	curl_setopt($curl, CURLOPT_FOLLOWLOCATION, 1);

	//Выполняем запрос:	
    $result = curl_exec($curl);

	$file = 'response_html.txt';

	file_put_contents($file, $result);

?>