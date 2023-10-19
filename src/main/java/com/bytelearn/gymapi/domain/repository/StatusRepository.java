package com.bytelearn.gymapi.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bytelearn.gymapi.domain.model.Status;

public interface StatusRepository extends JpaRepository<Status, Long> {
  
}
