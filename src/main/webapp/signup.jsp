<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String error = (String) session.getAttribute("error");
	session.removeAttribute("error");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Admin Signup</title>
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<script src="js/bootstrap.min.js"></script>
</head>
<body>
	<jsp:include page="components/navbar.jsp"></jsp:include>
	<br><br><br>
	<div class="d-flex flex-row justify-content-center pt-4">
		<form action="AdminController?action=register" method="POST" class="col-10 col-md-6 col-lg-3 border p-4 mt-4 rounded">
			<h3 class="text-center fw-bold">Sign Up</h3>
			<div class="mb-3 mt-3">
			 	<label for="firstName" class="form-label">First Name</label>
			    <input type="text" class="form-control form-control-md py-2" id="firstName" name="firstName" required>
			</div>
			<div class="mb-3 mt-3">
			 	<label for="lastName" class="form-label">Last Name</label>
			    <input type="text" class="form-control form-control-md py-2" id="lastName" name="lastName" required>
			</div>
			<div class="mb-3 mt-3">
			 	<label for="email" class="form-label">Email</label>
			    <input type="email" class="form-control form-control-md py-2" id="email" name="email" required>
			</div>
			<div class="mb-3">
			    <label for="pwd" class="form-label">Password</label>
			    <input type="password" class="form-control form-control-md py-2" id="pwd" name="pwd" required>
			</div>
			<div class="mb-3">
			    <label for="cpwd" class="form-label">Confirm Password</label>
			    <input type="password" class="form-control form-control-md py-2" id="cpwd" name="cpwd" required>
			</div>
			<% if(error!=null){ %>
				<div class="py-3 d-flex flex-row justify-content-center">
				  	<p class="text-danger"> <%= error %> </p>
				</div>
			<% } %>
			<div class="d-flex flex-row justify-content-center">
			  	<button type="submit" class="btn btn-primary">Sign Up</button>
			</div>
			<div class="mt-4">
				<a class="text-primary fs-6" href="login.jsp">Do you have an existing account? Login</a>
			</div>
		</form>
	</div>
</body>
</html>