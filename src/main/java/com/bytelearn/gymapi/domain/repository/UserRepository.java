package com.bytelearn.gymapi.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bytelearn.gymapi.domain.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
  
}
