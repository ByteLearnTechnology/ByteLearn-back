package com.bytelearn.gymapi.service;

import java.util.List;

import com.bytelearn.gymapi.controller.dtos.DataFinanceDTO;
import com.bytelearn.gymapi.controller.dtos.FinanceDTO;
import com.bytelearn.gymapi.domain.model.Finance;

public interface FinanceService {
  Finance create(FinanceDTO dto);
  DataFinanceDTO findById(Long id);
  void delete(Long id);
  void update(Long id, FinanceDTO dto);
  List<DataFinanceDTO> findAll();
  
}
