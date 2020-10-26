<%@ page import="models.Staff" %>
<%@ page import="models.Student" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 9/29/2020
  Time: 12:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="templates/header.html"/>
<%
    Object user = session.getAttribute("user");
    Student student = null;
    Staff staff = null;
    
    if (user == null) {
        session.invalidate();
        response.sendRedirect("index.jsp");
        return;
    }
%>
<body>
<jsp:include page="templates/nav.jsp"/>
<div class="p-2">
    <h4 class="title color-primary center">Manage Profile</h4>
    <form action="profile" method="post" onsubmit="return validate(this)">
        <diV class="row">
            <div class="col s12 m4 l4">
                <div class="card center p-2">
                    <%
                        if (user instanceof Staff) {
                             staff = (Staff) user;
                    %> 
                    
                    <p><strong>Full Name</strong></p>
                    <p><label><%=staff%></label></p>
                    <p><strong>User ID</strong></p>
                    <p><label><%=staff.getUserId()%></label></p>
                    <p><strong>EmployementId</strong></p>
                    <p><label><%=staff.getEmployementId()%></label></p>

                    <%
                        }else  if (user instanceof Student) {
                             student = (Student) user;
                    %>

                    <p><strong>Full Name</strong></p>
                    <p><label><%=student%></label></p>
                    <p><strong>Student Number</strong></p>
                    <p><label><%=student.getStudentNumber()%></label></p>
                    <p><strong>Team</strong></p>
                    <p><label><%=student.getTeamId()%></label></p>

                    <%
                        }
                    %>
                </div>
            </div>
            <div class="row col s12 m8 l8">
                <div class="card p-2">
                   <%
                       if (user instanceof Staff) {
                   %>
                    <div class="input-field col s12 m6 l6">
                        <i class="material-icons prefix">mail</i> 
                        <input type="email" name="Email" value="<%=staff.getEmail()%>" id="Email">
                        <label for="Email">Email Address</label>
                    </div>

                    <div class="input-field col s12 m6 l6">
                         <i class="material-icons prefix">phone</i>
                        <input type="tel" name="Phone" value="<%=staff.getPhone()%>" id="Phone">
                        <label for="Phone">Phone Number</label>
                    </div>
                    <%
                        }else if (user instanceof Student) {
                    %>
                    <div class="input-field col s12 m6 l6">
                        <input type="email" name="Email" value="<%=student.getEmail()%>" id="Email">
                        <label for="Email">Email Address</label>
                    </div>

                    <div class="input-field col s12 m6 l6">
                        <input type="tel" name="Phone" value="<%=student.getPhone()%>" id="Phone">
                        <label for="Phone">Phone Number</label>
                    </div>
                    <%
                        
                        }
                    %>
                    <div class="col s12 m6 l6 input-field">
                       <i class="material-icons prefix">lock_outline</i>
                        <input type="password" name="NewPassword" id="NewPassword">
                        <label for="NewPassword">New Password</label>
                    </div>
                    <div class="col s12 m6 l6 input-field">
                        <i class="material-icons prefix">lock_outline</i>
                        <input type="password" name="ConfirmNewPassword" id="ConfirmNewPassword">
                        <label for="ConfirmNewPassword">Confirm New Password</label>
                    </div>

<%--                    <div class="col s12  input-field">--%>
<%--                        <input type="password" name="CurrentPassword" id="CurrentPassword" required>--%>
<%--                        <label for="CurrentPassword">Enter current password to save the changes</label>--%>
<%--                    </div>--%>

                    <input type="submit" class="btn #0277bd light-blue darken-3" name="UpdateProfile" value="Save Changes">
                </div>
            </div>
        </diV>
    </form>
</div>
<script>
    function validate(form) {
        if (form.NewPassword.value != '' || form.ConfirmNewPassword.value != '') {
            if (form.NewPassword.value.length < 6){
                alert('Password must be 6 characters or more');
                return false;
            }

            if (form.NewPassword.value != form.ConfirmNewPassword.value) {
                alert('Passwords do not match');
                return false;
            }
        }
        return true;
    }
</script>
</body>
</html>
