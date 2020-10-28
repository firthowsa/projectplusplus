package controllers;


import dao.StaffDAO;
import dao.StudentDAO;
import dao.TeamsCompetitionDAO;
import models.Staff;
import models.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Auth", urlPatterns = {"/auth"})
public class Auth extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String password = request.getParameter("Password");
        try {
            if (request.getParameter("UserId") != null) {
                String userId = request.getParameter("UserId");
                Staff staff = StaffDAO.login(userId, password);
                if (staff == null) {
                    request.setAttribute("error", "Staff login failed. User ID or Password not correct.");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }else {
                    request.getSession().setAttribute("user", staff);
                    request.setAttribute("teamscompetition", TeamsCompetitionDAO.all());

                    request.getRequestDispatcher("staff.jsp").forward(request, response);                }
            }else if (request.getParameter("StudentNumber") != null) {
                String studentNumber = request.getParameter("StudentNumber");
                Student student = StudentDAO.login(studentNumber, password);
                if (student == null) {
                    request.setAttribute("error", "Student login failed. Student number or Password not correct.");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }else {
                    request.getSession().setAttribute("user", student);
                    request.setAttribute("teamscompetition", TeamsCompetitionDAO.all());
                    //System.out.println(TeamsCompetitionDAO.all());
                    request.getRequestDispatcher("student.jsp").forward(request, response);
                    //response.sendRedirect("student.jsp");
                }

            }else {
                request.setAttribute("error", "Invalid role");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        }catch (Exception e) {
            request.getSession().invalidate();
            response.sendRedirect("index.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("index.jsp");
    }
}
