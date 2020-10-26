<%@ page import="java.util.List" %>
<%@ page import="models.*" %>
<%@ page import="models.Staff" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 9/23/2020
  Time: 7:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="templates/header.html"/>
<body>

<jsp:include page="templates/nav.jsp"/>
<div class="p-2">
    
 <div class="row">
  <form method="post" action="new-teams">
    <div class="col s6">
       <h4 class="title color-primary">Join Team </h4>
            <%
            Competition competition = (Competition) request.getAttribute("competition");
            @SuppressWarnings("unchecked")
            List<Team> teams = (List<Team>) request.getAttribute("TeamsInCompetition");
            
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
             <table>
              <thead>
               <tr>
                 <th>TeamName</th>
                 <th>Join</th>
               </tr>
              </thead>
   
   
            <%
                for (Team team : teams) {
            %>
          <input type="text" value="<%=competition.getCompetitionId()%>" class="validate" required name="CompetitionId" id="CompetitionId" hidden>
          <input type="text" class="validate" required name="TeamName" id="TeamName" value="<%=team.getTeamName() %>" hidden>
        
         <tbody>
         <tr>
            <td><%=team.getTeamName() %></td>
          <td> <input type="submit" name="JoinTeam" class="btn-small #0277bd light-blue darken-3" value="Join Team"></td>
         </tr>
         </tbody>
    <%} %>

</table>
 </div>          
           </form>   
       <div class="col s3 "><h4></h4></div>
 <form method="post" action="new-teams">
   <div class="col s3 ">
      <h4 class="title color-primary">Create Team </h4>
      
       <div class="col s12 m6 l6 input-field">
            <input type="text" value="<%=competition.getCompetitionId()%>" class="validate" required name="CompetitionId" id="CompetitionId" hidden>
             <input type="text" class="validate" required name="TeamName" id="TeamName">
               <label for="TeamName">Team Name</label>
        </div>
            
        <div class="col s12">
             <input type="submit" name="CreateTeam" class="btn-small #0277bd light-blue darken-3" value="Register Team">
          </div>
    </div>
    </form>
  </div>
</div>
</body>
<script>
    

   
</script>
</html>
