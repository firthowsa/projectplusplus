package dao;

import java.sql.Connection;





import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import data.DatabaseAccess;
import models.Competition;

import models.TeamsCompetition;

public class TeamsCompetitionDAO {
	
	 public static TeamsCompetition create(ResultSet resultSet) {
	        try {
	            if (resultSet.next()) {
	                return  new TeamsCompetition(
	                		
	                        resultSet.getInt("teamId"),
	                                                                     
	                        resultSet.getInt("competitionId"),
	                        resultSet.getString("solution"),
	                        resultSet.getInt("point")
	                );
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return  null;
	    }

	    public static List<TeamsCompetition> createList(ResultSet resultSet) {
	        List<TeamsCompetition> teamsCompetition = new ArrayList<>();
	        try {
	            while (resultSet.next()) {
	            	teamsCompetition.add(new TeamsCompetition(
	            			
	                        resultSet.getInt("teamId"),
	                                              
	                        resultSet.getInt("competitionId"),
	                        resultSet.getString("solution"),
	                        resultSet.getInt("point")
	                ));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return teamsCompetition;
	    }

	    static Connection conn1;
	   	static PreparedStatement ps;
	       public static int insertTeamsCompetition(int t,int c) {
	   		int status = 0;
	   		
	   		try {
	   			
	   		conn1 =DatabaseAccess.connect();
	   		ps = conn1.prepareStatement("insert into teamscompetition (teamId, competitionId)values(?,?)");
	   		
	   		ps.setInt(1, t);
	   		ps.setInt(2,c);
	   		
	   		
	   		
	   		status = ps.executeUpdate();
	   		
	   		conn1.close();
	   		//System.out.println(c.getName());
	   			
	   		}catch(Exception e){
	   			System.out.println(e);
	   			System.out.println("could not insert new teamscompetition");
	   			
	   		}
	   		
	   		return status;
	   	}
	    
	    public static TeamsCompetition get(int teamId,int competitionId) {
	        return create(DatabaseAccess.executeQuery("select * from TeamsCompetition where teamId = '"+teamId+"'"));
	        
	    }
	    public static TeamsCompetition getparticipatingTeams(int competitionId) {
	        return create(DatabaseAccess.executeQuery("select * from TeamsCompetition where competitionId = '"+competitionId+"'"));
	        
	    }
	    public static void submitSolution(TeamsCompetition t) {
	        String sql = "update TeamsCompetition set " +
	                "solution = '"+t.getSolution()+"', " +
	                
	                
	                " where competitionId = '"+t.getCompetitionId()+"'";
	        DatabaseAccess.executeUpdate(sql);

	    }
	    public static void updatePoint(TeamsCompetition t) {
	        String sql = "update TeamsCompetition set " +
	                "solution = '"+t.getPoint()+"', " +
	                
	                
	                " where competitionId = '"+t.getCompetitionId()+"'";
	        DatabaseAccess.executeUpdate(sql);

	    }
	    
	    
	    public static List<TeamsCompetition> all() {
	        return createList(DatabaseAccess.executeQuery("select * from teamscompetition"));
	    }
	    
	    public static List<TeamsCompetition> getCompetitionId() {
	        return createList(DatabaseAccess.executeQuery("select   tc.* from student s inner join teammembers tm on s.StudentNumber = tm.StudentNumber inner join teamscompetition tc on tm.TeamId = tc.TeamId  "));
	    }
	    
	    public static List<TeamsCompetition> getParticipatingTeamsFromDB(Competition c) {
	    	return createList(DatabaseAccess.executeQuery("select * from TeamsCompetition where competitionid = "+c.getCompetitionId()));
	    	
	    }
	    
	    public static boolean studentInCompetition(String sId, int cId ) {
	    	try {
	    		String sql = "select tc.competitionId from teamscompetition tc \r\n"
	    				+ "inner join teammembers tm on tc.teamId = tm.teamId \r\n"
	    				+ "where tm.StudentNumber = '"+sId+"' and tc.competitionId = "+cId;
	    		return DatabaseAccess.executeQuery(sql).next();
	    	}catch(SQLException e) {
	    		e.printStackTrace();
	    	}
	    	return false;
	    }
	    
	    
	    public static int countTeamSubmissions(String sId, int cId) {
	    	try {
	    		/*
	    		 * select count(ss.SolutionId) as cnt 
from submittedsolutions ss 
inner join teamscompetition tc on ss.competitionId = tc.competitionId
inner join teammembers tm on tc.teamId = tm.teamId
where ss.competitionId = 2 and tm.StudentNumber = 'S19/12234/11';
	    		 */
	    		String sql = "select count(ss.SolutionId) as cnt \r\n"
	    				+ "from submittedsolutions ss \r\n"
	    				+ "inner join teamscompetition tc on ss.competitionId = tc.competitionId\r\n"
	    				+ "inner join teammembers tm on tc.teamId = tm.teamId\r\n"
	    				+ "where ss.competitionId = "+cId+" and tm.StudentNumber = '"+sId+"'";
	    		ResultSet rs = DatabaseAccess.executeQuery(sql);
	    		if(rs.next()) {
	    			return rs.getInt("cnt");
	    		}
	    	}catch(SQLException e) {
	    		e.printStackTrace();
	    	}
	    	return 0;
	    }

}
