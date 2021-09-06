package com.aktios.app.adapters.jpa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.beans.BeanUtils;
import com.aktios.app.annotations.ExcludeFromJacocoGeneratedReport;
import com.aktios.app.domain.models.NewsletterFrequency;

/**
 * Newsletter Frequency Entity.
 * @author juanmafe.
 */
@Entity
@Table(name="NEWS_SUBS_FREQ")
@ExcludeFromJacocoGeneratedReport
public class NewsletterFrequencyEntity {

	/** {@link Long} id */
	@Id
	private Long id;

	/** {@link String} name */
	@Column(name="NAME", length=200, nullable=false)
	private String name;

	/** {@link String} description */
	@Column(name="DESCRIPTION", length=200, nullable=false)
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
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
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