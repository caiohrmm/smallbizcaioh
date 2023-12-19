package com.caiohenrique.smallbizjava.controller;

import com.caiohenrique.smallbizjava.domain.Technician;
import com.caiohenrique.smallbizjava.domain.dtos.TechnicianDTO;
import com.caiohenrique.smallbizjava.services.TechnicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
