<html>
    <body>
        <form method="get" action="findmyresult.php">
        <tr>
		  <td><label for="id"><b>ID: </b></label>
		  <td><input type="number" id="id" name="id" required/></td><br>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
        </form>
    </body>
</html>
<?php
    require("connect.php");
    $id=$_GET['id'];
    $data=mysql_query("SELECT * FROM marksheet WHERE ID='$id'") or die("ID NOT FOUND");
    while($row=mysql_fetch_assoc($data))
    {
        echo "ID:".$row['ID'] ."<br>";
        echo "NAME:".$row['Name'] ."<br>";
        echo "MARKS OF C++:".$row['c++'] ."<br>";
        echo "MARKS OF JAVA:".$row['java'] ."<br>";
        echo "MARKS OF ALGORITHM:".$row['algorithm'] ."<br>";
        $per=($row['c++']+$row['java']+$row['algorithm'])/3;
        echo "PERCENTAGE:".$per."<br><br><br><br>";
    }
?>
