<%@page import="com.Entity.gkquestion"%>
<%@page import="java.util.List"%>
<%@page import="com.connection.jdbc_conn"%>
<%@page import="com.model.Promodel"%>
<%@page import="com.Entity.student_register"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="styles.css">
  <title>MCQ Quiz</title>
  <style>
    body {
  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
  margin: 0;
  padding: 0;
  display: flex;
  align-items: center;
  justify-content: center;
  height: 100vh;
  background-color: #f0f0f0;
}

.quiz-container {
  background-color: #fff;
  padding: 20px;
  border-radius: 8px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
  width: 400px;
}

h2 {
  text-align: center;
  color: #333;
}

.question {
  margin-bottom: 20px;
}

label {
  display: block;
  margin-bottom: 10px;
  background-color: #f4f4f4;
  padding: 10px;
  border-radius: 4px;
  cursor: pointer;
  transition: background-color 0.3s ease-in-out;
}

label:hover {
  background-color: #e0e0e0;
}

input[type="radio"] {
  margin-right: 8px;
}

button {
  background-color: #3498db;
  color: #fff;
  padding: 10px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  transition: background-color 0.3s ease-in-out;
}

button:hover {
  background-color: #2980b9;
}

  </style>
</head>
<body>

  <div class="quiz-container">
     
    <h2>MCQ Exam</h2>
    <%
       try{
    	   Promodel pm=new Promodel(jdbc_conn.getConnection());
    	   List<gkquestion> li=pm.gklist();
    	   
    	   int i=0;
    	   for(gkquestion g:li){
    		   i++;
    	
    %>
    <form id="quiz-form">
      <div class="question">
        <p><%=g.getQuestion() %></p>
        <label>
          <input type="radio" name="q1" value="a"> a)<%=g.getOption1() %>
        </label>
        <label>
          <input type="radio" name="q1" value="b"> b)<%=g.getOption2() %>
        </label>
        <label>
          <input type="radio" name="q1" value="c"> c)<%=g.getOption3() %>
        </label>
        <label>
          <input type="radio" name="q1" value="c"> c)<%=g.getOption4() %>
        </label>
      </div>

      

      <!-- Add more questions as needed -->

      <button type="button" >Submit</button>
    </form>
    <%
    	   }}catch(Exception e){
    		   out.print(e);
    	   }
    %>
    <div id="result"></div>
  </div>

 
</body>
</html>
