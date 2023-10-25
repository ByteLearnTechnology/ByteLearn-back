package com.bytelearn.gymapi.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bytelearn.gymapi.domain.model.Finance;

public interface FinanceRepository extends JpaRepository<Finance, Long>{
  
}
