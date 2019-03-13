package com.ddxx.mq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.ddxx.mq.config.RabbitMQConfig;

/***
 * 消费者
 */
@Component
public class Consumer {

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void consumeMessage(String message) {
       System.out.println("consume message : " + message);
    }
}
