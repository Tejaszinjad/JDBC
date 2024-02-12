package edu.jsp.test.student;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class StudentDelete {
	
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		DeleteData();
		scanner.close();
	}
	public static void DeleteData() {
		
		try {
			FileInputStream stream  = new FileInputStream("src/main/resources/student.properties");
			
			Properties properties = new Properties();
			
			properties.load(stream);
			
			Class.forName(properties.getProperty("driverpath"));
			
			Connection connection = DriverManager.getConnection(properties.getProperty("url"),properties);
			
			String query = "delete from student where stu_id = ? ";
			
			PreparedStatement preStatement = connection.prepareStatement(query);
			
			System.out.print("Enter the Id: ");
			preStatement.setInt(1, scanner.nextInt());
						
			int rowsaffected = preStatement.executeUpdate();
			
			if(rowsaffected > 0) {
				System.out.println("Data Deleted!");
			}
			else {
				System.out.println("Something went wrong");
			}
			
			preStatement.close();
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
