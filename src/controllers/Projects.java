package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProjectDAO;

/**
 * Servlet implementation class Projects
 */
@WebServlet(name="Projects",urlPatterns = {"/projects"})
public class Projects extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        

        if (request.getParameter("EditProject")  != null) {
            request.setAttribute("project", ProjectDAO.get(Integer.parseInt(request.getParameter("projectId"))));
            request.getRequestDispatcher("edit-project.jsp").forward(request, response);
            return;
        }
        
        if (request.getParameter("ReadMore")  != null) {
            request.setAttribute("project", ProjectDAO.get(Integer.parseInt(request.getParameter("projectId"))));
            request.getRequestDispatcher("view-project.jsp").forward(request, response);
            return;
        }

        if (request.getParameter("LevelFilter") != null) {
            try {
                String LevelFilterId =request.getParameter("LevelFilterId");
                request.setAttribute("projects", ProjectDAO.findByLevel(LevelFilterId));
                
                request.getRequestDispatcher("projects.jsp").forward(request, response);
            }catch (Exception e) {
                response.sendRedirect("projects");
            }
            return;
        }

        if (request.getParameter("CategoryFilter") != null) {
            try {
                String category = request.getParameter("CategoryIdFilter");
                request.setAttribute("projects", ProjectDAO.findByCategory(category));
                System.out.println(ProjectDAO.findByCategory(category));
               
                request.getRequestDispatcher("books.jsp").forward(request, response);
            }catch (Exception e) {
                response.sendRedirect("projects");
            }
            return;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("project", ProjectDAO.all());
        
        request.getRequestDispatcher("projects.jsp").forward(request, response);
    }
}
