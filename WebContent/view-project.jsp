<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="models.*" %>
    <%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<jsp:include page="templates/header.html"/>
<body>
<%
    Object user = session.getAttribute("user");
    if (user == null ) {
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
    <h4 class="title color-primary"><%=project.getTitle() %></h4>
    <div class="row">
        <div class="col l8 m8 s12">
             <img class="responsive-img" src="assets/img/facedetection.jpg">
              <p><%=project.getDescription() %></p>
        </div>
        
        
        <div class="col s12 m4 l4">
            <h6 class="title color-primary">Similar Projects</h6>
            
                   
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