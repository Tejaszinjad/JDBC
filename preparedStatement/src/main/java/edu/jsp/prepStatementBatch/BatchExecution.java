package edu.jsp.prepStatementBatch;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class BatchExecution {
	
	public static void main(String[] args) {
		try {
			FileInputStream stream = new FileInputStream("src/main/resources/student.properties");
			Properties properties = new Properties();
			
			properties.load(stream);
			
			//step1 
			Class.forName(properties.getProperty("driverpath"));
			
			//step2
			Connection connection = DriverManager.getConnection(properties.getProperty("url"),properties);
			
			//step3
			PreparedStatement statement = connection.prepareStatement("insert into teacher values(?,?,?,?);");
			
			statement.setInt(1,2);
			statement.setString(2, "divya");
			statement.setString(3, "female");
			statement.setInt(4, 25);
			
			statement.addBatch();
			

			statement.setInt(1,3);
			statement.setString(2, "Akshada");
			statement.setString(3, "female");
			statement.setInt(4, 23);
			
			statement.addBatch();
			

			statement.setInt(1,4);
			statement.setString(2, "Shubham");
			statement.setString(3, "male");
			statement.setInt(4, 25);
			
			statement.addBatch();
			

			statement.setInt(1,5);
			statement.setString(2, "Jayshree");
			statement.setString(3, "female");
			statement.setInt(4, 25);
			
			statement.addBatch();
			
			//step4
			int[]results=statement.executeBatch();
			
			for(int i=0; i<results.length;i++) {
				System.out.println(results[i]+ " no of rows affected by "+i+1);
			}
			//step5
			statement.close();
			connection.close();
			stream.close();
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {  
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

