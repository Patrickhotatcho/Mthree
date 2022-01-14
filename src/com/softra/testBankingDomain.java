package com.softra;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testBankingDomain {

	public static void main(String[] args) {
		//ApplicationContext context = new ClassPathXmlApplicationContext("banking-beans.xml");
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		Customer c1 = context.getBean("bs1",Customer.class);
		Customer c3 = context.getBean("bs1",Customer.class);
		//Customer c2 = context.getBean("bs2",Customer.class);
		System.out.println(c1);
		//System.out.println(c2);
		System.out.println(c3);
		ConfigurableApplicationContext configctx = (ConfigurableApplicationContext)context;
		configctx.close();

	}

}
