package com.jspiders.jdbc.dynamic;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

public class DynamicUpdate {
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
			
			query="update student set sname = ? where sid=?";
		
			
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, 2);
			preparedStatement.setString(2, "yuvraj");
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
