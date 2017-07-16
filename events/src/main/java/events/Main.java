package events;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {

		System.out.println("INIT APP..");
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		System.out.println("..INIT DONE");
		
		context.getBean(EventPublisher.class).publish("Hello World!");
		
	}

}
