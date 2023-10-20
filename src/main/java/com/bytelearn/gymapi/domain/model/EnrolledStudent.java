package com.bytelearn.gymapi.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "tb_enrolledStudent")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EnrolledStudent {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(nullable = false)
  private String name;
  private String phone;
  @Column(unique = true, nullable = false)
  private String cpf;
  private String email;
  @ManyToOne
  @JoinColumn(name = "plan_id")
  private Plan plan;
  @ManyToOne
  @JoinColumn(name = "status_id")
  private Status status;
  @ManyToOne
  @JoinColumn(name = "user_id", referencedColumnName = "id")
  private User user;

  @Override
  public String toString() {
    return "EnrolledStudent [ Id: " + id + ", nome: " + name + ", telefone: " + phone + ", CPF: " + cpf 
      + ", e-mail: " + email + " ]";
  }

}
