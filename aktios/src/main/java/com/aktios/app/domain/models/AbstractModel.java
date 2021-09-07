package com.aktios.app.domain.models;

import java.util.Objects;
import com.aktios.app.annotations.ExcludeFromJacocoGeneratedReport;

/**
 * Abstract Model.
 * @author juanmafe.
 */
@ExcludeFromJacocoGeneratedReport
public abstract class AbstractModel {

	/** {@link String} id */
	private String id;

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

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof AbstractModel)) {
			return false;
		}
		AbstractModel other = (AbstractModel) obj;
		return Objects.equals(id, other.id);
	}

}