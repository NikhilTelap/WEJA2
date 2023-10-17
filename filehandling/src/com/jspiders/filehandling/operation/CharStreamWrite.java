package com.jspiders.filehandling.operation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CharStreamWrite {
	public static void main(String[] args) throws IOException {
		File file=new File("Demo.txt");
		
		if(file.exists()) {
			FileWriter fileWriter=new FileWriter(file);
			fileWriter.write("data from java file");
			System.out.println("Data is written successfully");
			fileWriter.close();
			}
		else {
			file.createNewFile();
			System.out.println("File is created");
			
			FileWriter fileWriter=new FileWriter(file);
			fileWriter.write("data from java file");
			System.out.println("Data is written successfully");
			fileWriter.close();
		}
	}

}
