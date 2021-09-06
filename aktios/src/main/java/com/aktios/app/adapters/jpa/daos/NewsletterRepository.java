package com.aktios.app.adapters.jpa.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.aktios.app.adapters.jpa.entities.NewsletterSubscriptionEntity;

/**
 * Newsletter JPA Repository by Spring Data.
 * @author juanmafe.
 */
public interface NewsletterRepository extends JpaRepository<NewsletterSubscriptionEntity, Long> {}