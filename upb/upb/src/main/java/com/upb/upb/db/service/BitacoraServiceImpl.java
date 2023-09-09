package com.upb.upb.db.service;

import com.upb.upb.db.model.Bitacora;
import com.upb.upb.db.repository.BitacoraRepository;
import com.upb.upb.dto.BitacoraDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.OperationsException;
import java.util.ArrayList;
import java.util.List;

@Service
public class BitacoraServiceImpl implements BitacoraService {

    @Autowired
    private BitacoraRepository bitacoraRepository;

    @Override
    public List<BitacoraDto> findAll() {
        List<Bitacora> bitacoraList = bitacoraRepository.findAll();
        List<BitacoraDto> dtos = new ArrayList<>();

        for (Bitacora item: bitacoraList) {
            BitacoraDto dto = new BitacoraDto();
            dto.setId(item.getId());
            dto.setUser(item.getUser());
//            dto.setIdHumedad(item.getIdHumedad());
//            dto.setIdTemperatura(item.getIdTemperatura());
//            dto.setFecha(item.getFecha());
            dtos.add(dto);
        }
        return dtos;
    }

    @Override
    public BitacoraDto findByCode(String code) {
        return null;
    }

    @Override
    public BitacoraDto getById(Long id) throws OperationsException {
        return null;
    }

}
