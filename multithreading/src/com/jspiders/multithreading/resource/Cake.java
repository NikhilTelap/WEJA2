package com.jspiders.multithreading.resource;

public class Cake {
	
		private int noOfCakes;
	
		public Cake(){
			
			this.noOfCakes=noOfCakes;
		}
		
		
		public synchronized void orderedCakes(int orderedCakes) {
	
		System.out.println("You are trying to order"+orderedCakes+ "cakes");
		if(noOfCakes<orderedCakes) {
			System.out.println(orderedCakes+"Oredred cakes are not avilable please cake!");
			try {
			this.wait();
		}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
		

}
		System.out.println("Your cakes are arrived you can come and collect");
		noOfCakes-=orderedCakes;
		System.out.println("Ordered cakes are delivered");
		}
		
		public synchronized  void bakedCakes(int bakedCakes) {
			System.out.println("Baking "+bakedCakes);
			noOfCakes+=bakedCakes;
			System.out.println(bakedCakes+"baked Cakes avilable");
			System.out.println(noOfCakes+" Cakes avilable");
			notifyAll();
			
		}
}
