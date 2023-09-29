package com.upb.upb.db.service;

import com.upb.upb.dto.PruebaSensorDto;

import java.util.List;

public interface PruebaSensorService {
    List<PruebaSensorDto> findAll();
    void saveData(String saveData);

}
