package com.caiohenrique.smallbizjava.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.caiohenrique.smallbizjava.domain.dtos.TechnicianDTO;
import com.caiohenrique.smallbizjava.domain.enums.Profile;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Technician extends Person {

    private static final long serialVersionUID = 1L;

    @JsonIgnore
    @OneToMany(mappedBy = "technician")
    private List<Request> requests = new ArrayList<>();

    public Technician() {
        super();
        addProfile(Profile.TECHNICIAN);
    }

    public Technician(String name, String cpf, String email, String password) {
        super(name, cpf, email, password);
        addProfile(Profile.TECHNICIAN);
    }

    public List<Request> getRequests() {
        return requests;
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }

    public Technician(TechnicianDTO technicianDTO) {
        this.id = technicianDTO.getId();
        this.name = technicianDTO.getName();
        this.nin = technicianDTO.getNin();
        this.email = technicianDTO.getEmail();
        this.password = technicianDTO.getPassword();
        this.profiles = technicianDTO.getProfiles().stream().map(
                Profile::getId
        ).collect(Collectors.toSet());
        this.createdDate = technicianDTO.getCreatedDate();
        addProfile(Profile.CLIENT);
    }


}
