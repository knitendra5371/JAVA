package kafkaPC.kafkaProducerConsumer;

import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class KafkaProducerConsumer 
{
    public static void main( String[] args )
    {
    	   // create instance for properties to access producer configs   
        Properties props = new Properties();

        props.put("bootstrap.servers", "localhost:9092");
        props.put("retries", 0);
        props.put("batch.size", 16384);   
        props.put("linger.ms", 1);   
        props.put("buffer.memory", 33554432); 
        props.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");        
        props.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");
        
        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(props);
              
        String topicName="myTopic";
        try {
	        for(int i = 0; i < 10; i++) {
	           producer.send(new ProducerRecord(topicName, Integer.toString(i), Integer.toString(i)));
	           System.out.println("Message sent successfully");
	        }
        }catch(Exception e) {
        	e.printStackTrace();
        }finally{
        	producer.close();
        }
        
        
        
        
        Properties cprops = new Properties();
        
        cprops.put("bootstrap.servers", "localhost:9092");
        cprops.put("group.id", "test");
        cprops.put("enable.auto.commit", "true");
        cprops.put("auto.commit.interval.ms", "1000");
        cprops.put("session.timeout.ms", "30000");
        cprops.put("key.deserializer","org.apache.kafka.common.serialization.StringDeserializer");
        cprops.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(cprops);           
             //Kafka Consumer subscribes list of topics here.
             consumer.subscribe(Arrays.asList(topicName));

             System.out.println("Subscribed to topic " + topicName);
             int i = 0;
             
             try {
            	System.out.println("before getting records..!!");
                ConsumerRecords<String, String> records = consumer.poll(100);
                System.out.println("after getting records..!!");
                for (ConsumerRecord<String, String> record : records)
                
                // print the offset,key and value for the consumer records.
                System.out.printf("offset = %d, key = %s, value = %s\n", 
                   record.offset(), record.key(), record.value());
//             }
             }catch(Exception e) {
            	 e.printStackTrace();
             }finally {
            	 consumer.close();
             }
    }
}
