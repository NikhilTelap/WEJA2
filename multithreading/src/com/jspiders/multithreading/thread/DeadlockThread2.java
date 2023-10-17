package com.jspiders.multithreading.thread;

import com.jspiders.multithreading.resource.DeadlockResource;

public class DeadlockThread2 extends Thread{
	DeadlockResource deadlockResource;
	
	public DeadlockThread2(DeadlockResource deadlockResource) {
		this.deadlockResource=deadlockResource;
	}
	
	@Override
	public void run() {
		synchronized (deadlockResource.res2) {
			System.out.println(getName()+"applied lock on "+deadlockResource.res2);
		
		
		synchronized (deadlockResource.res1) {
			System.out.println(getName()+"applied lock on "+deadlockResource.res1);
		}
		System.out.println(getName()+"releades"+deadlockResource.res1);

	}

	System.out.println(getName()+"releades"+deadlockResource.res2);

}

}
