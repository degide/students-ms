package com.egide.services;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.egide.dao.AdminDao;
import com.egide.models.Admin;

public class AdminService extends AdminDao {
	public void userLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String rememberUser = request.getParameter("remember");
		
		Admin admin = getAdminByEmail(email);
		if(admin==null) {
			session.setAttribute("error", "Invalid email or password!");
			response.sendRedirect("login.jsp");
			return;
		}
		
		if(!admin.getPassword().equals(password)) {
			session.setAttribute("error", "Invalid email or password!");
			response.sendRedirect("login.jsp");
			return;
		}
		session.setAttribute("loggedIn", true);
		session.setAttribute("loggedInAdmin", admin.getId());
		response.sendRedirect("index.jsp");
	}
	
	public void userRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		String cpwd = request.getParameter("cpwd");
		
		if(!pwd.equals(cpwd)) {
			session.setAttribute("error", "Passwords don't match");
			response.sendRedirect("signup.jsp");
			return;
		}
		
		Admin existingAdmin = getAdminByEmail(email);
		if(existingAdmin.getEmail()!=null) {
			session.setAttribute("error", "Email already taken!");
			response.sendRedirect("signup.jsp");
			return;
		}
			
		Admin admin = new Admin();
		admin.setFirstName(request.getParameter("firstName"));
		admin.setLastName(request.getParameter("lastName"));
		admin.setEmail(email);
		admin.setPassword(pwd);
		
		int created = createAdmin(admin);
		
		if(created==1) {
			session.setAttribute("message", "Account created!");
			response.sendRedirect("login.jsp");
			return;
		}else {
			session.setAttribute("error", "Failed to create account!");
			response.sendRedirect("signup.jsp");
			return;
		}
	}
}
