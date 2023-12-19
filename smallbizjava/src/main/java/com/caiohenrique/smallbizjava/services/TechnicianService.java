package com.caiohenrique.smallbizjava.services;

import com.caiohenrique.smallbizjava.domain.Technician;
import com.caiohenrique.smallbizjava.repositories.TechnicianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TechnicianService {

    @Autowired
    private TechnicianRepository technicianRepository;

    public Technician findById(Long id) {

        Optional<Technician> technician = technicianRepository.findById(id);
        return technician.orElse(null);
    }

}