package com.hand.Util;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBeanFactory {
	private static final BeanFactory context;
	private SpringBeanFactory(){}
	static{
		context=new ClassPathXmlApplicationContext("ApplicationContext.xml");
	}
	public static BeanFactory getBeanFactory(){
		return context;
	}
}
