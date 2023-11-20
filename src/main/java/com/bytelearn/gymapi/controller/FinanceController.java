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

import com.bytelearn.gymapi.controller.dtos.DataFinanceDTO;
import com.bytelearn.gymapi.controller.dtos.FinanceDTO;
import com.bytelearn.gymapi.domain.model.Finance;
import com.bytelearn.gymapi.service.FinanceService;

@RestController
@RequestMapping("/api/finance")
public record FinanceController(FinanceService financeService) {
  
  public FinanceController(FinanceService financeService) {
    this.financeService = financeService;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Finance save(@RequestBody FinanceDTO financeDTO) {
    Finance f = financeService.create(financeDTO);
    return f;
  }

  @GetMapping("{id}")
  public DataFinanceDTO getFinanceById(@PathVariable Long id) {
    return financeService.findById(id);
  }

  @DeleteMapping("{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable Long id) {
    financeService.delete(id);
  }

  @PutMapping("{id}")
  public void update(@PathVariable Long id, @RequestBody FinanceDTO financeDTO) {
    financeService.update(id, financeDTO);
  }

  @GetMapping
  public List<DataFinanceDTO> getAll() {
    return financeService.findAll();
  }

}
