package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProjectDAO;
import models.Project;

/**
 * Servlet implementation class newProject
 */
@WebServlet(name="newProject", urlPatterns = {"/new-project"})
public class newProject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        
        String title = request.getParameter("Title"),
                category = request.getParameter("Category"),
                level = request.getParameter("Level"),
                description = request.getParameter("Description");

       ProjectDAO.insertProject(new Project(title, category, level, description));
        request.setAttribute("message", "Project "+title+" added to the database.");
        
        request.getRequestDispatcher("new-project.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        request.getRequestDispatcher("new-project.jsp").forward(request, response);
    }
}
