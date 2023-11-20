package com.caiohenrique.smallbizjava.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.caiohenrique.smallbizjava.domain.enums.Profile;

@Entity(name = "TB_TECHNICIAN")
public class Technician extends Person {

	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy = "technician")
	private List<Request> requests = new ArrayList<>();
	
	public Technician() {
		super();
		addProfile(Profile.TECHNICIAN);
	}

	public Technician(Long id, String name, String cpf, String email, String password) {
		super(id, name, cpf, email, password);
	}

	public List<Request> getRequests() {
		return requests;
	}

	public void setRequests(List<Request> requests) {
		this.requests = requests;
	}
	
	
	
	
	
	

}
