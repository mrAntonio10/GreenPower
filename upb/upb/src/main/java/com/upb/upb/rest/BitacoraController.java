package com.upb.upb.rest;

import com.upb.upb.db.service.BitacoraService;
import com.upb.upb.dto.BitacoraDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@Slf4j
@RestController
@RequestMapping("/api/bitacora")
public class BitacoraController {
    @Autowired
    BitacoraService bitacoraService;

    @GetMapping("/findAll")
    public ResponseEntity<List<BitacoraDto>> bitacoraFindAll(){
        try{
            log .info("Accediendo a listar todas las bitacoras");
            return ok(bitacoraService.findAll());
        } catch (Exception e){
            log.info("Error inesperado {}", e);
            return ResponseEntity.badRequest().body(null);
        }
    }

}
