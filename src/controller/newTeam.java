package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Team;
import myexception.DbException;
import services.TeamServices;

@WebServlet("/newteam")
public class newTeam extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public newTeam() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter pw = response.getWriter();
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String message = "";
		int n = 0;

		Team team = new Team(Integer.parseInt(id), name);

		TeamServices service = new TeamServices();
		try {
			n = service.addTeam(team);

		} catch (DbException e) {

			System.err.println(e.getMessage());
			message = e.getMessage();
		}

		if (n != 0) {
			message = "Team Added Successfully...";}

			pw.println("<h1>" + message + "</h1>");

			pw.println("<a href=\"addteam.jsp\">Go Back</a>");


	}
}
