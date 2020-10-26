package controllers;


import dao.StaffDAO;

import models.Staff;
import services.MailerService;
import services.PasswordGeneratorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "StaffRegister", urlPatterns = {"/register-staff"})
public class StaffRegister extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String firstName = request.getParameter("FirstName"),
               lastName  = request.getParameter("LastName"),
               phone  = request.getParameter("Phone"),
               email = request.getParameter("Email"),               
               password = PasswordGeneratorService.generate(6);
             String employementId = request.getParameter("EmploymentId");

      
        if (StaffDAO.findByEmail(email) != null) {
            request.setAttribute("error", "The email address has been used to register another staff.");
        }else if (StaffDAO.findByEmployementId(employementId) != null){
            request.setAttribute("error", "The employementId address has been used to register another staff");
        }else {
            int userId = StaffDAO.insertStaff(new  Staff(firstName, lastName, phone, email, password, false, employementId));

            String subject = "Staff registration at ProjectPlus",
                    message =  "You have been successfully registered as a Staff.\n" +
                            "Password : "+password+"\n" +
                            "User Id  :"+userId;
            MailerService.sendMessage(email, subject, message);
            request.setAttribute("message", "Staff registered successfully. Details emailed at "+email);
            
        }
        request.getRequestDispatcher("register-staff.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
        request.getRequestDispatcher("register-staff.jsp").forward(request, response);
    }
	
}
