package com.jspiders.multithreading.main;
import com.jspiders.multithreading.resource.Cake;
import com.jspiders.multithreading.thread.Customer1;
import com.jspiders.multithreading.thread.Customer2;
import com.jspiders.multithreading.thread.CakeOwner;

class CakeMain{
	public static void main(String[] args) {
		
		Cake cake = new Cake();
		Customer1 customer1 = new Customer1(cake);
		Customer2 customer2 = new Customer2(cake);
		CakeOwner cakeowner = new CakeOwner(cake) ;
		
		customer1.start();
		customer2.start();
		cakeowner.start();
		
		
	}

}
