package beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import annotations.UpperCase;

@Component
public class Singleton implements InitializingBean, DisposableBean, BeanNameAware, ApplicationContextAware, BeanFactoryAware   {

	@Value("5")
	private int count;
	@UpperCase
	@Value("HelloWorld")
	private String str;

	public Singleton() {
		System.out.println(this.getClass().getSimpleName() + " :constructor");
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}
	
	@PostConstruct 
	public void postConstract() throws Exception {
		System.out.println(this.getClass().getSimpleName() + " @PostConstruct method");
	}
	
	@PreDestroy 
	public void preDestroy() throws Exception {
		System.out.println(this.getClass().getSimpleName() + " @PreDestroy method");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println(this.getClass().getSimpleName() + " InitializingBean.afterPropertiesSet implementation");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println(this.getClass().getSimpleName() + " DisposableBean.destroy implementation");
	}

	@Override
	public void setBeanName(String name) {
		System.out.println(this.getClass().getSimpleName() + " BeanNameAware.setBeanName method" + "Setting bean name: " + name);
		
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("setApplicationContext");
		
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("setBeanFactory");
		
	}

}
