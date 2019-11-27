package com.sp.bdi.test.test2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Execute {
	
	public static void main(String[] args) {
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("ioc/ioc-2.xml");
		//Car c =(Car) ac.getBean("car");
		//System.out.println(c);
		////Car(carName=소나타, price=null)
		CarMaker cm= (CarMaker) ac.getBean("carMaker");
		//System.out.println(cm);
		//CarMaker [carMakerName=현대, car=null]
		//cm.setCar(c);
		System.out.println(cm.makeCar());
		
	}
}
