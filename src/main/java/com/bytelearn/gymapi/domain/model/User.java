package com.bytelearn.gymapi.domain.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tb_user")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(unique = true, nullable = false)
  private String login;
  @Column(nullable = false)
  private String password;
  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private List<EnrolledStudent> enrolled;

  @Override
  public String toString() {
    return "User [ Id: " + id + ", login: " + login + ", senha: " + password + " ]";
  }
}
