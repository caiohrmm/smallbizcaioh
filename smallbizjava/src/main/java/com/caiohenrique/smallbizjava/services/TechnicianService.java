package com.caiohenrique.smallbizjava.services;

import com.caiohenrique.smallbizjava.domain.Person;
import com.caiohenrique.smallbizjava.domain.Technician;
import com.caiohenrique.smallbizjava.domain.dtos.TechnicianDTO;
import com.caiohenrique.smallbizjava.exceptions.ObjectNotFoundException;
import com.caiohenrique.smallbizjava.exceptions.handler.BadRequestException;
import com.caiohenrique.smallbizjava.repositories.PersonRepository;
import com.caiohenrique.smallbizjava.repositories.TechnicianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TechnicianService {

    @Autowired
    private TechnicianRepository technicianRepository;

    @Autowired
    private PersonRepository personRepository;

    public Technician findById(Long id) {

        Optional<Technician> technician = technicianRepository.findById(id);
        return technician.orElseThrow(() -> new ObjectNotFoundException(
                "Técnico não encontrado!"
        ));
    }

    public List<Technician> findAll() {
        return technicianRepository.findAll();
    }

    public Technician create(TechnicianDTO technicianDTO) {

        technicianDTO.setId(null);

        // Valida campos
        verifyIntegratedFields(technicianDTO);

        Technician technician = new Technician(technicianDTO);
        return technicianRepository.save(technician);

    }

    private void verifyIntegratedFields(TechnicianDTO technicianDTO) {

        Optional<Person> personTech = this.personRepository.findByNin(technicianDTO.getNin());

        if (personTech.isPresent() && !Objects.equals(personTech.get().getId(), technicianDTO.getId())) {
            throw new BadRequestException("Já existe um técnico cadastrado com esse CPF.");
        }

        personTech = this.personRepository.findByEmail(technicianDTO.getEmail());

        if (personTech.isPresent() && !Objects.equals(personTech.get().getId(), technicianDTO.getId())) {
            throw new BadRequestException("Já existe um técnico cadastrado com esse E-mail.");
        }

    }

    public Technician update(Long id, TechnicianDTO technicianDTO) {
        technicianDTO.setId(id);
        Technician oldTechnicianDTO = findById(id);
        verifyIntegratedFields(technicianDTO);
        oldTechnicianDTO = new Technician(technicianDTO);
        return technicianRepository.save(oldTechnicianDTO);
    }
}
