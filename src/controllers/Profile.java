package controllers;


import dao.StaffDAO;
import dao.StudentDAO;

import models.Staff;
import models.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Profile", urlPatterns = {"/profile"})
public class Profile extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object user = request.getSession().getAttribute("user");
        String email = request.getParameter("Email"),
                phone  = request.getParameter("Phone"),
                firstname=request.getParameter("Firstname"),
                 lastname=request.getParameter("Lastname"),
                newPassword = request.getParameter("NewPassword");
        System.out.println(firstname +"Profile");
        System.out.println(email +"Profile");
        if (user instanceof Staff) {
            Staff staff = (Staff) user;
            staff.setEmail(email);
            staff.setPhone(phone);
            staff.setFirstName(firstname);
            staff.setLastName(lastname);
            if (!newPassword.equals("")) {
                staff.setPassword(newPassword);
            }
            StaffDAO.updateProfile(staff);
        }else if (user instanceof Student) {
            Student student = (Student) user;
            student.setEmail(email);
            student.setPhone(phone);
            student.setFirstName(firstname);
            student.setLastName(lastname);
            if (!newPassword.equals("")) {
                student.setPassword(newPassword);
            }
            StudentDAO.updateProfile(student);
        }
        response.sendRedirect("profile.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("profile.jsp");
    }
}
