package com.caiohenrique.smallbizjava;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.caiohenrique.smallbizjava.domain.Client;
import com.caiohenrique.smallbizjava.domain.Request;
import com.caiohenrique.smallbizjava.domain.Technician;
import com.caiohenrique.smallbizjava.domain.enums.Priority;
import com.caiohenrique.smallbizjava.domain.enums.Profile;
import com.caiohenrique.smallbizjava.domain.enums.Status;
import com.caiohenrique.smallbizjava.repositories.ClientRepository;
import com.caiohenrique.smallbizjava.repositories.PersonRepository;
import com.caiohenrique.smallbizjava.repositories.RequestRepository;
import com.caiohenrique.smallbizjava.repositories.TechnicianRepository;

@SpringBootApplication
public class SmallbizjavaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SmallbizjavaApplication.class, args);
	}
	
	@Autowired
	private RequestRepository requestRepository;
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private TechnicianRepository technicianRepository;

	@Override
	public void run(String... args) throws Exception {

		Technician testTechnician = new Technician("Caio Henrique", "99999999999", "caiohenrique@caiohenrique.com.br",
				"123");
		testTechnician.addProfile(Profile.ADMIN);

		Client testClient = new Client("Paulo Roberto", "99999999991", "pauloroberto@pauloroberto.com.br", "123");

		Request testRequest = new Request(Priority.MEDIUM, Status.IN_PROGRESS, "Primeiro Pedido",
				"Teste primeiro pedido",
				testClient,
				testTechnician);
		
		technicianRepository.saveAll(Arrays.asList(
				testTechnician));
		
		clientRepository.saveAll(Arrays.asList(
				testClient));
		
		requestRepository.saveAll(Arrays.asList(
				testRequest));

	}

}
