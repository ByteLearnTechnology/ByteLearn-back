package com.bytelearn.gymapi.domain.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "tb_plans")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Plan {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String description;
  private double price;
  @OneToOne(mappedBy = "plan")
  private Finance finance;
  @OneToMany(mappedBy = "plan")
  private List<EnrolledStudent> enrolleds;
  
}
