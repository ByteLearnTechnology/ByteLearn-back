package com.bytelearn.gymapi.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bytelearn.gymapi.domain.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
  @Query("SELECT u FROM User u WHERE u.login = :login")
  User findByLogin(@Param("login") String login);
}
