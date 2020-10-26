<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%--head--%>
<jsp:include page="templates/header.html"/>
<body>
<%--  nav--%>
<jsp:include page="templates/nav.jsp"/>
  <div class="index-main" style="
          background-image: url('');
          height: 100%;
          background-position: center;
          background-repeat: no-repeat;
          background-size: cover;
  ">
    <br>
    <div class="">

      <div class="mx-auto form-login">
        <div class="card">
          <div>
            <br>
            <h3 class="title center color-primary">Login</h3>
          </div>

          <div class="card-content">
              <div class="center">
                <label>
                  <input class="with-gap #0277bd light-blue darken-3" id="StaffRole" name="Role" type="radio" checked value="Staff"/>
                  <span>Staff</span>
                </label>
                <label>
                  <input class="with-gap #0277bd light-blue darken-3" id="StudentRole" name="Role" type="radio"  value="Student"/>
                  <span>Student</span>
                </label>
                <label>   
              </div>
              <%
                if (request.getAttribute("error") != null) {
              %>
            <div class="center  red lighten-2 alert">
                <%=request.getAttribute("error")%>
            </div>
            <%
              }
            %>
             <div id="StaffField">
               <form method="post" action="auth">
                 <div class="input-field">
                   <input name="UserId" type="text" id="UserId" class="validate" required>
                   <label for="UserId">User ID</label>
                 </div>
                 <div class="input-field">
                   <input type="password" name="Password" class="validate" required id="Password">
                   <label for="Password">Password</label>
                 </div>
                 <div class="input-field">
                   <input type="submit" name="Login" class="btn w-100 #0277bd light-blue darken-3" value="Login">
                 </div>
               </form>
             </div>

              <div id="StudentField" class="d-none">
                <form action="auth" method="post">
                  <div class="input-field">
                    <input name="StudentNumber" type="text" id="StudentNumber" class="validate" required>
                    <label for="StudentNumber">Student Number</label>
                  </div>

                  <div class="input-field">
                    <input type="password" name="Password" class="validate" required id="Password">
                    <label for="Password">Password</label>
                  </div>
                  <div class="input-field">
                    <input type="submit" name="Login"  class="btn w-100 #0277bd light-blue darken-3" value="Login">
                  </div>
                </form>
              </div>

              <span > Don't have an account?</span>
                 <a class="center" href="register-student.jsp" class="password">Sign Up</a></div>
                <p class="center"><a href="reset-password.jsp">Forgot Password?</a></p>
              </div>
          </div>
        </div>
      </div>
    </div>
  </div>
<script>
    $("#StaffRole").on("click", function (e) {
      if (this.checked) {
        $("#StaffField").removeClass("d-none");
        $("#StudentField").addClass("d-none");
        $("#ProfessorField").addClass("d-none");
      }
    })

    $("#StudentRole").on("click", function (e) {
      if (this.checked) {
        $("#StaffField").addClass("d-none");
        $("#StudentField").removeClass("d-none");
        $("#ProfessorField").addClass("d-none");
      }
    })
   
</script>
  </body>
</html>
