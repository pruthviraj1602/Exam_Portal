<%@page import="com.Entity.arithmaticQuestion"%>
<%@page import="com.Entity.gkquestion"%>
<%@page import="com.Entity.examiner_register"%>
<%@page import="com.Entity.student_register"%>
<%@page import="java.util.List"%>
<%@page import="com.connection.jdbc_conn"%>
<%@page import="com.model.Promodel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%
          student_register user=(student_register) session.getAttribute("std");
    if(user==null){
    	response.sendRedirect("index.jsp");
    }
    %>
<!DOCTYPE html>
<html lang="en">
 
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>GeeksForGeeks</title>
    <style>
       

@import url("https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap");

* {
margin: 0;
padding: 0;
box-sizing: border-box;
font-family: "Poppins", sans-serif;
}
:root {
--background-color1: #fafaff;
--background-color2: #ffffff;
--background-color3: #ededed;
--background-color4: #cad7fda4;
--primary-color: #4b49ac;
--secondary-color: #0c007d;
--Border-color: #3f0097;
--one-use-color: #3f0097;
--two-use-color: #5500cb;
}
body {
background-color: var(--background-color4);
max-width: 100%;
overflow-x: hidden;
}

header {
height: 70px;
width: 100vw;
padding: 0 30px;
background-color: var(--background-color1);
position: fixed;
z-index: 100;
box-shadow: 1px 1px 15px rgba(161, 182, 253, 0.825);
display: flex;
justify-content: space-between;
align-items: center;
}

.logo {
font-size: 27px;
font-weight: 600;
color: rgb(47, 141, 70);
}

.icn {
height: 30px;
}
.menuicn {
cursor: pointer;
}

.searchbar,
.message,
.logosec {
display: flex;
align-items: center;
justify-content: center;
}

.searchbar2 {
display: none;
}

.logosec {
gap: 60px;
}

.searchbar input {
width: 250px;
height: 42px;
border-radius: 50px 0 0 50px;
background-color: var(--background-color3);
padding: 0 20px;
font-size: 15px;
outline: none;
border: none;
}
.searchbtn {
width: 50px;
height: 42px;
display: flex;
align-items: center;
justify-content: center;
border-radius: 0px 50px 50px 0px;
background-color: var(--secondary-color);
cursor: pointer;
}

.message {
gap: 40px;
position: relative;
cursor: pointer;
}
.circle {
height: 7px;
width: 7px;
position: absolute;
background-color: #fa7bb4;
border-radius: 50%;
left: 19px;
top: 8px;
}
.dp {
height: 40px;
width: 40px;
background-color: #626262;
border-radius: 50%;
display: flex;
align-items: center;
justify-content: center;
overflow: hidden;
}
.main-container {
display: flex;
width: 100vw;
position: relative;
top: 70px;
z-index: 1;
}
.dpicn {
height: 42px;
}

.main {
height: calc(100vh - 70px);
width: 100%;
overflow-y: scroll;
overflow-x: hidden;
padding: 40px 30px 30px 30px;
}

.main::-webkit-scrollbar-thumb {
background-image: 
		linear-gradient(to bottom, rgb(0, 0, 85), rgb(0, 0, 50));
}
.main::-webkit-scrollbar {
width: 5px;
}
.main::-webkit-scrollbar-track {
background-color: #9e9e9eb2;
}

.box-container {
display: flex;
justify-content: space-evenly;
align-items: center;
flex-wrap: wrap;
gap: 50px;
}
.nav {
min-height: 91vh;
width: 250px;
background-color: var(--background-color2);
position: absolute;
top: 0px;
left: 00;
box-shadow: 1px 1px 10px rgba(198, 189, 248, 0.825);
display: flex;
flex-direction: column;
justify-content: space-between;
overflow: hidden;
padding: 30px 0 20px 10px;
}
.navcontainer {
height: calc(100vh - 70px);
width: 80px;
position: relative;
overflow-y: scroll;
overflow-x: hidden;
transition: all 0.5s ease-in-out;
}
.navcontainer::-webkit-scrollbar {
display: none;
}
.navclose {
width: 250px;
}
.nav-option {
width: 250px;
height: 60px;
display: flex;
align-items: center;
padding: 0 30px 0 20px;
gap: 20px;
transition: all 0.1s ease-in-out;
}
.nav-option:hover {
border-left: 5px solid #a2a2a2;
background-color: #dadada;
cursor: pointer;
}
.nav-img {
height: 30px;
}

.nav-upper-options {
display: flex;
flex-direction: column;
align-items: center;
gap: 30px;
}

.option1 {
border-left: 5px solid #010058af;
background-color: var(--Border-color);
color: white;
cursor: pointer;
}
.option1:hover {
border-left: 5px solid #010058af;
background-color: var(--Border-color);
}
.box {
height: 130px;
width: 230px;
border-radius: 20px;
box-shadow: 3px 3px 10px rgba(0, 30, 87, 0.751);
padding: 20px;
display: flex;
align-items: center;
justify-content: space-around;
cursor: pointer;
transition: transform 0.3s ease-in-out;
}
.box:hover {
transform: scale(1.08);
}

.box:nth-child(1) {
background-color: var(--one-use-color);
}
.box:nth-child(2) {
background-color: var(--two-use-color);
}
.box:nth-child(3) {
background-color: var(--one-use-color);
}
.box:nth-child(4) {
background-color: var(--two-use-color);
}

.box img {
height: 50px;
}
.box .text {
color: white;
}
.topic {
font-size: 13px;
font-weight: 400;
letter-spacing: 1px;
}

.topic-heading {
font-size: 30px;
letter-spacing: 3px;
}

.report-container {
min-height: 300px;
max-width: 1200px;
margin: 70px auto 0px auto;
background-color: #ffffff;
border-radius: 30px;
box-shadow: 3px 3px 10px rgb(188, 188, 188);
padding: 0px 20px 20px 20px;
}
.report-header {
height: 80px;
width: 100%;
display: flex;
align-items: center;
justify-content: space-between;
padding: 20px 20px 10px 20px;
border-bottom: 2px solid rgba(0, 20, 151, 0.59);
}

.recent-Articles {
font-size: 30px;
font-weight: 600;
color: #5500cb;
}

.view {
height: 35px;
width: 90px;
border-radius: 8px;
background-color: #5500cb;
color: white;
font-size: 15px;
border: none;
cursor: pointer;
}

.report-body {
max-width: 1160px;
overflow-x: auto;
padding: 20px;
}
.report-topic-heading,
.item1 {
width: 1120px;
display: flex;
justify-content: space-between;
align-items: center;
}
.t-op {
font-size: 18px;
letter-spacing: 0px;
}

.items {
width: 1120px;
margin-top: 15px;
}

.item1 {
margin-top: 20px;
}
.t-op-nextlvl {
font-size: 14px;
letter-spacing: 0px;
font-weight: 600;
}

.label-tag {
width: 100px;
text-align: center;
background-color: rgb(0, 177, 0);
color: white;
border-radius: 4px;
}

.nav a{
    text-decoration: none;
    color: black;
}

/* Responsive CSS Here */
@media screen and (max-width: 950px) {
.nav-img {
	height: 25px;
}
.nav-option {
	gap: 30px;
}
.nav-option h3 {
	font-size: 15px;
}
.report-topic-heading,
.item1,
.items {
	width: 800px;
}
}

@media screen and (max-width: 850px) {
.nav-img {
	height: 30px;
}
.nav-option {
	gap: 30px;
}
.nav-option h3 {
	font-size: 20px;
}
.report-topic-heading,
.item1,
.items {
	width: 700px;
}
.navcontainer {
	width: 100vw;
	position: absolute;
	transition: all 0.6s ease-in-out;
	top: 0;
	left: -100vw;
}
.nav {
	width: 100%;
	position: absolute;
}
.navclose {
	left: 00px;
}
.searchbar {
	display: none;
}
.main {
	padding: 40px 30px 30px 30px;
}
.searchbar2 {
	width: 100%;
	display: flex;
	margin: 0 0 40px 0;
	justify-content: center;
}
.searchbar2 input {
	width: 250px;
	height: 42px;
	border-radius: 50px 0 0 50px;
	background-color: var(--background-color3);
	padding: 0 20px;
	font-size: 15px;
	border: 2px solid var(--secondary-color);
}
}

@media screen and (max-width: 490px) {
.message {
	display: none;
}
.logosec {
	width: 100%;
	justify-content: space-between;
}
.logo {
	font-size: 20px;
}
.menuicn {
	height: 25px;
}
.nav-img {
	height: 25px;
}
.nav-option {
	gap: 25px;
}
.nav-option h3 {
	font-size: 12px;
	font-family: 
}
.nav-upper-options {
	gap: 15px;
}
.recent-Articles {
	font-size: 20px;
}
.report-topic-heading,
.item1,
.items {
	width: 550px;
}
}

@media screen and (max-width: 400px) {
.recent-Articles {
	font-size: 17px;
}
.view {
	width: 60px;
	font-size: 10px;
	height: 27px;
}
.report-header {
	height: 60px;
	padding: 10px 10px 5px 10px;
}
.searchbtn img {
	height: 20px;
}
}

@media screen and (max-width: 320px) {
.recent-Articles {
	font-size: 12px;
}
.view {
	width: 50px;
	font-size: 8px;
	height: 27px;
}
.report-header {
	height: 60px;
	padding: 10px 5px 5px 5px;
}
.t-op {
	font-size: 12px;
}
.t-op-nextlvl {
	font-size: 10px;
}
.report-topic-heading,
.item1,
.items {
	width: 300px;
}
.report-body {
	padding: 10px;
}
.label-tag {
	width: 70px;
}
.searchbtn {
	width: 40px;
}
.searchbar2 input {
	width: 180px;
}
}
.report-body table {
    width: 100%;
    border-collapse: collapse;
    margin-top: 20px;
}

.report-body th, .report-body td {
    padding: 12px;
    border: 1px solid #ddd;
    text-align: left;
}

.report-body th {
    background-color: #f2f2f2;
}

.report-body tr:hover {
    background-color: #f5f5f5;
}

    </style>
</head>
 
<body>
   
    <!-- for header part -->
    <header>
 
        <div class="logosec">
            <div class="logo"><%=user.getName() %></div>
            <img src="https://media.geeksforgeeks.org/wp-content/uploads/20221210182541/Untitled-design-(30).png"
                class="icn menuicn"
                id="menuicn"
                alt="menu-icon">
        </div>
 
      
 
        <div class="message">
            <div class="circle"></div>
            <img src="https://media.geeksforgeeks.org/wp-content/uploads/20221210183322/8.png"
                 class="icn"
                 alt="">
            <div class="dp">
              <img src="https://media.geeksforgeeks.org/wp-content/uploads/20221210180014/profile-removebg-preview.png"
                    class="dpicn"
                    alt="dp">
              </div>
        </div>
 
    </header>
 
    <div class="main-container">
        <div class="navcontainer">
            <nav class="nav">
                <div class="nav-upper-options">
                    <div class="nav-option option1">
                        <img src="https://media.geeksforgeeks.org/wp-content/uploads/20221210182148/Untitled-design-(29).png"
                            class="nav-img"
                            alt="dashboard">
                        <h3> Dashboard</h3>
                    </div>
 
                    <div class="option2 nav-option">
                        <img src="https://media.geeksforgeeks.org/wp-content/uploads/20221210183322/9.png"
                            class="nav-img"
                            alt="articles">
                       <a href="StudentExamLOG.jsp"><h3>Exam</h3></a>
                    </div>
 
                   
 
                    
 
                    <div class="nav-option option5">
                     
                        <img src="https://media.geeksforgeeks.org/wp-content/uploads/20221210183323/10.png"
                            class="nav-img"
                            alt="blog">
                            <a href="student_profile.jsp">  <h3> Profile</h3></a>
                        
                    </div>
 
                  
 
                    <div class="nav-option logout">
                        <img src="https://media.geeksforgeeks.org/wp-content/uploads/20221210183321/7.png" class="nav-img" alt="logout">
                      <a href="">  <h3>Logout</h3></a>
                    </div>
 
                </div>
            </nav>
        </div>
        <div class="main">
 
            <div class="searchbar2">
                <input type="text"
                       name=""
                       id=""
                       placeholder="Search">
                <div class="searchbtn">
                  <img src="https://media.geeksforgeeks.org/wp-content/uploads/20221210180758/Untitled-design-(28).png"
                        class="icn srchicn"
                        alt="search-button">
                  </div>
            </div>
 
             <div class="box-container">
         <a href="GKQuestion.jsp">
                <div class="box box1">
                    
                    <div class="text">
                        <h2 class="topic-heading"></h2>
                        <h2 class="topic">GK Questions</h2>

                    </div>
                   
                    <img src="https://media.geeksforgeeks.org/wp-content/uploads/20221210184645/Untitled-design-(31).png"
                        alt="Views">
                </div></a>
 
              <a href="arithmaticQuestion.jsp"> 
                <div class="box box2">
               
                    <div class="text">
                    
                        <h2 class="topic-heading"></h2>
                        <h2 class="topic">Arithmatic Questions</h2>
                        
                        
                    </div>
 
                    <img src="https://media.geeksforgeeks.org/wp-content/uploads/20221210185030/14.png"
                         alt="likes">
                </div></a>
 
             <a href="javaQuestion.jsp">
                 <div class="box box3">
                    <div class="text">
                   
                        <h2 class="topic-heading"></h2>
                        <h2 class="topic">JAVA Questions</h2>
                       
                    </div>
 
                    <img src="https://media.geeksforgeeks.org/wp-content/uploads/20221210184645/Untitled-design-(32).png"
                        alt="comments">
                </div> </a>
 
           <a href="sqlQuestion.jsp">
                <div class="box box4">
                    <div class="text">
                    
                        <h2 class="topic-heading"></h2>
                        <h2 class="topic">SQL Questions</h2>
                       
                    </div>
 
                    <img src="https://media.geeksforgeeks.org/wp-content/uploads/20221210185029/13.png" alt="published">
                </div> </a>
            </div>
 
            <div class="report-container">
                <div class="report-header">
                    <h1 class="recent-Articles">All Student Information</h1>
                </div>
 
                <div class="report-body">
                  <table>
                            <thead>
                                <tr>
                                    <th>Q No.</th>
                                    <th>Question</th>
                                    
                                    
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                <%
                                     try{
                                    	 Promodel pm=new Promodel(jdbc_conn.getConnection());
                                    	List<arithmaticQuestion> li=pm.arithmaticlist();
                                    	
                                    	 int i=0;
                                    	for(arithmaticQuestion a:li){
                                    		i++;
                                    	
                                %>
                                    <td><%=a.getId() %></td>
                                    <td><%=a.getQuestion() %></td>
                                    
                                 
                                </tr>
                                <%}}catch(Exception e){
                                	out.print(e);
                                }%>
                            </tbody>
                        </table>
                </div>
            </div>
        </div>
    </div>
 
    <script>
        let menuicn = document.querySelector(".menuicn");
let nav = document.querySelector(".navcontainer");

menuicn.addEventListener("click", () => {
	nav.classList.toggle("navclose");
})

    </script>
</body>
</html>