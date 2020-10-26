<?php
$con=mysqli_connect("localhost","Chintan Rajput","mdg123","BVMIntranet");
// Check connection
if (mysqli_connect_errno())
  {
  echo "Failed to connect to MySQL: " . mysqli_connect_error();
  }
// ...some PHP code for database "my_db"...
// Change database to "test"
mysqli_select_db($con,"test");
// ...some PHP code for database "test"...
mysqli_close($con);
?>
