package com.caiohenrique.smallbizjava.domain.enums;

public enum Priority {

	LOW(0, "ROLE_LOW", "BAIXA"),
	MEDIUM(1, "ROLE_MEDIUM", "MÉDIA"),
	HIGH(2, "ROLE_HIGH", "ALTA");

	private Integer id;
	private String description;
	private String name;

	private Priority(Integer id, String description, String name) {
		this.id = id;
		this.description = description;
		this.name = name;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
