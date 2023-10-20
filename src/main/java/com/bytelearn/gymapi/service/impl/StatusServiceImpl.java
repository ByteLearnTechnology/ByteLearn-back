package com.bytelearn.gymapi.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bytelearn.gymapi.controller.dtos.StatusDTO;
import com.bytelearn.gymapi.domain.model.Status;
import com.bytelearn.gymapi.domain.repository.StatusRepository;
import com.bytelearn.gymapi.exceptions.NotFoundException;
import com.bytelearn.gymapi.service.StatusService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StatusServiceImpl implements StatusService {
  private final StatusRepository statusRepository;

  @Override
  @Transactional
  public Status create(StatusDTO statusDTO) {
    Status status = new Status();
    status.setDescription(statusDTO.getDescription());
    return statusRepository.save(status);
  }

  @Override
  @Transactional
  public void delete(Long id) {
    statusRepository.deleteById(id);
  }

  @Override
  @Transactional(readOnly = true)
  public List<StatusDTO> findAll() {
    return statusRepository.findAll()
      .stream()
      .map((Status s) -> {
        return StatusDTO.builder()
          .id(s.getId())
          .description(s.getDescription())
          .build();
      }).toList();
  }

  @Override
  @Transactional(readOnly = true)
  public StatusDTO findById(Long id) {
    return statusRepository.findById(id)
      .map((Status s) -> {
        return StatusDTO.builder()
          .id(s.getId())
          .description(s.getDescription())
          .build();
      }).orElseThrow(() -> new NotFoundException("Status não encontrado."));
  }

  @Override
  @Transactional
  public void update(Long id, StatusDTO statusDTO) {
    Status status = statusRepository.findById(id)
      .orElseThrow(() -> new NotFoundException("Status não encontrado."));    

    status.setDescription(statusDTO.getDescription());
    statusRepository.save(status);
  }
  
}
