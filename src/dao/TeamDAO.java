package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.DatabaseAccess;

import models.Team;

public class TeamDAO {
	public static Team create(ResultSet resultSet) {
        try {
            if (resultSet.next()) {
                return  new Team(
                		 resultSet.getInt("TeamId"),
                		 resultSet.getString("TeamName"),
                        resultSet.getString("TeamLeader")
                      
                                                                     
                       
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  null;
    }

    public static List<Team> createList(ResultSet resultSet) {
        List<Team> team = new ArrayList<>();
        try {
            while (resultSet.next()) {
            	team.add(new Team(
            			resultSet.getInt("TeamId"),
               		   resultSet.getString("TeamName"),
                       resultSet.getString("TeamLeader")
                    
                                                         
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return team;
    }
    static Connection conn1;
   	static PreparedStatement ps;
       public static int insertTeam(Team t) {
   		int status = 0;
   		
   		try {
   			
   		conn1 =DatabaseAccess.connect();
   		ps = conn1.prepareStatement("insert into team (teamName, teamLeader)values(?,?)");
   		
   		ps.setString(1, t.getTeamName());
   		ps.setString(2, t.getTeamLeader());
   	
   		
   		status = ps.executeUpdate();
   		
   		conn1.close();
   		//System.out.println(c.getName());
   			
   		}catch(Exception e){
   			System.out.println(e);
   			System.out.println("could not insert new team");
   			
   		}
   		
   		return status;
   	}
    
       public static  void create(Team team) {
           String sql = "insert into team (teamName, teamLeader, competitionId) values(";
           sql+="'"+team.getTeamName()+"', ";
           sql+="'"+team.getTeamLeader()+"', ";
           sql+="'"+team.getCompetitionId()+"', ";
                      
           System.out.println(sql);
           DatabaseAccess.executeUpdate(sql);
       }
    public static Team get(int teamId) {
        return create(DatabaseAccess.executeQuery("select * from team where teamId = '"+teamId+"'"));
        
    }
    public static Team getStudentNumber(String studentNumber) {
        return create(DatabaseAccess.executeQuery("select * from team where studentNumber = '"+studentNumber+"'"));
        
    }
    public static Team getTeamName(String TeamName) {
        return create(DatabaseAccess.executeQuery("select * from team where TeamName = '"+TeamName+"'"));
        
    }
    
    public static Team getCompetitionId(int competitionId) {
        return create(DatabaseAccess.executeQuery("select * from team where competitionId = '"+competitionId+"'"));
        
    }
    
    public static List<Team> getTeamsInCompetition(int competitionId) {
        return createList(DatabaseAccess.executeQuery("SELECT team.* FROM `team`INNER JOIN teamscompetition ON teamscompetition.teamId= team.teamId WHERE teamscompetition.competitionId = '"+competitionId+"'"));
        
    }
    
    
    
   
    
    
    public static List<Team> all() {
        return createList(DatabaseAccess.executeQuery("select * from team"));
    }

}
