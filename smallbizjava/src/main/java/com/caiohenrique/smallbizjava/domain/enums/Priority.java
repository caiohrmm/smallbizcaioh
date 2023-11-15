package com.caiohenrique.smallbizjava.domain.enums;

public enum Priority {

	LOW(0, "ROLE_LOW"), MEDIUM(1, "ROLE_MEDIUM"), HIGH(2, "ROLE_HIGH");

	private Integer id;
	private String description;

	private Priority(Integer id, String description) {
		this.id = id;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public static Priority toEnum(Integer id) {

		if (id == null)
			return null;

		for (Priority priority : Priority.values()) {

			if (id.equals(priority.getId())) {
				return priority;
			}

		}

		throw new IllegalArgumentException("Invalid Priority");

	}

}
