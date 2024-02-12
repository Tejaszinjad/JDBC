package edu.jsp.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteTest {

	public static void main(String[] args) {  
		String dburl = "jdbc:postgresql://localhost:5432/test";
		String name = "postgres";
		String password = "root";
		
		try {
	//step 1
			Class.forName("org.postgresql.Driver");
			
	//step 2
			Connection connection = DriverManager.getConnection(dburl,name,password);
			
	//step 3
			String sql = "Delete Employees where emp_id=1";
			
			Statement statement = connection.createStatement();
	//step 4
			int result = statement.executeUpdate(sql);
			System.out.println(result + "Rows Deleted.");
	//step 5
			statement.close();
			connection.close();
			
		} catch (ClassNotFoundException e) {
		e.printStackTrace();
		
	    } catch (SQLException e) {
	    e.printStackTrace();
	
	}
}
}
