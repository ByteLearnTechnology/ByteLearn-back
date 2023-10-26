package com.bytelearn.gymapi.service;

import java.util.List;

import com.bytelearn.gymapi.controller.dtos.DataEnrolledStudentDTO;
import com.bytelearn.gymapi.controller.dtos.EnrolledStudentDTO;
import com.bytelearn.gymapi.domain.model.EnrolledStudent;

public interface EnrolledStudentService {
  EnrolledStudent create(EnrolledStudentDTO dto);
  DataEnrolledStudentDTO findById(Long id);
  void delete(Long id);
  void update(Long id, EnrolledStudentDTO dto);
  List<DataEnrolledStudentDTO> findAll();
  
}
