package com.egide.dao;

import java.sql.*;
import java.util.ArrayList;

import com.egide.db.DbConnector;
import com.egide.models.Admin;

public class AdminDao extends DbConnector {
	
	public int createAdmin(Admin admin) {
		try {
			String sql = "INSERT INTO admins(firstName,lastName,email,password) VALUES(?,?,?,?);";
			Connection connection = getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, admin.getFirstName());
			stmt.setString(2, admin.getLastName());
			stmt.setString(3, admin.getEmail());
			stmt.setString(4, admin.getPassword());
			int inserted = stmt.executeUpdate();
			stmt.close();
			return inserted;
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Exception: "+e.getMessage());
			return 0;
		}
	}
	
	public ArrayList<Admin> getAll(){
		try {
			String sql = "SELECT * FROM admins;";
			Connection connection = getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			ArrayList<Admin> admins = new ArrayList<Admin>();
			
			while(rs.next()) {
				Admin admin = new Admin();
				admin.setId(rs.getInt(1));
				admin.setFirstName(rs.getString(2));
				admin.setLastName(rs.getString(3));
				admin.setEmail(rs.getString(4));
				admin.setPassword("");
				admins.add(admin);
			}
			rs.close();
			stmt.close();
			return admins;
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Exception: "+e.getMessage());
			return new ArrayList<Admin>();
		}
	}
	
	public Admin getAdminByEmail(String email) {
		try {
			String sql = "SELECT * FROM admins WHERE email=?;";
			Connection connection = getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, email);
			ResultSet rs = stmt.executeQuery();
			Admin admin = null;
			while(rs.next()) {
				admin = new Admin();
				admin.setId(rs.getInt(1));
				admin.setFirstName(rs.getString(2));
				admin.setLastName(rs.getString(3));
				admin.setEmail(rs.getString(4));
				admin.setPassword(rs.getString(5));
			}
			return admin;
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Exception: "+e.getMessage());
			return null;
		}
	}
	
	public Admin getAdminById(int id) {
		try {
			String sql = "SELECT * FROM admins WHERE id=?;";
			Connection connection = getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			Admin admin = null;
			while(rs.next()) {
				admin = new Admin();
				admin.setId(rs.getInt(1));
				admin.setFirstName(rs.getString(2));
				admin.setLastName(rs.getString(3));
				admin.setEmail(rs.getString(4));
				admin.setPassword(rs.getString(5));
			}
			return admin;
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Exception: "+e.getMessage());
			return null;
		}
	}
	
}
