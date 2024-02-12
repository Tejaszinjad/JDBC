package edu.cls.test.student;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class StudentSelect {
	
	
	public static void main(String[] args) {
		
		RetriveData();

	}
	public static void RetriveData() {
		
		try {
			FileInputStream stream  = new FileInputStream("src/main/resources/student.properties");
			
			Properties properties = new Properties();
			
			properties.load(stream);
			
			Class.forName(properties.getProperty("driverpath"));
			
			Connection connection = DriverManager.getConnection(properties.getProperty("url"),properties);
			
			String query = "select * from student";
			
			Statement statement = connection.createStatement();
			
			ResultSet resultSet = statement.executeQuery(query);
			
			while(resultSet.next()) {
				System.out.println("Id : "+resultSet.getInt(1));
				System.out.println("Name : "+resultSet.getString(2));
				System.out.println("Contact : "+resultSet.getLong(3));
				System.out.println("Age : "+resultSet.getString(4));
			}
			resultSet.close();
			statement.close();
			connection.close();
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}