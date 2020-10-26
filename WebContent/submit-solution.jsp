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
    <h4 class="title color-primary">Submit Solution</h4>
    <form method="post" action="new-teams" onsubmit="return validate(this)">
        <div class="row">
            <%
            Competition competition = (Competition) request.getAttribute("competition");
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
                     <input type="text" value="<%=competition.getCompetitionId()%>" class="validate" required name="CompetitionId" id="CompetitionId" >
               
            <div class="col s12 m6 l6 input-field">
                <input type="text" class="validate" required name="Solution" id="Solution">
                <label for="Solution">Enter the Link To Your github repository</label>
            </div>

           

                        <div class="col s12">
                <input type="submit" name="SubmitURL" class="btn-small #0277bd light-blue darken-3" value="Submit Solution">
            </div>
          
        </div>
     </form>
</div>
</body>
<script>
    

    }
</script>
</html>
