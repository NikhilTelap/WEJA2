package com.jspiders.designpatterns.main;

import java.util.Scanner;

import com.jspiders.designpatterns.creational.Beverage;
import com.jspiders.designpatterns.creational.BlackTea;
import com.jspiders.designpatterns.creational.GreenTea;
import com.jspiders.designpatterns.creational.IceTea;
import com.jspiders.designpatterns.creational.NormalTea;

public class TeaFactory {
	private static Beverage beverage;
	
	public static void main(String[] args) {
		
		try {
			factory().order();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Beverage factory() {
		
		System.out.println("1.Normal Tea\n"+
							"2.Black Tea\n"+
							"3.Green Tea\n"+
							"4.Ice Tea");
		
		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		
		switch (choice) {
		case 1: 
				beverage = new NormalTea(); 
				break;
		case 2:
				beverage = new BlackTea();
				break;
		case 3:
				beverage = new GreenTea();
				break;
				
		case 4:
				beverage = new IceTea();
				break;
		default:
			System.out.println("Invalid choice\n "+"No tea ordered");
		}	
		
		return beverage;
		}
	}

	
	


