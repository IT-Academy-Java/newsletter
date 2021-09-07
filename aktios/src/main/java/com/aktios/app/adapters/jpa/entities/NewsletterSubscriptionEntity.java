package com.aktios.app.adapters.jpa.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.aktios.app.annotations.ExcludeFromJacocoGeneratedReport;
import com.aktios.app.domain.models.NewsletterSubscription;
import com.mongodb.lang.NonNull;
import com.mongodb.lang.Nullable;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Newsletter Subscription Entity.
 * @author juanmafe.
 */
@Document(collection="NEWS_SUBS")
@ExcludeFromJacocoGeneratedReport
public class NewsletterSubscriptionEntity {


	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;

	/** {@link String} name */
	@Field(name="NAME")
	@NonNull
	private String name;

	/** {@link String} surname */
	@Field(name="SURNAME")
	@NonNull
	private String surname;

	/** {@link LocalDate} birthday */
	@Field(name="BIRTHDAY")
	@Nullable
	private LocalDate birthday;

	/** {@link NewsletterFrequencyEntity} frequency */
	/**@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_NEWS_SUBS_FREQ", nullable=false)*/
	private NewsletterFrequencyEntity frequency;

	/** {@link NewsletterTechnologiesEntity} {@link List} technologies */
	/**@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "NEWS_SUBS_TAGS",
			joinColumns = @JoinColumn(name = "ID_NEWS_SUBS", nullable = false),
			inverseJoinColumns = @JoinColumn(name="ID_NEWS_SUBS_TECH", nullable = false))*/
	private List<NewsletterTechnologiesEntity> technologies;

	/**
	 * Default Constructor.
	 */
	public NewsletterSubscriptionEntity() {}

	/**
	 * Constructor based on {@link NewsletterSubscription} Object.
	 * @param newsletterSubscription {@link NewsletterSubscription} Object.
	 */
	public NewsletterSubscriptionEntity(NewsletterSubscription newsletterSubscription) {
		this.name = newsletterSubscription.getName();
		this.surname = newsletterSubscription.getSurname();
		this.birthday = newsletterSubscription.getBirthday();
		this.frequency = new NewsletterFrequencyEntity(newsletterSubscription.getFrequency());
		this.technologies = newsletterSubscription.getTechnologies().stream().map(NewsletterTechnologiesEntity::new).collect(Collectors.toList());
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
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * @param surname the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * @return the birthday
	 */
	public LocalDate getBirthday() {
		return birthday;
	}

	/**
	 * @param birthday the birthday to set
	 */
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	/**
	 * @return the frequency
	 */
	public NewsletterFrequencyEntity getFrequency() {
		return frequency;
	}

	/**
	 * @param frequency the frequency to set
	 */
	public void setFrequency(NewsletterFrequencyEntity frequency) {
		this.frequency = frequency;
	}

	/**
	 * @return the technologies
	 */
	public List<NewsletterTechnologiesEntity> getTechnologies() {
		return technologies!= null ? new ArrayList<>(technologies) : new ArrayList<>();
	}

	/**
	 * @param technologies the technologies to set
	 */
	public void setTechnologies(List<NewsletterTechnologiesEntity> technologies) {
		this.technologies = technologies != null ? new ArrayList<>(technologies) : new ArrayList<>();
	}

	/**
	 * Turns {@link NewsletterSubscriptionEntity} into {@link NewsletterSubscription};
	 * @return {@link NewsletterSubscription} Object.
	 */
	public NewsletterSubscription toNewsletterSubscription() {
		var newsletterSubscription = new NewsletterSubscription();
		newsletterSubscription.setId(getId());
		newsletterSubscription.setName(getName());
		newsletterSubscription.setSurname(getSurname());
		newsletterSubscription.setBirthday(getBirthday());
		newsletterSubscription.setFrequency(getFrequency().toNewsletterFrequency());
		newsletterSubscription.setTechnologies(getTechnologies().stream().map(NewsletterTechnologiesEntity::toNewsletterTechnologies).collect(Collectors.toList()));
		return newsletterSubscription;
	}

}