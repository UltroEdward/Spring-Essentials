package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Assert;

import beans.FileWorker;

public class Main {

	public static void main(String[] args) {

		System.out.println("INIT APP..");
		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		System.out.println("..INIT DONE");

		// Getting different beans of one class via different constructors
		FileWorker worker = (FileWorker) context.getBean("zipworker");
		System.out.println("Default constructor " + worker.toString());

		worker = (FileWorker) context.getBean("zipworker_constr_primitives");
		System.out.println("Constructor with primitives " + worker.toString());

		worker = (FileWorker) context.getBean("zipworker_constr_with_object");
		System.out.println("Constructor with primitives and object " + worker.toString());

		worker = (FileWorker) context.getBean("zipworker_constr_with_list");
		System.out.println("Constructor with primitives, obj and List " + worker.toString());

		worker = (FileWorker) context.getBean("zipworker_constr_inherit");
		System.out.println("Default constructor, bean inherited from primitives " + worker.toString());

		// Getting different beans of one class via setters
		worker = (FileWorker) context.getBean("zipworker_setter");
		System.out.println("Setter primitives " + worker.toString());

		worker = (FileWorker) context.getBean("zipworker_setter_object");
		System.out.println("Setter objects " + worker.toString());

		worker = (FileWorker) context.getBean("zipworker_setter_list");
		System.out.println("Setter list " + worker.toString());

		// Getting different beans of one class via factory method
		worker = (FileWorker) context.getBean("zipworker_factory");
		System.out.println("zipworker_factory " + worker.toString());

		// Scope examples
		worker = (FileWorker) context.getBean("zipworker_singleton");
		worker.setCount(666);
		worker.setName("Singleton");
		System.out.println("zipworker_singleton " + worker.toString());
		worker = (FileWorker) context.getBean("zipworker_singleton");
		Assert.isTrue(worker.getName().equals("Singleton"), "As this object is singleton, name should be the same");
		System.out.println("zipworker_singleton " + worker.toString());

		worker = (FileWorker) context.getBean("zipworker_prototype");
		Assert.isTrue(worker.getName() == null, "Prototype is always new");
		System.out.println("zipworker_prototype " + worker.toString());

		// Auto wired examples
		worker = (FileWorker) context.getBean("zipworker_Auto-Wired_ByName");
		System.out.println("Auto-Wired_ByName " + worker.toString());

		worker = (FileWorker) context.getBean("zipworker_Auto-Wired_ByType");
		System.out.println("Auto-Wired_ByType " + worker.toString());

		worker = (FileWorker) context.getBean("zipworker_Auto-Wired_ByConstr");
		System.out.println("Auto-Wired_ByConstr " + worker.toString());
		
		// Spring EL
		worker = (FileWorker) context.getBean("zipworker_SpEL");
		System.out.println("zipworker_SpEL " + worker.toString());
		

		((ClassPathXmlApplicationContext) context).close();
	}
}
