package com.caiohenrique.smallbizjava.domain;

import com.caiohenrique.smallbizjava.domain.dtos.ClientDTO;
import com.caiohenrique.smallbizjava.domain.enums.Profile;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


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

    public Client(ClientDTO clientDTO) {
        this.id = clientDTO.getId();
        this.name = clientDTO.getName();
        this.nin = clientDTO.getNin();
        this.email = clientDTO.getEmail();
        this.password = clientDTO.getPassword();
        this.profiles = clientDTO.getProfiles().stream().map(
                Profile::getId
        ).collect(Collectors.toSet());
        this.createdDate = clientDTO.getCreatedDate();
    }

}
