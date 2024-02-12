package edu.jsp.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
	
	public static void main(String[] args) {
		String dburl = "jdbc:postgresql://localhost:5432/test";
		String user = "postgres";
		String password = "root";
		
		try {
			Class.forName("org.postgresql.Driver");
			
	//step 2 create connection 3 ways
			Connection connection=DriverManager.getConnection(dburl, user, password);
			
	//step 3 create Statement 3 ways
			Statement statement =  connection.createStatement();
			
			String sql = "SELECT id, name, sal, con"
					+ "	FROM public.\"Employees\";";
			
			ResultSet resultset = statement.executeQuery(sql);
			
			while(resultset.next()) {
				System.out.println("id: "+resultset.getInt(1));
				System.out.println("name: "+resultset.getString(2));
				System.out.println("salary: "+resultset.getInt(3));
				System.out.println("contact: "+resultset.getInt(4));
				}
			
			resultset.close();
			statement.close();
			connection.close();
			
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
			
		 } catch (SQLException e) {
			    e.printStackTrace();
		}
			
			
			

	}

}
