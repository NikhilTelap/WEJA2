package com.jspiders.jdbc.operations;


import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class Operation1 {
	
	private static Connection connection;
	private static Statement ststement;
	private static ResultSet resultSet;
	private static int result;
	private static Properties properties = new Properties();
	private static String filePath = "D:\\WEJA2\\jdbc\\resources\\db_info.properties";
	private static String query;
	private static  FileInputStream file;
	private static 	Scanner scanner = new Scanner(System.in);

	
	
	private static void OpenConnection() {
		try {
			file=new FileInputStream(filePath);
			properties.load(file);
			
			Class.forName(properties.getProperty("driverPath"));
			connection=DriverManager.getConnection(properties.getProperty("dburl"),properties);
			statement=connection.CreateStatement();
			
		}
		catch(Exception e)
	{
		e.printStackTrace();
	}
	
}
	
	private static void CloseConnection() {
		try {
			if(connection !=null) {
				close.connection();
				
			}
			if(statement !=null) {
				close.statement();
			}
			if(resultSet !=null) {
				close.resultSet();
			}
			if(file !=null) {
				file.close();
			}
			if(result !=0) {
				result=0;
			
		}
			}
		catch(Exception e) {
			e.printStackTrace();
		}
	
	}
	
	private static void CreateTable() {
		
		try {
		OpenConnection();
		query="CREATE TABLE emp(empno INT,ename VARCHAR(50) NOT NULL,job VARCHAR(50),mgr VARCHAR(50),hiredate DATE NOT NULL ,sal INT NOT NULL,comm INT,"
				+"PRIMARY KEY(empno)";
		result =executeUpdate(query);
		System.out.println(result+"rows affected");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			CloseConnection();
		}
		
	}
	
	private static void InsertRecords() {
		try {
			OpenConnection();
		
		for(int i=1;i<=14;i++) {
			System.out.println("Enter empid:");
			int empid=scanner.nextInt();
			System.out.println("Enter ename:");
			String ename= scanner.next();
			System.out.println("Enter job:");
			String job= scanner.next();
			System.out.println("Enter mgr:");
			String mgr= scanner.next();
			System.out.println("Enter hiredate in yyyy-mm=dd format:");
			String date= scanner.next();
			System.out.println("Enter salary:");
			long sal= scanner.nextLong();
			System.out.println("Enter comm:");
			long comm= scanner.nextLong();
			
			query="insert into emp("+empid+"','"+ename+"','"+job+"','"+mgr+"','"+date+"',"+sal+","+comm+")";
			
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			CloseConnection();
		}
		
	}
	
	private static void SelectRecords() {
		try {
			OpenConnection();
				query="select * from emp";
		resultSet=statement.executeQuery(query);
		while(resultSet !=null) {
			System.out.println(resultSet.getString(1)+ "||"+
								resultSet.getString(2)+ "||"+
								resultSet.getString(3)+ "||"+
								resultSet.getString(4)+ "||"+
								resultSet.getString(5)+ "||"+
								resultSet.getString(6)+ "||"+
								resultSet.getString(7)+ "||");
			
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			CloseConnection();
		}
		}
	
		public static void UpdateRecords() {
			try {
				OpenConnection();
				System.out.println("Enter id of record you want to udate");
							int id1=scanner.nextInt();
				System.out.println("Enter record details you want to update");	
							String details1=scanner.next();
				System.out.println("Enter updated value");
							String updatedDetails1=scanner.next();
							
					query="UPDATE emp SET (ename,'"+details1+"','"+updatedDetails1+"')"+"where empid="+id1;
					
				result=statement.executeUpdate(query);
				System.out.println(result+"rows affected");
				
				
				System.out.println("Enter id of record you want to udate");
				int id2=scanner.nextInt();
	System.out.println("Enter record details you want to update");	
				String details2=scanner.next();
	System.out.println("Enter updated value");
				String updatedDetails2=scanner.next();
				
		query="UPDATE emp SET (ename,'"+details2+"','"+updatedDetails2+"')"+"where empid="+id2;
		
			result=statement.executeUpdate(query);
				System.out.println(result+"rows affected");
	
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				CloseConnection();
			}
		}
	
		
		private static void DeleteRecords() {
			try {
				OpenConnection();
				System.out.println("Enter id of record you want to delete");
				int id1=scanner.nextInt();
				query="DELETE FROM emp WHERE empno= "+id1;
					result=statement.executeUpdate(query);
				
				
				System.out.println("Enter id of record you want to delete");
				int id2=scanner.nextInt();
				query="DELETE FROM emp WHERE empno"+id2;
				result=statement.executeUpdate(query);
			
	
				System.out.println("Enter id of record you want to delete");
				int id3=scanner.nextInt();
				query="DELETE FROM emp WHERE empno"+id3;
				result=statement.executeUpdate(query);
				
				System.out.println(result+"rows affected");
			} catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				CloseConnection();
			}
		}

		}
		
		
		
	public static void main(String[] args) {
		
		CreateTable();
		InsertRecords();
		SelectRecords();
		UpdateRecords();
		SelectRecords();
		DeleteRecords();
		SelectRecords();
		
		
	}
	
	
}


