package com.upb.upb.db.service;

import com.upb.upb.dto.BitacoraDto;

import javax.management.OperationsException;
import java.util.List;

public interface BitacoraService {
    List<BitacoraDto> findAll();
    BitacoraDto findByCode(String code);
    BitacoraDto getById(Long id) throws OperationsException;
}
