package events;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class EventListener implements ApplicationListener<CustomEvent> {

	public void onApplicationEvent(CustomEvent event) {
		System.out.println("Receiving event: " + event.getMessage() );
	}

}
