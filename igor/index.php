echo <link rel='stylesheet' href='styles.css'>;

<div class='root'>
<table border="1">
<tr>
    <th>Id</th><th>Name</th><th>pass</th>
</tr>
<?php
    session_start();
    require_once("mysql.php");

    $query = "SELECT * FROM persons";
    $res = mysqli_query($link, $query);
    while ($row = mysqli_fetch_array($res)) 
    {
        echo"<tr>
        <td class='row'>".$row['id']."</td>
        <td class='row'>".$row['login']."</td>
        <td class='row'>".$row['password']."</td>
        <td class='controls'><a href='remove_person.php?lll=". $row['login']."'><img src='https://cdn-icons-png.flaticon.com/512/1828/1828843.png'/></a><img src='data:image/png;base64,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'/></td>
        </tr>";
    }
    if ($_SESSION['error']) {
        echo $_SESSION['error'];
    } 
?>
</table>
<!-- <div style="width: 100px; height: 50px; background-color: crimson; margin: 10px;" onclick="show()"></div> -->
    <form method="get" action="add_person.php" class='form'>
        <input type='text' name='lll' placeholder='Name'>
        <input type='text' name='ppp' placeholder='Password'>
        <input type='submit' value='Добавить' class='add'>
    </form>
</div>
