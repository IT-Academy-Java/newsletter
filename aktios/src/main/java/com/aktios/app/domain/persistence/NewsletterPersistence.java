package com.aktios.app.domain.persistence;

import java.util.stream.Stream;
import com.aktios.app.domain.models.NewsletterSubscription;

/**
 * Newsletter Persistence Layer.
 * @author juanmafe.
 */
public interface NewsletterPersistence {

	/**
	 * Gets all newsletter subscriptions.
	 * @return {@link NewsletterSubscription} {@link Stream}.
	 */
	Stream<NewsletterSubscription> getAll();

	/**
	 * Creates a newsletter subscription.
	 * @param newsletterSubscription {@link NewsletterSubscription} Object.
	 * @return {@link Long}.
	 */
	String save(NewsletterSubscription newsletterSubscription);

	/**
	 * Deletes a newsletter subscription.
	 * @param id {@link String}.
	 */
	void delete(String id);

}