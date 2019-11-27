package com.sp.bdi.test.test1;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class Excute {
	
	public static void main(String[] args) {
		FileSystemResource fsr = new FileSystemResource("src/main/resources/ioc/ioc-1.xml");
		BeanFactory bf = new XmlBeanFactory(fsr);
		
	
		Cat c = (Cat) bf.getBean("c");
		System.out.println(c);
		c.setName("홍철기");
		System.out.println(c);
		c.setAge(11);
		System.out.println(c);
		
		List<Cat> catList = new ArrayList<Cat>();
		catList.add(c);
		catList.add(c);
		System.out.println(catList);
		
		
	}

}
