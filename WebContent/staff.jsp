<%@ page import="models.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List" %>

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
         <%if(tc.getSolution()==null){ %>
          <td><p class="green-text ">No submissions</p></td>
          <%}else{ %>
         <td><a href="<%=tc.getSolution() %>"><%=tc.getSolution() %></a></td>
         <%} %>
          <td><form action="new-teams" method="post">
         <input name="teamid" value="<%=tc.getTeamId()%>" hidden>
          <input name="point" value=""type="text" required >
          <input type="submit" name="Grade" class="btn #e65100 green darken-4 " value="Grade" >
         </form></td>
        </tr>
         </tbody>
    <%} %>
    </table>
    </div>
    </body>
    </html>