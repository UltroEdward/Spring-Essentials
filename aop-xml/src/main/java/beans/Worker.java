package beans;

import java.util.Arrays;

import org.springframework.stereotype.Component;

@Component
public class Worker {

	public void doJob() {
		for (int i = 0; i < 100; i++) {
			int n = 99 * i;
		}
		System.out.println("done");
	}

	public void printWord(String word) {
		Arrays.asList(word).stream().forEach(e -> System.out.println(e));
	}

}
