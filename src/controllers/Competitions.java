package controllers;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CompetitionDAO;

import dao.TeamDAO;
import dao.TeamMembersDAO;
import dao.TeamsCompetitionDAO;
import models.Student;

/**
 * Servlet implementation class Competitions
 */
@WebServlet(name="Competitions",urlPatterns = {"/competitions"})
public class Competitions extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	Object user = request.getSession().getAttribute("user");
	
    if (request.getParameter("EditCompetition")  != null) {
            request.setAttribute("competition", CompetitionDAO.get(Integer.parseInt(request.getParameter("competitionId"))));
            request.getRequestDispatcher("edit-competition.jsp").forward(request, response);
           
            return;
        }
        
        if (request.getParameter("ReadMore")  != null) {
            request.setAttribute("competition", CompetitionDAO.get(Integer.parseInt(request.getParameter("competitionId"))));
            request.setAttribute("currentStudentTeamId", TeamMembersDAO.getTeamIds());
            request.setAttribute("currentStudentCompetition", TeamsCompetitionDAO.getCompetitionId());
           // request.setAttribute("teams", TeamDAO.all());
            
            if (user instanceof Student) {
            	Student student = (Student) user;
            	String member=student.getStudentNumber(); 
            	request.setAttribute("studentNumber", member);
            	request.setAttribute("studentnumber",TeamMembersDAO.get(member));
            	
            	 
            }
            request.getRequestDispatcher("view-competition.jsp").forward(request, response);
            
            return;
        }

       

        
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("competition", CompetitionDAO.all());
        request.setAttribute("teams", TeamDAO.all());
        
        request.getRequestDispatcher("competitions.jsp").forward(request, response);
    }
}
