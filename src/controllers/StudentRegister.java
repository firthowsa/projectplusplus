package controllers;





import dao.StudentDAO;
import models.Student;
import services.MailerService;
import services.PasswordGeneratorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "StudentRegister", urlPatterns = {"/register-student"})
public class StudentRegister extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String studentNumber = request.getParameter("StudentNumber"),
                firstName  = request.getParameter("FirstName"),
                lastName = request.getParameter("LastName"),
                phone = request.getParameter("Phone"),
                email = request.getParameter("Email"),
                yearOfStudy = request.getParameter("YearOfStudy"),
                password = PasswordGeneratorService.generate(6);
     
       System.out.println(StudentDAO.findByEmail(email));
       
       
       
        if (StudentDAO.get(studentNumber) != null) {
            request.setAttribute("error", "A student is already registered with the same Student Number");
        }else if (StudentDAO.findByEmail(email) != null){
            request.setAttribute("error", "A student is already registered with the same email");
        }else {
        	StudentDAO.insertStudent(new Student(studentNumber, firstName, lastName, phone,yearOfStudy, email, password));
           // StudentDAO.create(new Student( studentNumber, firstName, lastName, phone,yearOfStudy, email, password));
           // System.out.println(StudentDAO.get(studentNumber));
            Student student = StudentDAO.get(studentNumber);
            String subject = "Registration in the School Library Management System",
                    message = "You have been registered as as student into the school Library.\n" +
                            "User your student number "+student.getStudentNumber()+" and password "+student.getPassword()+" to access the system.\n" +
                            "Your borrower ID is ";
            MailerService.sendMessage(student.getEmail(), subject, message);
            request.setAttribute("message", "Student registered. Details sent to email "+email);
        }


       // request.setAttribute("campuses", CampusDAO.all());
        request.getRequestDispatcher("register-student.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //request.setAttribute("campuses", CampusDAO.all());
        request.getRequestDispatcher("register-student.jsp").forward(request, response);
   }
}
