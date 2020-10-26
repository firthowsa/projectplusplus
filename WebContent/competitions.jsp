<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="models.*" %>
<!DOCTYPE html>
<html>
<jsp:include page="templates/header.html"/>
<%
    Object user = session.getAttribute("user");
    if (user == null) {
        session.invalidate();
        response.sendRedirect("index.jsp");
        return;
   }
    @SuppressWarnings("unchecked")
    List<Competition> competitions = (List<Competition>) request.getAttribute("competition");
    @SuppressWarnings("unchecked")
    List<Team> teams = (List<Team>) request.getAttribute("teams");
    
   
    if (competitions == null ) {
        response.sendRedirect("competitions");
        return;
    }
%>
<body>
    <jsp:include page="templates/nav.jsp"/>
     <div class="container">
<div class="p-2">
    <h4 class="title center color-primary">Competitions</h4>
    <div class="row">
        
        <div class="input-field col l4 s12 m4">
            <form action="projects" method="post">
                <select name="CategoryIdFilter" id="CategoryIdFilter">
                    <option value="" disabled selected>Select category</option>
                    
                    <option value="Artificial Intelligence and Data Science">Artificial Intelligence and Data Science</option>
                    <option value="Android Development">Android Development</option>
                    <option value="Web Development">Web Development</option>
                    
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
    <div>
    
        
            <%
                for (Competition competition : competitions) {
            %>
              <%   if (user instanceof Staff) {
                %>
                
       <div class="col s12 m7">
              <h3 class="header"><%=competition.getTitle()%></h3>
         <div class="card horizontal">
           <div class="card-image">
              <img src="https://lorempixel.com/100/190/nature/6">
            </div>
        <div class="card-stacked">
         <div class="card-content">
              <p id="pa"> <%=competition.getDescription()%></p>
          </div>
          
        <div class="card-action">
                 <form action="competitions" method="post">
                        <input name="competitionId" value="<%=competition.getCompetitionId()%>" hidden>
                        <input type="submit" name="ReadMore" class="btn-small #0277bd light-blue darken-3" value="ReadMore">
                        
                        <input type="submit" name="EditCompetition" class="btn-small #0277bd light-blue darken-3" value="Edit">
                    </form>
          </div>     
           </div>      <%
                    }else{
                    %>
                    	<div class="col s12 m7">
                        <h3 class="header"><%=competition.getTitle()%></h3>
                   <div class="card horizontal">
                     <div class="card-image">
                        <img src="https://lorempixel.com/100/190/nature/6">
                      </div>
                  <div class="card-stacked">
                   <div class="card-content">
                        <p id="pa"><%=competition.getDescription()%></p>
                    </div>
                  <div class="card-action">
                           <form action="competitions" method="post">
                                  <input name="competitionId" value="<%=competition.getCompetitionId()%>" hidden>
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


document.querySelector('#pa').innerText = truncateText('#pa', 500);

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