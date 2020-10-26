<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="models.*" %>
<!DOCTYPE html>
<html>
<jsp:include page="templates/header.html"/>
<body>
<%
    Object user = session.getAttribute("user");
    if (user == null || !(user instanceof Staff)) {
        session.invalidate();
        response.sendRedirect("index.jsp");
        return;
    }
    
    Project project = (Project) request.getAttribute("project");
    if ( project == null) {
        response.sendRedirect("books");
        return;
    }
%>
<jsp:include page="templates/nav.jsp"/>
<div class="p-2">
    <h4 class="title color-primary">Edit Project</h4>
    <div class="row">
        <div class="row col s8">
            <h6 class="title color-primary">Edit Project Details</h6>
            <form method="post" action="edit-project">
                <div class="col s12 input-field">
                    <input name="projectId" value="<%=project.getProjectId()%>" hidden >
                    <input type="text" value="<%=project.getTitle()%>" name="Title" id="Title" class="validate" required>
                    <label for="Title">Project Title</label>
                </div>

                <div class="col s6 input-field">
                    <input type="text" value="<%=project.getCategory()%>" name="Category" id="Category" class="validate" required>
                    <label for="Category">Category</label>
                </div>
                <div class="col s6 input-field">
                    <input type="text" value="<%=project.getLevel()%>" name="Level" id="Level" class="validate" required>
                    <label for="Level">Level</label>
                </div>
                <div class="col s12 input-field">
                <textarea  id="Description" " rows="3" name="Description" class="materialize-textarea" required><%=project.getDescription() %></textarea>
                    
                    <label for="Description">Description </label>
                </div>

               
                <div class="input-field col s12">
                    <button class="btn pink darken-4 w-100" title="submit">Save changes</button>
                </div>
            </form>
        </div>

        
    </div>
</div>
</body>
<script>
    $(document).ready(function(){
        $('select').formSelect();
    });
</script>
</html>