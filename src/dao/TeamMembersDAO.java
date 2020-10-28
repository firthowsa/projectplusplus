package dao;


import java.sql.Connection;




import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.DatabaseAccess;

import models.TeamMembers;


public class TeamMembersDAO {
	
	 public static TeamMembers create(ResultSet resultSet) {
	        try {
	            if (resultSet.next()) {
	                return  new TeamMembers(
	                		
	                		 resultSet.getInt("TeamId"),
	                        resultSet.getString("StudentNumber")
	                                                                     
	                       
	                );
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return  null;
	    }

	    public static List<TeamMembers> createList(ResultSet resultSet) {
	        List<TeamMembers> teamMembers = new ArrayList<>();
	        try {
	            while (resultSet.next()) {
	            	teamMembers.add(new TeamMembers(
	            			
	            			 resultSet.getInt("TeamId"),
	                        resultSet.getString("StudentNumber")
	                                              
	                       
	                ));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return teamMembers;
	    }
	    static Connection conn1;
	   	static PreparedStatement ps;
	       public static int insertTeamsMembers(int t,String s) {
	   		int status = 0;
	   		
	   		try {
	   			
	   		conn1 =DatabaseAccess.connect();
	   		ps = conn1.prepareStatement("insert into TeamMembers (teamId, studentNumber)values(?,?)");
	   		
	   		ps.setInt(1, t);
	   		ps.setString(2, s);
	   		
	   		
	   		
	   		status = ps.executeUpdate();
	   		
	   		conn1.close();
	   		//System.out.println(c.getName());
	   			
	   		}catch(Exception e){
	   			System.out.println(e);
	   			System.out.println("could not insert new teammembers");
	   			
	   		}
	   		
	   		return status;
	   	}
	    
	    public static TeamMembers get(String studentNumber) {
	        return create(DatabaseAccess.executeQuery("select * from teammembers where studentNumber = '"+studentNumber+"'"));
	        
	    }
	    
	    public static TeamMembers getTeamId(int teamId) {
	        return create(DatabaseAccess.executeQuery("select * from teammembers where teamid = '"+teamId+"'"));
	        
	    }
	    
	    public static TeamMembers getTeamIdforSubmittingSolution(int competitionId,String studentNumber ) {
	        return create(DatabaseAccess.executeQuery("SELECT teammembers.* from teammembers INNER JOIN teamscompetition on teamscompetition.teamId=teammembers.teamId INNER JOIN student on "
	        		+ "student.StudentNumber=teammembers.StudentNumber where"
	        		+ " teamscompetition.competitionId='"+competitionId+"' AND teammembers.StudentNumber ='"+studentNumber+"'"));
	        
	    }
	    
	    
	    
	    public static List<TeamMembers> all() {
	        return createList(DatabaseAccess.executeQuery("select * from teammembers"));
	    }
	    
	    public static List<TeamMembers> all(String StudentNumber) {
	        return createList(DatabaseAccess.executeQuery("select * from teammembers where studentnumber="+StudentNumber));
	    }
	    
	    public static List<TeamMembers> getTeamId() {
	        return createList(DatabaseAccess.executeQuery("SELECT teammembers.* from teammembers INNER JOIN team on teammembers.teamId = team.TeamId "));
	    }
	    
	    public static List<TeamMembers> checkIfInCompetition() {
	        return createList(DatabaseAccess.executeQuery("select tm.*  from student s inner join teammembers tm on s.StudentNumber = tm.StudentNumber inner join teamscompetition tc on tm.TeamId = tc.TeamId"));
	    }
	    public static List<TeamMembers> getTeamIds() {
	        return createList(DatabaseAccess.executeQuery("select  tm.* from student s inner join teammembers tm on s.StudentNumber = tm.StudentNumber inner join teamscompetition tc on tm.TeamId = tc.TeamId "));
	        }
	    
//	    public static List<TeamsCompetition> checkIfInCompetitionId(Student c) {
//	        return createList(DatabaseAccess.executeQuery("select  tm.TeamId, tc.CompetitionId from student s inner join teammembers tm on s.StudentNumber = tm.StudentNumber inner join teamscompetition tc on tm.TeamId = tc.TeamId where s.studentnumber= "+c.getStudentNumber()r+));
//	    }
	    
	    
	    
	    
		
}
