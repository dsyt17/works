<?php
require_once('mysql.php');

$login = $_GET['lll'];

// if(!isset($login)) {
//     header("location: index.php");
// }

$query = "DELETE FROM persons WHERE login='$login'";
$res = mysqli_query($link, $query);

header("location: index.php");
?>