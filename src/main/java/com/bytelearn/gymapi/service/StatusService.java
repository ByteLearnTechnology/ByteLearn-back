package com.bytelearn.gymapi.service;

import java.util.List;

import com.bytelearn.gymapi.controller.dtos.StatusDTO;
import com.bytelearn.gymapi.domain.model.Status;

public interface StatusService {
  Status create(StatusDTO statusDTO);
  StatusDTO findById(Long id);
  void delete(Long id);
  void update(Long id, StatusDTO statusDTO);
  List<StatusDTO> findAll();
  
}