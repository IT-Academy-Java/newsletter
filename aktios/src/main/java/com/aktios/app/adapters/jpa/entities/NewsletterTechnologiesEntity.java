package com.aktios.app.adapters.jpa.entities;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.lang.NonNull;
import org.springframework.beans.BeanUtils;
import com.aktios.app.annotations.ExcludeFromJacocoGeneratedReport;
import com.aktios.app.domain.models.NewsletterTechnologies;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;


@Document(collection = "NEWS_SUBS_TECH")
@ExcludeFromJacocoGeneratedReport
public class NewsletterTechnologiesEntity {

	/** {@link Long} id */
	@MongoId
	private String id;

	/** {@link String} name */
	@Field(name="NAME")
	@NonNull
	private String name;

	/** {@link String} description */
	@Field(name="DESCRIPTION")
	@NonNull
	private String description;

	/** {@link NewsletterSubscriptionEntity} {@link List} newsletter */
	//@ManyToMany(mappedBy = "technologies")
	private List<NewsletterSubscriptionEntity> newsletter;

	/**
	 * Default Constructor.
	 */
	public NewsletterTechnologiesEntity() {}

	/**
	 * Constructor based on {@link NewsletterTechnologies} Object.
	 * @param newsletterTechnologies {@link NewsletterTechnologies} Object.
	 */
	public NewsletterTechnologiesEntity(NewsletterTechnologies newsletterTechnologies) {
		this.id = newsletterTechnologies.getId();
		this.name = newsletterTechnologies.getName();
		this.description = newsletterTechnologies.getDescription();
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the newsletter
	 */
	public List<NewsletterSubscriptionEntity> getNewsletter() {
		return new ArrayList<>(newsletter);
	}

	/**
	 * @param newsletter the newsletter to set
	 */
	public void setNewsletter(List<NewsletterSubscriptionEntity> newsletter) {
		this.newsletter = newsletter != null ? new ArrayList<>(newsletter) : new ArrayList<>();
	}

	/**
	 * Turns {@link NewsletterTechnologiesEntity} into {@link NewsletterTechnologies};
	 * @return {@link NewsletterTechnologies} Object.
	 */
	public NewsletterTechnologies toNewsletterTechnologies() {
		var newsletterTechnologies = new NewsletterTechnologies();
		BeanUtils.copyProperties(this, newsletterTechnologies);
		return newsletterTechnologies;
	}

}