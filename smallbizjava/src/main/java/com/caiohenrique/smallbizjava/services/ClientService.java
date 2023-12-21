package com.caiohenrique.smallbizjava.services;

import com.caiohenrique.smallbizjava.domain.Client;
import com.caiohenrique.smallbizjava.domain.Person;
import com.caiohenrique.smallbizjava.domain.Technician;
import com.caiohenrique.smallbizjava.domain.dtos.ClientDTO;
import com.caiohenrique.smallbizjava.domain.dtos.TechnicianDTO;
import com.caiohenrique.smallbizjava.exceptions.ObjectNotFoundException;
import com.caiohenrique.smallbizjava.exceptions.handler.BadRequestException;
import com.caiohenrique.smallbizjava.repositories.ClientRepository;
import com.caiohenrique.smallbizjava.repositories.PersonRepository;
import com.caiohenrique.smallbizjava.repositories.TechnicianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private PersonRepository personRepository;

    public Client findById(Long id) {

        Optional<Client> client = clientRepository.findById(id);
        return client.orElseThrow(() -> new ObjectNotFoundException(
                "Cliente não encontrado!"
        ));
    }

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public Client create(ClientDTO clientDTO) {

        clientDTO.setId(null);

        // Valida campos
        validateEssentialFields(clientDTO);

        Client client = new Client(clientDTO);
        return clientRepository.save(client);
    }

    private void validateEssentialFields(ClientDTO clientDTO) {

        Optional<Person> personTech = this.personRepository.findByNin(clientDTO.getNin());

        if (personTech.isPresent() && !Objects.equals(personTech.get().getId(), clientDTO.getId())) {
            throw new BadRequestException("Já existe um cliente cadastrado com esse CPF.");
        }

        personTech = this.personRepository.findByEmail(clientDTO.getEmail());

        if (personTech.isPresent() && !Objects.equals(personTech.get().getId(), clientDTO.getId())) {
            throw new BadRequestException("Já existe um cliente cadastrado com esse E-mail.");
        }

    }

    public Client update(Long id, ClientDTO clientDTO) {
        clientDTO.setId(id);
        Client oldClientDTO = findById(id);
        validateEssentialFields(clientDTO);
        oldClientDTO = new Client(clientDTO);
        return clientRepository.save(oldClientDTO);
    }

    public void delete(Long id) {

        Client clientToBeDeleted = findById(id);
        if (!clientToBeDeleted.getRequests().isEmpty())
            throw new BadRequestException("O cliente possui chamados em seu registro e" +
                    "não pode ser deletado no momento!");
        clientRepository.deleteById(id);


    }
}
