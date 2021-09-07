package com.aktios.app.adapters.rest;

import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import com.aktios.app.domain.models.NewsletterSubscription;
import com.aktios.app.domain.services.NewsletterService;
import com.aktios.app.objectmother.ObjectMotherNewsletter;

/**
 * Subscriptions Controller Test.
 * @author juanmafe
 */
@WebMvcTest
@ExtendWith(SpringExtension.class)
class SubscriptionsControllerTest {

	/** URL */
	private static final String URL = "/newsletter/subscriptions";

	/** {@link NewsletterService} newsletterService */
	@MockBean
	private NewsletterService newsletterService;

	/** {@link MockMvc} mockMvc */
	@Autowired
	private MockMvc mockMvc;

	/**
	 * Load mock beans behaviour.
	 */
	@BeforeEach
	void init() {
		Mockito.when(newsletterService.getAll()).thenReturn(ObjectMotherNewsletter.getNewsletterSubscriptionStream());
		Mockito.when(newsletterService.create(Mockito.any(NewsletterSubscription.class))).thenReturn("1L");
		doNothing().when(newsletterService).delete(Mockito.anyString());
	}

	/**
	 * Checks the get all newsletter rest.
	 * @throws Exception
	 */
	@Test
	void getAllSubscriptionsTest() throws Exception {
		mockMvc.perform(get(URL)).andExpect(status().isOk());
	}

	/**
	 * Checks the create newsletter rest.
	 * @throws Exception
	 */
	@Test
	void getCreateSubscriptionsTest() throws Exception {
		mockMvc.perform(post(URL).contentType(MediaType.APPLICATION_JSON)
		.content(ObjectMotherNewsletter.NEWSLETTER_JSON)).andExpect(status().is2xxSuccessful());
	}

	/**
	 * Checks the delete newsletter rest.
	 * @throws Exception
	 */
	@Test
	void getDeleteSubscriptionTest() throws Exception {
		mockMvc.perform(delete(URL + "/1")).andExpect(status().isOk());
	}

}