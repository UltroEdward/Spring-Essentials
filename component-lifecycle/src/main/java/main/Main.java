package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import beans.Prototype;
import beans.Singleton;
import beans.SingletonLazy;

public class Main {

	public static void main(String[] args) {

		System.out.println("INIT APP..");
		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		System.out.println("..INIT DONE");

		System.out.println(context.getBean(Singleton.class));
		System.out.println(context.getBean(Prototype.class));
		System.out.println(context.getBean(SingletonLazy.class));
		((ClassPathXmlApplicationContext) context).close();
	}

}
