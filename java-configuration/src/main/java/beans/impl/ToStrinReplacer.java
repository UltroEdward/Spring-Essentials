package beans.impl;

import java.lang.reflect.Method;

import org.springframework.beans.factory.support.MethodReplacer;

public class ToStrinReplacer implements MethodReplacer {

	@Override
	public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
		System.out.println("Replcaing method: " + method.getName());
		System.out.println("NEW FUNCTIONALITY");
		return "Replcaed value: " + obj.getClass();
	}

}
