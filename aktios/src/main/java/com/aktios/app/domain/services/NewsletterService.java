package com.aktios.app.domain.services;

import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aktios.app.domain.models.NewsletterSubscription;
import com.aktios.app.domain.persistence.NewsletterPersistence;
import com.aktios.app.domain.utils.NewsletterUtils;

/**
 * Newsletter Service.
 * @author juanmafe.
 */
@Service
public class NewsletterService {

	/** {@link NewsletterPersistence} persistence */
	@Autowired
	private NewsletterPersistence persistence;

	/**
	 * Gets all subscriptions
	 * @return {@link NewsletterSubscription} {@link Stream}.
	 */
	public Stream<NewsletterSubscription> getAll() {
		return persistence.getAll();
	}

	/**
	 * Creates a newsletter subscription.
	 * @param newsletterSubscription {@link NewsletterSubscription} Object.
	 * @return {@link Long}.
	 */
	public String create(NewsletterSubscription newsletterSubscription) {
		if (NewsletterUtils.checkNewsletterFields(newsletterSubscription)) {
			return persistence.save(newsletterSubscription);
		}
		throw new IllegalArgumentException("Some parameters are invalid");
	}

	/**
	 * Deletes a newsletter subscription.
	 * @param id {@link Long}.
	 */
	public void delete(String id) {
		if (id != null) persistence.delete(id);
	}

}