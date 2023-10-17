package com.jspiders.multithreading.thread;
import com.jspiders.multithreading.resource.Cake;

public class Customer2 extends Thread{
	
	private Cake cake;
	
	public Customer2(Cake cake) {
		this.cake=cake;
	}
	
	@Override
	public void run(){
		cake.orderedCakes(3);
	}

}
