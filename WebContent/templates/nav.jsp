<%@ page import="models.Staff" %>
<%@ page import="models.Student" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="navbar-fixed">
<nav class=" #0277bd light-blue darken-3" role="navigation">
    <div class="nav-wrapper">
        <a id="logo-container" href="#" class="brand-logo">ProjectPLus</a>
        <ul class="right hide-on-med-and-down">
            <%
                Object user = session.getAttribute("user");
                if (user == null) {
            %>
            <li><a href="index.jsp">Home</a></li>
            <li><a href="projects">Projects</a></li>
            <li><a href="help.jsp">Help</a></li>
            <li><a href="#">Contact</a></li>
            <%
                } else if (user instanceof Staff) {
                    Staff staff = (Staff) user;
            %>
            <li><a href="staff.jsp">Home</a></li>
            <li><a class='dropdown-trigger' href='#' data-target='manage-project'>Manage Projects<i class="material-icons right">arrow_drop_down</i></a></li>
           

            <%
                if (staff.isAdmin()) {
            %>
            
            
            <li>
                <a class='dropdown-trigger'href='#' data-target='manage-competition'>Manage Competition
                    <i class="material-icons right">arrow_drop_down</i>
                </a>
            </li>
           
            <ul id='manage-competition' class='dropdown-content'>
                <li><a href="new-competition.jsp"><i class="material-icons">add</i>Add Competition</a></li>                
                <li><a href="competitions"><i class="material-icons">visibility</i>View Competition</a></li>
                
                
            </ul>

            <li>
                <a class='dropdown-trigger'href='#' data-target='manage-users'>Manage users
                    <i class="material-icons right">arrow_drop_down</i>
                </a>
            </li>
           
            <ul id='manage-users' class='dropdown-content'>
                <li><a href="register-staff"><i class="material-icons">add</i>Add staff</a></li>                
                <li><a href="users"><i class="material-icons">visibility</i>View Staff</a></li>
                <li><a href="students"><i class="material-icons">visibility</i>View Students</a></li>
                
            </ul>
            <%
                }
            %>

            <li>
                <a href="#" class="dropdown-trigger" data-target="profile-dropdown">
                    <i class="valign-wrapper">
                        <img  style="height: 30px; width: 30px;" src="assets/img/background.jpg" alt="" class="responsive-img circle valign-wrapper">
                        &nbsp;
                        <span style="font-style: normal; font-size: 14px"><%=staff%></span>
                        <i class="material-icons right">arrow_drop_down</i>
                    </i>
                </a>
            </li>
            <ul id='manage-project' class='dropdown-content'>
                <li><a href="new-project.jsp"><i class="material-icons">add</i>Add Projects</a></li>                
                <li><a href="projects"><i class="material-icons">visibility</i>View Projects</a></li>              
            </ul>

            <ul id='profile-dropdown' class='dropdown-content'>
                <li><a href="profile"> <i class="material-icons prefix">account_circle</i>Profile</a></li>
                <li><a href="logout"> <i class="material-icons prefix">power_settings_new</i>Logout</a></li>
            </ul>

            <%
            } else if (user instanceof Student) {
                    Student student = (Student) user;
            %>
            <li><a href="student.jsp">Home</a></li>
             <li><a href="projects">Project</a></li>
              <li><a href="competitions">Competitions</a></li>
            
            <li>
                <a href="#" class="dropdown-trigger" data-target="profile-student">
                    <i class="valign-wrapper">
                        <img  style="height: 30px; width: 30px;" src="assets/img/background.jpg" alt="" class="responsive-img circle valign-wrapper">
                        &nbsp;
                        <span style="font-style: normal; font-size: 14px"><%=student%></span>
                        <i class="material-icons right">arrow_drop_down</i>
                    </i>
                </a>
            </li>
            <ul id='profile-student' class='dropdown-content'>
                <li><a href="profile">Profile</a></li>
                <li><a href="logout">Logout</a></li>
            </ul>
            <%
            }  else  {
                    session.invalidate();
                    response.sendRedirect("index.jsp");
                    return;
            }
            %>
        </ul>


<%--        Mobile--%>
        <ul id="nav-mobile" class="sidenav pink darken-4">
            <li>
                <h1 class="p-2">LMS</h1>
            </li>
            <%
                if (user == null) {
            %>
            <li><a href="index.jsp">Home</a></li>
            <li><a href="#">About</a></li>
            <li><a href="#">Contact</a></li>
            <%
            } else if (user instanceof Staff) {
                Staff staff = (Staff) user;
            %>
            <li><a href="staff">Home</a></li>
            <li><a class='dropdown-trigger' href='#' data-target='manage-books1'>Manage books<i class="material-icons right">arrow_drop_down</i></a></li>
            <li><a href="receive-book">Receive Book</a></li>
            <li>
                <a href="#" class="dropdown-trigger" data-target="profile-dropdown1">
                    <i class="valign-wrapper">
                        <img  style="height: 30px; width: 30px;" src="assets/img/background.jpg" alt="" class="responsive-img circle valign-wrapper">
                        &nbsp;
<%--                        <span style="font-style: normal; font-size: 14px"><%=staff%></span>--%>
                        <i class="material-icons right">arrow_drop_down</i>
                    </i>
                </a>
            </li>

            <ul id='manage-books1' class='dropdown-content'>
                <li><a href="new-book">Add book</a></li>
                <li><a href="new-e-book">Add e-book</a></li>
                <li><a href="books">View books</a></li>
                <li><a href="e-books">View e-books</a></li>
            </ul>

            <%
                if (staff.isAdmin()) {
            %>

            <li>
                <a class='dropdown-trigger'href='#' data-target='manage-users1'>Manage users
                     <i class="material-icons right">arrow_drop_down</i>
                 </a>
            </li>
            <li><a href="campuses">Campuses</a></li>

            <ul id='manage-users1' class='dropdown-content'>
                <li><a href="register-staff">Add staff</a></li>
                <li><a href="register-student">Add Student</a></li>
                <li><a href="register-professor">Add Professor</a></li>
                <li><a href="users">View Staff</a></li>
                <li><a href="students">View Students</a></li>
                <li><a href="professors">View Professors</a></li>
            </ul>
            <%
                }
            %>

            <ul id='profile-dropdown1' class='dropdown-content'>
                <li><a href="profile"> <i class="material-icons prefix">account_circle</i>Profile</a></li>
                <li><a href="logout"><i class="material-icons prefix">power_settings_new</i>Logout</a></li>
            </ul>

            <%
            } else if (user instanceof Student) {
                Student student = (Student) user;
            %>
            <li><a href="student">Home</a></li>
            <li><a class='dropdown-trigger' href='#' data-target='find-books-students1'>Find book<i class="material-icons right">arrow_drop_down</i></a></li>
            <ul id='find-books-students1' class='dropdown-content'>
                <li><a href="books">books</a></li>
                <li><a href="e-books">e-books</a></li>
            </ul>
            <li>
                <a href="#" class="dropdown-trigger" data-target="profile-student1">
                    <i class="valign-wrapper">
                        <img  style="height: 30px; width: 30px;" src="assets/img/background.jpg" alt="" class="responsive-img circle valign-wrapper">
                        &nbsp;
<%--                        <span style="font-style: normal; font-size: 14px"><%=student%></span>--%>
                        <i class="material-icons right">arrow_drop_down</i>
                    </i>
                </a>
            </li>
            <ul id='profile-student1' class='dropdown-content'>
                <li><a href="profile"><i class="material-icons prefix">account_circle</i>Profile</a></li>
                <li><a href="logout"><i class="material-icons prefix">power_settings_new</i>Logout</a></li>
            </ul>
            <%
            }  else  {
                    session.invalidate();
                    response.sendRedirect("index.jsp");
                    return;
                }
            %>
        </ul>
        <a href="#" data-target="nav-mobile" class="sidenav-trigger"><i class="material-icons">menu</i></a>
    </div>
    <script>
        $(document).ready(function (e) {
            $('.dropdown-trigger').dropdown();
        })
    </script>
</nav>
</div>
