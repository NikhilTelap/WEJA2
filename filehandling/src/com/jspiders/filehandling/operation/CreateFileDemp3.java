package com.jspiders.filehandling.operation;

import java.io.File;

public class CreateFileDemp3 {

	public static void main(String[] args) {
		File file = new File("Demo.txt");
		if(file.exists()) {
			System.out.println("File is already exists");
		}
			else {
				try {
					file.createNewFile();
					System.out.println("File is created");
					
				}
				catch (Exception e) {
					System.out.println("File is not created");
				}
			}
		
	}
}
