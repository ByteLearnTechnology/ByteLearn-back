package com.bytelearn.gymapi.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bytelearn.gymapi.controller.dtos.UserDTO;
import com.bytelearn.gymapi.domain.model.User;
import com.bytelearn.gymapi.domain.repository.UserRepository;
import com.bytelearn.gymapi.exceptions.BusinessRuleException;
import com.bytelearn.gymapi.exceptions.NotFoundException;
import com.bytelearn.gymapi.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
  private final UserRepository userRepository;

  @Override
  @Transactional
  public User create(UserDTO dto) {
    User user = new User();
    user.setLogin(dto.getLogin());
    user.setPassword(dto.getPassword());
    return userRepository.save(user);
  }

  @Override
  @Transactional
  public void delete(Long id) {
    userRepository.deleteById(id);
  }

  @Override
  @Transactional(readOnly = true)
  public List<UserDTO> findAll() {
    return userRepository.findAll()
      .stream()
      .map((User u) -> {
        return UserDTO.builder()
          .id(u.getId())
          .login(u.getLogin())
          .build();
      }).toList();
  }

  @Override
  @Transactional(readOnly = true)
  public UserDTO findById(Long id) {
    return userRepository.findById(id)
      .map((User u) -> {
        return UserDTO.builder()
          .id(u.getId())
          .login(u.getLogin())
          .build();
      }).orElseThrow(() -> new NotFoundException("Usuário não encontrado."));
  }

  @Override
  @Transactional
  public void update(Long id, UserDTO dto) {
    User user = userRepository.findById(id)
      .orElseThrow(() -> new NotFoundException("Usuário não encontrado."));

    user.setPassword(dto.getPassword());
    userRepository.save(user);
  }
  
  @Override
  @Transactional
  public UserDTO autenticar(UserDTO dto) {
    User user = userRepository.findByLogin(dto.getLogin());
    
    if (dto != null && dto.getPassword().equals(user.getPassword())) {
      return userRepository.findById(user.getId())
        .map((User u) -> {
          return UserDTO.builder()
            .id(u.getId())
            .login(u.getLogin())
          .build();
        }).orElseThrow(() -> new NotFoundException("Usuário não encontrado."));
    }

    throw new BusinessRuleException("Usuário ou senha inválida.");
  };

}
