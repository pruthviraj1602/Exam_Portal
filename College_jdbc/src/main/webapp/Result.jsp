<%@page import="com.Entity.student_register"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%
          student_register user=(student_register) session.getAttribute("std");
    if(user==null){
    	response.sendRedirect("Login.jsp");
    }
    %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <style>
        * {
             box-sizing: border-box;
            
        }
        body { margin: 4em;
              }
        .card{
            background-image: linear-gradient(to right,rgb(112, 110, 112),rgb(223, 223, 223));
            color: white;
            height: 300px;
        } 
    </style>
    
</head>
<body>
<%
try{
	   Integer id=Integer.parseInt(request.getParameter("id"));
	   Integer m=Integer.parseInt(request.getParameter("m"));
   
%>
    <div class="card text-center">
        <div class="card-header">
          Result
        </div>
        <div class="card-body" style="margin-top: 15px;">
          <h5 class="card-title"><%=user.getName() %></h5>
          <h5 class="card-text">You Get <%=+m %>/10</h5>
          <a href="Dashboared.jsp" class="btn btn-primary" style="margin-top: 20px;">Home</a>
        </div>
        <div class="card-footer" style="color: white;">
         <% if (m > 6) { %>
        <h5 class="card-text">Congratulations! You Passed</h5>
    <% } else { %>
        <h5 class="card-text">Unfortunately, You Did Not Pass!</h5>
    <% } %>
        </div>
      </div>
<%}catch(Exception e){
	e.printStackTrace();
}
	%>       

</body>
</html>