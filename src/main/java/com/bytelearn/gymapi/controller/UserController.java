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
import org.springframework.web.server.ResponseStatusException;

import com.bytelearn.gymapi.controller.dtos.UserDTO;
import com.bytelearn.gymapi.domain.model.User;
import com.bytelearn.gymapi.exceptions.BusinessRuleException;
import com.bytelearn.gymapi.service.UserService;

@RestController
@RequestMapping("/api/user")
public record UserController(UserService userService) {
  
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public User save(UserDTO userDTO) {
    User u = userService.create(userDTO);
    return u;
  }

  @GetMapping("{id}")
  public UserDTO getUserById(@PathVariable Long id) {
    return userService.findById(id);
  }

  @DeleteMapping("{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)  
  public void delete(Long id) {
    userService.delete(id);
  }

  @PutMapping("{id}")
  public void update(@PathVariable Long id, @RequestBody UserDTO userDTO) {
    userService.update(id, userDTO);
  }

  @GetMapping
  public List<UserDTO> getAll() {
    return userService.findAll();
  }

  @PostMapping("/login")
  public User auth(@RequestBody UserDTO dto) {
    try {
      User user = userService.autenticar(dto);
      return user;
    } catch (BusinessRuleException e) {
      throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
    }
  }

}
