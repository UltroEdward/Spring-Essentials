package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import beans.FileWorker;

public class Main {

	public static void main(String[] args) {

		System.out.println("INIT APP..");
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		System.out.println("..INIT DONE");

		FileWorker worker = (FileWorker) context.getBean("fileWorker");
		System.out.println(worker);
		
		worker = (FileWorker) context.getBean("baseWorker");
		System.out.println(worker);
		
		worker = (FileWorker) context.getBean("fileWorkerFull");
		System.out.println(worker);

		 ((AnnotationConfigApplicationContext) context).close();
	}
}
