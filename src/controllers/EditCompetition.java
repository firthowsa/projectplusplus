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
 * Servlet implementation class EditCompetition
 */
@WebServlet(name = "EditCompetition", urlPatterns = {"/edit-competition"})
public class EditCompetition extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		int competitionId = Integer.parseInt(request.getParameter("competitionId"));
        String title = request.getParameter("Title"),
                category = request.getParameter("Category"),
                rules = request.getParameter("Rules"),
                prize = request.getParameter("Prize"),
                description = request.getParameter("Description");
        Date deadline = Date.valueOf(request.getParameter("Deadline"));
        Competition competition=new Competition(competitionId,title,category,description,rules,prize,deadline);
        CompetitionDAO.updateCompetition(competition);
        
        request.setAttribute("message", "competition "+title+" added to the database.");
        
        request.getRequestDispatcher("competitions.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        request.getRequestDispatcher("competitions.jsp").forward(request, response);
    }
}
