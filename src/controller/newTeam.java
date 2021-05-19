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

/**
 * Servlet implementation class newTeam
 */
@WebServlet("/newteam")
public class newTeam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public newTeam() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw = response.getWriter();
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String message ="";
		int n =0;
		
		Team team = new Team(Integer.parseInt(id), name);
		
		TeamServices service = new TeamServices();	
		try {
			n = service.addTeam(team);
			message= "Team Added Successfully...";
		} catch (DbException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
			message = e.getMessage();
		}
		if(n == 0) {
			pw.println("<h1>"+ message+ "</h1>");
			
		}else {
			pw.println("<h1>"+ message+ "</h1>");
		}
		
		pw.println("<a href=\"addteam.jsp\">Go Back</a>");
			
	}

}
