<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="services.*"%>
<%@page import="model.*"%>
<%@page import="java.util.*"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html lang="en">
<link rel="stylesheet" type="text/css" href="CSS/style.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script type="text/javascript" charset="utf8"
	src="https://cdn.datatables.net/1.10.24/js/jquery.dataTables.js"></script>

<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.24/css/jquery.dataTables.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="CSS/table.css">

<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<head>
<meta charset="ISO-8859-1">

<title>Team Players</title>
<script type="text/javascript">
	$(document).ready(function() {
		$('#table_id').DataTable();
	});
</script>
</head>
<body style="text-align: center;">

 
  <%@ include file="header.html" %> 

	<h1>Welcome to Academy</h1>

	<br>
	<br>
	<br>
	<label for="search">Enter the team name to search</label>
	<script type="text/javascript">
		function register() {
			location.href = "addPlayer.jsp";
		}

		function addTeam() {
			location.href = "addteam.jsp";
		}
	</script>

	<form action="index.jsp" method="get">
		<input type="text" name="search" id="search">
		<button type="submit">Search</button>
	</form>

	<div id="players"
		style="text-align: center; margin-left: auto; margin-right: auto; width: 95%;">
		<table id="table_id" class="styled-table">
		<caption></caption>
			<%
				PlayerServices service = new PlayerServices();
			List<Player> sList = new ArrayList<Player>();
			String team = request.getParameter("search");

			sList = service.getData();
			Collections.sort(sList);
			%>

			<button onclick="close()">close</button>
			<thead>
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Age</th>
					<th>Gender</th>
					<th>Team Name</th>
				</tr>
			</thead>

			<tbody>
				<%
					for (Player p : sList) {
				 	if (p.getTeam().getTeamname().equalsIgnoreCase(team)) {
				 		
				%>
				<tr style="text-align: center;">
					<td><%=p.getPlayerId()%></td>
					<td><%=p.getPlayerName()%></td>
					<td><%=p.getPlayerAge()%></td>
					<td><%=p.getPlayerGender()%></td>
					<td><%=p.getTeam().getTeamname()%></td>
				</tr>
				<%
					}
				}
				%>
			</tbody>
		</table>
	</div>

	<script type="text/javascript">
		function close() {
			document.getElementById('players').style.display = 'none';

		}
	</script>

</body>
</html>