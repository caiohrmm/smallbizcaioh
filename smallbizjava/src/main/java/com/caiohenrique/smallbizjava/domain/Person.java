package com.caiohenrique.smallbizjava.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.Generated;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.caiohenrique.smallbizjava.domain.enums.Profile;
import com.fasterxml.jackson.annotation.JsonFormat;

/* this abstract class uses protected attributes for inheritance purposes. */

@Entity(name = "TB_PERSON")
public abstract class Person implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	
	@Column
	protected String name;
	
	@Column(unique = true)
	protected String nin;
	
	@Column(unique = true)
	protected String email;
	
	@Column
	protected String password;
	
	/* Whenever I search for a user it will bring all their associated profiles */
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "profiles")
	protected Set<Integer> profiles = new HashSet<>();
	
	@Column(name = "created_date")
	@JsonFormat(pattern = "dd/MM/yyyy")
	protected LocalDate createdDate = LocalDate.now();
	
	public Person() {
		super();
		addProfile(Profile.CLIENT);
	}

	public Person(Long id, String name, String nin, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.nin = nin;
		this.email = email;
		this.password = password;
		addProfile(Profile.CLIENT);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNin() {
		return nin;
	}

	public void setNin(String nin) {
		this.nin = nin;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Profile> getProfiles() {
		return profiles.stream().map(profile -> Profile.toEnum(profile)).collect(Collectors.toSet());
	}

	public void addProfile(Profile profile) {
		this.profiles.add(profile.getId());
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(createdDate, email, id, name, nin, password, profiles);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(createdDate, other.createdDate) && Objects.equals(email, other.email)
				&& Objects.equals(id, other.id) && Objects.equals(name, other.name) && Objects.equals(nin, other.nin)
				&& Objects.equals(password, other.password) && Objects.equals(profiles, other.profiles);
	}

	
	
	
	
	
	
	
	
	
	
	
}
