<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="models.*" %>

<!DOCTYPE html>
<html>
<head>
<jsp:include page="templates/header.html"/>
<%
    Object user = session.getAttribute("user");
    if (user == null) {
        session.invalidate();
        response.sendRedirect("index.jsp");
        return;
   }
    @SuppressWarnings("unchecked")
    List<TeamsCompetition> teamscompetition = (List<TeamsCompetition>) request.getAttribute("teamscompetition");
  
    %>
<body>

<jsp:include page="templates/nav.jsp"/>
<div class="container">
<table>
  <thead>
   <tr>
   <th>Competition</th>
   <th>Teams</th>
   <th>Source Code</th>
   <th>Score</th>
   
   </tr>
    <thead>

            <%
                for (TeamsCompetition tc : teamscompetition) {
                	if(tc.getPoint()!= 0){ 
            %>   

     <tbody>
     
     <tr>
     <td><form action="competitions" method="post">
    <input name="competitionId" value="<%=tc.getCompetitionId()%>" hidden>
      <a href=""> <input type="submit" name="ReadMore"  value="Competition <%=tc.getCompetitionId() %>"></a>
     </form></td>
     <td><form action="new-teams" method="post">
     <input name="teamid" value="<%=tc.getTeamId()%>" hidden>
      <a href=""> <input type="submit" name="TeamMembers"  value="Team <%=tc.getTeamId() %>"></a>
     </form></td>
    
     <td><a href="<%=tc.getSolution() %>"><%=tc.getSolution() %></a></td>
     <td><%=tc.getPoint() %></td>
     
     
     <%} %>
   </tr>
     </tbody>
<%} %>
</table>
</div>
</body>
</html>