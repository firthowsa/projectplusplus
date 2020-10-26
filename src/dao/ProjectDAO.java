package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.DatabaseAccess;
import models.Project;





public class ProjectDAO {
	
	public static Project create(ResultSet resultSet) {
        try {
            if (resultSet.next()) {
                return  new Project(
                        resultSet.getInt("ProjectId"),
                        resultSet.getString("Title"),
                        resultSet.getString("Category"),
                        resultSet.getString("Level"),
                        resultSet.getString("Description")
                        
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Project> createList(ResultSet resultSet) {
        List<Project> project = new ArrayList<>();
        try {
            while (resultSet.next()) {
                project.add(new Project(resultSet.getInt("ProjectId"),
                        resultSet.getString("Title"),
                        resultSet.getString("Category"),
                        resultSet.getString("Level"),
                        resultSet.getString("Description")
                       )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return project;
    }

	
	
	static Connection conn1;
	static PreparedStatement ps;
	public static int insertProject(Project p) {
		int status = 0;
		
		try {
			
		conn1 = DatabaseAccess.connect();
		ps = conn1.prepareStatement("insert into projects (title,category,level,description)values(?,?,?,?)");
		
		ps.setString(1, p.getTitle());
		ps.setString(2, p.getCategory());
		ps.setString(3, p.getLevel());
		ps.setString(4, p.getDescription());
		
		
		status = ps.executeUpdate();
		
		conn1.close();
		
			
		}catch(Exception e){
			System.out.println(e);
			System.out.println("there is an exception here3");
			
		}
		
		return status;
	}
	
	 public static List<Project> all() {
	        return createList(DatabaseAccess.executeQuery("select * from projects"));
	    }

	    public static Project get(int projectId) {
	        return create(DatabaseAccess.executeQuery("select * from projects where projectId = "+projectId));
	    }

	    public static void updateProject(Project project) {
	        String sql ="update Projects set Title ='"+project.getTitle()+"', Category = '"+project.getCategory()+"' ,Level = '"+project.getLevel()+"',Description = '"+project.getDescription()+"' where ProjectId ="+project.getProjectId();
	        DatabaseAccess.executeUpdate(sql);
	    }

	    public static void delete(int projectId) {
	        DatabaseAccess.executeUpdate("delete from Project where ProjectId = "+projectId);

	    }
	    public static  List<Project> findByCategory(String categoryId) {
	        return createList(DatabaseAccess.executeQuery("select * from projects where Category = "+categoryId));
	    }
	    
	    public static  List<Project> findByLevel(String levelFilterId) {
	        return createList(DatabaseAccess.executeQuery("select * from projects where Level = "+levelFilterId));
	    }


}
