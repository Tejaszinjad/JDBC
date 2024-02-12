package edu.jsp.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test {
	
	public static void main(String[] args) {
		
		String dburl = "jdbc:postgresql://localhost:5432/test";
		String user = "postgres";
		String password = "root";
		
		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection(dburl, user, password);
			
			System.out.println(connection);
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
