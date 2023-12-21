package com.caiohenrique.smallbizjava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.caiohenrique.smallbizjava.domain.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
