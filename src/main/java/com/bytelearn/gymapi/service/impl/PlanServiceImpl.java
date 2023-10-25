package com.bytelearn.gymapi.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bytelearn.gymapi.controller.dtos.PlanDTO;
import com.bytelearn.gymapi.domain.model.Plan;
import com.bytelearn.gymapi.domain.repository.PlanRepository;
import com.bytelearn.gymapi.exceptions.NotFoundException;
import com.bytelearn.gymapi.service.PlanService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlanServiceImpl implements PlanService {
  private final PlanRepository planRepository;

  @Override
  @Transactional
  public Plan create(PlanDTO dto) {
    Plan plan = new Plan();
    plan.setDescription(dto.getDescription());
    plan.setPrice(dto.getPrice());
    return planRepository.save(plan);
  }
  
  @Override
  @Transactional
  public void delete(Long id) {
    planRepository.deleteById(id);
  }

  @Override
  @Transactional(readOnly = true)
  public List<PlanDTO> findAll() {
    return planRepository.findAll()
      .stream()
      .map((Plan p) -> {
        return PlanDTO.builder()
          .id(p.getId())
          .description(p.getDescription())
          .price(p.getPrice())
          .build();
      }).toList();
  }

  @Override
  @Transactional(readOnly = true)
  public PlanDTO findById(Long id) {
    return planRepository.findById(id)
      .map((Plan p) -> {
        return PlanDTO.builder()
          .id(p.getId())
          .description(p.getDescription())
          .price(p.getPrice())
          .build();
      }).orElseThrow(() -> new NotFoundException("Plano não encontrado."));
  }

  @Override
  @Transactional
  public void update(Long id, PlanDTO dto) {
    Plan plan = planRepository.findById(id)
      .orElseThrow(() -> new NotFoundException("Dados do financeiro não encontrado."));

    plan.setDescription(dto.getDescription());
    plan.setPrice(dto.getPrice());
    planRepository.save(plan);
  }
  
}
