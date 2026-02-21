package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import exception.DatabaseException;

public class DB {
	private static final String URL = "jdbc:mysql://localhost:3306/public";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "dhelip";

	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(URL, USERNAME, PASSWORD);
		}catch(SQLException e) {
			throw new DatabaseException("Database connection failed", e);
		}
		
	}
}