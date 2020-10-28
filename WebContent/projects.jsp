<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="models.*" %>
<!DOCTYPE html>
<html>
<jsp:include page="templates/header.html"/>
<%
    Object user = session.getAttribute("user");
//    if (user == null) {
//        session.invalidate();
//        response.sendRedirect("index.jsp");
//        return;
//    }
   @SuppressWarnings("unchecked")
    List<Project> projects = (List<Project>) request.getAttribute("project");
   @SuppressWarnings("unchecked")
    List<Project> categories = (List<Project>) request.getAttribute("categories");
    if (projects == null ) {
        response.sendRedirect("projects");
        return;
    }
%>
<body>
    <jsp:include page="templates/nav.jsp"/>
     <div class="container">
<div class="p-2">
    <h4 class="title center color-primary">Project Ideas</h4>
    <div class="row">
        <div class="input-field col l4 s12 m4">
            <form action="projects" method="post">
                <select name="LevelFilterId" id="LevelFilterId">
                    <option value="" disabled selected>Select Level</option>
                    <option value="Beginner">Beginner</option>
                    <option value="Intermediate">Intermediate</option>
                    <option value="Advanced">Advanced</option>
                    
                    
                </select>
                <label>Filter by  Level</label>
                
                <input type="submit" name="LevelFilter" hidden id="LevelFilter">
            </form>
        </div>
        <div class="input-field col l4 s12 m4">
            <form action="projects" method="post">
                <select  name="CategoryIdFilter" id="CategoryIdFilter">
                    <option value="" disabled selected>Select category</option>
                      <%for(Project category:categories){ %>
                    <option value="<%=category.getCategory()%>"><%=category.getCategory()%></option>
                    
                    <%} %>
                </select>
                <label>Filter by  category</label>
                <input type="submit" name="CategoryFilter" hidden id="CategoryFilter">
            </form>
        </div>
        <div class="input-field col l4 s12 m4">
            <form method="post" action="projects">
                <input type="search" placeholder="Search by title" id="search">
            </form>
        </div>
    </div>
   
        
            <%
                for (Project project : projects) {
            %>
              <%   if (user instanceof Staff) {
                %>
             
       <div class="col s12 m7">
              <h3 class="header" class="student-name"><%=project.getTitle()%></h3>
         <div class="card horizontal">
           <div class="card-image">
              <img src="https://lorempixel.com/100/190/nature/6">
            </div>
        <div class="card-stacked">
         <div class="card-content">
              <p id="p"><%=project.getDescription()%></p>
          </div>
          
        <div class="card-action">
                 <form action="projects" method="post">
                        <input name="projectId" value="<%=project.getProjectId()%>" hidden>
                        <input type="submit" name="ReadMore" class="btn-small #0277bd light-blue darken-3" value="ReadMore">
                        
                        <input type="submit" name="EditProject" class="btn-small #0277bd light-blue darken-3" value="Edit">
                    </form>
          </div>     
           </div>      <%
                    }else{
                    %>
                    	<div class="col s12 m7">
                        <h3 class="header"><%=project.getTitle()%></h3>
                   <div class="card horizontal">
                     <div class="card-image">
                        <img src="https://lorempixel.com/100/190/nature/6">
                      </div>
                  <div class="card-stacked">
                   <div class="card-content" class="truncate">
                        <p><%=project.getDescription()%></p>
                    </div>
                  <div class="card-action">
                           <form action="projects" method="post">
                                  <input name="projectId" value="<%=project.getProjectId()%>" hidden>
                                  <input type="submit" name="ReadMore" class="btn-small #0277bd light-blue darken-3" value="ReadMore">
                                  
                              </form>
                   </div>
               <%          
                    }   
          %>
      
      </div>
    </div>
          <%
                }
            %>
      </div>     
    </div>
    </div>
   

</div>
</div>
</body>
<script>

function truncateText(selector, maxLength) {
    var element = document.querySelector(selector),
        truncated = element.innerText;

    if (truncated.length > maxLength) {
        truncated = truncated.substr(0,maxLength) + '...';
    }
    return truncated;
}
//You can then call the function with something like what i have below.

document.querySelector('p').innerText = truncateText('p', 500);
    $(document).ready(function(){
        $('select').formSelect();
    });
    
    function searchByTitle(word) {
        $('.book-row').each(function () {
            var tr = $(this);
            var td =  tr.find('.book-title');
            var title = td.text().toLocaleLowerCase();
            if (title.includes(word)) {
                tr.removeClass('d-none');
            }else {
                tr.addClass('d-none')
            }
        })
    }

    $('#search').keyup(function (e) {
        searchByTitle(this.value).toLocaleLowerCase();
    })

    $('#search').keydown(function (e) {
        searchByTitle(this.value).toLocaleLowerCase();
    })

    $('#LevelFilterId').change(function (e) {
        document.getElementById('LevelFilter').click();
    })
    $('#CategoryIdFilter').change(function (e) {
        document.getElementById('CategoryFilter').click();
    })
    
</script>


</html>
