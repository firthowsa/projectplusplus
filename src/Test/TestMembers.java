package Test;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.TeamMembersDAO;

import models.Student;

/**
 * Servlet implementation class TestMembers
 */
@WebServlet("/TestMembers")
public class TestMembers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Object user = request.getSession().getAttribute("user");
        
        if (user instanceof Student) {
        	Student student = (Student) user;
        	String member=student.getStudentNumber();
        	//int teamId=TeamMembersDAO.getTeamId(member);
        	
        	//System.out.println(member);
        	System.out.println(TeamMembersDAO.get(member).toString());
        	//System.out.println(TeamMembersDAO.getTeamId(member)+"works");
        	
        	//System.out.println(TeamMembersDAO.getTeamId(member));
//        	System.out.println(TeamsCompetitionDAO.all());
        }
        response.sendRedirect("profile.jsp");
	}


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.sendRedirect("profile.jsp");
	}

}
