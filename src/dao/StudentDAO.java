package dao;

import data.DatabaseAccess;

import models.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class StudentDAO {
    public static Student create(ResultSet resultSet) {
        try {
            if (resultSet.next()) {
                return  new Student(
                        resultSet.getString("StudentNumber"),
                        resultSet.getString("FirstName"),
                        resultSet.getString("LastName"),
                        resultSet.getString("Phone"),
                        resultSet.getString("YearOfStudy"),
                        resultSet.getString("Email"),                        
                        resultSet.getString("Password"),                                               
                        resultSet.getInt("TeamId")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  null;
    }

    public static List<Student> createList(ResultSet resultSet) {
        List<Student> students = new ArrayList<>();
        try {
            while (resultSet.next()) {
                students.add(new Student(
                        resultSet.getString("StudentNumber"),
                        resultSet.getString("FirstName"),
                        resultSet.getString("LastName"),
                        resultSet.getString("Phone"),
                        resultSet.getString("YearOfStudy"),
                        resultSet.getString("Email"),                       
                        resultSet.getString("Password"),                       
                        resultSet.getInt("TeamId")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
    static Connection conn1;
	static PreparedStatement ps;
    public static int insertStudent(Student c) {
		int status = 0;
		
		try {
			
		conn1 =DatabaseAccess.connect();
		ps = conn1.prepareStatement("insert into Student (StudentNumber, FirstName, LastName, Phone,YearOfStudy, Email, Password)values(?,?,?,?,?,?,?)");
		
		ps.setString(1, c.getStudentNumber());
		ps.setString(2, c.getFirstName());
		ps.setString(3, c.getLastName());
		ps.setString(4, c.getPhone());
		ps.setString(5, c.getYearOFStudy());
		ps.setString(6, c.getEmail());
		ps.setString(7, c.getPassword());
		
		status = ps.executeUpdate();
		
		conn1.close();
		//System.out.println(c.getName());
			
		}catch(Exception e){
			System.out.println(e);
			System.out.println("could not insert new user");
			
		}
		
		return status;
	}


    public static  void create(Student student) {
        String sql = "insert into Student (StudentNumber, FirstName, LastName, Phone,YearOfStudy, Email, Password) values(";
        sql+="'"+student.getStudentNumber()+"', ";
        sql+="'"+student.getFirstName()+"', ";
        sql+="'"+student.getLastName()+"', ";
        sql+="'"+student.getPhone()+"', ";
        sql+="'"+student.getYearOFStudy()+"', ";
        sql+="'"+student.getEmail()+"', ";      
        sql+="'"+student.getPassword()+"', ";
        
        System.out.println(sql);
        DatabaseAccess.executeUpdate(sql);
    }

    public static void update(Student student) {
        String sql = "update Student set " +
                "FirstName = '"+student.getFirstName()+"', " +
                "LastName = '"+student.getLastName()+"', " +
                "Phone = '"+student.getPhone()+"', " +
                "Email = '"+student.getEmail()+"', " +
                
                " where StudentNumber = '"+student.getStudentNumber()+"'";
        DatabaseAccess.executeUpdate(sql);

    }
    public static Student login(String studentNumber, String password) {
        return create(DatabaseAccess.executeQuery("select * from Student where StudentNumber = '"+studentNumber+"' and Password = '"+password+"'"));

    }

    public static Student get(String studentNumber) {
        return create(DatabaseAccess.executeQuery("select * from Student where StudentNumber = '"+studentNumber+"'"));
    }
    
//    public static Student getStudentsTeams(String studentNumber) {
//        return create(DatabaseAccess.executeQuery("select s.StudentNumber, tm.TeamId, tc.CompetitionId from student s inner join teammembers tm on s.StudentNumber = tm.StudentNumber inner join teamscompetition tc on tm.TeamId = tc.TeamId"));
//    }

    public static List<Student> getStudentsInSameTeam(int teamId) {
        return createList(DatabaseAccess.executeQuery("SELECT student.* from student INNER JOIN teammembers on student.StudentNumber=teammembers.StudentNumber WHERE teammembers.teamId = "+teamId));
    }
    public static List<Student> findByCampus(int campusNo) {
        return createList(DatabaseAccess.executeQuery("select * from Student where CampusNo = "+campusNo));
    }

    public static List<Student> all() {
        return createList(DatabaseAccess.executeQuery("select * from Student"));
    }

    public static Student findByBorrowerId(int borrowerId) {
        return create(DatabaseAccess.executeQuery("select * from  Student where BorrowerId = "+borrowerId));
    }

    public static void updateProfile(Student student) {
        String sql ="update Student set Email ='"+student.getEmail()+"', Phone = '"+student.getPhone()+"', Password = '"+student.getPassword()+"' where StudentNumber ='"+student.getStudentNumber()+"'";
        DatabaseAccess.executeUpdate(sql);
    }

    public static Student findByEmail(String email) {
        return create(DatabaseAccess.executeQuery("select * from Student where Email = '"+email+"'"));
    }
    
    public static List<Student> checkCompetitionId() {
    return createList(DatabaseAccess.executeQuery("select  s.* from student s inner join teammembers tm on s.StudentNumber = tm.StudentNumber inner join teamscompetition tc on tm.TeamId = tc.TeamId "));
    }
}
