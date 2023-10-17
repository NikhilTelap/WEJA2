package com.jspiders.multithreading.resource;

public class Pizza {
	
	private  int avilablePizza;
	public synchronized void orderPizza(int orderedPizza) {
		
		System.out.println("Trying to order"+orderedPizza+"pizzas");
		if(avilablePizza<orderedPizza) {
			System.out.println(orderedPizza+"pizzas are not avilable please wait!!");
			try {
				this.wait();
				
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			
		}
		avilablePizza-=orderedPizza;
		
		System.out.println(orderedPizza+"pizzas delivered");
		System.out.println(avilablePizza+"pizzas avilable");
		
		
	}
	
	public synchronized void bakePizza(int bakePizza) {
		System.out.println("Baking"+bakePizza+"pizzas");
		avilablePizza+=bakePizza;
		System.out.println(bakePizza+"Pizzas baked");
		System.out.println(avilablePizza+"pizzas avilable");
		this.notify();
	}
		
	
}



