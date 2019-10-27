package com.ocsen.consumer.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class Consumer {
	@Value("${topic-name}")
	private String topicName;

	@KafkaListener(topics = { "kafka-message" })
	public void process(String message, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) List partitions,
			@Header(KafkaHeaders.RECEIVED_TOPIC) List topics, @Header(KafkaHeaders.OFFSET) List offsets) {
		System.out.printf("%s-%d[%d] \"%s\"\n", topics.get(0), partitions.get(0), offsets.get(0), message);
	}
}
