package com.caiohenrique.smallbizjava.domain.enums;

public enum Status {
	
	OPEN(0, "ROLE_OPEN", "ABERTO"),
    IN_PROGRESS(1, "ROLE_IN_PROGRESS", "EM ANDAMENTO"),
    CLOSED(2, "ROLE_CLOSED", "FECHADO");
	
	private Integer id;
	private String description;
	private String name;
	
	
	private Status(Integer id, String description, String name) {
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

	public static Status toEnum(Integer id) {
		
		if (id == null) return null;
	
		for (Status status : Status.values()) {
			
			if (id.equals(status.getId())) {
				return status;
			}
			
		}
		throw new IllegalArgumentException("Invalid Status");
		
		
	}
	
	
	
	
	
	
	

}
