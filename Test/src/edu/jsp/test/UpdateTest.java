package edu.jsp.test;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UpdateTest {
	
	public static void main(String[] args) {
String dburl="jdbc:postgresql://localhost:5432/test";
		
		String user="postgres";
		
		String password="root";
     
		try {
			Class.forName("org.postgresql.Driver");
			
			Connection connection=DriverManager.getConnection(dburl,user,password);
			
			Statement statement=connection.createStatement();
			
			String query="update  public.\"Employees\" set name='Abhijit' where id=1";
			
			
			int resultset=statement.executeUpdate(query);
			
			System.out.println(resultset+"Rows affected");
			
			statement.close();
			connection.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
				
		

	}

	}


