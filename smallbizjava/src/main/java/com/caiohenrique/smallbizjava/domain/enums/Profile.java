package com.caiohenrique.smallbizjava.domain.enums;

public enum Profile {

	ADMIN(0, "ROLE_ADMIN"), CLIENT(1, "ROLE_CLIENT"), TECHNICIAN(2, "ROLE_TECHNICIAN");
	
	private Integer id;
	private String description;
	
	
	private Profile(Integer id, String description) {
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
	
	public static Profile toEnum(Integer id) {
		
		if (id == null) return null;
	
		for (Profile perfil : Profile.values()) {
			
			if (id.equals(perfil.getId())) {
				return perfil;
			}
			
		}
		
		throw new IllegalArgumentException("Invalid Profile");
		
		
	}
	
	
	
	
	
}
