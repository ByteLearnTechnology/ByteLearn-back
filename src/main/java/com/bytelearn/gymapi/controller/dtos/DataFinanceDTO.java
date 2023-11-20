package com.bytelearn.gymapi.controller.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DataFinanceDTO {
  private Long id;
  private Date payday;
  private Date dueDate;
  private int planMonths;
  private PlanDTO plan;
  
}
