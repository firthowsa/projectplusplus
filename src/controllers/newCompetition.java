package controllers;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CompetitionDAO;
import models.Competition;

/**
 * Servlet implementation class newCompetition
 */
@WebServlet(name="newCompetition", urlPatterns = {"/new-competition"})
public class newCompetition extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        
        String title = request.getParameter("Title"),
                category = request.getParameter("Category"),
                prize = request.getParameter("Prize"),
                rules = request.getParameter("Rules"),
                description = request.getParameter("Description");
        Date deadline = Date.valueOf(request.getParameter("Deadline"));

       CompetitionDAO.insertCompetition(new Competition(title, category, description,rules,prize,deadline));
        request.setAttribute("message", "Competition "+title+" added to the database.");
        
        request.getRequestDispatcher("new-competition.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        request.getRequestDispatcher("new-competition.jsp").forward(request, response);
    }

}
