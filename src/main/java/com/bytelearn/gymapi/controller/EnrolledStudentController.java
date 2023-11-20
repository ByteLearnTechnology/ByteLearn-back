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

import com.bytelearn.gymapi.controller.dtos.DataEnrolledStudentDTO;
import com.bytelearn.gymapi.controller.dtos.EnrolledStudentDTO;
import com.bytelearn.gymapi.domain.model.EnrolledStudent;
import com.bytelearn.gymapi.service.EnrolledStudentService;

@RestController
@RequestMapping("/api/enrolled")
public record EnrolledStudentController(EnrolledStudentService enrolledService) {
  
  public EnrolledStudentController(EnrolledStudentService enrolledService) {
    this.enrolledService = enrolledService;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public EnrolledStudent save(@RequestBody EnrolledStudentDTO enrolledDTO) {
    EnrolledStudent es = enrolledService.create(enrolledDTO);
    return es;
  }

  @GetMapping("{id}")
  public DataEnrolledStudentDTO getEnrolledById(@PathVariable Long id) {
    return enrolledService.findById(id);
  }

  @DeleteMapping("{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(Long id) {
    enrolledService.delete(id);
  }

  @PutMapping("{id}")
  public void update(@PathVariable Long id,@RequestBody EnrolledStudentDTO enrolledDTO) {
    enrolledService.update(id, enrolledDTO);
  }

  @GetMapping
  public List<DataEnrolledStudentDTO> getAll() {
    return enrolledService.findAll();
  }

}
