<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .form-container {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 300px;
        }

        .form-container h2 {
            text-align: center;
        }

        .form-group {
            margin-bottom: 15px;
        }

        .form-group label,
        .form-group select,
        .form-group input {
            display: block;
            width: 100%;
            margin-bottom: 5px;
        }

        .form-group input {
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        .form-group select {
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        .login-btn {
            width: 100%;
            padding: 10px;
            background-color: #3498db;
            border: 0;
            border-radius: 4px;
            color: #fff;
            cursor: pointer;
        }

        .login-btn:hover {
            background-color: #2980b9;
        }
    </style>
  
    
  
    
</head>
<body>

    <div class="form-container">
        <h2>Login</h2>
        <form id="loginForm" action="login_admin_servlet" method="post">
            <div class="form-group">
                <label for="email">Email</label>
                <input type="email" id="email" name="email" placeholder="Enter email">
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input type="password" id="password" name="password" placeholder="Enter password">
            </div>
            <button type="submit" class="login-btn">Login</button>
        </form>
    </div>

</body>
</html>
