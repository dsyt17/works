<?php
$login = "".$_GET['lll'];
$pass = "".$_GET['ppp'];

require_once('mysql.php');

if(!isset($login)) {
    header("location: index.php");
}


$find = "INSERT INTO persons (`login`, `password`) VALUES ('$login', '$pass')";

if ($find) {
    $_SESSION['error'] = 'Логин существует';
    header("location: index.php");
}


$query = "INSERT INTO persons (`login`, `password`) VALUES ('$login', '$pass')";


$res = mysqli_query($link, $query);
header("location: index.php");
?>