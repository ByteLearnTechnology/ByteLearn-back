package com.bytelearn.gymapi.service;

import java.util.List;

public interface CrudService<T, DTO, ID> {
  T create(DTO dto);
  DTO findById(ID id);
  void delete(ID id);
  void update(ID id, DTO dto);
  List<DTO> findAll();

}
