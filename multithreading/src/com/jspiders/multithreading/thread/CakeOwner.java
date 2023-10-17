package com.jspiders.multithreading.thread;
import com.jspiders.multithreading.resource.Cake;

public class CakeOwner extends Thread {
private Cake cake;
	
public CakeOwner(Cake cake) {
		this.cake=cake;
	}
	
	@Override
	public void run(){
		cake.bakedCakes(5);
	}

}
