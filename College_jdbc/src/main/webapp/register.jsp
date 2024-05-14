<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <title>User Registration Form</title>
  <style>
    body {
  font-family: Arial, sans-serif;
  margin: 0;
  padding: 20px;
}

h2 {
  text-align: center;
}

.register-form {
  max-width: 400px;
  margin: 0 auto;
  background: #f9f9f9;
  padding: 20px;
  border-radius: 8px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.form-group {
  margin-bottom: 15px;
}

label {
  display: block;
  font-weight: bold;
}

input[type="text"],
input[type="email"],
input[type="password"],
select {
  width: 95%;
  padding: 10px;
  margin-top: 5px;
  margin-bottom: 10px;
  border: 1px solid #ccc;
  border-radius: 4px;
}

.submit-btn {
  width: 100%;
  background-color: #4CAF50;
  color: white;
  padding: 10px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

.submit-btn:hover {
  background-color: #45a049;
}

  </style>
</head>
<body>

<h2>User Registration</h2>

<form action="student_register_servlet" method="post" class="register-form">
  <div class="form-group">
    <label for="fullname">Full Name:</label>
    <input type="text" id="fullname" name="fullname" required>
  </div>

  <div class="form-group">
    <label for="address">Address:</label>
    <input type="text" id="address" name="address" required>
  </div>

  <div class="form-group">
    <label for="email">Email:</label>
    <input type="email" id="email" name="email" required>
  </div>

  <div class="form-group">
    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required>
  </div>

  <div class="form-group">
    <label for="gender">Gender:</label>
    <select id="gender" name="gender" required>
      <option value="male">Male</option>
      <option value="female">Female</option>
      <option value="other">Other</option>
    </select>
  </div>

  <div class="form-group">
    <label for="branch">Branch:</label>
    <select id="branch" name="branch">
      <option value="MCA">MCA</option>
      <option value="BCA">BCA</option>
      <option value="CSE">CSE</option>
      <!-- Add more options as needed -->
    </select>
  </div>
 
  
  <button type="submit" class="submit-btn">Register</button>
</form>

<script>
  function validateForm() {
    var fullname = document.getElementById('fullname').value;
    var address = document.getElementById('address').value;
    var email = document.getElementById('email').value;
    var password = document.getElementById('password').value;

    if (fullname === "" || address === "" || email === "" || password === "") {
      alert("All fields must be filled out");
      return false;
    }

    // Additional validation can be added as needed

    return true;
  }
</script>
</body>
</html>
