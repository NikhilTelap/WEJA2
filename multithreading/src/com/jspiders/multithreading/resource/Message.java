package com.jspiders.multithreading.resource;

public class Message {
   private String content;
    private boolean isReady = false;
    public synchronized void setContent(String content) {
    	while (isReady) {
            try { 
            	wait();
            }
            catch (InterruptedException e) { 
            	e.printStackTrace();
            }        }
        this.content = content;   
        isReady = true;
        notifyAll();
    }
    public synchronized String getContent() { 
    	while (!isReady) {
    		
            try {
            	wait();
            } 
            catch (InterruptedException e) {
            	e.printStackTrace();
            }        }
        isReady = false;   
        notifyAll();
        return content;  
        }
}


