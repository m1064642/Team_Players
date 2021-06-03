<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">
#about {
	display: inline;
}


</style>
</head>
<body style="text-align: center;">
<%@ include file="header.html" %> 

	<h1>Add new Team</h1>
	<form action="newteam" method="post" style="box-sizing: content-box;">

		<label for="id">Enter the id</label> <input type="number" id="id"
			name="id" required> <br> <br> <label for="name">Enter
			the Name</label> <input type="text" id="name" name="name" required> <br>
		<br>

		<button type="submit">Add Team</button>
		<a href="index.jsp">Go Back</a>
	</form>

</body>
</html>