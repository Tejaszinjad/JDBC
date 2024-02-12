package edu.jsp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.util.Properties;
import java.util.Scanner;

public class StudentInsert {

	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		boolean loop = true;
		
		while(loop) {
			System.out.println("Enter your choice \n"
					+ "1 . Insert\n"
					+ "2 . Exit\n");
			int choice = scanner.nextInt();
			switch(choice) {
				case 1 :{
					insertStudent();
					break;
				}
				case 2 :{
					loop = false;
					try {
						exit();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					scanner.close();
					break;
				}
			}
		}
		
	}
	public static void exit() throws InterruptedException{
		System.out.println("EXITING FROM THE SYSTEM");
		
		int i = 5;
		while(i != 0) {
			System.out.print(".");
				Thread.sleep(450);
				i--;
		}
		System.out.println();
		System.out.println("THANK YOU!");
	}
	
	public static void insertStudent() {
		try {
			
				FileInputStream stream = new FileInputStream("src/main/resources/student.properties");
				
				Properties properties = new Properties();
				
				properties.load(stream);
				
				Class.forName(properties.getProperty("driverpath"));
				
				Connection connection = DriverManager.getConnection(properties.getProperty("url"),properties);
				
				String query = "insert into student (stu_id,stu_name,stu_contact,stu_age) values"
												+ "(?, ? , ? , ?)";
				
				PreparedStatement prepStatement = connection.prepareStatement(query);
				
				System.out.print("Enter the Id: ");
				prepStatement.setInt(1, scanner.nextInt());
				
				System.out.print("Enter your name : ");
				prepStatement.setString(2, scanner.next());
				
				System.out.print("Enter your Contact : ");
				prepStatement.setLong(3, scanner.nextLong());
				
				scanner.nextLine();
				
				System.out.print("Enter your age : ");
				prepStatement.setInt(4, scanner.nextInt());
				scanner.nextLine();
				
				
				int rowsaffected = prepStatement.executeUpdate();
				
				if(rowsaffected > 0) {
					System.out.println("Data inserted! \n");
				}
				else {
					System.out.println("Something went wrong");
				}
			
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
			}catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
}
