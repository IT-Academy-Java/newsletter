package com.aktios.app.adapters.jpa;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.aktios.app.adapters.jpa.daos.NewsletterRepository;
import com.aktios.app.adapters.jpa.entities.NewsletterSubscriptionEntity;
import com.aktios.app.objectmother.ObjectMotherNewsletter;
import com.aktios.app.objectmother.ObjectMotherNewsletterEntity;

/**
 * Newsletter Jpa Test.
 * @author juanmafe
 */
@SpringBootTest
@ExtendWith(SpringExtension.class)
class NewsletterJpaTest {

	/** {@link NewsletterJpa} newsletterJpa */
	@Autowired
	private NewsletterJpa newsletterJpa;

	/** {@link NewsletterJpa} newsletterJpaForVoids */
	@Mock
	private NewsletterJpa newsletterJpaForVoids;

	/** {@link NewsletterRepository} repository */
	@MockBean
	private NewsletterRepository repository;

	/**
	 * Load mock beans behaviour.
	 */
	@BeforeEach
	void init() {
		Mockito.when(repository.findAll()).thenReturn(ObjectMotherNewsletterEntity.getNewsletterSubscriptionEntityList());
		Mockito.when(repository.save(Mockito.any(NewsletterSubscriptionEntity.class))).thenReturn(ObjectMotherNewsletterEntity.getNewsletterSubscriptionEntity());
		doNothing().when(repository).deleteById(Mockito.anyLong());
	}

	/**
	 * Checks the get all newsletter service.
	 */
	@Test
	void getAllNewsletterSubscriptionsTest() {
		assertThat(newsletterJpa.getAll()).isNotEmpty().anyMatch(ns -> ns.getName().equals("Juan"));
	}

	/**
	 * Checks the create newsletter service.
	 */
	@Test
	void createNewsletterSubscriptionTest() {
		assertThat(newsletterJpa.save(ObjectMotherNewsletter.getNewsletterSubscription())).isEqualTo(1L);
		assertThat(newsletterJpa.save(null)).isEqualTo(-1L);
	}

	/**
	 * Checks the delete newsletter service.
	 */
	@Test
	void deleteNewsletterSubscriptionTest() {
		newsletterJpaForVoids.delete(1L);
		verify(newsletterJpaForVoids, times(1)).delete(1L);
		newsletterJpaForVoids.delete(null);
		verify(newsletterJpaForVoids, times(1)).delete(null);
	}

}