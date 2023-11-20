package com.bytelearn.gymapi.controller.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DataPlanDTO {
  private Long id;
  private String description;
  private double price;
  private FinanceDTO finance;

}
