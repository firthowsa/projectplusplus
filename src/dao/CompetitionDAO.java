package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.DatabaseAccess;
import models.Competition;



public class CompetitionDAO {
	
	public static Competition create(ResultSet resultSet) {
        try {
            if (resultSet.next()) {
                return  new Competition(
                        resultSet.getInt("CompetitionID"),
                        resultSet.getString("Title"),
                        resultSet.getString("Category"),
                        resultSet.getString("Description"),
                        resultSet.getString("Description"),
                        resultSet.getString("Prize"),
                        resultSet.getDate("Deadline")
                        
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Competition> createList(ResultSet resultSet) {
        List<Competition> competition = new ArrayList<>();
        try {
            while (resultSet.next()) {
            	competition.add(new Competition(resultSet.getInt("CompetitionID"),
                        resultSet.getString("Title"),
                        resultSet.getString("Category"),
                        resultSet.getString("Description"),
                        resultSet.getString("Description"),
                        resultSet.getString("Prize"),
                        resultSet.getDate("Deadline")
                        
                       )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return competition;
    }

    static Connection conn1;
	static PreparedStatement ps;
	public static int insertCompetition(Competition c) {
		int status = 0;
		
		try {
			
		conn1 = DatabaseAccess.connect();
		ps = conn1.prepareStatement("insert into competition (title,category,description,rules,prize,deadline)values(?,?,?,?,?,?)");
		
		ps.setString(1, c.getTitle());
		ps.setString(2, c.getCategory());
		ps.setString(3, c.getDescription());
		ps.setString(4, c.getRules());
		ps.setString(5, c.getPrize());
		ps.setDate(6, c.getDeadline());
		
		
		status = ps.executeUpdate();
		
		conn1.close();
		
			
		}catch(Exception e){
			System.out.println(e);
			System.out.println("there is an exception here3");
			
		}
		
		return status;
	}
	
	 public static List<Competition> all() {
	        return createList(DatabaseAccess.executeQuery("select * from competition"));
	    }

	    public static Competition get(int competitionId) {
	        return create(DatabaseAccess.executeQuery("select * from competition where competitionId = "+competitionId));
	    }

	    public static void updateCompetition(Competition competition) {
	        String sql ="update competition set Title ='"+competition.getTitle()+"', Category = '"+competition.getCategory()+"' ,Description = '"+competition.getDescription()+"',Rules = '"+competition.getRules()+"',Prize = '"+competition.getPrize()+"' ,Rules = '"+competition.getDeadline()+"' where competitionId ="+competition.getCompetitionId();
	        DatabaseAccess.executeUpdate(sql);
	    }

	    public static void delete(int competitionId) {
	        DatabaseAccess.executeUpdate("delete from Competition where competitionId = "+competitionId);

	    }
	    public static  List<Competition> findByCategory(String categoryId) {
	        return createList(DatabaseAccess.executeQuery("select * from competition where Category = "+categoryId));
	    }
	    
	   
	    
	   



}
