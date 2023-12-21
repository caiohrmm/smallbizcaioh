package com.caiohenrique.smallbizjava.controller;

import com.caiohenrique.smallbizjava.domain.Technician;
import com.caiohenrique.smallbizjava.domain.dtos.TechnicianDTO;
import com.caiohenrique.smallbizjava.services.TechnicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/technician")
public class TechnicianController {

    @Autowired
    private TechnicianService technicianService;

    // Método para buscar um técnico por ID
    @GetMapping(value = "/{id}")
    public ResponseEntity<TechnicianDTO> findById(@PathVariable Long id) {

        Technician technician = this.technicianService.findById(id);

        return ResponseEntity.ok().body(new TechnicianDTO(technician));
    }

    @GetMapping
    public ResponseEntity<List<TechnicianDTO>> findAll() {

        List<Technician> technicians = this.technicianService.findAll();
        List<TechnicianDTO> technicianDTOS = technicians.stream().map(TechnicianDTO::new).toList();

        return ResponseEntity.ok().body(technicianDTOS);
    }

    @PostMapping
    public ResponseEntity<TechnicianDTO> create(@Valid @RequestBody TechnicianDTO technicianDTO) {
        Technician technician = this.technicianService.create(technicianDTO);
        // Ao criar um novo técnico, a API retorna a sua URI de acesso no header.
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(
                technician.getId()
        ).toUri();
        return ResponseEntity.created(uri).body(new TechnicianDTO(technician));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<TechnicianDTO> update(@PathVariable Long id,@Valid @RequestBody TechnicianDTO technicianDTO) {
        Technician newTechnician = this.technicianService.update(id, technicianDTO);
        return ResponseEntity.ok().body(new TechnicianDTO(newTechnician));
    }


}
