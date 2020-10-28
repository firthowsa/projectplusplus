<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="models.*" %>
<!DOCTYPE html>
<html>
<jsp:include page="templates/header.html"/>
<%
    Object user = session.getAttribute("user");
    if (user == null) {
        session.invalidate();
        response.sendRedirect("index.jsp");
        return;
   }
    @SuppressWarnings("unchecked")
    List<Student> students = (List<Student>) request.getAttribute("teammembers");
   
%>
<body>
    <jsp:include page="templates/nav.jsp"/>
    
    <table>
              <thead>
               <tr>
                 <th>First Name</th>
                 <th>Last Name</th>
                 <th>Phone Number</th>
                 <th>Email</th>
               </tr>
              </thead>
              <%for(Student student:students){ %>
              <tbody>
              <tr>
              <td><%=student.getFirstName() %></td>
              <td><%=student.getLastName() %></td>
              <td><%=student.getPhone() %></td>
              <td><%=student.getEmail() %></td>
              </tr>
              </tbody>
              <%} %>
    </table>

</body>
</html>