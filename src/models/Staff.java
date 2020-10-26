package models;

;

public class Staff {
    private String  FirstName , LastName ,Phone ,Email ,EmployementId, Password;
    private boolean IsAdmin ;
    private int  UserId;

    public Staff(String firstName, String lastName, String phone, String email, String password, boolean isAdmin, String employementId) {
        FirstName = firstName;
        LastName = lastName;
        Phone = phone;
        Email = email;
        Password = password;
        IsAdmin = isAdmin;
        EmployementId = employementId;
    }

    public Staff(int userId,
                 String firstName,
                 String lastName,
                 String phone,
                 String email,
                 String password,
                 boolean isAdmin,
                 String employementId
    ) {
        UserId = userId;
        FirstName = firstName;
        LastName = lastName;
        Phone = phone;
        Email = email;
        Password = password;
        IsAdmin = isAdmin;
        EmployementId = employementId;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
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

    public boolean isAdmin() {
        return IsAdmin;
    }

    public void setAdmin(boolean admin) {
        IsAdmin = admin;
    }

    public String getEmployementId() {
        return EmployementId;
    }

    public void setEmployementId(String employementId) {
    	EmployementId = employementId;
    }

    @Override
    public String toString() {
        return FirstName+" "+LastName;
    }

    
}
