package main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import beans.FileWorker;

@Component
public class Main {

	@Autowired(required = true)
	private FileWorker worker;

	@Autowired(required = false)
	private FileWorker worker1;

	@Autowired
	@Qualifier("zipfileworker")
	private FileWorker worker2;
	
	@Value("1111")
	private int val;
	
	@Value("#{'RANDOM value from SpEL: ' + T(java.lang.Math).random()}")
	private String SpEl;

	public Main() {
		System.out.println("Constructor of Main");
	}

	public static void main(String[] args) {

		System.out.println("INIT APP..");
		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		System.out.println("..INIT DONE");

		// Taking manually bean with main method or can use AutowireCapableBeanFactory
		Main main = context.getBean(Main.class);

		System.out.println("Invoke autowired item not null: " + main.worker.toString());

		System.out.println("Invoke autowired item can be null: " + main.worker1.toString());

		System.out.println("Invoke autowired item qualified by name: " + main.worker2.toString());
		
		System.out.println("Invoke autowired item @value annotation: " + main.val);

		System.out.println("Invoke autowired item @value annotation + SpEL: " + main.SpEl);

		((ClassPathXmlApplicationContext) context).close();
	}

}
