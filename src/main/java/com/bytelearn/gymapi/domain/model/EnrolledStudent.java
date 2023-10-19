package com.bytelearn.gymapi.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Entity(name = "tb_enrolledStudent")
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
  @OneToOne
  private Plan plan;
  @OneToOne
  private Status status;
  
  public EnrolledStudent() { }

  public EnrolledStudent(String name, String phone, String cpf, String email) {
    this.name = name;
    this.phone = phone;
    this.cpf = cpf;
    this.email = email;
  }
  
  public EnrolledStudent(String name, String phone, String cpf, String email, Plan plan, Status status) {
    this.name = name;
    this.phone = phone;
    this.cpf = cpf;
    this.email = email;
    this.plan = plan;
    this.status = status;
  }

  @Override
  public String toString() {
    return "EnrolledStudent [ Id: " + id + ", nome: " + name + ", telefone: " + phone + ", CPF: " + cpf 
      + ", e-mail: " + email
      + ", plano: " + plan + ", status: " + status + " ]";
  }

}
