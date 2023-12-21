package com.caiohenrique.smallbizjava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.caiohenrique.smallbizjava.domain.Person;
import com.caiohenrique.smallbizjava.domain.Technician;

public interface TechnicianRepository extends JpaRepository<Technician, Long> {

}
