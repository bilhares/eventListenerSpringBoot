package com.projeto.resource;

import java.util.Random;

import javax.servlet.http.HttpServletResponse;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.projeto.event.CreatedProductEvent;
import com.projeto.model.Product;

@RestController
@RequestMapping("/events")
public class EventResource {

	@Autowired
	private ApplicationEventPublisher publisher;

	@Autowired
	RabbitTemplate template;

	@Value("${spring.rabbitmq.queue}")
	private String queue;

	@PostMapping("publish")
	public ResponseEntity<Product> publishEvent(@RequestBody Product e, HttpServletResponse response) {

		e.setId(new Random().nextLong());

		this.publisher.publishEvent(new CreatedProductEvent(e, response));

		return ResponseEntity.status(HttpStatus.CREATED).body(e);
	}

	@PostMapping("publish-amqp")
	public ResponseEntity<Product> publishEventAmqp(@RequestBody Product e, HttpServletResponse response)
			throws JsonProcessingException {
		e.setId(new Random().nextLong());

		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(e);

		template.convertAndSend(queue, e);

		return ResponseEntity.status(HttpStatus.CREATED).body(e);
	}

}
