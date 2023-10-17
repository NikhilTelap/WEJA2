package com.jspiders.serializationanddeserialization;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serialization {
	public static void main(String[] args) throws IOException {
		File file = new File("Student.txt");
		if(file.exists()) {
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(new Student(1,"Ram","Ram@gmail.com",25));
			System.out.println("Object is written in the object");
			objectOutputStream.close();
			fileOutputStream.close();
			
		}
		else {
			file.createNewFile();
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(new Student(1,"Ram","Ram@gmail.com",25));
			System.out.println("Object is written in the object");
			objectOutputStream.close();
			fileOutputStream.close();
		}
	}

}
