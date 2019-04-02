package com.mitrais.demo.kafka;

import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {
	@Value(value = "${kafka.topicName}")
    public static String topicName;
	@Value(value = "${kafka.groupId}")
    private String groupId;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	private CountDownLatch latch = new CountDownLatch(3);
	
	@KafkaListener(topics= "${kafka.topicName}", groupId="${kafka.groupId}", containerFactory = "kafkaListenerContainerFactory")
	public void listen(String message) {
		logger.info("Received message in group foo: [" + message + "]");
		latch.countDown();
	}

	public CountDownLatch getLatch() {
		return latch;
	}

}
