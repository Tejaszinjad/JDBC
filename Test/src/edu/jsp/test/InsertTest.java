package edu.jsp.test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertTest {
	
	public static void main(String[] args) {  
		String dburl = "jdbc:postgresql://localhost:5432/test";
		String user = "postgres";
		String password = "root";
		
	//step 1 Load and register driver 2 ways 
		try {
			Class.forName("org.postgresql.Driver");
			
	//step 2 create connection 3 ways
			Connection connection=DriverManager.getConnection(dburl, user, password);
			
	//step 3 create Statement 3 ways
			Statement statement =  connection.createStatement();
			
	//step 4 execute query 3 ways
			String query="insert into public.\"Employees\" values(3,'xyz',3000,789)";
			int result = statement.executeUpdate(query);
			System.out.println(result + "Rows affected");
			
	//step 5 close jdbc object
			statement.close();
			connection.close();
			}catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
