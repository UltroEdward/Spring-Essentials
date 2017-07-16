package events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class EventPublisher {

	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;

	public void publish(final String message) {
		System.out.println("Publishing custom event: " + message);
		CustomEvent event = new CustomEvent(this, message);
		applicationEventPublisher.publishEvent(event);
	}

}
