<?php
$result1 = mysql_query(“SHOW DATABASES”);
echo $result1;
$result2 = myspl_query(‘SHOW TABLES [FROM BVMIntranet][LIKE ‘%’]’)
echo $result2;
$sql = "CREATE TABLE Faculty (
id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
firstname VARCHAR(30) NOT NULL,
lastname VARCHAR(30) NOT NULL,
email VARCHAR(50),
reg_date TIMESTAMP
)";
if (mysqli_query($conn, $sql)) {
    echo "Table MyGuests created successfully";
} else {
    echo "Error creating table: " . mysqli_error($conn);
}
?>
