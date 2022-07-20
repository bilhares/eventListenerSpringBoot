package com.projeto.event.listeners;

import java.util.concurrent.TimeUnit;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.projeto.event.CreatedProductEvent;

@Component
public class CreatedProductEventListener {

	@Async
	@EventListener
	public void sendEmailToCustomer(CreatedProductEvent event) {
		try {
			System.out.println("Sending email to customer");

			Thread.sleep(TimeUnit.SECONDS.toMillis(10));

			System.out.println("send email Finished");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Async
	@EventListener
	public void integrateWithPayment(CreatedProductEvent event) {
		try {
			System.out.println("integrating with payment gateway");

			Thread.sleep(TimeUnit.SECONDS.toMillis(10));

			System.out.println("integration Finished");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
