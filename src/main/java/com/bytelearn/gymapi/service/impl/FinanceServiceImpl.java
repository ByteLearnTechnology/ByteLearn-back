package com.bytelearn.gymapi.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bytelearn.gymapi.controller.dtos.DataFinanceDTO;
import com.bytelearn.gymapi.controller.dtos.FinanceDTO;
import com.bytelearn.gymapi.controller.dtos.PlanDTO;
import com.bytelearn.gymapi.domain.model.Finance;
import com.bytelearn.gymapi.domain.model.Plan;
import com.bytelearn.gymapi.domain.repository.FinanceRepository;
import com.bytelearn.gymapi.domain.repository.PlanRepository;
import com.bytelearn.gymapi.exceptions.NotFoundException;
import com.bytelearn.gymapi.service.FinanceService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FinanceServiceImpl implements FinanceService {
  private final FinanceRepository financeRepository;
  private final PlanRepository planRepository;

  @Override
  @Transactional
  public Finance create(FinanceDTO dto) {
    Plan plan = planRepository.findById(dto.getPlan_id())
      .orElseThrow(() -> new NotFoundException("Plano não encontrado."));

    Finance finance = new Finance();
    finance.setPayday(dto.getPayday());
    finance.setPlanMonths(dto.getPlanMonths());
    finance.setDueDate(dto.getDueDate());
    finance.setPlan(plan);
    return financeRepository.save(finance);
  }

  @Override
  @Transactional
  public void delete(Long id) {
    financeRepository.deleteById(id);
  }

  @Override
  @Transactional(readOnly = true)
  public List<DataFinanceDTO> findAll() {
    return financeRepository.findAll()
      .stream()
      .map((Finance f) -> {
        return DataFinanceDTO.builder()
          .id(f.getId())
          .payday(f.getPayday())
          .planMonths(f.getPlanMonths())
          .dueDate(f.getDueDate())
          .plan(PlanDTO.builder()
            .id(f.getPlan().getId())
            .description(f.getPlan().getDescription())
            .price(f.getPlan().getPrice())
            .build())
          .build();
      }).toList();
  }

  @Override
  @Transactional(readOnly = true)
  public DataFinanceDTO findById(Long id) {
    return financeRepository.findById(id)
      .map((Finance f) -> {
        return DataFinanceDTO.builder()
          .id(f.getId())
          .payday(f.getPayday())
          .planMonths(f.getPlanMonths())
          .dueDate(f.getDueDate())
          .plan(PlanDTO.builder()
            .id(f.getPlan().getId())
            .description(f.getPlan().getDescription())
            .price(f.getPlan().getPrice())
            .build())
          .build();
      }).orElseThrow(() -> new NotFoundException("Dados do financeiro não encontrado."));
  }

  @Override
  @Transactional
  public void update(Long id, FinanceDTO dto) {
    Finance finance = financeRepository.findById(id)
      .orElseThrow(() -> new NotFoundException("Dados do financeiro não encontrado."));
    Plan plan = planRepository.findById(dto.getPlan_id())
      .orElseThrow(() -> new NotFoundException("Plano não encontrado."));

    finance.setPayday(dto.getPayday());
    finance.setPlanMonths(dto.getPlanMonths());
    finance.setDueDate(dto.getDueDate());
    finance.setPlan(plan);
    financeRepository.save(finance);
  }

}
