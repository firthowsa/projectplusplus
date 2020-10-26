<%@ page import="models.Staff" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

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
    %>
    
    <jsp:include page="templates/nav.jsp"/>
    
    <div class="p-2">
           
            <div class="row col s8">
                <h6 class="title color-primary">Create new Project</h6>
                <form method="post" action="new-project" enctype="multipart/form-data">
                 <div class="row">
               <h4 class="title color-primary">New Project</h4>
   
            <%
                if(request.getAttribute("message") != null) {
            %>
            <div class="s12 alert green darken-1 center">
                <%=request.getAttribute("message")%>
            </div>
            <%
                }
                if (request.getAttribute("error") != null) {
            %>
            <div class="s12 alert red darken-1 center">
                <%=request.getAttribute("error")%>
            </div>
            <%
                }
            %>
                <div class="col s12 input-field">
                    <input type="text" name="Title" id="Title" class="validate" required>
                    <label for="Title">Project Title</label>
                </div>
                
                <div class="input-field col s6">
                        <select required name="Category">
                            <option value="" disabled selected>Select Category</option>
                            
                            <option value="Artificial Intelligence and Data Science">Artificial Intelligence and Data Science</option>
                            <option value="Android Development">Android Development</option>
                            <option value="Web Development">Web Development</option>
                            
                        </select>
                        <label>Select Category</label>
                    </div>
                    
                    <div class="input-field col s6">
                        <select required name="Level">
                            <option value="" disabled selected>Select Level</option>
                            
                            <option value="Beginner">Beginner</option>
                            <option value="Intermediate">Intermediate</option>
                            <option value="Advanced">Advanced</option>
                            
                        </select>
                        <label>Select Level</label>
                    </div>

                    <div class="col s12 input-field">
                    <textarea  id="Description" rows="3" name="Description" class="materialize-textarea" required></textarea>
                      
                        <label for="Description">Description</label>
                    </div>
                    
                    
               
                   <div class="input-field col s12">
                        <button class="btn #0277bd light-blue darken-3 w-100" title="submit">add Project</button>
                   </div>
                </div>
                   </form>
                     
            
        </div>
    
</div>
</body>
<script>
    $(document).ready(function(){
        $('select').formSelect();
    });
</script>
</body>
</html>