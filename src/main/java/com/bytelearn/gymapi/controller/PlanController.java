package com.bytelearn.gymapi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bytelearn.gymapi.controller.dtos.DataPlanDTO;
import com.bytelearn.gymapi.controller.dtos.PlanDTO;
import com.bytelearn.gymapi.domain.model.Plan;
import com.bytelearn.gymapi.service.PlanService;

@RestController
@RequestMapping("/api/plan")
public record PlanController(PlanService planService) {
  
  public PlanController(PlanService planService) {
    this.planService = planService;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Plan save(@RequestBody PlanDTO planDTO) {
    Plan p = planService.create(planDTO);
    return p;
  }

  @GetMapping("{id}")
  public DataPlanDTO getPlanById(@PathVariable Long id) {
    return planService.findById(id);
  }

  @DeleteMapping("{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable Long id) {
    planService.delete(id);
  }

  @PutMapping("{id}")
  public void update(@PathVariable Long id, @RequestBody PlanDTO planDTO) {
    planService.update(id, planDTO);
  }

  @GetMapping
  public List<DataPlanDTO> getAll() {
    return planService.findAll();
  }

}
