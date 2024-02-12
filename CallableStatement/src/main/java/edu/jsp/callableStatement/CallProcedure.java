package edu.jsp.callableStatement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class CallProcedure {
	
	public static void main(String[] args) {
		
		try {
			FileInputStream stream = new FileInputStream("src/main/resources/config.properties");
			
			Properties properties = new Properties();
			properties.load(stream);
			
			  Class.forName(properties.getProperty("driverpath"));
			  Connection connection =DriverManager.getConnection(properties.getProperty("dburl"),properties);
			    
			    String sql="call insert_student(?,?,?,?,?,?,?,?)";
			    CallableStatement call=connection.prepareCall(sql);
			    
			    call.setInt(1, 1);
			    call.setString(2, "Tejas");
			    call.setInt(3, 23);
			    call.setInt(4, 8779359);
			    call.setString(5, "tejaszinjad04@gmail.com");
			    call.setInt(6, 89);
			    call.setInt(7, 65);
			    call.setInt(8, 85);
			    
			    
			    if(call.execute()==false) {
			    	System.out.println("Records inserted");
			    }
			    
			    call.close();
			    connection.close();
			    stream.close();
			    
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}catch(IOException e) {
				e.printStackTrace();
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
