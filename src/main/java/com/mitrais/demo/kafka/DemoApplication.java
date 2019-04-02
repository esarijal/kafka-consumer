package com.mitrais.demo.kafka;

import java.util.concurrent.TimeUnit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws InterruptedException {
		ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);
		
		MessageListener listener = context.getBean(MessageListener.class);
		listener.getLatch().await(10, TimeUnit.SECONDS);
	}

}
