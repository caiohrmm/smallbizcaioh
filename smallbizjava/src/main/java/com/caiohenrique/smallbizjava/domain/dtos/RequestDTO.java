package com.caiohenrique.smallbizjava.domain.dtos;

import com.caiohenrique.smallbizjava.domain.Request;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class RequestDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime openingDate = LocalDateTime.now();

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDate closingDate;

    private String priorityName;

    private Integer priority;

    private String statusName;

    private Integer status;

    private String title;

    private String description;

    private Long client;

    private Long technician;

    private String clientName;

    private String technicianName;

    public RequestDTO(Request request) {
        this.id = request.getId();
        this.openingDate = request.getOpeningDate();
        this.closingDate = request.getClosingDate();
        this.priorityName = request.getPriority().name();
        this.priority = request.getPriority().getId();
        this.statusName = request.getStatus().name();
        this.status = request.getStatus().getId();
        this.title = request.getTitle();
        this.description = request.getDescription();
        this.client = request.getClient().getId();
        this.technician = request.getTechnician().getId();
        this.technicianName = request.getTechnician().getName();
        this.clientName = request.getClient().getName();
    }

    public RequestDTO() {
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

    public String getPriorityName() {
        return priorityName;
    }

    public void setPriorityName(String priorityName) {
        this.priorityName = priorityName;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
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

    public Long getClient() {
        return client;
    }

    public void setClient(Long client) {
        this.client = client;
    }

    public Long getTechnician() {
        return technician;
    }

    public void setTechnician(Long technician) {
        this.technician = technician;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getTechnicianName() {
        return technicianName;
    }

    public void setTechnicianName(String technicianName) {
        this.technicianName = technicianName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestDTO that = (RequestDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(openingDate, that.openingDate) && Objects.equals(closingDate, that.closingDate) && Objects.equals(priorityName, that.priorityName) && Objects.equals(priority, that.priority) && Objects.equals(statusName, that.statusName) && Objects.equals(status, that.status) && Objects.equals(title, that.title) && Objects.equals(description, that.description) && Objects.equals(client, that.client) && Objects.equals(technician, that.technician) && Objects.equals(clientName, that.clientName) && Objects.equals(technicianName, that.technicianName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, openingDate, closingDate, priorityName, priority, statusName, status, title, description, client, technician, clientName, technicianName);
    }
}
