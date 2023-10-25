package com.bytelearn.gymapi.service;

import com.bytelearn.gymapi.controller.dtos.PlanDTO;
import com.bytelearn.gymapi.domain.model.Plan;

public interface PlanService extends CrudService<Plan, PlanDTO, Long> {
  
}
