package kafkaPubCon.kafkaPubConsumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

	@KafkaListener(topics = "test", groupId = "group.id")
	public void listen(String message) {
	    System.out.println("Received Messasge in group.id: " + message);
	}
}
