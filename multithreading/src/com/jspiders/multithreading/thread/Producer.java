package com.jspiders.multithreading.thread;
import com.jspiders.multithreading.resource.Message;

public class Producer implements Runnable {
	   private Message message;
	    public Producer(Message message) {
	        this.message = message; 
	        }
	    @Override
	    public void run() {  
	    	String[] messages = {"Message 1", "Message 2", "Message 3"};
	        for (String msg : messages) {
	        	
	            message.setContent(msg);   
	            System.out.println("Produced: " + msg);
	            try {
	                Thread.sleep(1000);   
	                }
	            catch (InterruptedException e) {
	                e.printStackTrace();           
	                }
	        }    }
	}


