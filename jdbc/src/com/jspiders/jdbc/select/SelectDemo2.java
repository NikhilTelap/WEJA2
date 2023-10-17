package com.jspiders.jdbc.select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectDemo2 {
	
	private static Connection connection;
	private static ResultSet resultSet;
	private static Statement statement;
	private static String driverPath = "com.mysql:cj:jdbc:Driver";
	private static String dburl="jdbc:mysql://locatlost:3306/weja2?user=root&password=root";
	private static String query;
	
	public static void main(String[] args) {
		try {
				Class.forName(driverPath);
				
				connection=DriverManager.getConnection(dburl);
				
				statement=connection.createStatement();
				
				query="select * from student";
				resultSet=statement.executeQuery(query);
				
				while(resultSet.next()) {
					System.out.println(resultSet.getString(1)+"||"+
										resultSet.getString(2)+"||"+
										resultSet.getString(3)+"||"+
										resultSet.getString(4)+"||");
				}
				
				
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(connection !=null) {
					connection.close();
				}
				if(statement != null) {
					statement.close();
				}
				if(resultSet !=null) {
					resultSet.close();
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		}
	}
}
	


