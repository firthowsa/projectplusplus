<%@ page import="java.util.List" %>

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
    <h4 class="title color-primary">Register Staff (User)</h4>
    <form method="post" action="register-staff" onsubmit="return validate(this)">
        <div class="row">
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
            <div class="col s12 m6 l6 input-field">
               <i class="material-icons prefix">account_circle</i>
                <input type="text" class="validate" required name="FirstName" id="FirstName">
                <label for="FirstName">First Name</label>
            </div>

            <div class="col s12 m6 l6 input-field">
                <i class="material-icons prefix">account_circle</i>
                <input type="text" class="validate" required name="LastName" id="LastName">
                <label for="LastName">Last Name</label>
            </div>
            
            <div class="col s12 m6 l6 input-field">
                <i class="material-icons prefix">edit</i>   
                <input type="text" class="validate" required name="EmploymentId" id="EmploymentId">
                <label for="EmploymentId">EmploymentId</label>
            </div>

            <div class="col s12 m6 l4 input-field">
                <i class="material-icons prefix">phone</i>
                <input type="tel" class="validate" required name="Phone" id="Phone">
                <label for="Phone">Phone</label>
            </div>

            <div class="col s12 m6 l4 input-field">
                <i class="material-icons prefix">mail</i>
                <input type="email" class="validate" required name="Email" id="Email">
                <label for="Email">Email Address</label>
            </div>
            
            

                        <div class="col s12">
                <button type="submit" class="btn #0277bd light-blue darken-3">Register User</button>
            </div>
        </div>
    </form>
</div>
</body>
<script>
    

    function validate(form) {
        if (form.FirstName.value.trim() === '') {
            alert('First name needed');
            return false;
        }
        if (form.LastName.value.trim() === '') {
            alert('Last name  needed');
            return false;
        }
        if (form.Phone.value.trim().length !== 10 || isNaN(form.Phone.value)) {
            alert('Enter a valid phone number');
            return false;
        }
        if (form.EmploymentId.value.trim() === '' ) {
            alert(' campus needed ');
            return false;
        }
        return true;

    }
</script>
</html>
