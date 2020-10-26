package controllers;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class TeamsCompetition
 */
@WebServlet("/TeamsCompetition")
public class TeamsCompetition extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		List<Competition> competitions = (List<Competition>) request.getAttribute("competition");
//	    List<Team> teams = (List<Team>) request.getAttribute("teams");
//	    List<Student> studentTeam = (List<Student>) request.getAttribute("studentTeam");
//	    
//	    for (Student student : studentTeam) {
//	    	String studentnumber=student.getStudentNumber();
//	    	System.out.println(studentnumber);
//	    	
//	    }
//	    
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
