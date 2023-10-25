package com.bytelearn.gymapi.service;

import com.bytelearn.gymapi.controller.dtos.UserDTO;
import com.bytelearn.gymapi.domain.model.User;

public interface UserService extends CrudService<User, UserDTO, Long> {
  
}
