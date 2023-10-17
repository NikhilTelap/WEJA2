package com.jspiders.jdbc.dynamic;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.util.Properties;

public class DynamicInsert {
	private static  Connection connection;
	private static PreparedStatement preparedStatement;
	private static int result;
	private static FileInputStream file;
	private static Properties properties = new Properties();
	private static String filePath="D:\\WEJA2\\jdbc\\resources\\db_info.properties"; 
	private static String query;
	
	public static void main(String[] args) {
		
		try {
			file = new FileInputStream(filePath);
			properties.load(file);
			Class.forName(properties.getProperty("driverpath"));
			
			connection = DriverManager.getConnection(properties.getProperty("dburl"),properties);
			
			query="insert into stud_details values (?,?,?,?)";
			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setInt(1, 6);
			preparedStatement.setString(2, "xyz");
			preparedStatement.setString(3, "xyz@gmail.com");
			preparedStatement.setLong(4, 1234567890);

			
			result = preparedStatement.executeUpdate();
			System.out.println(result+"rows affected");
		}

			catch(Exception e) {
				e.printStackTrace();
			}
			finally {
				try {
					if(connection !=null) {
						connection.close();
					}
					if(preparedStatement !=null) {
						preparedStatement.close();
					}
					if(result !=0) {
						result=0;
					}
					if(file !=null) {
						file.close();
					}
					
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}


