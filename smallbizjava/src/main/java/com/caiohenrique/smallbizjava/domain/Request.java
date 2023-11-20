package com.caiohenrique.smallbizjava.domain;

import java.time.LocalDate;
import java.util.Objects;

import com.caiohenrique.smallbizjava.domain.enums.Priority;
import com.caiohenrique.smallbizjava.domain.enums.Status;

public class Request {
	
	private Integer id;
	private LocalDate openingDate = LocalDate.now();
	private LocalDate closingDate;
	private Priority priority;
	private Status status;
	private String title;
	private String description;
	
	private Client client;
	private Technician technician;
	
	public Request(Integer id, Priority priority, Status status, String title, String description, Client client,
			Technician technician) {
		super();
		this.id = id;
		this.priority = priority;
		this.status = status;
		this.title = title;
		this.description = description;
		this.client = client;
		this.technician = technician;
	}

	public Request() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(LocalDate openingDate) {
		this.openingDate = openingDate;
	}

	public LocalDate getClosingDate() {
		return closingDate;
	}

	public void setClosingDate(LocalDate closingDate) {
		this.closingDate = closingDate;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Technician getTechnician() {
		return technician;
	}

	public void setTechnician(Technician technician) {
		this.technician = technician;
	}

	@Override
	public int hashCode() {
		return Objects.hash(client, closingDate, description, id, openingDate, priority, status, technician, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Request other = (Request) obj;
		return Objects.equals(client, other.client) && Objects.equals(closingDate, other.closingDate)
				&& Objects.equals(description, other.description) && Objects.equals(id, other.id)
				&& Objects.equals(openingDate, other.openingDate) && priority == other.priority
				&& status == other.status && Objects.equals(technician, other.technician)
				&& Objects.equals(title, other.title);
	}
	
	
	
	
	
	

}
