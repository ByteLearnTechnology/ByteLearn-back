package com.bytelearn.gymapi.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bytelearn.gymapi.domain.model.EnrolledStudent;

public interface EnrolledStudentRepository extends JpaRepository<EnrolledStudent, Long> {
  
}
