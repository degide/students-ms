<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String message = (String) session.getAttribute("message");
	session.removeAttribute("message");
	String error = (String) session.getAttribute("error");
	session.removeAttribute("error");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Admin Login</title>
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<script src="js/bootstrap.min.js"></script>
</head>
<body>
	<jsp:include page="components/navbar.jsp"></jsp:include>
	<br><br><br>
	<div  class="d-flex flex-row justify-content-center pt-4">
		<form action="AdminController?action=login" method="POST" class="col-10 col-md-6 col-lg-3 border p-4 mt-4 rounded">
			<h3 class="text-center fw-bold">Login</h3>
			<div class="mb-3 mt-3">
			 	<label for="email" class="form-label">Email</label>
			    <input type="email" class="form-control form-control-md py-2" id="email" placeholder="Enter email" name="email" required>
			</div>
			<div class="mb-3">
			    <label for="pwd" class="form-label">Password</label>
			    <input type="password" class="form-control form-control-md py-2" id="pwd" placeholder="Enter password" name="password" required>
			</div>
			<div class="form-check mb-3">
			    <label class="form-check-label fs-6">
			      <input class="form-check-input" type="checkbox" name="remember"> Remember me
			    </label>
			</div>
			<% if(message!=null){ %>
				<div class="py-3 d-flex flex-row justify-content-center">
				  	<p class="text-success"> <%= message %> </p>
				</div>
			<% } %>
			<% if(error!=null){ %>
				<div class="py-3 d-flex flex-row justify-content-center">
				  	<p class="text-danger"> <%= error %> </p>
				</div>
			<% } %>
			<div class="d-flex flex-row justify-content-center">
			  	<button type="submit" class="btn btn-primary">Log In</button>
			</div>
			<div class="mt-4">
				<a class="text-primary fs-6" href="signup.jsp">Don't have account? Sign Up</a>
			</div>
		</form>
	</div>
</body>
</html>