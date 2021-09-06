package com.aktios.app.adapters.jpa;

import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.aktios.app.adapters.jpa.daos.NewsletterRepository;
import com.aktios.app.adapters.jpa.entities.NewsletterSubscriptionEntity;
import com.aktios.app.domain.models.NewsletterSubscription;
import com.aktios.app.domain.persistence.NewsletterPersistence;

/**
 * Newsletter Jpa Persistence Layer.
 * @author juanmafe.
 */
@Repository
public class NewsletterJpa implements NewsletterPersistence {

	/** {@link NewsletterRepository} repository */
	@Autowired
	private NewsletterRepository repository;

	@Override
	public Stream<NewsletterSubscription> getAll() {
		return repository.findAll().stream().map(NewsletterSubscriptionEntity::toNewsletterSubscription);
	}

	@Override
	public Long save(NewsletterSubscription newsletterSubscription) {
		return newsletterSubscription != null ? repository.save(new NewsletterSubscriptionEntity(newsletterSubscription)).getId() : -1L;
	}

	@Override
	public void delete(Long id) {
		if (id != null) repository.deleteById(id);
	}

}