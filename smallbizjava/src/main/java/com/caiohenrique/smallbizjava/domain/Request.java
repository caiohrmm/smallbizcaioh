package com.caiohenrique.smallbizjava.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.caiohenrique.smallbizjava.domain.dtos.RequestDTO;
import com.caiohenrique.smallbizjava.domain.enums.Priority;
import com.caiohenrique.smallbizjava.domain.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Request implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "opening_date")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime openingDate = LocalDateTime.now();

    @Column(name = "closing_date")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate closingDate;

    @Column
    private Priority priority;

    @Column
    private Status status;

    @Column
    private String title;

    @Column
    private String description;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "technician_id")
    private Technician technician;

    public Request(Priority priority, Status status, String title, String description, Client client,
                   Technician technician) {
        super();
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(LocalDateTime openingDate) {
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
