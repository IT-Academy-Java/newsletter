package com.aktios.app.domain.utils;

import com.aktios.app.domain.models.NewsletterSubscription;

/**
 * Newsletter Utils.
 * @author juanmafe
 */
public final class NewsletterUtils {

	/**
	 * Private Constructor
	 */
	private NewsletterUtils() {}

	/**
	 * Checks newsletter fields.
	 * @param newsletterSubscription {@link NewsletterSubscription} Object.
	 * @return boolean.
	 */
	public static boolean checkNewsletterFields(NewsletterSubscription newsletterSubscription) {
		return newsletterSubscription != null
			&& newsletterSubscription.getName() != null
			&& newsletterSubscription.getSurname() != null
			&& newsletterSubscription.getFrequency() != null
			&& !newsletterSubscription.getTechnologies().isEmpty();
	}

}