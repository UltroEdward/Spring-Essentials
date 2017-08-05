package beans;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Component
public class Aspect {

	public void doWorkBefore() {
		System.out.println("[Aspect] work before method");
	}

	public void doWorkBeforeAndAfter(ProceedingJoinPoint joinpoint) throws Throwable {
		long start = System.currentTimeMillis();
		joinpoint.proceed();
		System.out.println("[Aspect] work around, execution took " + (System.currentTimeMillis() - start) + " milliseconds.");
	}
	
	public void intercepter(String word){
		System.out.println("[Aspect] intercepted varaible: " + word);
	}

}
