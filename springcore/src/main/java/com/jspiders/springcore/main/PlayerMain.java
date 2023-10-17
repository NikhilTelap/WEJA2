package com.jspiders.springcore.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jspiders.springcore.bean.TeamBean;

public class PlayerMain {
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("PlayerTeamConfig.xml");
			
						TeamBean team1 = (TeamBean)context.getBean("team1");
						
						System.out.println(team1);
						
						((ClassPathXmlApplicationContext)context).close();
						
	}

}
