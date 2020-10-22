<html>
<head>
	<title>MarkSheet</title>
	<style type="text/css" media="screen">
		table{
			margin-top:-100px;
		}
		h1{
			text-align: center;
			color:#741852;
			font-family: courier;
			background:yellow;
			margin-top:100px;
			width:500px;
		}
		hr{
			width: 650px;
		}
		label{
			padding-right: 100px;
			text-align:left;
		}
		td{

			color:#000000;
			font-family:courier;
		}
	</style>
</head>
<body>
    <center><h1>MARKSHEET</h1></center>
	<hr>
    <center>
	<table>
	<form method="post" action="form2.php">


        <tr>
		<td><label for="id"><b>ID: </b></label>
		<td><input type="number" id="id" name="id" required/></td><br></tr>

		<tr>
		<td><label for="name"><b>Name: </b></label></td>
		<td><input type="text" id="name" name="name" required/></td><br></tr>


		<tr>
		<td><label for="c"><b>Marks Of C++: </b></label>
		<td><input type="float" id="c" name="c" required/></td><br></tr>

        <tr>
		<td><label for="java"><b>Marks Of JAVA: </b></label>
		<td><input type="float" id="java" name="java" required/></td><br></tr>

        <tr>
		<td><label for="algo"><b>Marks Of Algorithm: </b></label>
		<td><input type="float" id="algo" name="algo" required/></td><br></tr>


		<tr>
        <td></td>
		<td><input type="submit" value="Submit"/></td>
		</tr>
	</form>
	</table>
    </center>
	<hr>
</body>
</html>
