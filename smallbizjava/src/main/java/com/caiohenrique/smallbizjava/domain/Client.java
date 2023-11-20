package com.caiohenrique.smallbizjava.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.caiohenrique.smallbizjava.domain.enums.Profile;


@Entity
public class Client extends Person {
	
	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy = "client")
	private List<Request> requests = new ArrayList<>();

	
	public Client() {
		super();
		addProfile(Profile.CLIENT);
	}

	public Client(String name, String cpf, String email, String password) {
		super(name, cpf, email, password);
		addProfile(Profile.CLIENT);
	}

	public List<Request> getRequests() {
		return requests;
	}

	public void setRequests(List<Request> requests) {
		this.requests = requests;
	}
	
	
	

}