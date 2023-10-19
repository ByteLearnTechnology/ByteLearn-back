package com.bytelearn.gymapi.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bytelearn.gymapi.domain.model.Plan;

public interface PlanRepository extends JpaRepository<Plan, Long> {
  
}
