package com.caiohenrique.smallbizjava.domain.dtos;

import com.caiohenrique.smallbizjava.domain.Client;
import com.caiohenrique.smallbizjava.domain.enums.Profile;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotNull;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class ClientDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    protected Long id;
    @NotNull(message = "O campo nome é obrigatório!")
    protected String name;
    @NotNull(message = "O campo CPF é obrigatório!")
    @CPF
    protected String nin;
    @NotNull(message = "O campo email é obrigatório!")
    protected String email;
    @NotNull(message = "O campo senha é obrigatório!")
    protected String password;
    protected Set<Integer> profiles = new HashSet<>();
    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDate createdDate = LocalDate.now();

    public ClientDTO(Client client) {
        this.id = client.getId();
        this.name = client.getName();
        this.nin = client.getNin();
        this.email = client.getEmail();
        this.password = client.getPassword();
        this.profiles = client.getProfiles().stream().map(
                Profile::getId
        ).collect(Collectors.toSet());
        this.createdDate = client.getCreatedDate();
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
        return profiles.stream().map(Profile::toEnum).collect(Collectors.toSet());
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientDTO clientDTO = (ClientDTO) o;
        return Objects.equals(id, clientDTO.id) && Objects.equals(name, clientDTO.name) && Objects.equals(nin, clientDTO.nin) && Objects.equals(email, clientDTO.email) && Objects.equals(password, clientDTO.password) && Objects.equals(profiles, clientDTO.profiles) && Objects.equals(createdDate, clientDTO.createdDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, nin, email, password, profiles, createdDate);
    }
}
