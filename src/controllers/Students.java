package controllers;



import dao.StudentDAO;
import dao.TeamsCompetitionDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Students", urlPatterns = {"/students"})
public class Students extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        if (request.getParameter("CampusFilter") != null) {
//            try {
//                int campusId = Integer.parseInt(request.getParameter("CampusIdFilter"));
//                request.setAttribute("students", StudentDAO.findByCampus(campusId));
//              //  request.setAttribute("campuses", CampusDAO.all());
//                request.getRequestDispatcher("students.jsp").forward(request, response);
//            }catch (Exception e) {
//                response.sendRedirect("students");
//            }
//        }
        
        request.setAttribute("students", StudentDAO.all());
        request.setAttribute("teamscompetition", TeamsCompetitionDAO.all());
        System.out.println(TeamsCompetitionDAO.all());
        
        request.getRequestDispatcher("student.jsp").forward(request, response);
        //return;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //request.setAttribute("students", StudentDAO.all());
        request.setAttribute("teamscompetition", TeamsCompetitionDAO.all());
        
        request.getRequestDispatcher("student.jsp").forward(request, response);
    }
}
