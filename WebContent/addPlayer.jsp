<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="services.*"%>
<%@page import="model.*"%>
<%@page import="java.util.*"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="text-align: center;">
	<h1>Add new Player</h1>

	<form action="register" method="post">

		<label for="id">Enter the id</label> <input type="number" id="id"
			name="id" required> <br>
		<br> <label for="name">Enter the Name</label> <input type="text"
			id="name" name="name" required> <br>
		<br> <label for="age">Enter the Age</label> <input type="number"
			id="age" name="age" required> <br>
		<br> <label for="gender">Enter the gender</label> <input
			type="text" id="gender" name="gender" required> <br>
		<br>

		<%
    TeamServices service = new TeamServices();
			List<Team> sList = new ArrayList<Team>();
			
				sList = service.getData();
			%>

		<label for="team">select the team</label> <select id="team"
			name="team" value="">
			<%
					for (Team t : sList) {
				%>
			<option value="<%= t.getTeamId()%>"><%= t.getTeamId()+" " + t.getTeamname() %>
			</option>
			<%
					}
				%>
		</select> <br>
		<br>

		<button type="submit">Add Player</button>
		<a href="index.jsp">Go Back</a>
	</form>

</body>
</html>