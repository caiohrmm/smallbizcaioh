package com.caiohenrique.smallbizjava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.caiohenrique.smallbizjava.domain.Request;

public interface RequestRepository extends JpaRepository<Request, Long> {

}
