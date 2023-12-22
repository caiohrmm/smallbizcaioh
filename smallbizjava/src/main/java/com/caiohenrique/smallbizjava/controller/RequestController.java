package com.caiohenrique.smallbizjava.controller;

import com.caiohenrique.smallbizjava.domain.Request;
import com.caiohenrique.smallbizjava.domain.Technician;
import com.caiohenrique.smallbizjava.domain.dtos.RequestDTO;
import com.caiohenrique.smallbizjava.domain.dtos.TechnicianDTO;
import com.caiohenrique.smallbizjava.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/request")
public class RequestController {

    @Autowired
    private RequestService requestService;

    // Método para buscar um request por ID
    @GetMapping(value = "/{id}")
    public ResponseEntity<RequestDTO> findById(@PathVariable Long id) {

        Request request = this.requestService.findById(id);

        return ResponseEntity.ok().body(new RequestDTO(request));
    }

    @GetMapping
    public ResponseEntity<List<RequestDTO>> findAll() {

        List<Request> requests = this.requestService.findAll();
        List<RequestDTO> requestDTOS = requests.stream().map(RequestDTO::new).toList();

        return ResponseEntity.ok().body(requestDTOS);
    }
}
