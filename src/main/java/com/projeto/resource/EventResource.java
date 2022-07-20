package com.projeto.resource;

import java.util.Random;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.event.CreatedProductEvent;
import com.projeto.model.Product;

@RestController
@RequestMapping("/events")
public class EventResource {

	@Autowired
	private ApplicationEventPublisher publisher;

	@PostMapping("publish")
	public ResponseEntity<Product> publishEvent(@RequestBody Product e, HttpServletResponse response) {

		e.setId(new Random().nextLong());

		this.publisher.publishEvent(new CreatedProductEvent(e, response));

		return ResponseEntity.status(HttpStatus.CREATED).body(e);
	}

}
