package edu.jsp.connectionpool;

import java.sql.Connection;

public class PoolTest {
	public static void main(String[] args) {
		Connection connection = ConnectionPool.getConnection();
		System.out.println(connection);
		}

}
