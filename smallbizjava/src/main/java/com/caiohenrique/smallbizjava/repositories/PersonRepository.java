package com.caiohenrique.smallbizjava.repositories;

import com.caiohenrique.smallbizjava.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {

    Optional<Person> findByNin(String nin);
    Optional<Person> findByEmail(String email);

}
