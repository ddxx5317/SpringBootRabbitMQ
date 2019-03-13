package com.ddxx.mq.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ddxx.mq.config.RabbitMQConfig;

@RestController
public class ProducerController {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@GetMapping("/sendMessage")
	public Object sendMessage() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, RabbitMQConfig.ROUTING_KEY, "value"+i);
				}
			}
		}).start();
		return "ok";
	}
}