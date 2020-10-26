
<%@ page import="java.util.List" %>
<%@ page import="models.Staff" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 9/23/2020
  Time: 6:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="templates/header.html"/>
<body>

<jsp:include page="templates/nav.jsp"/>
<div class="p-2">
    <form action="register-student" method="post" onsubmit="return validate(this)">
        <h4 class="title color-primary">Register Student</h4>
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
            <div class="col l4 m6 s12 input-field">
                <input type="text" name="StudentNumber" class="validate" required id="StudentNumber">
                <label for="StudentNumber">Student Number</label>
            </div>
            <div class="col l4 m6 s12 input-field">
                <i class="material-icons prefix">account_circle</i>
                <input type="text" name="FirstName" class="validate" required id="FirstName">
                <label for="FirstName">First Name</label>
            </div>
            <div class="col l4 m6 s12 input-field">
                <i class="material-icons prefix">account_circle</i>
                <input type="text" name="LastName" class="validate" required id="LastName">
                <label for="LastName">Last Name</label>
            </div>
            <div class="col l6 m6 s12 input-field">
                <i class="material-icons prefix">mail</i>
                <input type="email" name="Email" class="validate" required id="Email">
                <label for="Email">Email Address</label>
            </div> 
            <div class="col l6 s12 input-field">
                <i class="material-icons prefix">phone</i>
                <input type="tel" name="Phone" class="validate" required id="Phone">
                <label for="Phone">Phone</label>
            </div>          

            <div class="input-field col l6 s12">
                <select name="YearOfStudy">
                    <option value="" disabled selected>SelectYear of Study</option>
                    
                    <option value="First Year">First Year</option>
                    <option value=">Second Year">Second Year</option>
                    <option value="Third Year">Third Year</option>
                    <option value="Fourth Year">Fourth Year</option>
                    
                </select>
                <label for="YearOfStudy">YearOfStudy</label>
            </div>

       
        </div>
         <div class="col l6 s12 input-field">
            <button class="btn #0277bd light-blue darken-3" type="submit">Register Student</button>
        </div>
        <span >Already have an account?</span>
<a href="index.jsp" class="password">Log In</a></div>
    </form>
</div>
<script>
   
$(document).ready(function(){
    $('select').formSelect();
});
    function validate(form) {
        if (form.StudentNumber.value.trim() === '') {
            alert('Student number needed');
            return false;
        }

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
        if (form.YearOfStudy.value.trim() === null || form.YearOfStudy.value === '') {
            alert('Select YearOfStudy ');
            return false;
        }

       

        return true;

    }

    
</script>
</body>
</html>
