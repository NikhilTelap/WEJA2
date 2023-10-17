package com.jspiders.designpatterns.creational;

public class ContactMain {
	public static void main(String[] args) {
		Contact contact = new ContactBuilder().lastName("musk").firstName("Elon").getContact();
		System.out.println(contact);
	}

}
