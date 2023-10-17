package com.jspiders.multithreading.main;

import com.jspiders.multithreading.thread.MyThread3;

public class ThreadMain3 {

	public static void main(String[] args) {
		MyThread3 myThread3= new MyThread3();
		
		System.out.println("Name of the Thread is:"+myThread3.getName());
		System.out.println("Priority of the Thread is :"+myThread3.getPriority());
	}
}
