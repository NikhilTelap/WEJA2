package com.jspiders.jdbc.select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectDemo1 {
	public static void main(String[] args) {
		
		try {
			
			//1.Load the driver class
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//2.open Connection
			Connection connectiion = DriverManager.getConnection("jdbc:mysql://localhost:3306/scott?user=root&password=root");
			
			//3.prepare/create statement
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from emp");
			
			//4.process the result
			while(resultSet.next()) {
				System.out.println(resultSet.getString(1)+ " || "
								+  resultSet.getString(2)+ " || "
								+   resultSet.getString(3)+ " || "
								+   resultSet.getString(4));
			}
			
			//5.close connection
			
			connection.close();
			statement.close();
			resultSet.close();
			
					} catch (ClassNotFoundException e) {
			e.printStackTrace();
					}
			catch(SQLException e) {
				e.printStackTrace();
				
			}
		}
	}


