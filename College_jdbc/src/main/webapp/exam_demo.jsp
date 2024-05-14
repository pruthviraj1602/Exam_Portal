<%@page import="com.Entity.gkquestion"%>
<%@page import="java.util.List"%>
<%@page import="com.connection.jdbc_conn"%>
<%@page import="com.model.Promodel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<style>
    @import url('https://fonts.googleapis.com/css2?family=Montserrat&display=swap');

*{
    margin: 0;
    padding: 0;
    box-sizing: border-box;
}

body{
    background-color: #fff;
}
.container{
    background-color: #555;
    color: #ddd;
    border-radius: 10px;
    padding: 20px;
    font-family: 'Montserrat', sans-serif;
    max-width: 700px;
}
.container > p{
    font-size: 32px;
}
.question{
    width: 75%;
}
.options{
    position: relative;
    padding-left: 40px;
}
#options label{
    display: block;
    margin-bottom: 15px;
    font-size: 14px;
    cursor: pointer;
}
.options input{
    opacity: 0;
}
.checkmark {
    position: absolute;
    top: -1px;
    left: 0;
    height: 25px;
    width: 25px;
    background-color: #555;
    border: 1px solid #ddd;
    border-radius: 50%;
}
.options input:checked ~ .checkmark:after {
    display: block;
}
.options .checkmark:after{
    content: "";
	width: 10px;
    height: 10px;
    display: block;
	background: white;
    position: absolute;
    top: 50%;
	left: 50%;
    border-radius: 50%;
    transform: translate(-50%,-50%) scale(0);
    transition: 300ms ease-in-out 0s;
}
.options input[type="radio"]:checked ~ .checkmark{
    background: #21bf73;
    transition: 300ms ease-in-out 0s;
}
.options input[type="radio"]:checked ~ .checkmark:after{
    transform: translate(-50%,-50%) scale(1);
}
.btn-primary{
    background-color: #555;
    color: #ddd;
    border: 1px solid #ddd;
}
.btn-primary:hover{
    background-color: #21bf73;
    border: 1px solid #21bf73;
}
.btn-success{
    padding: 5px 25px;
    background-color: #21bf73;
}
@media(max-width:576px){
    .question{
        width: 100%;
        word-spacing: 2px;
    } 
}
</style>
</head>
<body>
 <div class="container mt-sm-5 my-1">
        <div class="question ml-sm-5 pl-sm-5 pt-2">
            <div class="py-2 h5"><b>Student</b></div>
            <div class="ml-md-3 ml-sm-3 pl-md-5 pt-sm-0 pt-3" id="options">
            </div>
        </div>
    </div>
 <%
       try{
    	   Integer id=Integer.parseInt(request.getParameter("id"));
    	   Integer m=Integer.parseInt(request.getParameter("m"));
    	   
    	   Promodel pm=new Promodel(jdbc_conn.getConnection());
    	   List<gkquestion> li=pm.gklist();
    	
    	   for(gkquestion g:li){
    		   
    		  
    %>
   <form action="Exam_Demo" method="post">
    <%
       if(g.getId()==id){
    	   
       
    %>
    <div class="container mt-sm-5 my-1">
        <div class="question ml-sm-5 pl-sm-5 pt-2">
            <div class="py-2 h5"><b><%="Q"+g.getId()%>) <%=g.getQuestion() %></b></div>
            <input type="hidden" name=id value="<%=g.getId()%>">
            <input type="hidden" name=m value=<%=+m %>>
            <input type="hidden" name=question value="<%=g.getQuestion()%>">
           
            <div class="ml-md-3 ml-sm-3 pl-md-5 pt-sm-0 pt-3" id="options">
            
                <label class="options"><%=g.getOption1()%>
                    <input type="radio" name="answer" value="<%=g.getOption1()%>">
                    <span class="checkmark"></span>
                </label>
                <label class="options"><%=g.getOption2() %>
                    <input type="radio" name="answer" value="<%=g.getOption2()%>">
                    <span class="checkmark"></span>
                </label>
                <label class="options"><%=g.getOption3() %>
                    <input type="radio" name="answer" value="<%=g.getOption3()%>">
                    <span class="checkmark"></span>
                </label>
                <label class="options"><%=g.getOption4() %>
                    <input type="radio" name="answer" value="<%=g.getOption4()%>">
                    <span class="checkmark"></span>
                </label>
            </div>
        </div>
        
    <%} %>
    
  <%
    	   }
  %>
       
        <div class="d-flex align-items-center pt-3">
            <div class="ml-auto mr-sm-5">
             
            <button type="submit" class="btn btn-success">Submit</button>
                     
                </div>
        </div>
    </div> 
    </form>
    <%
    	   }catch(Exception e){
    		   out.print(e);
    	   }
    %>
</body>
</html>