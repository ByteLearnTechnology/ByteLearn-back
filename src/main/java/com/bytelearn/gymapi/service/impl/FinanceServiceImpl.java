package com.bytelearn.gymapi.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bytelearn.gymapi.controller.dtos.FinanceDTO;
import com.bytelearn.gymapi.domain.model.Finance;
import com.bytelearn.gymapi.domain.repository.FinanceRepository;
import com.bytelearn.gymapi.exceptions.NotFoundException;
import com.bytelearn.gymapi.service.FinanceService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FinanceServiceImpl implements FinanceService {
  private final FinanceRepository financeRepository;

  @Override
  @Transactional
  public Finance create(FinanceDTO dto) {
    Finance finance = new Finance();
    finance.setPayday(dto.getPayday());
    finance.setPlanMonths(dto.getPlanMonths());
    return financeRepository.save(finance);
  }

  @Override
  @Transactional
  public void delete(Long id) {
    financeRepository.deleteById(id);
  }

  @Override
  @Transactional(readOnly = true)
  public List<FinanceDTO> findAll() {
    return financeRepository.findAll()
      .stream()
      .map((Finance f) -> {
        return FinanceDTO.builder()
          .id(f.getId())
          .payday(f.getPayday())
          .planMonths(f.getPlanMonths())
          .build();
      }).toList();
  }

  @Override
  @Transactional(readOnly = true)
  public FinanceDTO findById(Long id) {
    return financeRepository.findById(id)
      .map((Finance f) -> {
        return FinanceDTO.builder()
          .id(f.getId())
          .payday(f.getPayday())
          .planMonths(f.getPlanMonths())
          .build();
      }).orElseThrow(() -> new NotFoundException("Dados do financeiro não encontrado."));
  }

  @Override
  @Transactional
  public void update(Long id, FinanceDTO dto) {
    Finance finance = financeRepository.findById(id)
      .orElseThrow(() -> new NotFoundException("Dados do financeiro não encontrado."));

    finance.setPayday(dto.getPayday());
    finance.setPlanMonths(dto.getPlanMonths());
    financeRepository.save(finance);
  }

}
