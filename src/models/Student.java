package models;



public class Student {
    private String StudentNumber, FirstName , LastName , Phone , Email ,YearOfStudy, Password;
   
    private int TeamId;

    public Student(String studentNumber,
                   String firstName,
                   String lastName,
                   String phone,
                   String yearOfStudy,
                   String email,                   
                   String password,                  
                   int teamId
    ) {
        StudentNumber = studentNumber;
        FirstName = firstName;
        LastName = lastName;
        Phone = phone;
        YearOfStudy=yearOfStudy;
        Email = email;        
        Password = password;       
       TeamId=teamId;
    }

    public Student(String studentNumber,
                   String firstName,
                   String lastName,
                   String phone,
                   String yearOfStudy,
                   String email,                  
                   String password
                   
    ) {
        StudentNumber = studentNumber;
        FirstName = firstName;
        LastName = lastName;
        Phone = phone;
        YearOfStudy=yearOfStudy;
        Email = email;         
        Password = password;
        
       
    }

   

    public String getStudentNumber() {
        return StudentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        StudentNumber = studentNumber;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    

   

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

   
    

    @Override
    public String toString() {
        return FirstName +" "+LastName;
    }

	public int getTeamId() {
		return TeamId;
	}

	public void setTeamId(int teamId) {
		TeamId = teamId;
	}

	public String getYearOFStudy() {
		return YearOfStudy;
	}

	public void setYearOFStudy(String yearOFStudy) {
		YearOfStudy = yearOFStudy;
	}

   
}
