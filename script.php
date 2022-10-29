<?php

$conn = mysqli_connect("localhost", "admin", "225506", "wordpress");

if ($conn == false){
    print("Ошибка: Невозможно подключиться к MySQL " . mysqli_connect_error());
}
else {
    print("Соединение установлено успешно");
}

mysqli_set_charset($conn, "utf8");

// $sql = "SELECT * from wp_posts";

// $result = mysqli_query($conn, $sql);

// if ($result == false) {
//     print("Произошла ошибка при выполнении запроса");
// }

// while ($row = mysqli_fetch_array($result)) {
//     print("id: " . $row['ID'] . "; " . $row['post_title'] .PHP_EOL);
// }

$curl = curl_init();

curl_setopt_array($curl, [
	CURLOPT_URL => "https://ai-translation-apis.p.rapidapi.com/json",
	CURLOPT_RETURNTRANSFER => true,
	CURLOPT_FOLLOWLOCATION => true,
	CURLOPT_ENCODING => "",
	CURLOPT_MAXREDIRS => 10,
	CURLOPT_TIMEOUT => 30,
	CURLOPT_HTTP_VERSION => CURL_HTTP_VERSION_1_1,
	CURLOPT_CUSTOMREQUEST => "POST",
	CURLOPT_POSTFIELDS => "{\n    \"to\": \"hi\",\n    \"source\": {\n        \"message\": \"welcome to rapid api\"\n    }\n}",
	CURLOPT_HTTPHEADER => [
		"X-RapidAPI-Host: ai-translation-apis.p.rapidapi.com",
		"X-RapidAPI-Key: 87dc11ece0msh0f19268a79aac3dp1a40fejsna8ec5ca21381",
		"content-type: application/json"
	],
]);

$response = curl_exec($curl);
$err = curl_error($curl);

curl_close($curl);

if ($err) {
	echo "cURL Error #:" . $err;
} else {
	echo $response;
}


?>