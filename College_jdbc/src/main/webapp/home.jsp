<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>College Home Page</title>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <style>
        
body, h1, h2, h3, h4, h5, h6, p, ul {
    margin: 0;
    padding: 0;
}

body {
    font-family: Arial, sans-serif;
    line-height: 1.6;
}
body {
    font-family: Arial, sans-serif;
    line-height: 1.6;
    background-image: url('https://theknowledgereview.com/wp-content/uploads/2020/07/Dr.-D.-Y.-Patil-College-of-Agricultural-Engineering-Technology.jpg');
    background-size: cover;
    background-repeat: no-repeat;
}


.main-content {
    width: 80%;
    margin: 20px auto;
    margin-top: 90px;
    background-color: rgba(255, 255, 255, 0.8); 
    padding: 20px;
}

section {
    margin: 20px 0;
}

footer {
    text-align: center;
    padding: 10px 0;
    background: #333;
    color: #fff;
    position: fixed;
    bottom: 0;
    width: 100%;
}
.navbar{
    margin-top: 100px;
}
.navbar{
      justify-content: space-between;
}
    </style>
</head>
<body>

    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#"></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarNavDropdown">
          <ul class="navbar-nav">
            <li class="nav-item active">
              <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
            </li>

            <li class="nav-item">
              <a class="nav-link" href="#">Features</a>
            </li>

            <li class="nav-item">
              <a class="nav-link" href="#">Pricing</a>
            </li>

            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Registration
              </a>
              <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">  
                <a class="dropdown-item" href="register.jsp">Student</a>
                <a class="dropdown-item" href="registerExaminer.jsp">Examiner</a>
              </div>
            </li>
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Login
              </a>
              <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                <a class="dropdown-item" href="LoginAdmin.jsp">Admin</a>
                <a class="dropdown-item" href="Login.jsp">Student</a>
                <a class="dropdown-item" href="LoginExaminer.jsp">Examiner</a>
              </div>
            </li>
          </ul>
        </div>
      </nav>

    <div class="main-content">
        <section id="home">
            <h1>Welcome to Our College</h1>
            <p>Welcome to our college's website. Here you can find information about our programs, faculty, and more.</p>
        </section>

        <section id="about">
            <h2>About Our College</h2>
            <p>Provide a brief description of the college, its history, mission, and values here.</p>
        </section>
    </div>

    <footer>
        <p>&copy; 2023 YourCollege.com</p>
    </footer>

</body>
</html>