package com.caiohenrique.smallbizjava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.caiohenrique.smallbizjava.domain.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
