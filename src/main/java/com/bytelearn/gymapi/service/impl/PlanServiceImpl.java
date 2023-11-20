package com.bytelearn.gymapi.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bytelearn.gymapi.controller.dtos.DataPlanDTO;
import com.bytelearn.gymapi.controller.dtos.FinanceDTO;
import com.bytelearn.gymapi.controller.dtos.PlanDTO;
import com.bytelearn.gymapi.domain.model.Finance;
import com.bytelearn.gymapi.domain.model.Plan;
import com.bytelearn.gymapi.domain.repository.FinanceRepository;
import com.bytelearn.gymapi.domain.repository.PlanRepository;
import com.bytelearn.gymapi.exceptions.NotFoundException;
import com.bytelearn.gymapi.service.PlanService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlanServiceImpl implements PlanService {
  private final PlanRepository planRepository;
  private final FinanceRepository financeRepository;

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
  public List<DataPlanDTO> findAll() {
    return planRepository.findAll()
      .stream()
      .map((Plan p) -> {
        return DataPlanDTO.builder()
          .id(p.getId())
          .description(p.getDescription())
          .price(p.getPrice())
          .finance(FinanceDTO.builder()
            .id(p.getFinance().getId())
            .payday(p.getFinance().getPayday())
            .planMonths(p.getFinance().getPlanMonths())
            .build())
          .build();
      }).toList();
  }

  @Override
  @Transactional(readOnly = true)
  public DataPlanDTO findById(Long id) {
    return planRepository.findById(id)
      .map((Plan p) -> {
        return DataPlanDTO.builder()
          .id(p.getId())
          .description(p.getDescription())
          .price(p.getPrice())
          .finance(FinanceDTO.builder()
            .id(p.getFinance().getId())
            .payday(p.getFinance().getPayday())
            .planMonths(p.getFinance().getPlanMonths())
            .build())
          .build();
      }).orElseThrow(() -> new NotFoundException("Plano não encontrado."));
  }

  @Override
  @Transactional
  public void update(Long id, PlanDTO dto) {
    Plan plan = planRepository.findById(id)
      .orElseThrow(() -> new NotFoundException("Dados do plano não encontrado."));
    Finance finance = financeRepository.findById(dto.getFinance_id())
      .orElseThrow(() -> new NotFoundException("Financeiro não encontrado."));

    plan.setDescription(dto.getDescription());
    plan.setPrice(dto.getPrice());
    plan.setFinance(finance);
    planRepository.save(plan);
  }
  
}
