package com.caiohenrique.smallbizjava.domain.enums;

public enum Status {
	
	OPEN(0, "ROLE_OPEN"),
    IN_PROGRESS(1, "ROLE_IN_PROGRESS"),
    CLOSED(2, "ROLE_CLOSED");
	
	private Integer id;
	private String description;
	
	
	private Status(Integer id, String description) {
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
