package postprocessors;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class BeanInfoBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println(String.format("BeanFactoryPostProcessor.postProcessBeanFactory {%s}: Bean definition count: %d", this.getClass().getSimpleName(), beanFactory.getBeanDefinitionCount()));
	}

}
