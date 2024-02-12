package edu.jsp.callableStatement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class Function {

	public static void main(String[] args) {
		try {
			FileInputStream stream =new FileInputStream("src/main/resources/config.properties");
			Properties properties = new Properties();
			properties.load(stream);
			
		    Class.forName(properties.getProperty("driverpath"));
		    Connection connection =DriverManager.getConnection(properties.getProperty("dburl"),properties);
		    String sql="select count_by_gender(?)";
		    CallableStatement call=connection.prepareCall(sql);
		    call.setString(1, "male");
		  
		    ResultSet rs=call.executeQuery();
		    rs.next();
		    int count = rs.getInt(1);
		    System.out.println(count + " no of male teachers");

		    rs.close();
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