package controllers;

import java.io.IOException;




import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CompetitionDAO;
import dao.StudentDAO;
import dao.TeamDAO;
import dao.TeamMembersDAO;
import dao.TeamsCompetitionDAO;

import models.Student;
import models.Team;
import models.TeamsCompetition;


/**
 * Servlet implementation class NewTeam
 */
@WebServlet(name="NewTeam",urlPatterns = {"/new-teams"})
public class NewTeam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Object user = request.getSession().getAttribute("user");
		
	    if (request.getParameter("JoinCompetition")  != null) {
	    	    
	    	    request.setAttribute("TeamsInCompetition", TeamDAO.getTeamsInCompetition(Integer.parseInt(request.getParameter("competitionId"))));
	    	    request.setAttribute("competition", CompetitionDAO.get(Integer.parseInt(request.getParameter("competitionId"))));
	            request.getRequestDispatcher("join-team.jsp").forward(request, response);
	           
	            return;
	        }
	        
	        if (request.getParameter("CreateTeam")  != null) {
	           
	            	Student student = (Student) user;
	            	String teamLeader=student.getStudentNumber();
	            	String teamName = request.getParameter("TeamName");
	            	int competitionId=Integer.parseInt(request.getParameter("CompetitionId"));
	            	
	            	if (TeamDAO.getTeamName(teamName) != null) {
	                     request.setAttribute("error", "Teamname is taken,kindly select another one");
	                 }else
	                 {
	            	TeamDAO.insertTeam(new Team(teamName,teamLeader));
	            	request.setAttribute("team", TeamDAO.all());
	            
	            	Team teams=TeamDAO.getTeamName(teamName);
	            	
	            	TeamMembersDAO.insertTeamsMembers(teams.getTeamId(), teamLeader);
	            	TeamsCompetitionDAO.insertTeamsCompetition(teams.getTeamId(), competitionId);
	                 }
	            	 
	          
	            request.getRequestDispatcher("view-competition.jsp").forward(request, response);
	            
	            return;
	        }
	        if (request.getParameter("JoinTeam")  != null) {
		          
		            	Student student = (Student) user;
		            	String teamLeader=student.getStudentNumber();
		            	String teamName = request.getParameter("TeamName");
		            	
		            	
		            	request.setAttribute("team", TeamDAO.all());
		            	
		            	Team teams=TeamDAO.getTeamName(teamName);
		            	
		            	
		            	TeamMembersDAO.insertTeamsMembers(teams.getTeamId(), teamLeader);
		            
		                request.getRequestDispatcher("view-competition.jsp").forward(request, response);
		            
		            return;
		        }
	        
	        if (request.getParameter("SubmitSolution")  != null) {
		        int competitionId= Integer.parseInt(request.getParameter("competitionId"));
		         Student student = (Student) user;
		         String studentNumber=student.getStudentNumber();
		         //System.out.println(competitionId +""+ studentNumber);
	    	    request.setAttribute("competition", CompetitionDAO.get(Integer.parseInt(request.getParameter("competitionId"))));
	    	    request.setAttribute("teamid", TeamMembersDAO.getTeamIdforSubmittingSolution(competitionId, studentNumber));

            
                request.getRequestDispatcher("submit-solution.jsp").forward(request, response);
            
            return;
        }

	        if (request.getParameter("SubmitURL")  != null) {
		     
		       
	    	   int teamId=Integer.parseInt(request.getParameter("teamid"));
               String solution = request.getParameter("Solution");
               TeamsCompetition t=TeamsCompetitionDAO.getAll(teamId);
               int competitionId=t.getCompetitionId();
               int point=t.getPoint();
               int teamsCompetitionId=t.getTeamsCompetitionId();
               int count=t.getCount();
               TeamsCompetition teamsCompetition=new TeamsCompetition(teamId,competitionId,solution,point,teamsCompetitionId,count);
               count= count +1;
               teamsCompetition.setTeamId(teamId);
               teamsCompetition.setCompetitionId(competitionId);
               teamsCompetition.setSolution(solution);
               teamsCompetition.setPoint(point);
               teamsCompetition.setTeamsCompetitionId(teamsCompetitionId);
               teamsCompetition.setCount(count);
               
             TeamsCompetitionDAO.submitSolution(teamsCompetition);
            
                request.getRequestDispatcher("view-competition.jsp").forward(request, response);
            
            return;
        }
              if (request.getParameter("TeamMembers")  != null) {
   	    	   int teamId=Integer.parseInt(request.getParameter("teamid"));

	    	    request.setAttribute("teammembers", StudentDAO.getStudentsInSameTeam(teamId));
	            request.getRequestDispatcher("team.jsp").forward(request, response);
	           
	            return;
	        }
              
              if (request.getParameter("Grade")  != null) {
     		     
   		       
   	    	   int teamId=Integer.parseInt(request.getParameter("teamid"));
   	    	   int point=Integer.parseInt(request.getParameter("point"));

                  //String solution = request.getParameter("Solution");
                  TeamsCompetition t=TeamsCompetitionDAO.getAll(teamId);
                  int competitionId=t.getCompetitionId();
                 int points=(t.getPoint() +point)/(2);
                  int teamsCompetitionId=t.getTeamsCompetitionId();
                  int count=t.getCount();
                  String solution = t.getSolution();
                  TeamsCompetition teamsCompetition=new TeamsCompetition(teamId,competitionId,solution,point,teamsCompetitionId,count);
                 
                  teamsCompetition.setTeamId(teamId);
                  teamsCompetition.setCompetitionId(competitionId);
                  teamsCompetition.setSolution(solution);
                  teamsCompetition.setPoint(points);
                  teamsCompetition.setTeamsCompetitionId(teamsCompetitionId);
                  teamsCompetition.setCount(count);
                  
                TeamsCompetitionDAO.submitSolution(teamsCompetition);
               
                   request.getRequestDispatcher("staff").forward(request, response);
               
               return;
           }
	       

	    }

	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        request.setAttribute("competition", CompetitionDAO.all());
	        
	        request.getRequestDispatcher("competitions.jsp").forward(request, response);
	    }
}
