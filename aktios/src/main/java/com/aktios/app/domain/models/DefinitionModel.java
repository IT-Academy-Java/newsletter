package com.aktios.app.domain.models;

import java.util.Objects;
import com.aktios.app.annotations.ExcludeFromJacocoGeneratedReport;

/**
 * Definition Model.
 * @author juanmafe.
 */
@ExcludeFromJacocoGeneratedReport
public abstract class DefinitionModel extends AbstractModel {

	/** {@link String} name */
	private String name;

	/** {@link String} description */
	private String description;

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

	@Override
	public int hashCode() {
		final var prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(name);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof DefinitionModel)) {
			return false;
		}
		DefinitionModel other = (DefinitionModel) obj;
		return Objects.equals(name, other.name);
	}

}