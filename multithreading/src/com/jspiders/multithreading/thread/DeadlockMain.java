package com.jspiders.multithreading.thread;

import com.jspiders.multithreading.resource.DeadlockResource;

public class DeadlockMain {
	public static void main(String[] args) {
		DeadlockResource deadlockResource = new DeadlockResource();
		DeadlockThread1 deadlockThread1 = new DeadlockThread1(deadlockResource);
		DeadlockThread2 deadlockThread2 = new DeadlockThread2(deadlockResource);
		
		deadlockThread1.setName("T1");
		deadlockThread1.setName("T2");
		deadlockThread1.start();
		deadlockThread2.start();

		
	}

}
