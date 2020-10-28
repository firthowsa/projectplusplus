package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TeamsCompetitionDAO;

/**
 * Servlet implementation class Staff
 */
@WebServlet(name = "Staff", urlPatterns = {"/staff"})
public class Staff extends HttpServlet {
	 /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
	        request.setAttribute("teamscompetition", TeamsCompetitionDAO.all());
	        
	        request.getRequestDispatcher("staff.jsp").forward(request, response);
	        //return;
	    }

	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        //request.setAttribute("students", StudentDAO.all());
	        request.setAttribute("teamscompetition", TeamsCompetitionDAO.all());
	        
	        request.getRequestDispatcher("staff.jsp").forward(request, response);
	    }
}
