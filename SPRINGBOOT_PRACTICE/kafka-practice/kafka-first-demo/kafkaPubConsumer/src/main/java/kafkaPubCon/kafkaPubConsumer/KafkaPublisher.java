package kafkaPubCon.kafkaPubConsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaPublisher {
	
	
	
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	 
	
	
	private String topic="test";
	
	@GetMapping("/publish/{name}")
	public String sendMessage(@PathVariable String name) {
		kafkaTemplate.send(topic,"Hi "+name);
		return "message send Successfully";
	}
	

}
