package com.caiohenrique.smallbizjava.services;

import com.caiohenrique.smallbizjava.domain.Client;
import com.caiohenrique.smallbizjava.domain.Request;
import com.caiohenrique.smallbizjava.exceptions.ObjectNotFoundException;
import com.caiohenrique.smallbizjava.repositories.PersonRepository;
import com.caiohenrique.smallbizjava.repositories.RequestRepository;
import com.caiohenrique.smallbizjava.repositories.TechnicianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RequestService {

    @Autowired
    private RequestRepository requestRepository;

    @Autowired
    private PersonRepository personRepository;


    public Request findById(Long id) {

        Optional<Request> request = requestRepository.findById(id);
        return request.orElseThrow(() -> new ObjectNotFoundException("Chamado " +
                "de id: "+id+ " não encontrado!"));

    }

    public List<Request> findAll() {
        return requestRepository.findAll();
    }
}
