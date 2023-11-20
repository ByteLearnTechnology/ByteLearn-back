package com.bytelearn.gymapi.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bytelearn.gymapi.controller.dtos.DataEnrolledStudentDTO;
import com.bytelearn.gymapi.controller.dtos.DataFinanceDTO;
import com.bytelearn.gymapi.controller.dtos.EnrolledStudentDTO;
import com.bytelearn.gymapi.controller.dtos.PlanDTO;
import com.bytelearn.gymapi.controller.dtos.StatusDTO;
import com.bytelearn.gymapi.domain.model.EnrolledStudent;
import com.bytelearn.gymapi.domain.model.Finance;
import com.bytelearn.gymapi.domain.model.Status;
import com.bytelearn.gymapi.domain.repository.EnrolledStudentRepository;
import com.bytelearn.gymapi.domain.repository.FinanceRepository;
import com.bytelearn.gymapi.domain.repository.StatusRepository;
import com.bytelearn.gymapi.exceptions.NotFoundException;
import com.bytelearn.gymapi.service.EnrolledStudentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EnrolledStudentServiceImpl implements EnrolledStudentService {
  private final EnrolledStudentRepository enrolledRepository;
  private final StatusRepository statusRepository;
  private final FinanceRepository financeRepository;

  @Override
  @Transactional
  public EnrolledStudent create(EnrolledStudentDTO dto) {
    Status status = statusRepository.findById(dto.getStatus_id())
      .orElseThrow(() -> new NotFoundException("Status não encontrado."));
    Finance finance = financeRepository.findById(dto.getFinance_id())
      .orElseThrow(() -> new NotFoundException("Dados financeiros não encontrado."));
    
    EnrolledStudent enrolled = new EnrolledStudent();
    enrolled.setName(dto.getName());
    enrolled.setPhone(dto.getPhone());
    enrolled.setCpf(dto.getCpf());
    enrolled.setEmail(dto.getEmail());
    enrolled.setStatus(status);
    enrolled.setFinance(finance);
    return enrolledRepository.save(enrolled);
  }

  @Override
  @Transactional
  public void delete(Long id) {
    enrolledRepository.deleteById(id);
  }

  @Override
  @Transactional(readOnly = true)
  public List<DataEnrolledStudentDTO> findAll() {
    return enrolledRepository.findAll()
      .stream()
      .map((EnrolledStudent es) -> {
        return DataEnrolledStudentDTO.builder()
          .id(es.getId())
          .name(es.getName())
          .phone(es.getPhone())
          .cpf(es.getCpf())
          .email(es.getEmail())
          .status(StatusDTO.builder()
            .id(es.getStatus().getId())
            .description(es.getStatus().getDescription())
            .build())
          .finance(DataFinanceDTO.builder()
            .id(es.getFinance().getId())
            .payday(es.getFinance().getPayday())
            .planMonths(es.getFinance().getPlanMonths())
            .dueDate(es.getFinance().getDueDate())
            .plan(PlanDTO.builder()
              .id(es.getFinance().getPlan().getId())
              .description(es.getFinance().getPlan().getDescription())
              .price(es.getFinance().getPlan().getPrice())
              .build())
            .build())
          .build();
      }).toList();
  }

  @Override
  @Transactional(readOnly = true)
  public DataEnrolledStudentDTO findById(Long id) {
    return enrolledRepository.findById(id)
      .map((EnrolledStudent es) -> {
        return DataEnrolledStudentDTO.builder()
          .id(es.getId())
          .name(es.getName())
          .phone(es.getPhone())
          .cpf(es.getCpf())
          .email(es.getEmail())
          .status(StatusDTO.builder()
            .id(es.getStatus().getId())
            .description(es.getStatus().getDescription())
            .build())
          .finance(DataFinanceDTO.builder()
            .id(es.getFinance().getId())
            .payday(es.getFinance().getPayday())
            .planMonths(es.getFinance().getPlanMonths())
            .dueDate(es.getFinance().getDueDate())
            .plan(PlanDTO.builder()
              .id(es.getFinance().getPlan().getId())
              .description(es.getFinance().getPlan().getDescription())
              .price(es.getFinance().getPlan().getPrice())
              .build())
            .build())
          .build();
      }).orElseThrow(() -> new NotFoundException("Matrícula não encontrada."));
  }

  @Override
  @Transactional
  public void update(Long id, EnrolledStudentDTO dto) {
    EnrolledStudent enrolled = enrolledRepository.findById(id)
      .orElseThrow(() -> new NotFoundException("Matrícula não encontrada."));
    Status status = statusRepository.findById(dto.getStatus_id())
      .orElseThrow(() -> new NotFoundException("Status não encontrado."));
    Finance finance = financeRepository.findById(dto.getFinance_id())
      .orElseThrow(() -> new NotFoundException("Dados financeiros não encontrado."));
    
    enrolled.setName(dto.getName());
    enrolled.setPhone(dto.getPhone());
    enrolled.setCpf(dto.getCpf());
    enrolled.setEmail(dto.getEmail());
    enrolled.setStatus(status);
    enrolled.setFinance(finance);
    enrolledRepository.save(enrolled);
  }
  
}
