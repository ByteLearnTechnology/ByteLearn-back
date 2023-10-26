package com.bytelearn.gymapi.controller.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnrolledStudentDTO {
  private Long id;
  private String name;
  private String phone;
  private String cpf;
  private String email;
  private Long plan_id;
  private Long status_id;
  private Long user_id;
  private Long finance_id;

}
