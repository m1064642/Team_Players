package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Player;
import model.Team;
import myexception.DbException;
import services.PlayerServices;

@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Register() {
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw = response.getWriter();
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String gender = request.getParameter("gender");
		String team = request.getParameter("team");
		boolean isMatched = false;

		int tID = Integer.parseInt(team);
		Team t = new Team(tID, "team");

		Player p = new Player(Long.parseLong(id), name, Byte.parseByte(age), gender, t);

		PlayerServices service = new PlayerServices();
		String message = "";
		int n = 0;

		try {
			n = service.addPlayer(p);
			message = "Player Added Succeesfully...";
		} catch (DbException e) {
			System.err.println(e.getMessage());
			message = e.getMessage();
		}

//		if (n == 0) {
//			pw.println("<h1>" + message + "</h1>");
//		} else {
//			pw.println("<h1>" + message + "</h1>");
//
//		}
		pw.println("<h1>" + message + "</h1>");

		pw.println("<a href=\"addPlayer.jsp\">Go Back</a>");

	}

}
