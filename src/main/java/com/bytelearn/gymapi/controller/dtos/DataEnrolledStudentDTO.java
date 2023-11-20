package com.bytelearn.gymapi.controller.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DataEnrolledStudentDTO {
  private Long id;
  private String name;
  private String phone;
  private String cpf;
  private String email;
  private DataPlanDTO plan;
  private StatusDTO status;

}
