package com.jspiders.filehandling.operation;

import java.io.File;

public class CreateFileDemo2 {

	public static void main(String[] args) {
		File file = new File("Demo.txt");

		try {
			file.createNewFile();
			System.out.println("File is created");
		
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("File not created");
		}
	
	}
}
