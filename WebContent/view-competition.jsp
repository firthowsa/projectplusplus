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
    
    
    Competition competition = (Competition) request.getAttribute("competition");
    TeamMembers studentnumber = (TeamMembers) request.getAttribute("studentnumber");
    List<TeamMembers> currentStudentTeamIds = (List<TeamMembers>) request.getAttribute("currentStudentTeamId");
    List<TeamsCompetition> currentStudentCompetitions = (List<TeamsCompetition>) request.getAttribute("currentStudentCompetition");
   Team competitionId = (Team) request.getAttribute("competitionId");
   // List<Student> studentTeam = (List<Student>) request.getAttribute("studentTeam");
   String StudentNumber=(String)request.getAttribute("studentNumber");
    
   
    if ( competition == null) {
        response.sendRedirect("competitions");
        return;
    }
    
   
%>
<jsp:include page="templates/nav.jsp"/>
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
            
 <nav>
    <div class="nav-wrapper #fafafa grey lighten-5"">
      <a href="#" class="brand-logo"><h4 class="title color-primary"><%=competition.getTitle() %></h4></a>
      <ul id="nav-mobile" class="right hide-on-med-and-down">
        
       <li>
        <form action="new-teams" method="post">
             <input name="competitionId" value="<%=competition.getCompetitionId()%>"hidden >
             
                       <%
                       Student s = (Student) user;
                       		if(!competition.studentParticipating(s.getStudentNumber())) {
                       %> 
                        
                        <input type="submit" name="JoinCompetition" class="btn #e65100 orange darken-4 " value="Join Competition">
                       <%
                       		}
                       		
                       %>
        
      <% 
               if (competition.studentParticipating(s.getStudentNumber()) && competition.countTeamSummissions(s.getStudentNumber()) < 5) {
       %> 
                      <input name="competitionId" value="<%=competition.getCompetitionId()%>"hidden >
                       <input type="submit" name="SubmitSolution" class="btn-small #e65100 orange darken-4 " value="Submit Solution">
        <%
                       		}
        %> 
         </form>   
         </li>
      </ul>
    </div>
  </nav>

  


<div class="p-2">
 <div class="row">
 <div class="col s12 m4 l3 #ffffff white" >
            
             <ul>
               <li><a href="#">Description</a></li><br><br>
               <li><a href="#">Rules</a></li><br><br>
              <li><a href="#">Prize</a></li><br><br>
              <li><a href="#">Time Line</a></li><br><br>
             </ul>
                   
        </div>
    <div class="col s12 m8 l9">
       
             <img class="responsive-img" src="">
              <p id="description" ><%=competition.getDescription() %></p>
              <p id="rules" hidden><%=competition.getRules() %></p>
              <p id="prize" hidden><%=competition.getPrize() %></p>
              <p id="deadline" hidden><%=competition.getDeadline() %></p>
        </div>
        
        
        
    </div>
</div>
</body>
<script>
    $(document).ready(function(){
        $('select').formSelect();
    });
   
    	  $("#description").click(function(){
    	    $("#rules").show();
    	  });
    	});
    
   
</script>
</html>