package com.aktios.app.adapters.jpa.entities;

import com.mongodb.lang.NonNull;
import org.springframework.beans.BeanUtils;
import com.aktios.app.annotations.ExcludeFromJacocoGeneratedReport;
import com.aktios.app.domain.models.NewsletterFrequency;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;


@Document(collection = "NEWS_SUBS_FREQ")
@ExcludeFromJacocoGeneratedReport
public class NewsletterFrequencyEntity {

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

	/**
	 * Default Constructor.
	 */
	public NewsletterFrequencyEntity() {}

	/**
	 * Constructor based on {@link NewsletterFrequency} Object.
	 * @param newsletterFrequency {@link NewsletterFrequency} Object.
	 */
	public NewsletterFrequencyEntity(NewsletterFrequency newsletterFrequency) {
		this.id = newsletterFrequency.getId();
		this.name = newsletterFrequency.getName();
		this.description = newsletterFrequency.getDescription();
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
	 * Turns {@link NewsletterFrequencyEntity} into {@link NewsletterFrequency};
	 * @return {@link NewsletterFrequency} Object.
	 */
	public NewsletterFrequency toNewsletterFrequency() {
		var newsletterFrequency = new NewsletterFrequency();
		BeanUtils.copyProperties(this, newsletterFrequency);
		return newsletterFrequency;
	}

}