package com.aktios.app.adapters.jpa.daos;

import com.aktios.app.adapters.jpa.entities.NewsletterSubscriptionEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Newsletter JPA Repository by Spring Data.
 * @author juanmafe.
 */
public interface NewsletterRepository extends MongoRepository<NewsletterSubscriptionEntity, Long> {
    void deleteById(String id);
}