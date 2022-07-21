package com.projeto.amqp.consumers;

import java.util.concurrent.TimeUnit;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.projeto.model.ProductDto;

@Component
public class ProductConsumer {

	@RabbitListener(queues = "${spring.rabbitmq.queue}")
	public void consume(@Payload ProductDto product) {
		try {

			System.out.println("Consuming product " + product.getId());

			Thread.sleep(TimeUnit.SECONDS.toMillis(10));

			System.out.println("Consumed " + product.getId());

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
