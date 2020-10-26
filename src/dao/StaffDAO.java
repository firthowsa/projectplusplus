package dao;


import data.DatabaseAccess;

import models.Staff;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StaffDAO {
    public static Staff create(ResultSet resultSet) {
        try {
            if (resultSet.next()) {
                return  new Staff(
                        resultSet.getInt("UserId"),
                        resultSet.getString("FirstName"),
                        resultSet.getString("LastName"),
                        resultSet.getString("Phone"),
                        resultSet.getString("Email"),
                        resultSet.getString("Password"),
                        resultSet.getBoolean("IsAdmin"),
                        resultSet.getString("EmployementId")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Staff> createList(ResultSet resultSet) {
        List<Staff> staff = new ArrayList<>();
        try {
            while (resultSet.next()) {
                staff.add(new Staff(resultSet.getInt("UserId"),
                        resultSet.getString("FirstName"),
                        resultSet.getString("LastName"),
                        resultSet.getString("Phone"),
                        resultSet.getString("Email"),
                        resultSet.getString("Password"),
                        resultSet.getBoolean("IsAdmin"),
                        resultSet.getString("EmployementId"))
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return staff;
    }

    public static int create(Staff staff) {
        String sql = "insert into Staff (UserId, FirstName, LastName, Phone, Email, Password, EmployementId	) values (" +
                "'"+staff.getUserId()+"', " +
                "'"+staff.getFirstName()+"', " +
                "'"+staff.getLastName()+"', " +
                "'"+staff.getPhone()+"', " +
                "'"+staff.getEmail()+"', " +
                "'"+staff.getPassword()+"', " +staff.getEmployementId()+")";
        //System.out.println(staff.getPhone());
       return  DatabaseAccess.getLastInsertedIndex(sql);
    }

    public static Staff login(String userId, String password) {
        return create(DatabaseAccess.executeQuery("select * from Staff where UserId = '"+userId+"' and Password = '"+password+"'"));
    }
    
    static Connection conn1;
	static PreparedStatement ps;
    public static int insertStaff(Staff c) {
		int status = 0;
		
		try {
			
		conn1 =DatabaseAccess.connect();
		ps = conn1.prepareStatement( "insert into Staff (UserId, FirstName, LastName, Phone, Email, Password, EmployementId	)values(?,?,?,?,?,?,?)");
		
		ps.setInt(1, c.getUserId());
		ps.setString(2, c.getFirstName());
		ps.setString(3, c.getLastName());
		ps.setString(4, c.getPhone());
		ps.setString(5, c.getEmail());
		ps.setString(6, c.getPassword());
		ps.setString(7, c.getEmployementId());
		
		status = ps.executeUpdate();
		
		conn1.close();
		//System.out.println(c.getName());
			
		}catch(Exception e){
			System.out.println(e);
			System.out.println("could not insert new user");
			
		}
		
		return status;
	}


   
    public static List<Staff> all() {
        return createList(DatabaseAccess.executeQuery("select * from Staff"));
    }

    public static Staff get(int userId) {
        return create(DatabaseAccess.executeQuery("select * from Staff where UserId = "+userId));
    }

    public static void updateProfile(Staff staff) {
        String sql ="update Staff set Email ='"+staff.getEmail()+"', Phone = '"+staff.getPhone()+"' ,Password = '"+staff.getPassword()+"' where UserId ="+staff.getUserId();
        DatabaseAccess.executeUpdate(sql);
    }

    public static void delete(int userId) {
        DatabaseAccess.executeUpdate("delete from Staff where UserId = "+userId);

    }

    public static void makeAdmin(int userId) {
        DatabaseAccess.executeUpdate("update Staff set IsAdmin = 1 where UserId = "+userId);
    }

    public static Staff findByEmail(String email) {
        return create(DatabaseAccess.executeQuery("select * from Staff where Email = '"+email+"'"));
    }
    
    public static Staff findByEmployementId(String employementId) {
        return create(DatabaseAccess.executeQuery("select * from Staff where EmployementId = '"+employementId+"'"));
    }

}
