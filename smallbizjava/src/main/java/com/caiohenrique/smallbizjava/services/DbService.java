package com.caiohenrique.smallbizjava.services;

import com.caiohenrique.smallbizjava.domain.Client;
import com.caiohenrique.smallbizjava.domain.Request;
import com.caiohenrique.smallbizjava.domain.Technician;
import com.caiohenrique.smallbizjava.domain.enums.Priority;
import com.caiohenrique.smallbizjava.domain.enums.Profile;
import com.caiohenrique.smallbizjava.domain.enums.Status;
import com.caiohenrique.smallbizjava.repositories.ClientRepository;
import com.caiohenrique.smallbizjava.repositories.RequestRepository;
import com.caiohenrique.smallbizjava.repositories.TechnicianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DbService {

    @Autowired
    private RequestRepository requestRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private TechnicianRepository technicianRepository;

    public void initDatabase() {

        Technician testTechnician = new Technician("Caio Henrique", "99999999999", "caiohenrique@caiohenrique.com.br",
                "123");
        Technician testTechnician2 = new Technician("Luis Felipe", "100000000000", "luisfelipe@caiohenrique.com.br",
                "123");
        testTechnician.addProfile(Profile.ADMIN);

        Client testClient = new Client("Paulo Roberto", "99999999991", "pauloroberto@pauloroberto.com.br", "123");
        Client testClient2 = new Client("Rodrigo Souza", "9999999992", "rodrigosouza@pauloroberto.com.br", "123");

        Request testRequest = new Request(Priority.MEDIUM, Status.IN_PROGRESS, "Primeiro Pedido",
                "Teste primeiro pedido",
                testClient,
                testTechnician);

        technicianRepository.saveAll(List.of(
                testTechnician, testTechnician2));

        clientRepository.saveAll(List.of(
                testClient, testClient2));

        requestRepository.saveAll(List.of(
                testRequest));
    }

}
