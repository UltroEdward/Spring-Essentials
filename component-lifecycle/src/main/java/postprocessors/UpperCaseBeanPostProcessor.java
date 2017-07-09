package postprocessors;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.stream.Collectors;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;

import annotations.UpperCase;

public class UpperCaseBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		Field[] fields = bean.getClass().getDeclaredFields();
		for (Field field : fields) {
			Annotation[] annotations = field.getAnnotations();
			if (annotations != null) {

				System.out.println(String.format("{%s}: Reading annotation in [%s] from field [%s] - [%s]",
						this.getClass().getSimpleName(), bean.getClass().getSimpleName(), field.getName(),
						Arrays.asList(annotations).stream().map(e -> e.toString()).collect(Collectors.toList())));
			}

		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		Field[] fields = bean.getClass().getDeclaredFields();
		for (Field field : fields) {
			UpperCase upperCase = field.getAnnotation(UpperCase.class);
			if (upperCase != null) {
				field.setAccessible(true);
				String value = (String) ReflectionUtils.getField(field, bean);
				if (value != null) {
					System.out.println(String.format(
							"{%s}: Using @UpperCase to change field [%s] with value [%s] in [%s]",
							this.getClass().getSimpleName(), field.getName(), value, bean.getClass().getSimpleName()));
					ReflectionUtils.setField(field, bean, value.toUpperCase());
				}

			}
		}
		return bean;

	}

}
