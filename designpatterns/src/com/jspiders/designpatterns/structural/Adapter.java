package com.jspiders.designpatterns.structural;

public class Adapter extends Employee implements Event {

	@Override
	public void womensDay(Adapter adapter) {
		adapter.setId(1);
		adapter.setName("radha");
		adapter.setEmail("radha@gmail.com");
		
		System.out.println("Chief guest for womens day is "+adapter.getName());
	}

	@Override
	public void mensDay(Adapter adapter) {
		adapter.setId(1);
		adapter.setName("Ramesh");
		adapter.setEmail("ramesh@gmail.com");
		
		System.out.println("Chief guest for mens day is "+adapter.getName());

	}

	
}
