<?php
    $_db = 'experiment';
    $_user = 'root';
    $_pass = '';
    $link = mysqli_connect('localhost',$_user, $_pass,$_db) OR DIE("Не могу создать соединение ");
    
?>