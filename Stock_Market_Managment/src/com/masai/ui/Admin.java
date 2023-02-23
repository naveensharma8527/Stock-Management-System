package com.masai.ui;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.masai.dbUtils.DbUtils;
import com.masai.exception.SomeThingWrongException;

public class Admin {
	
	static void displayAdminMenu() {
		System.out.println("1. Register new customer.");
		System.out.println("2. View all the customers.");
		System.out.println("3. Add new stocks.");
		System.out.println("4. View all the stocks.");
		System.out.println("5. View consolidated report of a stock.");
		System.out.println("6. Delete customer");
		System.out.println("7. Delete stock");
		System.out.println("0. for Exit");
	}
	
	public static void isAdmin(String username,String password) {
		Connection con = null;
		try {
			 con = DbUtils.connectToDatabase();
			
			String insertQuery = "select * from broker where b_username = ? && b_password = ?";
			
			PreparedStatement ps = con.prepareStatement(insertQuery);
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if(DbUtils.isResultSetEmpty(rs)) {
				System.out.println("Wrong username or password");
			}else {
				System.out.println("Welcome "+ username);
				displayAdminMenu();
				System.exit(0);
				
			}

			
			
		} catch (SQLException e) {
			
			new SomeThingWrongException();
		} finally {
			try {
				DbUtils.closeConnection(con);
			} catch (SQLException e) {
				
				new SomeThingWrongException();
			}
		}
		
		
	}
	
}
