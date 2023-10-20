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

import com.bytelearn.gymapi.controller.dtos.StatusDTO;
import com.bytelearn.gymapi.domain.model.Status;
import com.bytelearn.gymapi.service.StatusService;

@RestController
@RequestMapping("/api/status")
public class StatusController {
  private StatusService statusService;

  public StatusController(StatusService statusService) {
    this.statusService = statusService;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Status save(@RequestBody StatusDTO statusDTO) {
    Status s = statusService.create(statusDTO);
    return s;
  }

  @GetMapping("{id}")
  public StatusDTO getStatusById(@PathVariable Long id) {
    return statusService.findById(id);
  }

  @DeleteMapping("{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable Long id) {
    statusService.delete(id);
  }

  @PutMapping("{id}")
  public void update(@PathVariable Long id, @RequestBody StatusDTO statusDTO) {
    statusService.update(id, statusDTO);
  }

  @GetMapping
  public List<StatusDTO> getAll() {
    return statusService.findAll();
  }

}
