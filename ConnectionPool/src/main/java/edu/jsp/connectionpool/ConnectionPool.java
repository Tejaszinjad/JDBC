package edu.jsp.connectionpool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
	
	private static final int pool_size=5;
	private static List<Connection> connections = new ArrayList<>(); 
	
	private static String dburl="jdbc:postgresql://localhost:5432/jdbc";
	private static String username = "postgres";
	private static String password = "root";
	
	public static Connection createConnection() {
		Connection connection;
		try {
		connection =DriverManager.getConnection(dburl, username, password);
		
		return connection;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	static {
		try {
			Class.forName("org.postgresql.Driver");
			
			for(int i=0;i<pool_size;i++) {
				connections.add(createConnection());
			}
			System.out.println("Connection Added : "+connections.size());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection(){
		if(!connections.isEmpty()) {
			return connections.remove(0);
		}else {
			return createConnection();
		}	
	}
	
	public static void receiveConnection(Connection connection) {
		if(connections.size()<pool_size) {
			connections.add(getConnection());
		}else {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	
}
