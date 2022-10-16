package com.bean;

//public class SQLConnection {
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;

	public class DBConnection {
		private static DBConnection sqlconnection = new DBConnection();
		
		Connection connection;
		
		private DBConnection() {
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant","root","geetha123");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		public static Connection getInstance() {
			return sqlconnection.connection;
			
		}

		public static void main(String[] args) {
			System.out.println(DBConnection.getInstance());

		}

	}
