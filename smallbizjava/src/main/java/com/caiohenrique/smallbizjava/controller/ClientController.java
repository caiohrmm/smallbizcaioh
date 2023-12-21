package com.caiohenrique.smallbizjava.controller;

import com.caiohenrique.smallbizjava.domain.Client;
import com.caiohenrique.smallbizjava.domain.Technician;
import com.caiohenrique.smallbizjava.domain.dtos.ClientDTO;
import com.caiohenrique.smallbizjava.domain.dtos.TechnicianDTO;
import com.caiohenrique.smallbizjava.services.ClientService;
import com.caiohenrique.smallbizjava.services.TechnicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    // Método para buscar um técnico por ID
    @GetMapping(value = "/{id}")
    public ResponseEntity<ClientDTO> findById(@PathVariable Long id) {

        Client client = this.clientService.findById(id);

        return ResponseEntity.ok().body(new ClientDTO(client));
    }

    @GetMapping
    public ResponseEntity<List<ClientDTO>> findAll() {

        List<Client> technicians = this.clientService.findAll();
        List<ClientDTO> technicianDTOS = technicians.stream().map(ClientDTO::new).toList();

        return ResponseEntity.ok().body(technicianDTOS);
    }

    @PostMapping
    public ResponseEntity<ClientDTO> create(@Valid @RequestBody ClientDTO clientDTO) {
        Client client = this.clientService.create(clientDTO);
        // Ao criar um novo técnico, a API retorna a sua URI de acesso no header.
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(
                client.getId()
        ).toUri();
        return ResponseEntity.created(uri).body(new ClientDTO(client));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ClientDTO> update(@PathVariable Long id, @Valid @RequestBody ClientDTO clientDTO) {
        Client newClient = this.clientService.update(id, clientDTO);
        return ResponseEntity.ok().body(new ClientDTO(newClient));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ClientDTO> delete(@PathVariable Long id) {
        this.clientService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
