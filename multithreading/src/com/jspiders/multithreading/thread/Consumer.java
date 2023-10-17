package com.jspiders.multithreading.thread;
import com.jspiders.multithreading.resource.Message;


	public class Consumer implements Runnable { 
		private Message message;
    public Consumer(Message message) {
    	
        this.message = message;  
        }
    @Override
    public void run() { 
    	for (int i = 0; i < 3; i++) {
    		
            String content = message.getContent();  
            System.out.println("Consumed: " + content);
            try {
                Thread.sleep(1000);   
                }
            catch (InterruptedException e) {
                e.printStackTrace();           
                }
        } 
    	}
}

