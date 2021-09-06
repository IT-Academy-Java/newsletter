package com.aktios.app.adapters.rest;

import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.aktios.app.adapters.dto.NewsletterSubscriptionDto;
import com.aktios.app.domain.models.NewsletterSubscription;
import com.aktios.app.domain.services.NewsletterService;

/**
 * Subscriptions Rest Controller.
 * @author juanmafe.
 */
@RestController
@RequestMapping("/newsletter/subscriptions")
public class SubscriptionsController {

	/** {@link NewsletterService} service */
	@Autowired
	private NewsletterService service;

	/**
	 * Gets all newsletter subscriptions.
	 * @return {@link NewsletterSubscriptionDto} {@link Stream}.
	 */
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public Stream<NewsletterSubscriptionDto> getAllSubscriptions() {
		return service.getAll().map(NewsletterSubscriptionDto::new);
	}

	/**
	 * Creates a newsletter subscription.
	 * @param newsletterSubscription {@link NewsletterSubscription} Object.
	 * @return {@link Long}.
	 */
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public Long createSubscriptions(@RequestBody NewsletterSubscription newsletterSubscription) {
		return service.create(newsletterSubscription);
	}

	/**
	 * Deletes a newsletter subscription.
	 * @param id {@link Long}.
	 */
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteSubscription(@PathVariable("id") Long id) {
		service.delete(id);
	}

}