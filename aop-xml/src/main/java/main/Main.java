package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import beans.Worker;

public class Main {

	public static void main(String[] args) {

		System.out.println("INIT APP..");
		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		System.out.println("..INIT DONE");

		Worker worker = context.getBean(Worker.class);
		worker.doJob();
		worker.printWord("heLlo");

		((ClassPathXmlApplicationContext) context).close();
	}
}
