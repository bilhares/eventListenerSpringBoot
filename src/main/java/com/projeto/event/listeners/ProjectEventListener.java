package com.projeto.event.listeners;

import java.net.URI;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.projeto.event.CreatedResourceEvent;

@Component
public class ProjectEventListener<K, T> {

	/**
	 * Add location header to every created resource
	 * 
	 * @param event
	 */
	@EventListener
	public void insertHeaderLocation(CreatedResourceEvent<K, T> event) {
		System.out.println("adding loacation header");

		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}").buildAndExpand(event.getId())
				.toUri();
		event.getResponse().setHeader("Location", uri.toASCIIString());

		System.out.println("location header added");
	}
}
