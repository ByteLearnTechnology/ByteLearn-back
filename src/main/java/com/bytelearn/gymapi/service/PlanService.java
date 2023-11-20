package com.bytelearn.gymapi.service;

import java.util.List;

import com.bytelearn.gymapi.controller.dtos.DataPlanDTO;
import com.bytelearn.gymapi.controller.dtos.PlanDTO;
import com.bytelearn.gymapi.domain.model.Plan;

public interface PlanService {
  Plan create(PlanDTO dto);
  DataPlanDTO findById(Long id);
  void delete(Long id);
  void update(Long id, PlanDTO dto);
  List<DataPlanDTO> findAll();
  
}
