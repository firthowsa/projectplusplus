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
    
    Competition competition = (Competition) request.getAttribute("competition");
    if ( competition == null) {
        response.sendRedirect("competitions");
        return;
    }
%>
<jsp:include page="templates/nav.jsp"/>
<div class="p-2">
    <h4 class="title color-primary">Edit Competition</h4>
    <div class="row">
        <div class="row col s8">
            <h6 class="title color-primary">Edit Competition Details</h6>
            <form method="post" action="edit-competition">
                <div class="col s12 input-field">
                    <input name="competitionId" value="<%=competition.getCompetitionId()%>" hidden >
                    <input type="text" value="<%=competition.getTitle()%>" name="Title" id="Title" class="validate" required>
                    <label for="Title">Project Title</label>
                </div>

                <div class="col s6 input-field">
                    <input type="text" value="<%=competition.getCategory()%>" name="Category" id="Category" class="validate" required>
                    <label for="Category">Category</label>
                </div>
                
                <div class="col s6 input-field">
                    <input type="date" value="<%=competition.getDeadline()%>" name="Deadline" id="Deadline" class="validate" required>
                    <label for="Level">Deadline</label>
                </div>
                
                <div class="col s6 input-field">
                    <input type="text" value="<%=competition.getPrize()%>" name="Prize" id="Prize" class="validate" required>
                    <label for="Level">Prize</label>
                </div>
                <div class="col s6 input-field">
                    <input type="text" value="<%=competition.getRules()%>" name="Rules" id="Rules" class="validate" required>
                    <label for="Level">Rules</label>
                </div>
                <div class="col s12 input-field">
                <textarea  id="Description" " rows="3" name="Description" class="materialize-textarea" required><%=competition.getDescription() %></textarea>
                    
                    <label for="Description">Description </label>
                </div>

               
                <div class="input-field col s12">
                    <button class="btn #0277bd light-blue darken-3" title="submit">Save changes</button>
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