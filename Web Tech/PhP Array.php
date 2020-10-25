<!DOCTYPE html>
<html>
<head>
	<title>temp</title>
	<style>
		p
		{
			font-family: cursive;
			font-size: 16px;
		}
	</style>
</head>
<body>
<?php
$movie = array("Red Sperrow", "Green Mile", "Blue Mountail States", "Yellow Submarin");
echo "<b><h1>Movies</h1></b><br>";
echo "<ol>";
foreach ($movie as $value) {
  echo "<li><p>$value</p></li><br>";
}
echo "</ol>";
?>
</body>
</html>
