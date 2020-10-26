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
 * Servlet implementation class EditProject
 */
@WebServlet(name = "EditProject", urlPatterns = {"/edit-project"})
public class EditProject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		int projectId = Integer.parseInt(request.getParameter("projectId"));
        String title = request.getParameter("Title"),
                category = request.getParameter("Category"),
                level = request.getParameter("Level"),
                description = request.getParameter("Description");
        Project project=new Project(projectId,title,category,level,description);
        ProjectDAO.updateProject(project);
        
        request.setAttribute("message", "Book "+title+" added to the database.");
        
        request.getRequestDispatcher("projects.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        request.getRequestDispatcher("projects.jsp").forward(request, response);
    }

}
