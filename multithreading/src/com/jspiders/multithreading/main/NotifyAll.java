package com.jspiders.multithreading.main;
import com.jspiders.multithreading.resource.Message;
import com.jspiders.multithreading.thread.Producer;
import com.jspiders.multithreading.thread.Consumer;

public class NotifyAll {
	public class NotifyAllDemo {    public static void main(String[] args) {
        Message message = new Message();
        Thread producerThread = new Thread(new Producer(message)); 
        Thread consumerThread = new Thread(new Consumer(message));
        producerThread.start();
        consumerThread.start();    
         }
}

}
